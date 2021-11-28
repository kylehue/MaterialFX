package io.github.palexdev.materialfx.controls;

import io.github.palexdev.materialfx.beans.Alignment;
import io.github.palexdev.materialfx.beans.PopupPositionBean;
import io.github.palexdev.materialfx.beans.PositionBean;
import io.github.palexdev.materialfx.controls.base.MFXStyleablePopup;
import io.github.palexdev.materialfx.effects.Interpolators;
import io.github.palexdev.materialfx.skins.MFXPopupSkin;
import io.github.palexdev.materialfx.utils.AnimationUtils.KeyFrames;
import io.github.palexdev.materialfx.utils.AnimationUtils.TimelineBuilder;
import javafx.animation.Animation;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.PopupControl;
import javafx.scene.control.Skin;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Scale;
import javafx.stage.Window;

import java.util.function.BiFunction;

/**
 * Custom and better implementation of a {@link PopupControl}.
 * <p></p>
 * Setting the popup's content is now easier, it is animated (can be disabled), the animation
 * can be changed but the most important features are the hover property and PseudoClass ("popup-hover" in css)
 * that specifies when the mouse is on the content, and the new show methods that make use of {@link HPos}
 * and {@link VPos} to compute the position for you, no more x and y computation, leave it to {@code MFXPopup}.
 * <p>
 * Of course if needed JavaFX's methods are still available.
 * <p></p>
 * Also allows to reposition the popup on demand by calling {@link #reposition()} and also
 * offers a new {@link EventType}.
 * <p></p>
 * Now implements {@link MFXStyleablePopup} to make the popup customizable with CSS.
 * Please check the interface's documentation on how to use the functionality.
 */
public class MFXPopup extends PopupControl implements MFXStyleablePopup {
    //================================================================================
    // Properties
    //================================================================================
    private PopupPositionBean position;
    private final ObjectProperty<Node> content = new SimpleObjectProperty<>() {
        @Override
        public void set(Node newValue) {
            Node oldValue = get();
            if (oldValue != null) {
                oldValue.removeEventFilter(MouseEvent.MOUSE_ENTERED, entered);
                oldValue.removeEventFilter(MouseEvent.MOUSE_EXITED, exited);
            }
            newValue.addEventFilter(MouseEvent.MOUSE_ENTERED, entered);
            newValue.addEventFilter(MouseEvent.MOUSE_EXITED, exited);
            super.set(newValue);
        }
    };
    private BiFunction<Node, Scale, Animation> animationProvider;
    private boolean animated = true;

    private final PseudoClass HOVER_PSEUDO_CLASS = PseudoClass.getPseudoClass("popup-hover");
    private final BooleanProperty hover = new SimpleBooleanProperty(false);
    private final EventHandler<MouseEvent> entered = event -> setHover(true);
    private final EventHandler<MouseEvent> exited = event -> setHover(false);

    private Parent styleableParent;
    private final MFXStyleablePopup.CSSBridge bridge = new MFXStyleablePopup.CSSBridge(this);

    //================================================================================
    // Constructors
    //================================================================================
    public MFXPopup() {
        animationProvider = (node, scale) -> TimelineBuilder.build()
                .show(150, node)
                .add(KeyFrames.of(150,
                        scale.xProperty(), 1, Interpolators.INTERPOLATOR_V2
                ))
                .add(KeyFrames.of(150,
                        scale.yProperty(), 1, Interpolators.INTERPOLATOR_V2
                ))
                .getAnimation();
        initialize();
    }

    public MFXPopup(Node content) {
        setContent(content);
        animationProvider = (node, scale) -> TimelineBuilder.build()
                .show(150, node)
                .add(KeyFrames.of(150,
                        scale.xProperty(), 1, Interpolators.INTERPOLATOR_V2
                ))
                .add(KeyFrames.of(150,
                        scale.yProperty(), 1, Interpolators.INTERPOLATOR_V2
                ))
                .getAnimation();
        initialize();
    }

    //================================================================================
    // Methods
    //================================================================================
    private void initialize() {
        setAutoFix(false);
        setAutoHide(true);
        setHideOnEscape(true);

        hover.addListener(invalidated -> pseudoClassStateChanged(HOVER_PSEUDO_CLASS, hover.get()));
    }

    /**
     * Shows the popup at the BOTTOM_RIGHT of the specified node.
     * <p></p>
     * Calls {@link #show(Node, Alignment, double, double)}.
     */
    public void show(Node node) {
        show(node, Alignment.of(HPos.RIGHT, VPos.BOTTOM), 0, 0);
    }

    /**
     * Shows the popup at the given positions.
     * <p></p>
     * Calls {@link #show(Node, Alignment, double, double)}.
     */
    public void show(Node node, Alignment alignment) {
        show(node, alignment, 0, 0);
    }

    /**
     * Shows the popup at the given positions, then shifts the computed coordinates
     * by the given offsets.
     * <p></p>
     * Once the position is computed, it is stored in a {@link PopupPositionBean} alongside other
     * useful info. These info are important because before the popup is actually shown, its skin
     * is created. The {@link MFXPopupSkin} uses these info to properly position and animate the popup.
     * This is needed because before creating the skin the content is not laid out so its sizes/bounds are 0
     * and the "real" coordinates cannot be computed. For this reason, the coordinates stored in the
     * position bean are not reliable, because they do not take into account the adjustments applied
     * by the skin. (as of now, maybe will be improved in the future)
     */
    public void show(Node node, Alignment alignment, double xOffset, double yOffset) {
        if (node.getScene() == null || node.getScene().getWindow() == null) {
                throw new IllegalStateException("Cannot show the popup. The node must be attached to a scene/window!");
            }

        Window window = node.getScene().getWindow();
        PositionBean position = computePosition(node, window, alignment, xOffset, yOffset);
        this.position = new PopupPositionBean(node, position, alignment, xOffset, yOffset);
        show(window, position.getX(), position.getY());
    }

    // TODO add show Window

    /**
     * Repositions the popup by recomputing the position from
     * the previous stored info.
     * <p>
     * This should be called when the owner's position changes.
     *
     * @see #show(Node, Alignment, double, double)
     * @see PopupPositionBean
     */
    public void reposition() {
        if (!isShowing() || position == null) return;
        position = computePosition();
        setX(position.getX());
        setY(position.getY());
    }

    /**
     * Computes the initial (x, y) coordinates for the given parameters.
     * These will be "refined" in the skin.
     */
    private PositionBean computePosition(Node node, Window window, Alignment alignment, double xOffset, double yOffset) {
        Point2D origin = node.localToScene(0, 0);

        HPos hPos = alignment.getHPos();
        VPos vPos = alignment.getVPos();
        double x = window.getX() + origin.getX() + node.getScene().getX() + computeHPos(node, hPos, xOffset);
        double y = window.getY() + origin.getY() + node.getScene().getY() + computeVPos(node, vPos, yOffset);
        return PositionBean.of(x, y);
    }

    /**
     * Used to compute the new position of the popup when repositioning.
     */
    public PopupPositionBean computePosition() {
        Node node = position.getOwner();
        Window window = node.getScene().getWindow();
        Alignment alignment = position.getAlignment();
        PositionBean reposition = computePosition(node, window, alignment, position.getXOffset(), position.getYOffset());
        return new PopupPositionBean(node, reposition, alignment, position.getXOffset(), position.getYOffset());
    }

    /**
     * Computes the x coordinate shifting according to the given {@link HPos} and x offset.
     */
    private double computeHPos(Node node, HPos hPos, double xOffset) {
        double x;
        double contentWidth = getContent().prefWidth(-1);
        double ownerWidth = node.getLayoutBounds().getWidth();
        switch (hPos) {
            case LEFT:
                x = -Math.abs((contentWidth - ownerWidth));
                break;
            case CENTER: {
                x = -Math.abs(ownerWidth / 2 - contentWidth / 2);
                break;
            }
            default: {
                x = 0;
                break;
            }
        }
        return x + xOffset;
    }

    /**
     * Computes the y coordinate shift according to the given {@link VPos} and y offset.
     */
    private double computeVPos(Node node, VPos vPos, double yOffset) {
        return (vPos == VPos.BOTTOM ? node.getLayoutBounds().getHeight() : 0) + yOffset;
    }

    //================================================================================
    // Getters/Setters
    //================================================================================

    /**
     * @return the instance of the {@link PopupPositionBean} computed when showing
     * or repositioning the popup. Note that it will return null if the popup is not showing.
     */
    public PopupPositionBean getPosition() {
        return position;
    }

    public Node getContent() {
        return content.get();
    }

    /**
     * Specifies the popup's content.
     * <p>
     * As of now changing the content while the popup is shown won't have any effect.
     * For it to work, the popup must be closed and reopened again.
     * As of now, there's no plan to improve this because such use case would introduce
     * an unnecessary layer of complexity and in my opinion it's also a discouraged practice to change
     * the popup's content while open. It would be better to use a container Pane and change its content.
     * <p></p>
     * This is a property because when the content changes it's needed to add the necessary handlers to it
     * to make the "hover" feature work.
     * <p></p>
     * The content <b>cannot</b> be null.
     */
    public ObjectProperty<Node> contentProperty() {
        return content;
    }

    public void setContent(Node content) {
        this.content.set(content);
    }

    /**
     * @return the function used by the skin to produce the popup's animation
     */
    public BiFunction<Node, Scale, Animation> getAnimationProvider() {
        return animationProvider;
    }

    /**
     * Sets the function used by the skin to produce the popup's animation.
     * <p>
     * The input parameters are the popup's container (it's a {@link StackPane}, and
     * the {@link Scale} transform applied to the container.
     */
    public void setAnimationProvider(BiFunction<Node, Scale, Animation> animationProvider) {
        this.animationProvider = animationProvider;
    }

    /**
     * Specifies whether tha popup's is animated.
     */
    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public boolean isHover() {
        return hover.get();
    }

    /**
     * Specifies if the mouse is on the popup's content.
     */
    public BooleanProperty hoverProperty() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover.set(hover);
    }

    //================================================================================
    // Override Methods
    //================================================================================

    /**
     * {@inheritDoc}
     * <p></p>
     * Overridden to set the stored {@link PopupPositionBean} to null.
     */
    @Override
    public void hide() {
        position = null;
        super.hide();
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        return new MFXPopupSkin(this);
    }

    @Override
    public Parent getPopupStyleableParent() {
        return styleableParent;
    }

    @Override
    public void setPopupStyleableParent(Parent parent) {
        bridge.dispose();
        this.styleableParent = parent;
        bridge.initializeStylesheets();
    }

    @Override
    public ObservableList<String> getStyleSheets() {
        return bridge.getStylesheets();
    }

    //================================================================================
    // Events
    //================================================================================

    /**
     * Events class for {@link MFXPopup}s.
     * <p></p>
     * Introduces a new event type: "REPOSITION_EVENT". It can be used to inform a popup that it should
     * reposition. The typical use of this event is in case of Control/Skin or in general MVC pattern.
     * If you don't have a reference to the popup, fire this event and capture it in the class that has the popup's reference
     * then call, {@link #reposition()}.
     */
    public static class MFXPopupEvent extends Event {

        public static final EventType<MFXPopupEvent> REPOSITION_EVENT = new EventType<>(ANY, "Reposition Event");

        public MFXPopupEvent(EventType<? extends Event> eventType) {
            super(eventType);
        }
    }
}

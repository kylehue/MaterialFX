/*
 * Copyright (C) 2023 Parisi Alessandro - alessandro.parisi406@gmail.com
 * This file is part of MaterialFX (https://github.com/palexdev/MaterialFX)
 *
 * MaterialFX is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * MaterialFX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with MaterialFX. If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.palexdev.mfxresources.fonts.fontawesome;

import io.github.palexdev.mfxresources.fonts.IconDescriptor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Enumerator class for FontAwesomeRegular icons. (Count: 163)
 */
public enum FontAwesomeRegular implements IconDescriptor {
    ADDRESS_BOOK("far-address-book", '\uE900'),
    ADDRESS_CARD("far-address-card", '\uE901'),
    BELL("far-bell", '\uE902'),
    BELL_SLASH("far-bell-slash", '\uE903'),
    BOOKMARK("far-bookmark", '\uE904'),
    BUILDING("far-building", '\uE905'),
    CALENDAR("far-calendar", '\uE906'),
    CALENDAR_CHECK("far-calendar-check", '\uE907'),
    CALENDAR_DAYS("far-calendar-days", '\uE908'),
    CALENDAR_MINUS("far-calendar-minus", '\uE909'),
    CALENDAR_PLUS("far-calendar-plus", '\uE90A'),
    CALENDAR_XMARK("far-calendar-xmark", '\uE90B'),
    CHART_BAR("far-chart-bar", '\uE90C'),
    CHESS_BISHOP("far-chess-bishop", '\uE90D'),
    CHESS_KING("far-chess-king", '\uE90E'),
    CHESS_KNIGHT("far-chess-knight", '\uE90F'),
    CHESS_PAWN("far-chess-pawn", '\uE910'),
    CHESS_QUEEN("far-chess-queen", '\uE911'),
    CHESS_ROOK("far-chess-rook", '\uE912'),
    CIRCLE("far-circle", '\uE913'),
    CIRCLE_CHECK("far-circle-check", '\uE914'),
    CIRCLE_DOT("far-circle-dot", '\uE915'),
    CIRCLE_DOWN("far-circle-down", '\uE916'),
    CIRCLE_LEFT("far-circle-left", '\uE917'),
    CIRCLE_PAUSE("far-circle-pause", '\uE918'),
    CIRCLE_PLAY("far-circle-play", '\uE919'),
    CIRCLE_QUESTION("far-circle-question", '\uE91A'),
    CIRCLE_RIGHT("far-circle-right", '\uE91B'),
    CIRCLE_STOP("far-circle-stop", '\uE91C'),
    CIRCLE_UP("far-circle-up", '\uE91D'),
    CIRCLE_USER("far-circle-user", '\uE91E'),
    CIRCLE_XMARK("far-circle-xmark", '\uE91F'),
    CLIPBOARD("far-clipboard", '\uE920'),
    CLOCK("far-clock", '\uE921'),
    CLONE("far-clone", '\uE922'),
    CLOSED_CAPTIONING("far-closed-captioning", '\uE923'),
    COMMENT("far-comment", '\uE924'),
    COMMENT_DOTS("far-comment-dots", '\uE925'),
    COMMENTS("far-comments", '\uE926'),
    COMPASS("far-compass", '\uE927'),
    COPY("far-copy", '\uE928'),
    COPYRIGHT("far-copyright", '\uE929'),
    CREDIT_CARD("far-credit-card", '\uE92A'),
    ENVELOPE("far-envelope", '\uE92B'),
    ENVELOPE_OPEN("far-envelope-open", '\uE92C'),
    EYE("far-eye", '\uE92D'),
    EYE_SLASH("far-eye-slash", '\uE92E'),
    FACE_ANGRY("far-face-angry", '\uE92F'),
    FACE_DIZZY("far-face-dizzy", '\uE930'),
    FACE_FLUSHED("far-face-flushed", '\uE931'),
    FACE_FROWN("far-face-frown", '\uE932'),
    FACE_FROWN_OPEN("far-face-frown-open", '\uE933'),
    FACE_GRIMACE("far-face-grimace", '\uE934'),
    FACE_GRIN("far-face-grin", '\uE935'),
    FACE_GRIN_BEAM("far-face-grin-beam", '\uE936'),
    FACE_GRIN_BEAM_SWEAT("far-face-grin-beam-sweat", '\uE937'),
    FACE_GRIN_HEARTS("far-face-grin-hearts", '\uE938'),
    FACE_GRIN_SQUINT("far-face-grin-squint", '\uE939'),
    FACE_GRIN_SQUINT_TEARS("far-face-grin-squint-tears", '\uE93A'),
    FACE_GRIN_STARS("far-face-grin-stars", '\uE93B'),
    FACE_GRIN_TEARS("far-face-grin-tears", '\uE93C'),
    FACE_GRIN_TONGUE("far-face-grin-tongue", '\uE93D'),
    FACE_GRIN_TONGUE_SQUINT("far-face-grin-tongue-squint", '\uE93E'),
    FACE_GRIN_TONGUE_WINK("far-face-grin-tongue-wink", '\uE93F'),
    FACE_GRIN_WIDE("far-face-grin-wide", '\uE940'),
    FACE_GRIN_WINK("far-face-grin-wink", '\uE941'),
    FACE_KISS("far-face-kiss", '\uE942'),
    FACE_KISS_BEAM("far-face-kiss-beam", '\uE943'),
    FACE_KISS_WINK_HEART("far-face-kiss-wink-heart", '\uE944'),
    FACE_LAUGH("far-face-laugh", '\uE945'),
    FACE_LAUGH_BEAM("far-face-laugh-beam", '\uE946'),
    FACE_LAUGH_SQUINT("far-face-laugh-squint", '\uE947'),
    FACE_LAUGH_WINK("far-face-laugh-wink", '\uE948'),
    FACE_MEH("far-face-meh", '\uE949'),
    FACE_MEH_BLANK("far-face-meh-blank", '\uE94A'),
    FACE_ROLLING_EYES("far-face-rolling-eyes", '\uE94B'),
    FACE_SAD_CRY("far-face-sad-cry", '\uE94C'),
    FACE_SAD_TEAR("far-face-sad-tear", '\uE94D'),
    FACE_SMILE("far-face-smile", '\uE94E'),
    FACE_SMILE_BEAM("far-face-smile-beam", '\uE94F'),
    FACE_SMILE_WINK("far-face-smile-wink", '\uE950'),
    FACE_SURPRISE("far-face-surprise", '\uE951'),
    FACE_TIRED("far-face-tired", '\uE952'),
    FILE("far-file", '\uE953'),
    FILE_AUDIO("far-file-audio", '\uE954'),
    FILE_CODE("far-file-code", '\uE955'),
    FILE_EXCEL("far-file-excel", '\uE956'),
    FILE_IMAGE("far-file-image", '\uE957'),
    FILE_LINES("far-file-lines", '\uE958'),
    FILE_PDF("far-file-pdf", '\uE959'),
    FILE_POWERPOINT("far-file-powerpoint", '\uE95A'),
    FILE_VIDEO("far-file-video", '\uE95B'),
    FILE_WORD("far-file-word", '\uE95C'),
    FILE_ZIPPER("far-file-zipper", '\uE95D'),
    FLAG("far-flag", '\uE95E'),
    FLOPPY_DISK("far-floppy-disk", '\uE95F'),
    FOLDER("far-folder", '\uE960'),
    FOLDER_CLOSED("far-folder-closed", '\uE961'),
    FOLDER_OPEN("far-folder-open", '\uE962'),
    FONT_AWESOME("far-font-awesome", '\uE963'),
    FUTBOL("far-futbol", '\uE964'),
    GEM("far-gem", '\uE965'),
    HAND("far-hand", '\uE966'),
    HAND_BACK_FIST("far-hand-back-fist", '\uE967'),
    HAND_LIZARD("far-hand-lizard", '\uE968'),
    HAND_PEACE("far-hand-peace", '\uE969'),
    HAND_POINT_DOWN("far-hand-point-down", '\uE96A'),
    HAND_POINTER("far-hand-pointer", '\uE96B'),
    HAND_POINT_LEFT("far-hand-point-left", '\uE96C'),
    HAND_POINT_RIGHT("far-hand-point-right", '\uE96D'),
    HAND_POINT_UP("far-hand-point-up", '\uE96E'),
    HAND_SCISSORS("far-hand-scissors", '\uE96F'),
    HANDSHAKE("far-handshake", '\uE970'),
    HAND_SPOCK("far-hand-spock", '\uE971'),
    HARD_DRIVE("far-hard-drive", '\uE972'),
    HEART("far-heart", '\uE973'),
    HOSPITAL("far-hospital", '\uE974'),
    HOURGLASS("far-hourglass", '\uE975'),
    HOURGLASS_HALF("far-hourglass-half", '\uE976'),
    ID_BADGE("far-id-badge", '\uE977'),
    ID_CARD("far-id-card", '\uE978'),
    IMAGE("far-image", '\uE979'),
    IMAGES("far-images", '\uE97A'),
    KEYBOARD("far-keyboard", '\uE97B'),
    LEMON("far-lemon", '\uE97C'),
    LIFE_RING("far-life-ring", '\uE97D'),
    LIGHTBULB("far-lightbulb", '\uE97E'),
    MAP("far-map", '\uE97F'),
    MESSAGE("far-message", '\uE980'),
    MONEY_BILL_1("far-money-bill-1", '\uE981'),
    MOON("far-moon", '\uE982'),
    NEWSPAPER("far-newspaper", '\uE983'),
    NOTE_STICKY("far-note-sticky", '\uE984'),
    OBJECT_GROUP("far-object-group", '\uE985'),
    OBJECT_UNGROUP("far-object-ungroup", '\uE986'),
    PAPER_PLANE("far-paper-plane", '\uE987'),
    PASTE("far-paste", '\uE988'),
    PEN_TO_SQUARE("far-pen-to-square", '\uE989'),
    RECTANGLE_LIST("far-rectangle-list", '\uE98A'),
    RECTANGLE_XMARK("far-rectangle-xmark", '\uE98B'),
    REGISTERED("far-registered", '\uE98C'),
    SHARE_FROM_SQUARE("far-share-from-square", '\uE98D'),
    SNOWFLAKE("far-snowflake", '\uE98E'),
    SQUARE("far-square", '\uE98F'),
    SQUARE_CARET_DOWN("far-square-caret-down", '\uE990'),
    SQUARE_CARET_LEFT("far-square-caret-left", '\uE991'),
    SQUARE_CARET_RIGHT("far-square-caret-right", '\uE992'),
    SQUARE_CARET_UP("far-square-caret-up", '\uE993'),
    SQUARE_CHECK("far-square-check", '\uE994'),
    SQUARE_FULL("far-square-full", '\uE995'),
    SQUARE_MINUS("far-square-minus", '\uE996'),
    SQUARE_PLUS("far-square-plus", '\uE997'),
    STAR("far-star", '\uE998'),
    STAR_HALF("far-star-half", '\uE999'),
    STAR_HALF_STROKE("far-star-half-stroke", '\uE99A'),
    SUN("far-sun", '\uE99B'),
    THUMBS_DOWN("far-thumbs-down", '\uE99C'),
    THUMBS_UP("far-thumbs-up", '\uE99D'),
    TRASH_CAN("far-trash-can", '\uE99E'),
    USER("far-user", '\uE99F'),
    WINDOW_MAXIMIZE("far-window-maximize", '\uE9A0'),
    WINDOW_MINIMIZE("far-window-minimize", '\uE9A1'),
    WINDOW_RESTORE("far-window-restore", '\uE9A2'),
    ;

    private static Map<String, Character> cache;
    private final String description;
    private final char code;

    FontAwesomeRegular(String description, char code) {
        this.description = description;
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public char getCode() {
        return code;
    }

    @Override
    public Map<String, Character> getCache() {
        return cache();
    }

    /**
     * Converts the given icon description/name to its corresponding unicode character.
     *
     * @param desc the icon description/name
     * @return the icon's unicode character
     * @throws IllegalArgumentException if no icon with the given description could be found
     */
    public static char toCode(String desc) {
        return Optional.ofNullable(cache().get(desc))
            .orElseThrow(() -> new IllegalArgumentException("Icon description '" + desc + "' is invalid!"));
    }

    /**
     * Same as {@link IconDescriptor#getCache()}, allows to retrieve the cache from a static context.
     */
    public static Map<String, Character> cache() {
        if (cache == null) {
            cache = Arrays.stream(values())
                .collect(Collectors.toUnmodifiableMap(
                    FontAwesomeRegular::getDescription,
                    FontAwesomeRegular::getCode
                ));
        }
        return cache;
    }
}

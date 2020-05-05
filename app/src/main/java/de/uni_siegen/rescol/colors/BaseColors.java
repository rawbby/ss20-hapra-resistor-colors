package de.uni_siegen.rescol.colors;

public class BaseColors {

    public enum BaseColor {

        BLACK(0),
        BROWN(1),
        RED(2),
        ORANGE(3),
        YELLOW(4),
        GREEN(5),
        BLUE(6),
        PURPLE(7),
        GREY(8),
        WHITE(9);

        public final int number;

        BaseColor(int number) {
            this.number = number;
        }
    }

    public static final BaseColor[] BASE_COLOR_FIRST = {
            BaseColor.BROWN,
            BaseColor.RED,
            BaseColor.ORANGE,
            BaseColor.YELLOW,
            BaseColor.GREEN,
            BaseColor.BLUE,
            BaseColor.PURPLE,
            BaseColor.GREY,
            BaseColor.WHITE
    };

    public static final BaseColor[] BASE_COLOR_NEXT = BaseColor.values();
}


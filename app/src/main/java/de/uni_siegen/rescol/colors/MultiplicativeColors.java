package de.uni_siegen.rescol.colors;

public class MultiplicativeColors {

    public enum MultiplicativeColor {

        SILVER(0.01),
        GOLD(0.1),
        BLACK(1),
        BROWN(10),
        RED(100),
        ORANGE(1000),
        YELLOW(10000),
        GREEN(100000),
        BLUE(1000000),
        PURPLE(10000000),
        GREY(100000000),
        WHITE(1000000000);

        public final double value;

        MultiplicativeColor(double value) {
            this.value = value;
        }
    }

    public static final MultiplicativeColor[] MULTIPLICATIVE_COLORS = MultiplicativeColor.values();
}

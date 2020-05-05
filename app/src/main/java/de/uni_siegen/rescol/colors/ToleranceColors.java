package de.uni_siegen.rescol.colors;

public class ToleranceColors {
    public enum ToleranceColor {

        SILVER("+/- 10%"),
        GOLD("+/- 5%"),
        BROWN("+/- 1%"),
        RED("+/- 2%"),
        GREEN("+/- 0.5%"),
        BLUE("+/- 0.25%"),
        PURPLE("+/- 0.1%"),
        GREY("+/- 0.05%");

        public final String value;

        ToleranceColor(String value) {
            this.value = value;
        }
    }

    public static final ToleranceColor[] TOLERANCE_COLORS = ToleranceColor.values();
}

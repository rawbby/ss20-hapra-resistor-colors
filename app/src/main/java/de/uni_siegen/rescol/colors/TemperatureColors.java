package de.uni_siegen.rescol.colors;

public class TemperatureColors {

    public enum TemperatureColor {

        BROWN("100 ppm/\u00B0C"),
        RED("50 ppm/\u00B0C"),
        ORANGE("15 ppm/\u00B0C"),
        YELLOW("25 ppm/\u00B0C"),
        BLUE("10 ppm/\u00B0C"),
        PURPLE("5 ppm/\u00B0C"),
        WHITE("1 ppm/\u00B0C");

        public final String coefficient;

        TemperatureColor(String coefficient) {
            this.coefficient = coefficient;
        }
    }

    public static final TemperatureColor[] TEMPERATURE_COLORS = TemperatureColor.values();
}

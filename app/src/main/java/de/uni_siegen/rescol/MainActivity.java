package de.uni_siegen.rescol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import de.uni_siegen.rescol.colors.BaseColors.BaseColor;
import de.uni_siegen.rescol.colors.MultiplicativeColors.MultiplicativeColor;
import de.uni_siegen.rescol.colors.TemperatureColors;
import de.uni_siegen.rescol.colors.ToleranceColors.ToleranceColor;

import static de.uni_siegen.rescol.colors.BaseColors.BASE_COLOR_FIRST;
import static de.uni_siegen.rescol.colors.BaseColors.BASE_COLOR_NEXT;
import static de.uni_siegen.rescol.colors.MultiplicativeColors.MULTIPLICATIVE_COLORS;
import static de.uni_siegen.rescol.colors.TemperatureColors.TEMPERATURE_COLORS;
import static de.uni_siegen.rescol.colors.ToleranceColors.TOLERANCE_COLORS;

public class MainActivity extends AppCompatActivity {

    private RadioButton checkRings4;
    private RadioButton checkRings5;
    private RadioButton checkRings6;

    private Spinner spinnerBase1;
    private Spinner spinnerBase2;
    private Spinner spinnerBase3;
    private Spinner spinnerMultiplicative;
    private Spinner spinnerTolerance;
    private Spinner spinnerTemperature;

    private TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.checkRings4 = findViewById(R.id.check_rings_4);
        this.checkRings5 = findViewById(R.id.check_rings_5);
        this.checkRings6 = findViewById(R.id.check_rings_6);
        this.spinnerBase1 = findViewById(R.id.spinner_ring_1);
        this.spinnerBase2 = findViewById(R.id.spinner_ring_2);
        this.spinnerBase3 = findViewById(R.id.spinner_ring_3);
        this.spinnerMultiplicative = findViewById(R.id.spinner_ring_4);
        this.spinnerTolerance = findViewById(R.id.spinner_ring_5);
        this.spinnerTemperature = findViewById(R.id.spinner_ring_6);
        this.textOutput = findViewById(R.id.text_output);

        this.spinnerBase3.setEnabled(false);
        this.spinnerTemperature.setEnabled(false);

        View.OnClickListener checkRingsListener = this::onCheckRingsClick;
        this.checkRings4.setOnClickListener(checkRingsListener);
        this.checkRings5.setOnClickListener(checkRingsListener);
        this.checkRings6.setOnClickListener(checkRingsListener);

        OnItemChangedListener spinnerRingsListener = new OnItemChangedListener(this::onSpinnerRingsChange);
        this.spinnerBase1.setOnItemSelectedListener(spinnerRingsListener);
        this.spinnerBase2.setOnItemSelectedListener(spinnerRingsListener);
        this.spinnerBase3.setOnItemSelectedListener(spinnerRingsListener);
        this.spinnerMultiplicative.setOnItemSelectedListener(spinnerRingsListener);
        this.spinnerTolerance.setOnItemSelectedListener(spinnerRingsListener);
        this.spinnerTemperature.setOnItemSelectedListener(spinnerRingsListener);
    }

    public void onCheckRingsClick(View v) {

        if (this.checkRings4.isChecked()) {

            this.spinnerBase3.setEnabled(false);
            this.spinnerTemperature.setEnabled(false);
            recalculateWithRings4();

        } else if (this.checkRings5.isChecked()) {

            this.spinnerBase3.setEnabled(true);
            this.spinnerTemperature.setEnabled(false);
            recalculateWithRings5();

        } else if (this.checkRings6.isChecked()) {

            this.spinnerBase3.setEnabled(true);
            this.spinnerTemperature.setEnabled(true);
            recalculateWithRings6();
        }
    }

    public void onSpinnerRingsChange() {

        if (this.checkRings4.isChecked()) {
            recalculateWithRings4();
        } else if (this.checkRings5.isChecked()) {
            recalculateWithRings5();
        } else if (this.checkRings6.isChecked()) {
            recalculateWithRings6();
        }
    }

    public void recalculateWithRings4() {

        int base1Index = spinnerBase1.getSelectedItemPosition();
        int base2Index = spinnerBase2.getSelectedItemPosition();
        int multiplicativeIndex = spinnerMultiplicative.getSelectedItemPosition();
        int toleranceIndex = spinnerTolerance.getSelectedItemPosition();

        // BaseColor
        BaseColor base1 = BASE_COLOR_FIRST[base1Index];
        BaseColor base2 = BASE_COLOR_NEXT[base2Index];

        // multiplicative
        MultiplicativeColor multiplicative = MULTIPLICATIVE_COLORS[multiplicativeIndex];

        // tolerance
        ToleranceColor tolerance = TOLERANCE_COLORS[toleranceIndex];

        double resistance = (base1.number * 10 + base2.number) * multiplicative.value;

        printResult(resistance, tolerance.value, "undeclared");
    }

    public void recalculateWithRings5() {

        int base1Index = spinnerBase1.getSelectedItemPosition();
        int base2Index = spinnerBase2.getSelectedItemPosition();
        int base3Index = spinnerBase3.getSelectedItemPosition();
        int multiplicativeIndex = spinnerMultiplicative.getSelectedItemPosition();
        int toleranceIndex = spinnerTolerance.getSelectedItemPosition();

        // BaseColor
        BaseColor base1 = BASE_COLOR_FIRST[base1Index];
        BaseColor base2 = BASE_COLOR_NEXT[base2Index];
        BaseColor base3 = BASE_COLOR_NEXT[base3Index];

        // multiplicative
        MultiplicativeColor multiplicative = MULTIPLICATIVE_COLORS[multiplicativeIndex];

        // tolerance
        ToleranceColor tolerance = TOLERANCE_COLORS[toleranceIndex];

        int base = (base1.number * 100 + base2.number * 10 + base3.number);
        double resistance = base * multiplicative.value;

        printResult(resistance, tolerance.value, "undeclared");
    }

    public void recalculateWithRings6() {

        int base1Index = spinnerBase1.getSelectedItemPosition();
        int base2Index = spinnerBase2.getSelectedItemPosition();
        int base3Index = spinnerBase3.getSelectedItemPosition();
        int multiplicativeIndex = spinnerMultiplicative.getSelectedItemPosition();
        int toleranceIndex = spinnerTolerance.getSelectedItemPosition();
        int temperatureIndex = spinnerTemperature.getSelectedItemPosition();

        // BaseColor
        BaseColor base1 = BASE_COLOR_FIRST[base1Index];
        BaseColor base2 = BASE_COLOR_NEXT[base2Index];
        BaseColor base3 = BASE_COLOR_NEXT[base3Index];

        // multiplicative
        MultiplicativeColor multiplicative = MULTIPLICATIVE_COLORS[multiplicativeIndex];

        // tolerance
        ToleranceColor tolerance = TOLERANCE_COLORS[toleranceIndex];

        // temperature
        TemperatureColors.TemperatureColor temperature = TEMPERATURE_COLORS[temperatureIndex];

        int base = (base1.number * 100 + base2.number * 10 + base3.number);
        double resistance = base * multiplicative.value;

        printResult(resistance, tolerance.value, temperature.coefficient);
    }

    private void printResult(double resistance, String tolerance, String temperature) {

        final char OHM_SYMBOL = '\u2126';

        String result = "Resistance:  " + resistance + OHM_SYMBOL + '\n' +
                "Tolerance:   " + tolerance + '\n' +
                "Temperature: " + temperature + '\n';

        this.textOutput.setText(result);
    }
}

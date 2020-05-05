package de.uni_siegen.rescol;


import android.view.View;
import android.widget.AdapterView;

public class OnItemChangedListener implements AdapterView.OnItemSelectedListener {

    @FunctionalInterface
    public interface OnItemChanged {
        void onItemChanged();
    }

    private OnItemChanged onItemChanged;

    OnItemChangedListener(OnItemChanged onItemChanged) {
        this.onItemChanged = onItemChanged;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.onItemChanged.onItemChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        this.onItemChanged.onItemChanged();
    }
}

package br.com.usp.parentalcontrol;

import java.io.Serializable;

public class Obligation implements Serializable {

    String obligation;
    boolean isSelected;

    public Obligation(String obligation, boolean isSelected) {
        this.obligation = obligation;
        this.isSelected = isSelected;
    }

    public String getObligation() {
        return obligation;
    }

    public void setObligation(String obligation) {
        this.obligation = obligation;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

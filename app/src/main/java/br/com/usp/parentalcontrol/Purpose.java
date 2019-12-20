package br.com.usp.parentalcontrol;

import android.widget.CheckBox;

import java.io.Serializable;

public class Purpose implements Serializable {

    String purpose;
    boolean isSelected;

    public Purpose(String purpose, boolean checkPurpose) {
        this.purpose = purpose;
        this.isSelected = isSelected;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

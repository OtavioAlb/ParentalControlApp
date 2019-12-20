package br.com.usp.parentalcontrol;

import java.io.Serializable;

public class Recipient implements Serializable {

    String recipient;
    boolean isSelected;

    public Recipient(String recipient, boolean isSelected) {
        this.recipient = recipient;
        this.isSelected = isSelected;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

package br.com.usp.parentalcontrol;

import java.io.Serializable;

public class locationObjects implements Serializable {

    String location;
    Boolean isSelected;

    public locationObjects(String location, Boolean isSelected) {
        this.location = location;
        this.isSelected = isSelected;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}

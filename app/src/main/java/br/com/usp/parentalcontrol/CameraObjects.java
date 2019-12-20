package br.com.usp.parentalcontrol;

import java.io.Serializable;

public class CameraObjects implements Serializable {

    String camera;
    Boolean isSelected;

    public CameraObjects(String camera, Boolean isSelected) {
        this.camera = camera;
        this.isSelected = isSelected;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}

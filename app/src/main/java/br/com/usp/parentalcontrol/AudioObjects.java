package br.com.usp.parentalcontrol;

import java.io.Serializable;

public class AudioObjects implements Serializable {

    String Audio;
    boolean isSelected;

    public AudioObjects(String audio, boolean isSelected) {
        Audio = audio;
        this.isSelected = isSelected;
    }

    public String getAudio() {
        return Audio;
    }

    public void setAudio(String audio) {
        Audio = audio;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

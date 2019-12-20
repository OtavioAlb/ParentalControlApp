package br.com.usp.parentalcontrol;

import java.io.Serializable;

public class Operation implements Serializable {

    String operation;
    Boolean isSelected;

    public Operation(String operation, Boolean isSelected) {
        this.operation = operation;
        this.isSelected = isSelected;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}

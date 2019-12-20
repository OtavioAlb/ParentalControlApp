package br.com.usp.parentalcontrol.Model;

public class Rule {

    int id;
    String nameRule;
    String descriptRule;
    String webServiceRule;
    String operationCheck;
    String objectCheck;
    String purpose;
    String recipient;
    String obligation;
    String retention;

    public Rule() {
    }

    public Rule(String nameRule, String webServiceRule) {
        this.nameRule = nameRule;
        this.webServiceRule = webServiceRule;
    }

    public Rule(int id, String nameRule, String descriptRule, String webServiceRule,
                String operationCheck, String objectCheck, String purpose, String recipient,
                String obligation, String retention) {
        this.nameRule = nameRule;
        this.descriptRule = descriptRule;
        this.webServiceRule = webServiceRule;
        this.operationCheck = operationCheck;
        this.objectCheck = objectCheck;
        this.purpose = purpose;
        this.recipient = recipient;
        this.obligation = obligation;
        this.retention = retention;
    }

    public Rule(String nameRule, String descriptRule, String webServiceRule, String operationCheck,
                String objectCheck, String purpose, String recipient, String obligation, String retention) {
        this.nameRule = nameRule;
        this.descriptRule = descriptRule;
        this.webServiceRule = webServiceRule;
        this.operationCheck = operationCheck;
        this.objectCheck = objectCheck;
        this.purpose = purpose;
        this.recipient = recipient;
        this.obligation = obligation;
        this.retention = retention;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRule() {
        return nameRule;
    }

    public void setNameRule(String nameRule) {
        this.nameRule = nameRule;
    }

    public String getDescriptRule() {
        return descriptRule;
    }

    public void setDescriptRule(String descriptRule) {
        this.descriptRule = descriptRule;
    }

    public String getWebServiceRule() {
        return webServiceRule;
    }

    public void setWebServiceRule(String webServiceRule) {
        this.webServiceRule = webServiceRule;
    }

    public String getOperationCheck() {
        return operationCheck;
    }

    public void setOperationCheck(String operationCheck) {
        this.operationCheck = operationCheck;
    }

    public String getObjectCheck() {
        return objectCheck;
    }

    public void setObjectCheck(String objectCheck) {
        this.objectCheck = objectCheck;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getObligation() {
        return obligation;
    }

    public void setObligation(String obligation) {
        this.obligation = obligation;
    }

    public String getRetention() {
        return retention;
    }

    public void setRetention(String retention) {
        this.retention = retention;
    }
}

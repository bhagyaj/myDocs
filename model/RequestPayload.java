package com.polixia.policywallet.server.model;

public class RequestPayload {
    private CSettings cSettings;
    private CQuestionaireSet cQuestionaireSet;
    private CQuestionaireCards cQuestionaireCards;
    private CQuestionairSections cQuestionairSections;
    private CQuestionaireType cQuestionaireType;
    private CQuestionairePage cQuestionairePage;
    private CQuestionairePageFields cQuestionairePageFields;

    public CSettings getcSettings() {
        return cSettings;
    }

    public void setcSettings(CSettings cSettings) {
        this.cSettings = cSettings;
    }

    public CQuestionaireSet getcQuestionaireSet() {
        return cQuestionaireSet;
    }

    public void setcQuestionaireSet(CQuestionaireSet cQuestionaireSet) {
        this.cQuestionaireSet = cQuestionaireSet;
    }

    public CQuestionaireCards getcQuestionaireCards() {
        return cQuestionaireCards;
    }

    public void setcQuestionaireCards(CQuestionaireCards cQuestionaireCards) {
        this.cQuestionaireCards = cQuestionaireCards;
    }

    public CQuestionairSections getcQuestionairSections() {
        return cQuestionairSections;
    }

    public void setcQuestionairSections(CQuestionairSections cQuestionairSections) {
        this.cQuestionairSections = cQuestionairSections;
    }

    public CQuestionaireType getcQuestionaireType() {
        return cQuestionaireType;
    }

    public void setcQuestionaireType(CQuestionaireType cQuestionaireType) {
        this.cQuestionaireType = cQuestionaireType;
    }

    public CQuestionairePageFields getcQuestionairePageFields() {
        return cQuestionairePageFields;
    }

    public void setcQuestionairePageFields(CQuestionairePageFields cQuestionairePageFields) {
        this.cQuestionairePageFields = cQuestionairePageFields;
    }

    public CQuestionairePage getcQuestionairePage() {
        return cQuestionairePage;
    }

    public void setcQuestionairePage(CQuestionairePage cQuestionairePage) {
        this.cQuestionairePage = cQuestionairePage;
    }
}

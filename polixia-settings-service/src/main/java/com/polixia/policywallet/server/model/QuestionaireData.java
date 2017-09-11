package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;

import java.util.List;

public class QuestionaireData {
    
    
    @JsonView(DataView.HDataSummary.class)
    private Integer versionId;
    @JsonView(DataView.HDataSummary.class)
    private String version;
    @JsonView(DataView.HSpecific.class)
    private List<QuestionaireType> questionaires;

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<QuestionaireType> getQuestionaires() {
        return questionaires;
    }

    public void setQuestionaires(List<QuestionaireType> questionaires) {
        this.questionaires = questionaires;
    }
}

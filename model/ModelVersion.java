package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jjegasingam on 7/31/2017.
 */
public class ModelVersion{
    @JsonView(QDataView.QHDataSummary.class)
    int VersionId;
    @JsonView(QDataView.QHDataSummary.class)
    String Version;
    @JsonView(QDataView.QHDataSummary.class)
    List<CQuestionaireType> questionaires = new ArrayList<>();

    public int getVersionId() {
        return VersionId;
    }

    public void setVersionId(int versionId) {
        VersionId = versionId;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public List<CQuestionaireType> getQuestionaires() {
        return questionaires;
    }

    public void setQuestionaires(List<CQuestionaireType> questionaires) {
        this.questionaires = questionaires;
    }

    public void setVersion_Data(CSettings version_Data) {

        VersionId=version_Data.getId();
        Version = version_Data.getVersion();
    }

//
}

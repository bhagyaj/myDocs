package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.QDataView;

import javax.persistence.*;

@Entity
@Table(name = "cfieldquestiondef")
public class CFieldQuestionDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(QDataView.QDataSummary.class)
    @Column(name = "id")
    private int id;
    @Column(name = "versionId")
    @JsonView(QDataView.QDataSummary.class)
    private int versionId;
    @Column(name = "Version")
    @JsonView(QDataView.QDataSummary.class)
    private String version;
    @Column(name = "FieldOwner")
    @JsonView(QDataView.QDataSummary.class)
    private String fieldOwner;
    @Column(name = "FieldName")
    @JsonView(QDataView.QDataSummary.class)
    private String fieldName;
    @Column(name = "FieldDefId")
    @JsonView(QDataView.QDataSummary.class)
    private int fieldDefId;
    @Column(name = "FieldCode")
    private String fieldCode;
    @Column(name = "OrderNumber")
    @JsonView(QDataView.QDataSummary.class)
    private int order;
    @Column(name = "Question")
    @JsonView(QDataView.QDataSummary.class)
    private String Question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFieldOwner() {
        return fieldOwner;
    }

    public void setFieldOwner(String fieldOwner) {
        this.fieldOwner = fieldOwner;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getFieldDefId() {
        return fieldDefId;
    }

    public void setFieldDefId(int fieldDefId) {
        this.fieldDefId = fieldDefId;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}

package com.polixia.policywallet.server.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.util.ApplicationConstant;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cfieldquestiondef")
public class FieldQuestionDef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(DataView.DataSummary.class)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Version")
    @JsonView(DataView.DataSummary.class)
    private String version;
    @Column(name = "FieldOwner")
    @JsonView(DataView.DataSummary.class)
    private String fieldOwner;
    @Column(name = "FieldName")
    @JsonView(DataView.DataSummary.class)
    private String fieldName;
    @ManyToOne
    @JoinColumn(name = "FieldDefId")
    @JsonView(DataView.DataSummary.class)
    @NotNull(message = ApplicationConstant.ERROR_MESSAGE_REQUIRED_DATA_NOT_FOUND)
    private FieldDef cFieldDef;
    @Column(name = "FieldCode")
    private String fieldCode;
    @Column(name = "OrderNumber")
    @JsonView(DataView.DataSummary.class)
    private Integer order;
    @Column(name = "Question")
    @JsonView(DataView.DataSummary.class)
    private String Question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public FieldDef getcFieldDef() {
        return cFieldDef;
    }

    public void setcFieldDef(FieldDef cFieldDef) {
        this.cFieldDef = cFieldDef;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}

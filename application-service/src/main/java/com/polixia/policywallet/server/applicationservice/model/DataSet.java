package com.polixia.policywallet.server.applicationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    @JsonIgnore
    private Tracker tracker = new Tracker();
    private String SetName;
    private String SetNickName;
    private List<DataSection> sections= new ArrayList<>();

    public String getSetName() {
        return SetName;
    }

    public void setSetName(String setName) {
        SetName = setName;
    }

    public String getSetNickName() {
        return SetNickName;
    }

    public void setSetNickName(String setNickName) {
        SetNickName = setNickName;
    }

    public List<DataSection> getSections() {
        return sections;
    }

    public void setSections(List<DataSection> sections) {
        this.sections = sections;
    }

    public void addSection(EventData eventData){
        if(tracker.check(eventData.getSectionName())){
            sections.get(tracker.getId(eventData.getSectionName())).addPage(eventData);
        }
        else{
            DataSection dataSection = new DataSection();
            dataSection.setSectionName(eventData.getSectionName());
            dataSection.setSectionNickName(eventData.getSectionNickName());
            tracker.add(eventData.getSectionName());
            dataSection.addPage(eventData);
            sections.add(dataSection);
        }
    }
}

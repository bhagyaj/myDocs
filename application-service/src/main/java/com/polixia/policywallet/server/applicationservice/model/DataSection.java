package com.polixia.policywallet.server.applicationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class DataSection {
    @JsonIgnore
    Tracker tracker = new Tracker();

    private String sectionName;

    private String sectionNickName;
    private List<DataPage> pages = new ArrayList<>();

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionNickName() {
        return sectionNickName;
    }

    public void setSectionNickName(String sectionNickName) {
        this.sectionNickName = sectionNickName;
    }

    public List<DataPage> getPages() {
        return pages;
    }

    public void setPages(List<DataPage> pages) {
        this.pages = pages;
    }

    public void addPage(EventData eventData){
        if(tracker.check(eventData.getPageName())){
            pages.get(tracker.getId(eventData.getPageName())).addField(eventData);
        }
        else{
            DataPage dataPage = new DataPage();
            dataPage.setPageName(eventData.getPageName());
            tracker.add(eventData.getPageName());
            dataPage.addField(eventData);
            pages.add(dataPage);
        }
    }
}

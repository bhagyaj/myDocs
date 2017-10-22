package com.polixia.policywallet.server.applicationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class DataCard {
    @JsonIgnore
    private Tracker tracker = new Tracker();

    private String cardname;
    private List<DataSet> sets = new ArrayList<>();

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public List<DataSet> getSets() {
        return sets;
    }

    public void setSets(List<DataSet> sets) {
        this.sets = sets;
    }

    public void addSet(EventData eventData) {
        if (tracker.check(eventData.getSetName())) {
            sets.get(tracker.getId(eventData.getSetName())).addSection(eventData);
        } else {
            DataSet dataSet = new DataSet();
            dataSet.setSetName(eventData.getSetName());
            dataSet.setSetNickName(eventData.getSetNickName());
            tracker.add(eventData.getSetName());
            dataSet.addSection(eventData);
            sets.add(dataSet);
        }

    }
}

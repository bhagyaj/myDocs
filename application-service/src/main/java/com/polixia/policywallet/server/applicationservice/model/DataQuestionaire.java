package com.polixia.policywallet.server.applicationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brupasinghe on 10/17/2017.
 */
public class DataQuestionaire {
    @JsonIgnore
    private Tracker tracker = new Tracker();

    private String QuestionaireName;

    private List<DataCard> cards = new ArrayList<>();


    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }

    public String getQuestionaireName() {
        return QuestionaireName;
    }

    public void setQuestionaireName(String questionaireName) {
        this.QuestionaireName = questionaireName;
    }

    public List<DataCard> getCards() {
        return cards;
    }

    public void setCards(List<DataCard> cards) {
        this.cards = cards;
    }


    public void addCard(EventData eventData) {
        if (tracker.check(eventData.getCardName())) {
            cards.get(tracker.getId(eventData.getCardName())).addSet(eventData);
        } else {
            DataCard dataCard = new DataCard();
            dataCard.setCardname(eventData.getCardName());
            tracker.add(eventData.getCardName());
            dataCard.addSet(eventData);
            cards.add(dataCard);
        }

    }
}

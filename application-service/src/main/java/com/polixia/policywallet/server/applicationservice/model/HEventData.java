package com.polixia.policywallet.server.applicationservice.model;

/**
 * Created by brupasinghe on 10/17/2017.
 */
public class HEventData {
    private DataQuestionaire questionaire = new DataQuestionaire();



    public DataQuestionaire getQuestionaires() {
        return questionaire;
    }

    public void setQuestionaires(DataQuestionaire questionaires) {
        this.questionaire = questionaires;
    }

    public void addEventData(EventData eventData){
        if(questionaire.getQuestionaireName()!=null){
            questionaire.addCard(eventData);
        }
        else{
            DataQuestionaire dataQuestionaire = new DataQuestionaire();
            dataQuestionaire.setQuestionaireName(eventData.getQuestionaireType());
            dataQuestionaire.addCard(eventData);
            questionaire=dataQuestionaire;
        }
    }
}

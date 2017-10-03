package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.*;

import java.util.List;

public interface SettingsService {


    QuestionairePageField createPageField(QuestionairePageField payload);

    QuestionairePageField getPageFieldsById(Integer pageFieldId);

    QuestionaireCard createCards(QuestionaireCard payload);

    QuestionaireCard getCardById(int cardId);

    QuestionaireSection createSection(QuestionaireSection payload);

    QuestionaireSection getSectionById(int sectionId);

    QuestionaireType createQuestionnaire(QuestionaireType payload);

    QuestionaireSet addSet(QuestionaireSet payload);

    QuestionaireType getQuestionaireTypeById(int questionaireTypeId);

    QuestionairePage addPage(QuestionairePage payload);

    List<ResponseData> getGraphics(int version);

    List<ResponseData> getEventTypeData(int version);

    List<ResponseData> getEventSubscription(int version);

    Lobdef getLoBDefById(int id);

    QuestionairePage getPage(int id);

    public List<QuestionaireData> getHierarchicalQuestionaire(int version);

    public List<Setting> getVersions(int version);

    public List<Compliance> getCompliance(int version);

    QuestionaireSet getQuestionaireSet(int id);

    public List<ResponseData> getcSettingsByVersion(Integer id);


    List<FieldDef> getFieldDefinitions(Integer storeserver);

    FieldDef createFieldDefinition(FieldDef fieldDef);

    List<CarrierToVersion> getStoreserverVersions(String storeserver);


    EventTypeDef createEventTypeDefinition(EventTypeDef eventTypeDef);

    List<EventTypeDef> getEventTypeDefinitions();

    EventTypeDef getEventTypeDefinitionById(Integer id);

    EventTypeDef updateEventTypeDefinition(EventTypeDef payload);

    TileDef createTileDefinition(TileDef payload);

    Setting getSettingsById(Integer id);

    List<TileDef> getTileDefinitions();

    TileDef getTileDefinitionById(Integer id);

    TileDef updateTileDefinition(TileDef payload);

    FieldTypeDef createFieldTypeDef(FieldTypeDef fieldTypeDef);

    Setting getSettingById(Integer id);

    List<FieldTypeDef> getallFieldTypeDefs();

    FieldTypeDef getFieldTypeDef(Integer id);

    Lobdef createlobdef(Lobdef lobdef);

    List<Lobdef> getallLobDefs();

    QuestionaireType updateQuestionaireDefinition(QuestionaireType payload);

    QuestionaireCard updateQuestionaireCardDefinition(QuestionaireCard payload);

    QuestionaireSet updateQuestionaireSetDefinition(QuestionaireSet payload);

    QuestionaireSection updateQuestionairSectionDefinition(QuestionaireSection payload);

    QuestionairePage updateQuestionairePageDefinition(QuestionairePage payload);

    QuestionairePageField updateQuestionairePageFieldDefinition(QuestionairePageField payload);

    List<FieldTypeDef> getFieldTypes();

    List<QuestionaireData> getAllHierarchicalQuestionaires();

    FieldDef getFieldDefinitionsById(Integer id);

    List<Setting> getAllSettings();

    List<QuestionaireType> getQuestionaireByStoreserverId(Integer storeserverId);

    List<ComplianceRule> getAllCompliances(Integer storeserver);

    FieldDef updateFieldDefinition(FieldDef fieldDef);

    FieldTypeDef updateFieldTypeDef(FieldTypeDef fieldTypeDef);

    Lobdef updateLobDef(Lobdef lobdef);

    List<FieldTypeDef> getFieldTypesByVersion(Integer version);

    List<QuestionaireType> getQuestionaireByOwnerAndType(Integer storeserverId, String questionaire);
}

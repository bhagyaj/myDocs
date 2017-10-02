package com.polixia.policywallet.server.service.impl;

import com.polixia.policywallet.server.model.*;
import com.polixia.policywallet.server.repository.SettingsRepository;
import com.polixia.policywallet.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Settings service Implementation
 */
@Service
public class SettingsServiceImpl implements SettingsService {

    @Autowired
    QuestionairePageFieldsService questionairePageFieldsService;
    @Autowired
    QuestionaireCardsService questionaireCardsService;
    @Autowired
    QuestionairSectionsService questionairSectionsService;
    @Autowired
    QuestionaireTypeService questionaireTypeService;
    @Autowired
    GraphicalResourceDefService graphicalResourceDefService;
    @Autowired
    GraphicalResourceTypeService graphicalResourceTypeService;
    @Autowired
    EventTypeDefService eventTypeDefService;
    @Autowired
    FieldDefService fieldDefService;
    @Autowired
    TileDefService tileDefService;
    @Autowired
    FieldTypeDefService fieldTypeDefService;
    @Autowired
    LobDefService lobDefService;
    @Autowired
    EventSubscriptionService eventSubscriptionService;

    @Autowired
    QuestionaireSetService questionaireSetService;

    @Autowired
    QuestionairePageService questionairePageService;


    @Autowired
    ComplianceRuleDefService complianceRuleDefService;

    @Autowired
    ComplianceRuleService complianceRuleService;

    @Autowired
    EventCompliancesService eventCompliancesService;

    @Autowired
    QuestionairePageFldCompliancesService questionairePageFldCompliancesService;

    @Autowired
    SettingsRepository settingsRepository;

    @Autowired
    StoreServerService storeServerService;


    @Override
    public QuestionairePageField createPageField(QuestionairePageField payload) {
        return questionairePageFieldsService.upsertQuestionairePageField(payload);
    }

    @Override
    public QuestionairePageField getPageFieldsById(Integer pageFieldId) {
        return questionairePageFieldsService.getCQuestionairePageFieldsById(pageFieldId);
    }

    @Override
    public QuestionaireCard createCards(QuestionaireCard payload) {
        return questionaireCardsService.upsertCards(payload);
    }

    @Override
    public QuestionaireCard getCardById(int cardId) {
        return questionaireCardsService.getCardById(cardId);
    }

    @Override
    public QuestionaireSection createSection(QuestionaireSection payload) {
        return questionairSectionsService.upsertSection(payload);
    }

    @Override
    public QuestionaireSection getSectionById(int sectionId) {
        return questionairSectionsService.getSectionById(sectionId);
    }


    @Override
    public QuestionaireType createQuestionnaire(QuestionaireType payload) {
        return questionaireTypeService.upsertQuestionnaire(payload);
    }

    /**
     * This method will add QuestionaireSet
     *
     * @param payload
     * @return
     */
    @Override
    public QuestionaireSet addSet(QuestionaireSet payload) {
        return questionaireSetService.upsertQuestionaireSet(payload);
    }


    @Override
    public QuestionaireType getQuestionaireTypeById(int questionaireTypeId) {
        return questionaireTypeService.getQuestionaireTypeById(questionaireTypeId);
    }


    /**
     * This method will fetch Questionaire Set Based on Id
     *
     * @param id
     * @return cQuestionaireSet
     */
    @Override
    public QuestionaireSet getQuestionaireSet(int id) {
        return questionaireSetService.getCQuestionaireSetById(id);
    }

    /**
     * Get version data greater than given version
     *
     * @param id the version id
     * @return list of available versions
     */
    @Override
    public List<ResponseData> getcSettingsByVersion(Integer id) {
        ResponseData settingsData = new ResponseData();
        List<ResponseData> settingsDataList = new LinkedList<ResponseData>();
        settingsData.setTableName("csettings");
        settingsData.setDataList(settingsRepository.getSettingsByVersion(id));
        settingsDataList.add(settingsData);
        return settingsDataList;
    }
    @Override
    public List<ComplianceRule> getCompliance(long timestamp) {
        return complianceRuleService.getComplianceRulesBytimestampGreaterThan(timestamp);
    }


    @Override
    public List<FieldDef> getFieldDefinitions(Integer storeserver) {
     return fieldDefService.getFieldDefinitions(storeserver);
    }

    @Override
    public FieldDef createFieldDefinition(FieldDef fieldDef) {
       return fieldDefService.upsertFieldDefinition(fieldDef);
    }

    /**
     * This method will add a new QuestionairePage
     *
     * @param payload
     * @return QuestionairePage
     */
    @Override
    public QuestionairePage addPage(QuestionairePage payload) {
        return questionairePageService.upsertQuestionairePage(payload);
    }


    @Override
    public List<ResponseData> getGraphics(int version) {
        List<ResponseData> graphicsDataList = new LinkedList<ResponseData>();
        ResponseData graphicsDefData = new ResponseData();
        graphicsDefData.setTableName("cgraphicalresourcedef");
        graphicsDefData.setDataList(graphicalResourceDefService.getCGraphicalResourceDefById(version));
        graphicsDataList.add(graphicsDefData);

        ResponseData graphicsTypeData = new ResponseData();
        graphicsTypeData.setTableName("cgraphicalresourcestype");
        graphicsTypeData.setDataList(graphicalResourceTypeService.getCGraphicalResourceTypeById(version));
        graphicsDataList.add(graphicsTypeData);

        return graphicsDataList;
    }

    @Override
    public List<ResponseData> getEventTypeData(int version) {
        List<ResponseData> eventTypeDataList = new LinkedList<ResponseData>();
        ResponseData eventTypeDefData = new ResponseData();
        eventTypeDefData.setTableName("ceventtypedef");
        eventTypeDefData.setDataList(eventTypeDefService.getCEventTypeDefByVersionId(version));
        eventTypeDataList.add(eventTypeDefData);

        ResponseData cfielddefData = new ResponseData();
        cfielddefData.setTableName("cfielddef");
        cfielddefData.setDataList(fieldDefService.getCFieldDefByVersionId(version));
        eventTypeDataList.add(cfielddefData);

        ResponseData ctiledefData = new ResponseData();
        ctiledefData.setTableName("ctiledef");
        ctiledefData.setDataList(tileDefService.getCTileDefByVersionId(version));
        eventTypeDataList.add(ctiledefData);

        ResponseData cFieldTypedefData = new ResponseData();
        cFieldTypedefData.setTableName("cfieldtypedef");
        cFieldTypedefData.setDataList(fieldTypeDefService.getCFieldTypeDefByVersionId(version));
        eventTypeDataList.add(cFieldTypedefData);

        ResponseData clobDefData = new ResponseData();
        clobDefData.setTableName("clobdef");
        clobDefData.setDataList(lobDefService.getCLobdefByVersionId(version));
        eventTypeDataList.add(clobDefData);

        return eventTypeDataList;
    }


    /**
     * This will fetch QuestionairePage based on PageId
     *
     * @param id
     * @return cQuestionairePage
     */
    @Override
    public QuestionairePage getPage(int id) {
        return questionairePageService.getCQuestionairePageById(id);
    }


    /**
     * This method will return the hierarchical questionaire structure
     *
     * @param version
     * @return List<QuestionaireData>
     */
    @Override
    public List<QuestionaireData> getHierarchicalQuestionaire(int version) {
        ArrayList<QuestionaireData> questionaires = new ArrayList<>();
        List<Setting> versions = getVersions(version);
        for (Setting setting : versions) {
            QuestionaireData questionaireData = new QuestionaireData();
            questionaireData.setVersionId(setting.getId());
            questionaireData.setVersion(setting.getVersion());
            questionaireData.setQuestionaires(questionaireTypeService.getQuestionaireTypeByVersion(setting.getId()));
            questionaires.add(questionaireData);
        }
        return questionaires;
    }

    @Override
    public List<ResponseData> getEventSubscription(int version) {
        List<ResponseData> responseDataList = new LinkedList<ResponseData>();

        ResponseData responseData = new ResponseData();
        responseData.setTableName("ceventsubscription");
        responseData.setDataList(eventSubscriptionService.getCEventSubscriptionByVersionId(version));
        responseDataList.add(responseData);

        return responseDataList;
    }

    @Override
    public Lobdef getLoBDefById(int id) {
        return lobDefService.get(id);
    }

    /**
     * This method vill return the latest setting versions above the given version
     *
     * @param version
     * @return List<Setting>
     */
    @Override
    public List<Setting> getVersions(int version) {
        return settingsRepository.getSettingsListByVersion(version);
    }


    @Override
    public List<StoreServer> getStoreserverVersions(String storeserver) {
        return storeServerService.getStoreserverVersions(storeserver);
    }

    @Override
    public EventTypeDef createEventTypeDefinition(EventTypeDef eventTypeDef) {
        return eventTypeDefService.upsertEventTypeDefinition(eventTypeDef);
    }

    @Override
    public List<EventTypeDef> getEventTypeDefinitions() {
        return eventTypeDefService.getEventTypeDefinitions();
    }

    @Override
    public EventTypeDef getEventTypeDefinitionById(Integer id) {
        return eventTypeDefService.getEventTypeDefinitionById(id);
    }

    @Override
    public EventTypeDef updateEventTypeDefinition(EventTypeDef payload) {
        return eventTypeDefService.upsertEventTypeDefinition(payload);
    }

    @Override
    public TileDef createTileDefinition(TileDef payload) {
        return tileDefService.upsertTileDefinition(payload);
    }

    @Override
    public Setting getSettingsById(Integer id) {
        return settingsRepository.getSettingById(id);
    }

    @Override
    public List<TileDef> getTileDefinitions() {
        return tileDefService.getTileDefinitions();
    }

    @Override
    public TileDef getTileDefinitionById(Integer id) {
        return tileDefService.getTileDefinitionById(id);
    }

    @Override
    public TileDef updateTileDefinition(TileDef payload) {
        return tileDefService.upsertTileDefinition(payload);
    }


    /**
     * this will upsertLobDefinition a field type definition
     * @param fieldTypeDef
     * @return
     */

    @Override
    public FieldTypeDef createFieldTypeDef(FieldTypeDef fieldTypeDef) {
        return fieldTypeDefService.upsertFieldTypeDef(fieldTypeDef);
    }

    /**
     * This method will fetch a settings version by id
     * @param id
     * @return
     */

    @Override
    public Setting getSettingById(Integer id) {
        return settingsRepository.getSettingById(id);
    }


    /**
     * This method will get all field type definitions
     * @return
     */
    @Override
    public List<FieldTypeDef> getallFieldTypeDefs() {
        return fieldTypeDefService.getall();
    }

    /**
     * This method will get field type definition by id
     * @param id
     * @return
     */
    @Override
    public FieldTypeDef getFieldTypeDef(Integer id) {
        return fieldTypeDefService.get(id);
    }

    @Override
    public Lobdef createlobdef(Lobdef lobdef) {
        return lobDefService.upsertLobDefinition(lobdef);
    }

    @Override
    public List<Lobdef> getallLobDefs() {
        return lobDefService.getall();
    }
    public QuestionaireType updateQuestionaireDefinition(QuestionaireType payload) {
        return questionaireTypeService.upsertQuestionnaire(payload);
    }

    @Override
    public QuestionaireCard updateQuestionaireCardDefinition(QuestionaireCard payload) {
        return questionaireCardsService.upsertCards(payload);
    }

    @Override
    public QuestionaireSet updateQuestionaireSetDefinition(QuestionaireSet payload) {
        return questionaireSetService.upsertQuestionaireSet(payload);
    }

    @Override
    public QuestionaireSection updateQuestionairSectionDefinition(QuestionaireSection payload) {
        return questionairSectionsService.upsertSection(payload);
    }

    @Override
    public QuestionairePage updateQuestionairePageDefinition(QuestionairePage payload) {
        return questionairePageService.upsertQuestionairePage(payload);
    }

    @Override
    public QuestionairePageField updateQuestionairePageFieldDefinition(QuestionairePageField payload) {
        return questionairePageFieldsService.upsertQuestionairePageField(payload);
    }

    @Override
    public List<FieldTypeDef> getFieldTypes() {
        return fieldTypeDefService.getall();
    }

    @Override
    public List<QuestionaireData> getAllHierarchicalQuestionaires() {
        List<QuestionaireData> data = new ArrayList();
        QuestionaireData questionaireData = new QuestionaireData();
        questionaireData.setQuestionaires(questionaireTypeService.findAll());
        data.add(questionaireData);
        return data;

    }

    @Override
    public FieldDef getFieldDefinitionsById(Integer id) {
        return fieldDefService.getCFieldDefById(id);
    }

    @Override
    public List<ComplianceRule> getAllCompliances(Integer storeserver) {
        return complianceRuleService.getAllCompliances(storeserver);
    }

    @Override
    public FieldDef updateFieldDefinition(FieldDef fieldDef) {
        return fieldDefService.upsertFieldDefinition(fieldDef);
    }

    @Override
    public FieldTypeDef updateFieldTypeDef(FieldTypeDef fieldTypeDef) {
        return fieldTypeDefService.upsertFieldTypeDef(fieldTypeDef);
    }

    @Override
    public Lobdef updateLobDef(Lobdef lobdef) {
        return lobDefService.upsertLobDefinition(lobdef);
    }

    @Override
    public List<FieldTypeDef> getFieldTypesByVersion(Integer version) {
        return fieldTypeDefService.getFieldTypesByVersion(version);
    }

    @Override
    public List<QuestionaireType> getQuestionaireByOwnerAndType(Integer storeserverId, String questionaire) {
        return questionaireTypeService.getQuestionaireByOwnerAndType(storeserverId,questionaire);
    }

    @Override
    public List<QuestionaireData> getHierarchicalQuestionaireSync(Long dateTime) {
        List<QuestionaireData> data = new ArrayList();
        QuestionaireData questionaireData = new QuestionaireData();
        questionaireData.setQuestionaires(questionaireTypeService.getHierarchicalQuestionaireSync(dateTime));
        data.add(questionaireData);
        return data;
    }

    @Override
    public List<Setting> getAllSettings() {
        return settingsRepository.findAll();
    }

    @Override
    public List<QuestionaireType> getQuestionaireByStoreserverId(Integer storeserverId) {
        return questionaireTypeService.getQuestionaireByStoreserverId(storeserverId);
    }

}

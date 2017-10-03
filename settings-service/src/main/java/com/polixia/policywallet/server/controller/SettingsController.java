package com.polixia.policywallet.server.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.polixia.policywallet.core.component.LoggerFactory;
import com.polixia.policywallet.core.exceptions.PolixiaException;
import com.polixia.policywallet.server.jview.DataView;
import com.polixia.policywallet.server.model.*;
import com.polixia.policywallet.server.service.SettingsService;
import com.polixia.policywallet.server.util.ApplicationConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for the setting service
 */


@RestController
@RequestMapping(value = "/policywallet/settings")
public class SettingsController {

    @Autowired
    SettingsService settingsService;


    @Bean
    private  LoggerFactory.Logger logger() {
        return new LoggerFactory.Logger(this.getClass());
    }

    @Autowired
    LoggerFactory.Logger logger;

    /**
     * Create a questionaire
     *
     * @param payload the requested questionaire data
     * @return newly created QuestionaireType object
     * @throws PolixiaException if QuestionaireType creation failed
     */
    @RequestMapping(value = "/questionaires", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionaireType createQuestionaire(@RequestBody @Valid QuestionaireType payload) {

        try {
            return settingsService.createQuestionnaire(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());

        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * Get questionaire data using questionaire Id
     *
     * @param questionaireId the primary key of the QuestionaireType table
     * @return QuestionaireType data under given primary key
     * @throws PolixiaException if Requested QuestionaireType does not available
     */
    @RequestMapping(value = "/questionaires/{Id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.HDataSummary.class)
    public QuestionaireType getQuestionaireById(@PathVariable("Id") int questionaireId) {
        QuestionaireType questionaireType = settingsService.getQuestionaireTypeById(questionaireId);
        if (questionaireType == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DATA_NOT_AVAILABLE,
                    ApplicationConstant.ERROR_CODE_DATA_NOT_AVAILABLE, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }
        return questionaireType;
    }

    /**
     * Get questionaire data using storeserver Id
     *
     * @param storeserverId the primary key of the storeserver table
     * @return QuestionaireType data under given primary key
     */
    @RequestMapping(value = "/questionaires", method = RequestMethod.GET, params ="storeserver")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<QuestionaireType> getQuestionaireByStoreserverId(@RequestParam("storeserver") Integer storeserverId) {
        return settingsService.getQuestionaireByStoreserverId(storeserverId);
    }

    /**
     * Get questionaireType data using storeserver Id and questionaireType type
     *
     * @param storeserverId the primary key of the storeserver table,
     * @param questionaireType the requested questionaireType
     * @return QuestionaireType data under given primary key
     */
    @RequestMapping(value = "/questionaires", method = RequestMethod.GET, params = {"questionairetype", "storeserver"})
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.HDataSummary.class)
    public List<QuestionaireType> getQuestionaireByOwnerAndType(@RequestParam("questionairetype") String questionaireType, @RequestParam("storeserver") Integer storeserverId) {
        return settingsService.getQuestionaireByOwnerAndType(storeserverId,questionaireType);
    }

    /**
     * Update Questionaire definitions
     *
     * @param payload Questionaire definition data
     * @return QuestionaireType object
     */
    @RequestMapping(value = "questionaires", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionaireType updateQuestionaireDefinition(@RequestBody @Valid QuestionaireType payload) {
        try {

            return settingsService.updateQuestionaireDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * Create a card under questionaire
     *
     * @param payload the requested card data
     * @return newly created QuestionaireCard object
     * @throws PolixiaException if QuestionaireCard creation failed
     */
    @RequestMapping(value = "questionaires/cards", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionaireCard createCard(@RequestBody @Valid QuestionaireCard payload) {

        try {
            return settingsService.createCards(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * Get card data using card Id
     *
     * @param cardId the primary key of the QuestionaireCard table
     * @return QuestionaireCard data under given primary key
     * @throws PolixiaException if Requested QuestionaireCard does not available
     */
    @RequestMapping(value = "/questionaires/cards/{Id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionaireCard getCardById(@PathVariable("Id") int cardId) {
        QuestionaireCard cards = settingsService.getCardById(cardId);
        if (cards == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DATA_NOT_AVAILABLE,
                    ApplicationConstant.ERROR_CODE_DATA_NOT_AVAILABLE, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }
        return cards;
    }

    /**
     * Update QuestionaireCard definitions
     *
     * @param payload QuestionaireCard definition data
     * @return QuestionaireCard object
     */
    @RequestMapping(value = "questionaires/cards", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionaireCard updateQuestionaireCardDefinition(@RequestBody @Valid QuestionaireCard payload) {
        try {

            return settingsService.updateQuestionaireCardDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * This method will add QuestionaireSet
     *
     * @param payload
     * @return
     */
    @RequestMapping(value = "/questionaires/sets", method = RequestMethod.POST)
    @JsonView(DataView.Basic.class)
    public QuestionaireSet createQuestionairSet(@RequestBody @Valid QuestionaireSet payload) {

        try {
            return settingsService.addSet(payload);
        } catch (DataIntegrityViolationException dive) {
            //this happens when composite key constraint fails
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_COMPOSITE_ERROR,
                    ApplicationConstant.ERROR_CODE_COMPOSITE_ERROR, ApplicationConstant.HTTP_BAD_REQUEST);
        } catch (PolixiaException pe) {
            //catches the polixia exception logs it and rethrow it
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        }

    }

    /**
     * This method will fetch QuestionaireSet based on Id
     *
     * @param id
     * @return QuestionaireSet
     */
    @RequestMapping(value = "/questionaires/sets/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.ServiceSummary.class)
    public QuestionaireSet getQuestionSet(@PathVariable("id") int id) {
        QuestionaireSet cQuestionaireSet = settingsService.getQuestionaireSet(id);
        if (cQuestionaireSet == null) {
            //this happens when the data does exist for the id
            throw new PolixiaException(ApplicationConstant.ERROR_QSET_DATA_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_QSET_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }
        return cQuestionaireSet;
    }

    /**
     * Update QuestionaireSet definitions
     *
     * @param payload QuestionaireSet definition data
     * @return QuestionaireSet object
     */
    @RequestMapping(value = "questionaires/sets", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionaireSet updateQuestionaireSetDefinition(@RequestBody @Valid QuestionaireSet payload) {
        try {

            return settingsService.updateQuestionaireSetDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * Create a section under questionaire
     *
     * @param payload the requested card data
     * @return newly created cQuestionairSections object
     * @throws PolixiaException if section creation failed
     */
    @RequestMapping(value = "questionaires/sections", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionaireSection createSection(@RequestBody @Valid QuestionaireSection payload) {

        try {
            return settingsService.createSection(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * Get section data using section Id
     *
     * @param sectionId the primary key of the QuestionaireSection table
     * @return section data under given primary key
     * @throws PolixiaException if Requested section does not available
     */
    @RequestMapping(value = "/questionaires/sections/{Id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.ServiceSummary.class)
    public QuestionaireSection getSectionById(@PathVariable("Id") int sectionId) {
        QuestionaireSection sections = settingsService.getSectionById(sectionId);
        if (sections == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DATA_NOT_AVAILABLE,
                    ApplicationConstant.ERROR_CODE_DATA_NOT_AVAILABLE, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }
        return sections;
    }

    /**
     * Update QuestionaireSection definitions
     *
     * @param payload QuestionaireSection definition data
     * @return QuestionaireSection object
     */
    @RequestMapping(value = "questionaires/sections", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionaireSection updateQuestionairSectionDefinition(@RequestBody @Valid QuestionaireSection payload) {
        try {

            return settingsService.updateQuestionairSectionDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * This method will add a QuestionairePage
     *
     * @param payload
     * @return QuestionairePage
     */
    @RequestMapping(value = "/questionaires/pages", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionairePage addPage(@RequestBody @Valid QuestionairePage payload) {

        try {
            return settingsService.addPage(payload);
        } catch (DataIntegrityViolationException e) {
            //this happens when composite key constraint fails
            throw new PolixiaException(ApplicationConstant.ERROR_DATA_EXISTS,
                    ApplicationConstant.ERROR_CODE_DATA_NOT_INSERT, ApplicationConstant.HTTP_SC_NOT_FOUND);
        } catch (PolixiaException pe) {
            //catches the polixia exception logs it and rethrow it
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());

        }
    }


    /**
     * This method will fetch questionairePage based on the id(PageId)
     *
     * @param id
     * @return QuestionairePage
     */
    @RequestMapping(value = "/questionaires/pages/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.ServiceSummary.class)
    public QuestionairePage getPage(@PathVariable("id") int id) {
        QuestionairePage cQuestionairePage = settingsService.getPage(id);
        if (cQuestionairePage == null) {
            //This is caused when the id does not exists
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_PAGE_NOT_FOUND,
                    ApplicationConstant.ERROR_CODE_PAGE_NOT_FOUND, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }
        return cQuestionairePage;
    }

    /**
     * Update QuestionairePage definitions
     *
     * @param payload QuestionairePage definition data
     * @return QuestionairePage object
     */
    @RequestMapping(value = "questionaires/pages", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionairePage updateQuestionairePageDefinition(@RequestBody @Valid QuestionairePage payload) {
        try {

            return settingsService.updateQuestionairePageDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * upsertQuestionaireSet questionaire page fields
     *
     * @param payload the questionaire page field data
     * @return newly added questionaire page field
     * @throws PolixiaException if pageField creation failed
     */
    @RequestMapping(value = "questionaires/pagefields", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionairePageField createPageField(@RequestBody @Valid QuestionairePageField payload) {
        try {
            return settingsService.createPageField(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * Get questionaire page fields by pageFieldId
     *
     * @param pageFieldId the primary key of the
     * @return questionaire page fields QuestionairePageField table
     * @throws PolixiaException if Requested PageField does not available
     */
    @RequestMapping(value = "questionaires/pagefields/{Id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.ServiceSummary.class)
    public QuestionairePageField getPageFieldById(@PathVariable("Id") Integer pageFieldId) {
        QuestionairePageField pageFields = settingsService.getPageFieldsById(pageFieldId);
        if (pageFields == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DATA_NOT_AVAILABLE,
                    ApplicationConstant.ERROR_CODE_DATA_NOT_AVAILABLE, ApplicationConstant.HTTP_SC_NOT_FOUND);
        } else {
            return pageFields;
        }
    }

    /**
     * Update QuestionairePageField definitions
     *
     * @param payload QuestionairePageField definition data
     * @return QuestionairePageField object
     */
    @RequestMapping(value = "questionaires/pagefields", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public QuestionairePageField updateQuestionairePageFieldDefinition(@RequestBody @Valid QuestionairePageField payload) {
        try {

            return settingsService.updateQuestionairePageFieldDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * Get version data greater than given version
     *
     * @param version requested version
     * @return List of Available versions
     */
    @RequestMapping(value = "/versions", method = RequestMethod.GET, params = "version")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseData> getCSettings(@RequestParam("version") int version) {
        return settingsService.getcSettingsByVersion(version);
    }

    /**
     * Get all version data
     *
     * @return List of Available versions
     */
    @RequestMapping(value = "/versions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<Setting> getAllSettings() {
        return settingsService.getAllSettings();
    }

    /**
     * Get graphic data according to the version
     *
     * @param version the app version
     * @return graphic settings
     */
    @RequestMapping(value = "/graphics", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.DataSummary.class)
    public List<ResponseData> getGraphics(@RequestParam("version") int version) {
        return settingsService.getGraphics(version);
    }

    /**
     * Event related settings data
     *
     * @param version the requested version
     * @return setting data from each and every database table which related to event
     */
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.DataSummary.class)
    public List<ResponseData> getEventTypeData(@RequestParam("version") int version) {
        return settingsService.getEventTypeData(version);
    }

    /**
     * Get settings data related to event subscription
     *
     * @param version the requested version
     * @return List of setting data related to event subscription from given version onwards
     */
    @RequestMapping(value = "/subscriptions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseData> getEventSubscription(@RequestParam("version") int version) {
        return settingsService.getEventSubscription(version);
    }

    /**
     * This method will return the hierarchical questionaire structure
     *
     * @param version
     * @return List<QuestionaireData>
     */
    @RequestMapping(value = "/questionaires", params = "version")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.HDataSummary.class)
    public List<QuestionaireData> getHierarchicalQuestionaire(@RequestParam("version") int version) {
        return settingsService.getHierarchicalQuestionaire(version);
    }

    /**
     * This method will return the hierarchical questionaire structure for available questionaires
     *
     * @return List<QuestionaireData>
     */
    @RequestMapping(value = "/questionaires", params = "type")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.HSpecific.class)
    public List<QuestionaireData> getAllHierarchicalQuestionaires(@RequestParam("type") String summary) {
        if (summary.equalsIgnoreCase("Summary")) {
            return settingsService.getAllHierarchicalQuestionaires();
        } else {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_USE_TYPE_AS_SUMMARY, ApplicationConstant.ERROR_CODE_USE_TYPE_AS_SUMMARY, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * Get compliances greater than given version
     *
     * @param version the given version
     * @return list of compliance rules
     */
    @RequestMapping(value = "/compliances" , params = "version")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<Compliance> getCompliance(@RequestParam("version") int version) {
        return settingsService.getCompliance(version);
    }

    /**
     * Get all available compliances
     *
     * @return list of compliance rules
     */
    @RequestMapping(value = "/compliances")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Specific.class)
    public List<ComplianceRule> getAllCompliances(@RequestParam("storeserver") Integer storeserver) {
        return settingsService.getAllCompliances(storeserver);
    }


    /**
     * gets all field definitions by storeserver id
     * @param storeserver the storeserver id
     *
     * @return list of field definitions
     */
    @RequestMapping(value = "fielddefinitions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<FieldDef> getFieldDefinitions(@RequestParam("storeserver") int storeserver) {
        return settingsService.getFieldDefinitions(storeserver);
    }

    /**
     * gets field definitions by Id
     *
     * @return object of field definitions
     * @throws PolixiaException
     */
    @RequestMapping(value = "fielddefinitions/{Id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public FieldDef getFiledDefinitionsById(@PathVariable("Id") Integer id) {
        FieldDef fieldDef = settingsService.getFieldDefinitionsById(id);
        if (fieldDef != null) {
            return fieldDef;
        } else
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DATA_NOT_AVAILABLE, ApplicationConstant.ERROR_CODE_DATA_NOT_AVAILABLE, ApplicationConstant.HTTP_SC_NOT_FOUND);
    }

    /**
     * creates field definitions
     *
     * @param fieldDef field definition data
     * @return FieldDef object
     */
    @RequestMapping(value = "fielddefinitions", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public FieldDef createFieldDefinition(@RequestBody @Valid FieldDef fieldDef) {
        try {
            return settingsService.createFieldDefinition(fieldDef);
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * update field definitions
     *
     * @param fieldDef field definition data
     * @return FieldDef object
     */
    @RequestMapping(value = "fielddefinitions", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public FieldDef updateFieldDefinition(@RequestBody @Valid FieldDef fieldDef) {
        try {
            return settingsService.updateFieldDefinition(fieldDef);
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }


    /**
     * use to get version and id of store server
     *
     * @param storeserver the store server name
     * @return List of ids and versions
     */
    @RequestMapping(value = "/storeservers", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<CarrierToVersion> getStoreserverVersions(@RequestParam("storeserver") String storeserver) {
        return settingsService.getStoreserverVersions(storeserver);

    }

    /**
     * creates event type definitions
     *
     * @param payload event type definition data
     * @return EventTypeDef object
     */
    @RequestMapping(value = "eventtypedefinitions", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public EventTypeDef createEventTypeDefinition(@RequestBody @Valid EventTypeDef payload) {
        try {
            return settingsService.createEventTypeDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * gets all eventType definitions
     *
     * @return list of event type definitions
     */
    @RequestMapping(value = "eventtypedefinitions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<EventTypeDef> getEventTypeDefinitions() {
        return settingsService.getEventTypeDefinitions();
    }

    /**
     * gets eventType definitions by Id
     *
     * @return Object of event type definitions
     */
    @RequestMapping(value = "eventtypedefinitions/{Id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public EventTypeDef getEventTypeDefinitionById(@PathVariable("Id") Integer id) {
        return settingsService.getEventTypeDefinitionById(id);
    }

    /**
     * Update event type definitions
     *
     * @param payload event type definition data
     * @return EventTypeDef object
     */
    @RequestMapping(value = "eventtypedefinitions", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public EventTypeDef updateEventTypeDefinition(@RequestBody @Valid EventTypeDef payload) {
        try {

            return settingsService.updateEventTypeDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * This method will return event types with id
     *
     * @return list with event types and ids
     */
    @RequestMapping(value = "/eventtypedefinitions")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Specific.class)
    public List<EventTypeDef> geteventTypes(@RequestParam("type") String type) {
        if (!type.equals("summary")) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_USE_TYPE_AS_SUMMARY, ApplicationConstant.ERROR_CODE_USE_TYPE_AS_SUMMARY, ApplicationConstant.HTTP_SC_BAD_REQUEST);

        }

        return settingsService.getEventTypeDefinitions();
    }


    /**
     * creates Tile definitions
     *
     * @param payload tile definition data
     * @return TileDef object
     */
    @RequestMapping(value = "tiledefinitions", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public TileDef createTileDefinition(@RequestBody @Valid TileDef payload) {
        try {
            return settingsService.createTileDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * gets all Tile definitions
     *
     * @return list of tile definitions
     */
    @RequestMapping(value = "tiledefinitions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<TileDef> getTileDefinitions() {
        return settingsService.getTileDefinitions();
    }

    /**
     * gets Tile definitions by Id
     *
     * @return Object of tile definitions
     */
    @RequestMapping(value = "tiledefinitions/{Id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public TileDef getTileDefinitionById(@PathVariable("Id") Integer id) {
        TileDef tileDef = settingsService.getTileDefinitionById(id);
        if (tileDef != null) {
            return tileDef;
        } else
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DATA_NOT_AVAILABLE, ApplicationConstant.ERROR_CODE_DATA_NOT_AVAILABLE, ApplicationConstant.HTTP_SC_NOT_FOUND);

    }

    /**
     * Update Tile definitions
     *
     * @param payload event type definition data
     * @return EventTypeDef object
     */
    @RequestMapping(value = "tiledefinitions", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public TileDef updateTileDefinition(@RequestBody @Valid TileDef payload) {
        try {

            return settingsService.updateTileDefinition(payload);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }

    }

    /**
     * This method will upsertLobDefinition a Field Type Definition
     *
     * @param fieldTypeDef
     * @return
     */
    @RequestMapping(value = "/fieldtypedefinitions", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public FieldTypeDef createFieldTypeDef(@RequestBody @Valid FieldTypeDef fieldTypeDef) {
        try {
            return settingsService.createFieldTypeDef(fieldTypeDef);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * This method will update a Field Type Definition
     *
     * @param fieldTypeDef
     * @return
     */
    @RequestMapping(value = "/fieldtypedefinitions", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public FieldTypeDef updateFieldTypeDef(@RequestBody @Valid FieldTypeDef fieldTypeDef) {
        try {
            return settingsService.updateFieldTypeDef(fieldTypeDef);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * This method will get all Field Type Definitions
     *
     * @return
     */
    @RequestMapping(value = "/fieldtypedefinitions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<FieldTypeDef> getallFieldTypeDefs() {
        return settingsService.getallFieldTypeDefs();
    }


    /**
     * This method will get Field Type definition By Id
     */
    @RequestMapping(value = "/fieldtypedefinitions/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public FieldTypeDef getFieldTypeDef(@PathVariable("id") Integer id) {
        FieldTypeDef fieldTypeDef = settingsService.getFieldTypeDef(id);
        if (fieldTypeDef == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DATA_NOT_AVAILABLE,
                    ApplicationConstant.ERROR_CODE_DATA_NOT_AVAILABLE, ApplicationConstant.HTTP_SC_NOT_FOUND);
        }
        return fieldTypeDef;
    }

    /**
     * This method will get all Field Type Definitions
     *
     * @return
     */
    @RequestMapping(value = "/fieldtypedefinitions", method = RequestMethod.GET, params = "version")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<FieldTypeDef> getFieldTypesByVersion(@RequestParam("version") Integer version) {
            return settingsService.getFieldTypesByVersion(version);
    }

    /**
     * This method will return LoB Definition for the given id
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "lobdefinitions/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public Lobdef getLoBDef(@PathVariable("id") Integer id) {
        Lobdef lobdef = settingsService.getLoBDefById(id);
        if (lobdef == null) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DATA_NOT_AVAILABLE,
                    ApplicationConstant.ERROR_CODE_DATA_NOT_AVAILABLE, ApplicationConstant.HTTP_SC_NOT_FOUND);

        }
        return lobdef;
    }

    /**
     * This method will upsertLobDefinition a lob definition
     *
     * @param lobdef
     * @return
     */
    @RequestMapping(value = "/lobdefinitions", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public Lobdef createLobDef(@RequestBody @Valid Lobdef lobdef) {
        try {
            return settingsService.createlobdef(lobdef);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * This method will update a lob definition
     *
     * @param lobdef
     * @return
     */
    @RequestMapping(value = "/lobdefinitions", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public Lobdef updateLobDef(@RequestBody @Valid Lobdef lobdef) {
        try {
            return settingsService.updateLobDef(lobdef);
        } catch (PolixiaException pe) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_SAVE_FAILED.concat(pe.getErrorMessage()), pe.getErrorCode(), pe.getStatusCode());
        } catch (DataIntegrityViolationException e) {
            throw new PolixiaException(ApplicationConstant.ERROR_MESSAGE_DUPLICATE_DATA, ApplicationConstant.ERROR_CODE_DUPLICATE_DATA, ApplicationConstant.HTTP_SC_BAD_REQUEST);
        }
    }

    /**
     * This method will return all the LoB definitions
     *
     * @return
     */
    @RequestMapping(value = "/lobdefinitions", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @JsonView(DataView.Basic.class)
    public List<Lobdef> getallLobDefs() {
        return settingsService.getallLobDefs();
    }


}

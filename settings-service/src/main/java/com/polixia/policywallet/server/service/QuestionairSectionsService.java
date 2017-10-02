package com.polixia.policywallet.server.service;

import com.polixia.policywallet.server.model.QuestionaireSection;

/**
 * QuestionairSections Service
 */
public interface QuestionairSectionsService {

    QuestionaireSection upsertSection(QuestionaireSection payload);

    QuestionaireSection getSectionById(int sectionId);
}

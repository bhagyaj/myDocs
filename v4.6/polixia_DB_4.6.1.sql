-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: polixia_db_v4.6
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cbrokerevent`
--

DROP TABLE IF EXISTS `cbrokerevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbrokerevent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `EventType` char(20) DEFAULT NULL,
  `CredStatus` char(50) DEFAULT NULL,
  `EventLogo` blob,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`EventType`),
  KEY `fk_setting_brokerevent_idx` (`VersionId`),
  CONSTRAINT `fk_setting_brokerevent` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbrokerevent`
--

LOCK TABLES `cbrokerevent` WRITE;
/*!40000 ALTER TABLE `cbrokerevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `cbrokerevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccomplianceruledef`
--

DROP TABLE IF EXISTS `ccomplianceruledef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ccomplianceruledef` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `ComplianceRuleId` int(11) DEFAULT NULL,
  `RuleName` char(20) DEFAULT NULL,
  `Rule` int(2) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `QuestionairePageFieldId` int(11) DEFAULT NULL,
  `FieldName` char(50) DEFAULT NULL,
  `Sign` char(2) DEFAULT NULL,
  `Value` char(100) DEFAULT NULL,
  `Operator` char(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreServer`,`RuleName`,`Rule`,`QuestionaireType`,`CardName`,`SetName`,`SectionName`,`PageName`,`FieldName`),
  KEY `fk_compliancerule_complianceruledef_idx` (`ComplianceRuleId`),
  KEY `fk_pagefield_complianceruledef_idx` (`QuestionairePageFieldId`),
  CONSTRAINT `fk_compliancerule_complianceruledef` FOREIGN KEY (`ComplianceRuleId`) REFERENCES `ccompliancerules` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagefield_complianceruledef` FOREIGN KEY (`QuestionairePageFieldId`) REFERENCES `cquestionairepagefields` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccomplianceruledef`
--

LOCK TABLES `ccomplianceruledef` WRITE;
/*!40000 ALTER TABLE `ccomplianceruledef` DISABLE KEYS */;
/*!40000 ALTER TABLE `ccomplianceruledef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccompliancerules`
--

DROP TABLE IF EXISTS `ccompliancerules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ccompliancerules` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` char(20) DEFAULT NULL,
  `StoreServerId` int(11) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `ComplainceRule` char(20) DEFAULT NULL,
  `Description` char(20) DEFAULT NULL,
  `ComplianceResource` varchar(50) DEFAULT NULL,
  `ConsentGroup` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreServer`,`ComplainceRule`),
  KEY `fk_storeserver_compliancerules_idx` (`StoreServerId`),
  CONSTRAINT `fk_storeserver_compliancerules` FOREIGN KEY (`StoreServerId`) REFERENCES `sstoreserver` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccompliancerules`
--

LOCK TABLES `ccompliancerules` WRITE;
/*!40000 ALTER TABLE `ccompliancerules` DISABLE KEYS */;
/*!40000 ALTER TABLE `ccompliancerules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cevent`
--

DROP TABLE IF EXISTS `cevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cevent` (
  `Policy_Id` int(11) DEFAULT NULL,
  `PolicyId` char(50) DEFAULT NULL,
  `EventId` char(50) NOT NULL,
  `EventTypeId` int(11) DEFAULT NULL,
  `EventType` char(20) DEFAULT NULL,
  `TriggerEventId` char(50) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `ContentDef` char(50) DEFAULT NULL,
  `SvrUsersId` int(11) DEFAULT NULL,
  `User` char(20) DEFAULT NULL,
  `ServerSync` int(14) DEFAULT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `Submitted` timestamp(6) NULL DEFAULT NULL,
  `Effective` timestamp NULL DEFAULT NULL,
  `Compliance` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`EventId`),
  UNIQUE KEY `COMPOSITE` (`PolicyId`,`EventId`),
  KEY `fk_policy_event_idx` (`Policy_Id`),
  KEY `fk_questionairetype_event_idx` (`QuestionaireTypeId`),
  KEY `fk_event_event_idx` (`TriggerEventId`),
  KEY `fk_eventtype_event_idx` (`EventTypeId`),
  KEY `fk_svrusers_event_idx` (`SvrUsersId`),
  CONSTRAINT `fk_event_event` FOREIGN KEY (`TriggerEventId`) REFERENCES `cevent` (`EventId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_eventttype_event` FOREIGN KEY (`EventTypeId`) REFERENCES `ceventtypedef` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_policy_event` FOREIGN KEY (`Policy_Id`) REFERENCES `upolicy` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionairetype_event` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_svrusers_event` FOREIGN KEY (`SvrUsersId`) REFERENCES `svrusers` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cevent`
--

LOCK TABLES `cevent` WRITE;
/*!40000 ALTER TABLE `cevent` DISABLE KEYS */;
INSERT INTO `cevent` VALUES (NULL,'1111','1111',NULL,'APPLICATION',NULL,NULL,'Q_AUTO_QUESTIONAIRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,'1111','2222',NULL,'APPLICATIO',NULL,NULL,'Q_AUTO_QUESTIONAIRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,'2222','3333',NULL,'APPLICATION',NULL,NULL,'Q_AUTO_QUESTIONAIRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,'2222','4444',NULL,'APPLICATION',NULL,NULL,'Q_AUTO_QUESTIONAIRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,'1111','5555',NULL,'APPLICATION',NULL,NULL,'Q_AUTO_QUESTIONAIRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(NULL,'1111','6666',NULL,'APPLICATION',NULL,NULL,'Q_AUTO_QUESTIONAIRE',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ceventcompliance`
--

DROP TABLE IF EXISTS `ceventcompliance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceventcompliance` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `StoreBrand` char(50) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(50) DEFAULT NULL,
  `EventType` char(20) DEFAULT NULL,
  `ComplianceRuleId` int(11) DEFAULT NULL,
  `ComplianceRule` char(20) DEFAULT NULL,
  `ConsentType` char(10) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreServer`,`StoreBrand`,`LoB`,`EventType`,`ComplianceRule`),
  KEY `fk_compliancerule_eventcompliance_idx` (`ComplianceRuleId`),
  KEY `fk_lobsubscription_eventcompliance_idx` (`LoBSubscriptionId`),
  CONSTRAINT `fk_compliancerules_eventcompliance` FOREIGN KEY (`ComplianceRuleId`) REFERENCES `ccompliancerules` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lobsubscription_eventcompliance` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceventcompliance`
--

LOCK TABLES `ceventcompliance` WRITE;
/*!40000 ALTER TABLE `ceventcompliance` DISABLE KEYS */;
/*!40000 ALTER TABLE `ceventcompliance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ceventcomplianceconsent`
--

DROP TABLE IF EXISTS `ceventcomplianceconsent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceventcomplianceconsent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Policy_Id` int(11) DEFAULT NULL,
  `PolicyId` char(50) DEFAULT NULL,
  `EventId` char(50) DEFAULT NULL,
  `ComplianceRuleId` int(11) DEFAULT NULL,
  `ComplianceRule` char(20) DEFAULT NULL,
  `ConsentedOn` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`PolicyId`,`EventId`,`ComplianceRule`),
  KEY `fk_policy_eveentCompliance_idx` (`Policy_Id`),
  KEY `fk_complianceRule_eventCompliance_idx` (`ComplianceRuleId`),
  CONSTRAINT `fk_complianceRule_eventCompliance` FOREIGN KEY (`ComplianceRuleId`) REFERENCES `ccompliancerules` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_policy_eveentCompliance` FOREIGN KEY (`Policy_Id`) REFERENCES `upolicy` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='this might be changed to u event complaiance as sarindu has added cevent as uevent';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceventcomplianceconsent`
--

LOCK TABLES `ceventcomplianceconsent` WRITE;
/*!40000 ALTER TABLE `ceventcomplianceconsent` DISABLE KEYS */;
/*!40000 ALTER TABLE `ceventcomplianceconsent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ceventdata`
--

DROP TABLE IF EXISTS `ceventdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceventdata` (
  `Id` int(10) NOT NULL,
  `Policy_Id` int(11) DEFAULT NULL,
  `PolicyId` char(50) DEFAULT NULL,
  `EventId` char(50) DEFAULT NULL,
  `PageFeildId` int(11) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SetNickName` char(50) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `SectionNickName` char(50) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `FieldName` char(50) DEFAULT NULL,
  `Content` blob,
  `FieldCode` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`PolicyId`,`EventId`),
  KEY `fk_uevent_ueventdata_idx` (`EventId`),
  KEY `fk_policy_eventdata_idx` (`Policy_Id`),
  KEY `fk_pageField_ceventdata_idx` (`PageFeildId`),
  CONSTRAINT `fk_pageField_ceventdata` FOREIGN KEY (`PageFeildId`) REFERENCES `cquestionairepagefields` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_policy_eventdata` FOREIGN KEY (`Policy_Id`) REFERENCES `upolicy` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uevent_ueventdata` FOREIGN KEY (`EventId`) REFERENCES `cevent` (`EventId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Sarindu has ignored uPolicy';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceventdata`
--

LOCK TABLES `ceventdata` WRITE;
/*!40000 ALTER TABLE `ceventdata` DISABLE KEYS */;
INSERT INTO `ceventdata` VALUES (9,NULL,NULL,'1111',NULL,'UPID_PERSUS','QPAYMENT','ECHK','BD_NICKNAME','blank',NULL,'SAMPLEPAGE2','SAMPLEFIELD3','sampletext3',NULL),(10,NULL,NULL,'1111',NULL,'UPID_PERSUS','QPAYMENT','CCARD','CC_NICKNAME','SAMPLE',NULL,'SAMPLEPAGE1','SAMPLEFIELD2','sampletxt2',NULL),(11,NULL,NULL,'1111',NULL,'UPID_PERSUS','QPERSONAL','SAMPLESET',NULL,'blank',NULL,'blank','SAMPLEFIELD1','sampletxt1',''),(12,NULL,NULL,'1111',NULL,'UPID_PERSUS','QPERSONAL','blank',NULL,'NAMEADR',NULL,'PNAMEADR','NAME','Bob',NULL),(13,NULL,NULL,'1111',NULL,'UPID_PERSUS','QPERSONAL','blank',NULL,'EMPLOYEESTAT',NULL,'PEMPLOYEESTAT','EMPLOYEESTATUS','Student',NULL),(14,NULL,NULL,'1111',NULL,'UPID_PERSUS','blank','blank',NULL,'Beneficiary',NULL,'blank','BENEFIT','NoBenefit',NULL);
/*!40000 ALTER TABLE `ceventdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ceventsubscription`
--

DROP TABLE IF EXISTS `ceventsubscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceventsubscription` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `StoreBrand` char(50) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(50) DEFAULT NULL,
  `EventType` char(20) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `ContentDef` char(50) DEFAULT NULL,
  `Notification` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreServer`,`StoreBrand`,`LoB`,`EventType`),
  KEY `fk_questionaire_eventsub_idx` (`QuestionaireTypeId`),
  KEY `fk_lobsubscription_eventsubscription_idx` (`LoBSubscriptionId`),
  CONSTRAINT `fk_lobsubscription_eventsubscription` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionaire_eventsub` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceventsubscription`
--

LOCK TABLES `ceventsubscription` WRITE;
/*!40000 ALTER TABLE `ceventsubscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `ceventsubscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ceventtypedef`
--

DROP TABLE IF EXISTS `ceventtypedef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ceventtypedef` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `FieldOwner` char(50) DEFAULT NULL,
  `EventType` char(20) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `ContentDef` char(50) DEFAULT NULL,
  `WalletTile` char(20) DEFAULT NULL,
  `StoreTile` char(20) DEFAULT NULL,
  `Originator` char(20) DEFAULT NULL,
  `Description` char(50) DEFAULT NULL,
  `Hidden` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`FieldOwner`,`EventType`),
  KEY `fk_questionaire_eventtypedef_idx` (`QuestionaireTypeId`),
  CONSTRAINT `fk_questionaire_eventtypedef` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ceventtypedef`
--

LOCK TABLES `ceventtypedef` WRITE;
/*!40000 ALTER TABLE `ceventtypedef` DISABLE KEYS */;
/*!40000 ALTER TABLE `ceventtypedef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cfielddef`
--

DROP TABLE IF EXISTS `cfielddef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfielddef` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServerId` int(11) DEFAULT NULL,
  `FieldOwner` char(50) DEFAULT NULL,
  `FieldName` char(50) DEFAULT NULL,
  `FieldTypeDefId` int(11) DEFAULT NULL,
  `FieldType` char(10) DEFAULT NULL,
  `FieldLength` char(10) DEFAULT NULL,
  `FieldDescription` char(100) DEFAULT NULL,
  `CheckTable` char(50) DEFAULT NULL,
  `Lower` char(50) DEFAULT NULL,
  `Upper` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`FieldOwner`,`FieldName`),
  KEY `fk_storeserver_fielddef_idx` (`StoreServerId`),
  KEY `fk_fieldtypedef_fielddef_idx` (`FieldTypeDefId`),
  CONSTRAINT `fk_fieldtypedef_fielddef` FOREIGN KEY (`FieldTypeDefId`) REFERENCES `cfieldtypedef` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_storeserver_fielddef` FOREIGN KEY (`StoreServerId`) REFERENCES `sstoreserver` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cfielddef`
--

LOCK TABLES `cfielddef` WRITE;
/*!40000 ALTER TABLE `cfielddef` DISABLE KEYS */;
INSERT INTO `cfielddef` VALUES (1,'v1.0',1,'POLIXIA','NAME',1,'CHAR','50','NODIS','',NULL,NULL),(2,'V1.0',1,'POLIXIA','SAMPLEFIELD1',1,'CHAR','50','NODIS',NULL,NULL,NULL),(3,'V1.0',1,'POLIXIA','EMPLOYEESTATUS',1,'CHAR','50','NODIS',NULL,NULL,NULL),(4,'V1.0',1,'POLIXIA','SAMPLEFIELD2',1,'CHAR','50','nODIS',NULL,NULL,NULL),(5,'V1.0',1,'POLIXIA','SAMPLEFIELD3',1,'CHAR','50','NODIS',NULL,NULL,NULL),(6,'V1.0',1,'POLIXIA','BENEFIT',1,'CHAR','50','NODIS',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cfielddef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cfieldquestiondef`
--

DROP TABLE IF EXISTS `cfieldquestiondef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfieldquestiondef` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `FieldDefId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `FieldOwner` char(50) DEFAULT NULL,
  `FieldName` char(50) DEFAULT NULL,
  `FieldCode` char(50) DEFAULT NULL,
  `OrderNumber` int(4) DEFAULT NULL,
  `Question` char(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`FieldOwner`,`FieldName`,`FieldCode`),
  KEY `fk_cfieldsquestiondef_fieldname_idx` (`FieldName`),
  KEY `fk_fielddef_questiontype_idx` (`FieldDefId`),
  CONSTRAINT `fk_fielddef_questiontype` FOREIGN KEY (`FieldDefId`) REFERENCES `cfielddef` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cfieldquestiondef`
--

LOCK TABLES `cfieldquestiondef` WRITE;
/*!40000 ALTER TABLE `cfieldquestiondef` DISABLE KEYS */;
/*!40000 ALTER TABLE `cfieldquestiondef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cfieldtypedef`
--

DROP TABLE IF EXISTS `cfieldtypedef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfieldtypedef` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `versionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `FieldType` char(10) DEFAULT NULL,
  `FieldDescription` char(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`FieldType`),
  KEY `fk_cfieldtypedef` (`Version`),
  KEY `fk_settings_fieldtype_idx` (`versionId`),
  CONSTRAINT `fk_settings_fieldtype` FOREIGN KEY (`versionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Defines Field Type definitions that will be hardcoded in App';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cfieldtypedef`
--

LOCK TABLES `cfieldtypedef` WRITE;
/*!40000 ALTER TABLE `cfieldtypedef` DISABLE KEYS */;
INSERT INTO `cfieldtypedef` VALUES (1,1,'v1.0','char','letters');
/*!40000 ALTER TABLE `cfieldtypedef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cgraphicalresourcedef`
--

DROP TABLE IF EXISTS `cgraphicalresourcedef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cgraphicalresourcedef` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `GraphicalResourceTypeId` int(11) DEFAULT NULL,
  `ResourceType` char(50) DEFAULT NULL,
  `StoreServerId` int(11) DEFAULT NULL,
  `Owner` char(50) DEFAULT NULL,
  `ResourceName` char(10) DEFAULT NULL,
  `Platform` char(10) DEFAULT NULL,
  `Resolution` char(10) DEFAULT NULL,
  `Description` char(100) DEFAULT NULL,
  `GraphicResource` blob,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`ResourceType`,`Owner`,`ResourceName`,`Platform`,`Resolution`),
  KEY `fk_settings_gdef_idx` (`VersionId`),
  KEY `fk_storeserver_gdef_idx` (`StoreServerId`),
  KEY `fk_gresourcetype_gdef_idx` (`GraphicalResourceTypeId`),
  CONSTRAINT `fk_resouretype_gdef` FOREIGN KEY (`GraphicalResourceTypeId`) REFERENCES `cgraphicalresourcestype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_settings_gdef` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_storeserver_gdef` FOREIGN KEY (`StoreServerId`) REFERENCES `sstoreserver` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cgraphicalresourcedef`
--

LOCK TABLES `cgraphicalresourcedef` WRITE;
/*!40000 ALTER TABLE `cgraphicalresourcedef` DISABLE KEYS */;
/*!40000 ALTER TABLE `cgraphicalresourcedef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cgraphicalresourcestype`
--

DROP TABLE IF EXISTS `cgraphicalresourcestype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cgraphicalresourcestype` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `ResourceType` char(50) DEFAULT NULL,
  `Description` char(100) DEFAULT NULL,
  `NormalizedResolution` char(20) DEFAULT NULL,
  `SampleResource` blob,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`ResourceType`),
  KEY `fk_settings_graphicalresourcedef_idx` (`VersionId`),
  CONSTRAINT `fk_settings_graphicalresourcedef` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cgraphicalresourcestype`
--

LOCK TABLES `cgraphicalresourcestype` WRITE;
/*!40000 ALTER TABLE `cgraphicalresourcestype` DISABLE KEYS */;
/*!40000 ALTER TABLE `cgraphicalresourcestype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clobdef`
--

DROP TABLE IF EXISTS `clobdef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clobdef` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `ApplicationQuestionaire` char(50) DEFAULT NULL,
  `StoreLoBLogo` blob,
  `Text1` char(50) DEFAULT NULL,
  `DisplayOrder` int(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`LoB`,`Version`),
  KEY `fk_settings_lobdef_idx` (`VersionId`),
  CONSTRAINT `fk_setting_lobdef` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clobdef`
--

LOCK TABLES `clobdef` WRITE;
/*!40000 ALTER TABLE `clobdef` DISABLE KEYS */;
/*!40000 ALTER TABLE `clobdef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cquestionairecards`
--

DROP TABLE IF EXISTS `cquestionairecards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cquestionairecards` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `QuestionaireOwner` char(50) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `OrderNumber` int(4) DEFAULT NULL,
  `Title` char(100) DEFAULT NULL,
  `PageLogo` blob,
  `NoSet` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`QuestionaireOwner`,`QuestionaireType`,`CardName`),
  KEY `fk_questionairetype_cards_idx` (`QuestionaireTypeId`),
  CONSTRAINT `fk_questionairetype_cards` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cquestionairecards`
--

LOCK TABLES `cquestionairecards` WRITE;
/*!40000 ALTER TABLE `cquestionairecards` DISABLE KEYS */;
INSERT INTO `cquestionairecards` VALUES (1,'v1.0','polixia',1,'UPID_PERSUS','QPERSONAL',1,'PERSONAL','?',NULL),(2,'v1.0','polixia',1,'UPID_PERSUS','QPAYMENT',2,'PAYMENT','?',NULL),(3,'v1.0','polixia',1,'UPID_PERSUS','blank',3,'blank','blank',NULL);
/*!40000 ALTER TABLE `cquestionairecards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cquestionairepage`
--

DROP TABLE IF EXISTS `cquestionairepage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cquestionairepage` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `QuestionaireOwner` char(50) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SectionId` int(11) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `OrderNumber` int(4) DEFAULT NULL,
  `Description` char(50) DEFAULT NULL,
  `ComplianceRuleId` int(11) DEFAULT NULL,
  `ComplianceRule` char(20) DEFAULT NULL,
  `PageBehavior` char(10) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`QuestionaireOwner`,`QuestionaireType`,`CardName`,`SetName`,`SectionName`,`PageName`) USING BTREE,
  KEY `fk_questionairetype_page_idx` (`QuestionaireType`),
  KEY `fk_section_cquestionairepage_idx` (`SectionId`),
  KEY `fk_comrule_page_idx` (`ComplianceRuleId`),
  KEY `fk_setting_page_idx` (`Id`),
  CONSTRAINT `fk_comrule_page` FOREIGN KEY (`ComplianceRuleId`) REFERENCES `ccompliancerules` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_cquestionairepage` FOREIGN KEY (`SectionId`) REFERENCES `cquestionairsections` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cquestionairepage`
--

LOCK TABLES `cquestionairepage` WRITE;
/*!40000 ALTER TABLE `cquestionairepage` DISABLE KEYS */;
INSERT INTO `cquestionairepage` VALUES (1,'v1.0','POLIXIA','UPID_PERSUS','QPERSONAL','blank',1,'NAMEADR','PNAMEADR',1,'NODIS',NULL,NULL,NULL),(2,'V1.0','POLIXIA','UPID_PERSUS','QPERSONAL','blank',2,'EMPLOYEESTAT','PEMPLOYEESTAT',2,'NODIS',NULL,NULL,NULL),(3,'v1.0','POLIXIA','UPID_PERSUS','QPAYMENT','CCARD',4,'SAMPLE','SAMPLEPAGE1',1,'NODIS',NULL,NULL,NULL),(4,'V1.0','POLIXIA','UPID_PERSUS','QPAYMENT','ECHK',5,'blank','SAMPLEPAGE2',2,'NODIS',NULL,NULL,NULL),(5,'V1.0','POLIXIA','UPID_PERSUS','QPERSONAL','SAMPLESET',6,'blank','blank',1,'NODIS',NULL,NULL,NULL),(6,'V1.0','POLIXIA','UPID_PERSUS','blank','blank',3,'BENEFICIARY','blank',1,'NODIS',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cquestionairepage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cquestionairepagefields`
--

DROP TABLE IF EXISTS `cquestionairepagefields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cquestionairepagefields` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `QuestionaireOwner` char(50) DEFAULT NULL,
  `QuestionaireType` char(20) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `PageId` int(11) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `FieldDefId` int(11) DEFAULT NULL,
  `FieldName` char(20) DEFAULT NULL,
  `OrderNumber` int(4) DEFAULT NULL,
  `UserInput` tinyint(4) DEFAULT NULL,
  `ServerInput` tinyint(4) DEFAULT NULL,
  `MandatoryField` tinyint(4) DEFAULT NULL,
  `HiddenField` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`QuestionaireOwner`,`QuestionaireType`,`CardName`,`SetName`,`SectionName`,`PageName`,`FieldName`),
  KEY `fk_questionaireset_idx` (`SetName`),
  KEY `fk_fielddef_field_idx` (`FieldDefId`),
  KEY `fk_page_field_idx` (`PageId`),
  CONSTRAINT `fk_fielddef_field` FOREIGN KEY (`FieldDefId`) REFERENCES `cfielddef` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_page_field` FOREIGN KEY (`PageId`) REFERENCES `cquestionairepage` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cquestionairepagefields`
--

LOCK TABLES `cquestionairepagefields` WRITE;
/*!40000 ALTER TABLE `cquestionairepagefields` DISABLE KEYS */;
INSERT INTO `cquestionairepagefields` VALUES (1,'V1.0','POLIXIA','UPID_PERSUS','QPERSONAL','SAMPLESET','blank',5,'blank',1,'SAMPLEFIELD1',1,1,1,1,1),(2,'V1.0','POLIXIA','UPID_PERSUS','QPERSONAL','blank','NAMEADR',1,'PNAMEADR',2,'NAME',1,1,1,1,1),(3,'V1.0','POLIXIA','UPID_PERSUS','QPERSONAL','blank','EMPLOYEESTAT',2,'PEMPLOYEESTAT',3,'EMPLOYEESTATUS',1,1,1,1,1),(4,'V1.0','POLIXIA','UPID_PERSUS','QPAYMENT','CCARD','SAMPLE',3,'SAMPLEPAGE1',4,'SAMPLEFIELD2',1,1,1,1,1),(5,'V1.0','POLIXIA','UPID_PERSUS','QPAYMENT','ECHK','blank',4,'SAMPLEPAGE2',5,'SAMPLEFIELD3',1,1,1,1,1),(6,'V1.0','POLIXIA','UPID_PERSUS','blank','blank','BENEFICIARY',6,'blank',6,'BENEFIT',1,1,1,1,1);
/*!40000 ALTER TABLE `cquestionairepagefields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cquestionairepagefldcompliance`
--

DROP TABLE IF EXISTS `cquestionairepagefldcompliance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cquestionairepagefldcompliance` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` char(10) NOT NULL,
  `QuestionaireOwner` char(50) NOT NULL,
  `QuestionaireType` char(10) NOT NULL,
  `CardName` char(20) NOT NULL,
  `SetName` char(20) NOT NULL,
  `SectionName` char(20) NOT NULL,
  `PageName` char(20) NOT NULL,
  `PageFieldId` int(11) DEFAULT NULL,
  `FieldName` char(20) NOT NULL,
  `ComplainceRuleId` int(11) DEFAULT NULL,
  `ComplianceRule` char(20) NOT NULL,
  `FieldBehavior` char(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`QuestionaireOwner`,`QuestionaireType`,`CardName`,`SetName`,`SectionName`,`PageName`,`FieldName`,`ComplianceRule`),
  KEY `fk_compliance_fieldComplaince_idx` (`ComplainceRuleId`),
  KEY `fk_pagefield_fieldComplaince_idx` (`PageFieldId`),
  CONSTRAINT `fk_compliance_fieldComplaince` FOREIGN KEY (`ComplainceRuleId`) REFERENCES `ccompliancerules` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagefield_fieldComplaince` FOREIGN KEY (`PageFieldId`) REFERENCES `cquestionairepagefields` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cquestionairepagefldcompliance`
--

LOCK TABLES `cquestionairepagefldcompliance` WRITE;
/*!40000 ALTER TABLE `cquestionairepagefldcompliance` DISABLE KEYS */;
/*!40000 ALTER TABLE `cquestionairepagefldcompliance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cquestionaireset`
--

DROP TABLE IF EXISTS `cquestionaireset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cquestionaireset` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `QuestionaireOwner` char(50) DEFAULT NULL,
  `QuestionaireType` char(20) DEFAULT NULL,
  `CardId` int(11) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetId` char(20) DEFAULT NULL,
  `SetMax` int(2) DEFAULT NULL,
  `Text` char(50) DEFAULT NULL,
  `OrderNumber` int(4) DEFAULT NULL,
  `FieldDefId` int(11) DEFAULT NULL,
  `SetNickNameField` char(50) DEFAULT NULL,
  `NoSection` tinyint(4) DEFAULT NULL,
  `ComplianceRuleId` int(11) DEFAULT NULL,
  `ComplianceRule` char(20) DEFAULT NULL,
  `SetBehaviour` char(10) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`QuestionaireOwner`,`QuestionaireType`,`CardName`,`SetId`),
  KEY `fk_fielddef_set_idx` (`FieldDefId`),
  KEY `fk_card_set_idx` (`CardId`),
  KEY `fk_comrules_set_idx` (`ComplianceRuleId`),
  CONSTRAINT `fk_card_set` FOREIGN KEY (`CardId`) REFERENCES `cquestionairecards` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comrules_set` FOREIGN KEY (`ComplianceRuleId`) REFERENCES `ccompliancerules` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fielddef_set` FOREIGN KEY (`FieldDefId`) REFERENCES `cfielddef` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cquestionaireset`
--

LOCK TABLES `cquestionaireset` WRITE;
/*!40000 ALTER TABLE `cquestionaireset` DISABLE KEYS */;
INSERT INTO `cquestionaireset` VALUES (1,'v1.0','POLIXIA','UPID_PERSUS',1,'QPERSONAL','SAMPLESET',0,NULL,1,1,NULL,0,NULL,NULL,NULL),(2,'V1.0','POLIXIA','UPID_PERSUS',2,'QPAYMENT','CCARD',3,'Add Credit Card',1,1,'CC_NICKNAME',0,NULL,NULL,NULL),(3,'V1.0','POLIXIA','UPID_PERSUS',2,'QPAYMENT','ECHK',3,'Add Bank Details',2,1,'BD_NICKNAME',0,NULL,NULL,NULL),(4,'V1.0','POLIXIA','UPID_PERSUS',1,'QPERSONAL','blank',3,NULL,2,1,NULL,0,NULL,NULL,NULL),(6,'V1.0','POLIXIA','UPID_PERSUS',3,'blank','blank',3,NULL,1,1,NULL,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cquestionaireset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cquestionairetype`
--

DROP TABLE IF EXISTS `cquestionairetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cquestionairetype` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServerId` int(11) DEFAULT NULL,
  `QuestionaireOwner` char(50) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `Description` char(20) DEFAULT NULL,
  `QuestionaireId` int(11) DEFAULT NULL,
  `FollowUpEvent` char(50) DEFAULT NULL,
  `ReviewSubmit` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`QuestionaireOwner`,`QuestionaireType`),
  KEY `fk_storeserver_questionairetype_idx` (`StoreServerId`),
  KEY `fk_questionaireType_questionairetype_idx` (`QuestionaireId`),
  CONSTRAINT `fk_questionaireType_questionairetype` FOREIGN KEY (`QuestionaireId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_storeserver_questionairetype` FOREIGN KEY (`StoreServerId`) REFERENCES `sstoreserver` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cquestionairetype`
--

LOCK TABLES `cquestionairetype` WRITE;
/*!40000 ALTER TABLE `cquestionairetype` DISABLE KEYS */;
INSERT INTO `cquestionairetype` VALUES (1,'v1.0',1,'polixia','UPID_PERSUS','Sample questionaire',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cquestionairetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cquestionairsections`
--

DROP TABLE IF EXISTS `cquestionairsections`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cquestionairsections` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `QuestionaireOwner` char(50) DEFAULT NULL,
  `QuestionaireType` char(20) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetId` int(11) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `SectionLogo` blob,
  `SectionText` char(50) DEFAULT NULL,
  `OrderNumber` int(4) DEFAULT NULL,
  `SectionSet` tinyint(4) DEFAULT NULL,
  `FieldDefId` int(11) DEFAULT NULL,
  `SectionNickNameField` char(50) DEFAULT NULL,
  `NoPage` tinyint(4) DEFAULT NULL,
  `ComplianceRuleId` int(11) DEFAULT NULL,
  `ComplianceRule` char(20) DEFAULT NULL,
  `SectionBehavior` char(10) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`QuestionaireOwner`,`QuestionaireType`,`CardName`,`SetName`,`SectionName`),
  KEY `fk_set_section_idx` (`SetId`),
  KEY `fk_fielddef_section_idx` (`FieldDefId`),
  KEY `fk_compliancerules_section_idx` (`ComplianceRuleId`),
  CONSTRAINT `fk_compliancerules_section` FOREIGN KEY (`ComplianceRuleId`) REFERENCES `ccompliancerules` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_fielddef_section` FOREIGN KEY (`FieldDefId`) REFERENCES `cfielddef` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_set_section` FOREIGN KEY (`SetId`) REFERENCES `cquestionaireset` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cquestionairsections`
--

LOCK TABLES `cquestionairsections` WRITE;
/*!40000 ALTER TABLE `cquestionairsections` DISABLE KEYS */;
INSERT INTO `cquestionairsections` VALUES (1,'V1.0','POLIXIA','UPID_PERSUS','QPERSONAL',4,'blank','NAMEADR',NULL,'Name and Address',1,0,1,NULL,0,NULL,NULL,NULL),(2,'v1.0','POLIXIA','UPID_PERSUS','QPERSONAL',4,'blank','EMPLOYEESTAT',NULL,'Employee Status',2,0,1,'CC_NICKNAMKE',0,NULL,NULL,NULL),(3,'V1.0','POLIXIA','UPID_PERSUS','blank',6,'blank','BENEFICIARY',NULL,'Beneficiary',3,1,1,'BD_Nickname',0,NULL,NULL,NULL),(4,'v1.0','POLIXIA','UPID_PERSUS','QPAYMENT',2,'CCARD','SAMPLE',NULL,'Samplesection',1,0,1,NULL,0,NULL,NULL,NULL),(5,'v1.0','POLIXIA','UPID_PERSUS','QPAYMENT',3,'ECHK','blank',NULL,'blank',1,3,1,NULL,0,NULL,NULL,NULL),(6,'v1.0','POLIXIA','UPID_PERSUS','QPERSONAL',1,'SAMPLESET','blank',NULL,'blank',1,3,1,NULL,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cquestionairsections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `csettings`
--

DROP TABLE IF EXISTS `csettings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `csettings` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `Description` char(100) DEFAULT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `Released` tinyint(4) DEFAULT NULL,
  `Active` tinyint(4) DEFAULT NULL,
  `Location` char(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Version_UNIQUE` (`Version`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `csettings`
--

LOCK TABLES `csettings` WRITE;
/*!40000 ALTER TABLE `csettings` DISABLE KEYS */;
INSERT INTO `csettings` VALUES (1,'v1.0','go live release',NULL,1,1,NULL);
/*!40000 ALTER TABLE `csettings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctiledef`
--

DROP TABLE IF EXISTS `ctiledef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctiledef` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `Tile` char(20) DEFAULT NULL,
  `Description` char(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`Tile`),
  KEY `fk_settings_tiledef_idx` (`VersionId`),
  CONSTRAINT `fk_settings_tiledef` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctiledef`
--

LOCK TABLES `ctiledef` WRITE;
/*!40000 ALTER TABLE `ctiledef` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctiledef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papplication`
--

DROP TABLE IF EXISTS `papplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `papplication` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApplicationId` char(50) NOT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `Wallet_Id` int(11) DEFAULT NULL,
  `WalletId` char(50) DEFAULT NULL,
  `UIDId` int(11) DEFAULT NULL,
  `UID` char(50) DEFAULT NULL,
  `Active` tinyint(4) DEFAULT NULL,
  `Broker_Id` int(11) DEFAULT NULL,
  `BrokerId` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `ApplicationId_UNIQUE` (`ApplicationId`),
  KEY `fk_version_application_idx` (`VersionId`),
  KEY `fk_wallet_application_idx` (`Wallet_Id`),
  KEY `fk_broker_application_idx` (`Broker_Id`),
  KEY `fk_uid_application_idx` (`UIDId`),
  CONSTRAINT `fk_broker_application` FOREIGN KEY (`Broker_Id`) REFERENCES `pbroker` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uid_application` FOREIGN KEY (`UIDId`) REFERENCES `puid` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_version_application` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_wallet_application` FOREIGN KEY (`Wallet_Id`) REFERENCES `uwallet` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papplication`
--

LOCK TABLES `papplication` WRITE;
/*!40000 ALTER TABLE `papplication` DISABLE KEYS */;
/*!40000 ALTER TABLE `papplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papplicationcomplianceconsent`
--

DROP TABLE IF EXISTS `papplicationcomplianceconsent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `papplicationcomplianceconsent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApplicationId` char(50) DEFAULT NULL,
  `StoreSever` char(50) DEFAULT NULL,
  `StoreBrand` char(50) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(50) DEFAULT NULL,
  `ComplianceRuleId` int(11) DEFAULT NULL,
  `ComplianceRule` char(20) DEFAULT NULL,
  `ConsentedOn` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`ComplianceRule`,`LoB`,`StoreBrand`,`StoreSever`,`ApplicationId`),
  KEY `fk_compliancerules_applicationcomplianceconsent_idx` (`ComplianceRuleId`),
  KEY `fk_lobsubscription_applicationcomplianceconsent_idx` (`LoBSubscriptionId`),
  CONSTRAINT `fk_compliancerules_applicationcomplianceconsent` FOREIGN KEY (`ComplianceRuleId`) REFERENCES `ccompliancerules` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lobsubscription_applicationcomplianceconsent` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papplicationcomplianceconsent`
--

LOCK TABLES `papplicationcomplianceconsent` WRITE;
/*!40000 ALTER TABLE `papplicationcomplianceconsent` DISABLE KEYS */;
/*!40000 ALTER TABLE `papplicationcomplianceconsent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papplicationdata`
--

DROP TABLE IF EXISTS `papplicationdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `papplicationdata` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApplicationId` char(50) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `StoreBrand` char(20) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `PageFieldId` int(11) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SetNickName` char(50) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `SectionNickName` char(50) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `FieldName` char(50) DEFAULT NULL,
  `Content` blob,
  `FieldCode` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`ApplicationId`,`StoreServer`,`StoreBrand`,`LoB`,`PageFieldId`),
  KEY `fk_lobsubscription_applicationdata_idx` (`LoBSubscriptionId`),
  KEY `fk_pagefield_applicationdata_idx` (`PageFieldId`),
  CONSTRAINT `fk_lobsubscription_applicationdata` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagefield_applicationdata` FOREIGN KEY (`PageFieldId`) REFERENCES `cquestionairepagefields` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papplicationdata`
--

LOCK TABLES `papplicationdata` WRITE;
/*!40000 ALTER TABLE `papplicationdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `papplicationdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papplicationresult`
--

DROP TABLE IF EXISTS `papplicationresult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `papplicationresult` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApplicationId` char(50) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `StoreBrand` char(50) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(50) DEFAULT NULL,
  `Policy_Id` int(11) DEFAULT NULL,
  `PolicyId` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`ApplicationId`,`StoreServer`,`StoreBrand`,`LoB`),
  KEY `fk_policy_applicationresult_idx` (`Policy_Id`),
  KEY `fk_lobsubscription_applicationresult_idx` (`LoBSubscriptionId`),
  CONSTRAINT `fk_lobsubscription_applicationresult` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_policy_applicationresult` FOREIGN KEY (`Policy_Id`) REFERENCES `upolicy` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papplicationresult`
--

LOCK TABLES `papplicationresult` WRITE;
/*!40000 ALTER TABLE `papplicationresult` DISABLE KEYS */;
/*!40000 ALTER TABLE `papplicationresult` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `papplicationstore`
--

DROP TABLE IF EXISTS `papplicationstore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `papplicationstore` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ApplicationId` char(50) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `StroreBrand` char(50) DEFAULT NULL,
  `LobSubscriptionId` int(11) DEFAULT NULL,
  `Lob` char(50) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `Status` char(10) DEFAULT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `Submitted` timestamp(6) NULL DEFAULT NULL,
  `FullFilled` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`ApplicationId`,`StoreServer`,`StroreBrand`,`Lob`),
  KEY `fk_questionairetype_applicationstore_idx` (`QuestionaireTypeId`),
  KEY `fk_lobsubscription_applicationstore_idx` (`LobSubscriptionId`),
  CONSTRAINT `fk_lobsubscription_applicationstore` FOREIGN KEY (`LobSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionairetype_applicationstore` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `papplicationstore`
--

LOCK TABLES `papplicationstore` WRITE;
/*!40000 ALTER TABLE `papplicationstore` DISABLE KEYS */;
/*!40000 ALTER TABLE `papplicationstore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbroker`
--

DROP TABLE IF EXISTS `pbroker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbroker` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `BrokerId` char(50) DEFAULT NULL,
  `Description` char(50) DEFAULT NULL,
  `BrokerStoreLogo` blob,
  `ShieldGrey` blob,
  `ShieldProcessing` blob,
  `BrokerBanner` blob,
  `BrokerFileTypeLogo` blob,
  `BrokerMiniLogo` blob,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `User` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `BrokerId_UNIQUE` (`BrokerId`),
  KEY `fk_setting_broker_idx` (`VersionId`),
  CONSTRAINT `fk_setting_broker` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbroker`
--

LOCK TABLES `pbroker` WRITE;
/*!40000 ALTER TABLE `pbroker` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbroker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbrokerevent`
--

DROP TABLE IF EXISTS `pbrokerevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbrokerevent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `BrokerID` char(50) DEFAULT NULL,
  `EventID` char(50) DEFAULT NULL,
  `EventTypeId` int(11) DEFAULT NULL,
  `EventType` char(20) DEFAULT NULL,
  `TriggerEventID` char(50) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `StoreBrand` char(20) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `ContentDef` char(50) DEFAULT NULL,
  `Submitted` timestamp NULL DEFAULT NULL,
  `Effective` timestamp NULL DEFAULT NULL,
  `ServerSync` timestamp NULL DEFAULT NULL,
  `Created` timestamp NULL DEFAULT NULL,
  `pbrokereventcol1` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`BrokerID`,`EventID`),
  KEY `fk_eventtype_brokerevent_idx` (`EventTypeId`),
  KEY `fk_lobsubscription_brokerevent_idx` (`LoBSubscriptionId`),
  KEY `fk_questionnairetype_brokerevent_idx` (`QuestionaireTypeId`),
  CONSTRAINT `fk_eventtype_brokerevent` FOREIGN KEY (`EventTypeId`) REFERENCES `ceventtypedef` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lobsubscription_brokerevent` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionnairetype_brokerevent` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbrokerevent`
--

LOCK TABLES `pbrokerevent` WRITE;
/*!40000 ALTER TABLE `pbrokerevent` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbrokerevent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbrokereventdata`
--

DROP TABLE IF EXISTS `pbrokereventdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbrokereventdata` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Broker_Id` int(11) DEFAULT NULL,
  `BrokerID` char(50) DEFAULT NULL,
  `EventID` char(50) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `StoreBrand` char(20) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SetNickName` char(50) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `SectionNickName` char(50) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `QuestionairePageFieldId` int(11) DEFAULT NULL,
  `FieldDef` char(50) DEFAULT NULL,
  `content` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`EventID`,`StoreServer`,`StoreBrand`,`LoB`,`BrokerID`),
  KEY `fk_broker_brokereventdata_idx` (`Broker_Id`),
  KEY `fk_lobsubscription_brokereventdata_idx` (`LoBSubscriptionId`),
  KEY `fk_questionairepage_brokereventdata_idx` (`QuestionairePageFieldId`),
  CONSTRAINT `fk_broker_brokereventdata` FOREIGN KEY (`Broker_Id`) REFERENCES `pbroker` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lobsubscription_brokereventdata` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionairepage_brokereventdata` FOREIGN KEY (`QuestionairePageFieldId`) REFERENCES `cquestionairepage` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbrokereventdata`
--

LOCK TABLES `pbrokereventdata` WRITE;
/*!40000 ALTER TABLE `pbrokereventdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbrokereventdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbrokerlob`
--

DROP TABLE IF EXISTS `pbrokerlob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbrokerlob` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Broker_Id` int(11) DEFAULT NULL,
  `BrokerId` char(50) DEFAULT NULL,
  `BrokerLoB` char(20) DEFAULT NULL,
  `Active` tinyint(4) DEFAULT NULL,
  `LoBLogo` blob,
  `Text1` char(50) DEFAULT NULL,
  `Text2` char(50) DEFAULT NULL,
  `DisplayOrder` int(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`BrokerId`,`BrokerLoB`),
  KEY `fk_broker_brokerlob_idx` (`Broker_Id`),
  CONSTRAINT `fk_broker_brokerlob` FOREIGN KEY (`Broker_Id`) REFERENCES `pbroker` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbrokerlob`
--

LOCK TABLES `pbrokerlob` WRITE;
/*!40000 ALTER TABLE `pbrokerlob` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbrokerlob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbrokerref`
--

DROP TABLE IF EXISTS `pbrokerref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbrokerref` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `BrokerId` char(50) DEFAULT NULL,
  `SysId` char(50) DEFAULT NULL,
  `BrokerRef` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`BrokerId`,`SysId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbrokerref`
--

LOCK TABLES `pbrokerref` WRITE;
/*!40000 ALTER TABLE `pbrokerref` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbrokerref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbrokersubscription`
--

DROP TABLE IF EXISTS `pbrokersubscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbrokersubscription` (
  `Id` int(11) NOT NULL,
  `BrokerId` char(50) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `StoreBrand` char(50) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `BrokerLoBId` int(11) DEFAULT NULL,
  `BrokerLoB` char(50) DEFAULT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `Expiration` timestamp NULL DEFAULT NULL,
  `Submitted` timestamp(6) NULL DEFAULT NULL,
  `BrokerEventId` int(11) DEFAULT NULL,
  `CredStatus` char(20) DEFAULT NULL,
  `Approved` timestamp(6) NULL DEFAULT NULL,
  `Active` tinyint(4) DEFAULT NULL,
  `User` char(20) DEFAULT NULL,
  `Password` char(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`BrokerId`,`StoreServer`,`StoreBrand`,`LoB`),
  KEY `fk_lobsubscription_brokersubcription_idx` (`LoBSubscriptionId`),
  KEY `fk_brokerlob_brokersub_idx` (`BrokerLoBId`),
  CONSTRAINT `fk_brokerlob_brokersub` FOREIGN KEY (`BrokerLoBId`) REFERENCES `pbrokerlob` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lobsubscription_brokersubcription` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbrokersubscription`
--

LOCK TABLES `pbrokersubscription` WRITE;
/*!40000 ALTER TABLE `pbrokersubscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbrokersubscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbrokersubscriptionchannel`
--

DROP TABLE IF EXISTS `pbrokersubscriptionchannel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbrokersubscriptionchannel` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `BrokerSubscriptionId` int(11) DEFAULT NULL,
  `BrokerId` char(50) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `StoreBrand` char(50) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `Channel` char(20) DEFAULT NULL,
  `Description` char(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`BrokerId`,`StoreServer`,`StoreBrand`,`LoB`,`Channel`),
  KEY `fk_brokersubscription_brokersubscriptionchannel_idx` (`BrokerSubscriptionId`),
  CONSTRAINT `fk_brokersubscription_brokersubscriptionchannel` FOREIGN KEY (`BrokerSubscriptionId`) REFERENCES `pbrokersubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbrokersubscriptionchannel`
--

LOCK TABLES `pbrokersubscriptionchannel` WRITE;
/*!40000 ALTER TABLE `pbrokersubscriptionchannel` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbrokersubscriptionchannel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbrokersubscriptionchanneldef`
--

DROP TABLE IF EXISTS `pbrokersubscriptionchanneldef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbrokersubscriptionchanneldef` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `BrokerSubscriptionChannelId` int(11) DEFAULT NULL,
  `BrokerId` char(50) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `StoreBrand` char(50) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `Channel` char(20) DEFAULT NULL,
  `Rule` int(2) DEFAULT NULL,
  `pageFieldId` int(11) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `FieldName` char(50) DEFAULT NULL,
  `Sign` char(2) DEFAULT NULL,
  `Value` char(100) DEFAULT NULL,
  `Operator` char(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`BrokerId`,`StoreServer`,`StoreBrand`,`LoB`,`Channel`,`Rule`,`QuestionaireType`,`CardName`,`SetName`,`SectionName`,`PageName`,`FieldName`),
  KEY `fkbrokersubscriptionchannel_brokersubscriptionchanneldef_idx` (`BrokerSubscriptionChannelId`),
  KEY `fk_pagefields_brokersubscriptionchanneldef_idx` (`pageFieldId`),
  CONSTRAINT `fk_pagefields_brokersubscriptionchanneldef` FOREIGN KEY (`pageFieldId`) REFERENCES `cquestionairepagefields` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkbrokersubscriptionchannel_brokersubscriptionchanneldef` FOREIGN KEY (`BrokerSubscriptionChannelId`) REFERENCES `pbrokersubscriptionchannel` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbrokersubscriptionchanneldef`
--

LOCK TABLES `pbrokersubscriptionchanneldef` WRITE;
/*!40000 ALTER TABLE `pbrokersubscriptionchanneldef` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbrokersubscriptionchanneldef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pbrokersubscriptiondata`
--

DROP TABLE IF EXISTS `pbrokersubscriptiondata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pbrokersubscriptiondata` (
  `Id` int(11) NOT NULL,
  `Broker_Id` int(11) DEFAULT NULL,
  `BrokerId` char(50) DEFAULT NULL,
  `StoreServerId` int(11) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `StoreBrandId` int(11) DEFAULT NULL,
  `StoreBrand` char(20) DEFAULT NULL,
  `LobSubscriptionId` int(11) DEFAULT NULL,
  `Lob` char(20) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardId` int(11) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetId` int(11) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SetNickName` char(50) DEFAULT NULL,
  `SectionId` int(11) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `SectionNickName` char(50) DEFAULT NULL,
  `PageId` int(11) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `FieldDef` char(50) DEFAULT NULL,
  `Content` text,
  PRIMARY KEY (`Id`),
  KEY `fk_broker_brokersubscriptiondata_idx` (`Broker_Id`),
  KEY `fk_storeserevr_brokersubscriptiondata_idx` (`StoreServerId`),
  KEY `fk_questionairetype_brokersubscriptiondata_idx` (`QuestionaireTypeId`),
  KEY `fk_card_brokersubscriptiondata_idx` (`CardId`),
  KEY `fk_set_brokersubscriptiondata_idx` (`SetId`),
  KEY `fk_page_brokersubscriptiondata_idx` (`PageId`),
  KEY `fk_storebrand_brokersubsriptiondata_idx` (`StoreBrandId`),
  KEY `fk_section_brokersubdata_idx` (`SectionId`),
  KEY `fk_lobsubscription_brokersubscriptiondata_idx` (`LobSubscriptionId`),
  CONSTRAINT `fk_broker_brokersubscriptiondata` FOREIGN KEY (`Broker_Id`) REFERENCES `pbroker` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_card_brokersubscriptiondata` FOREIGN KEY (`CardId`) REFERENCES `cquestionairecards` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lobsubscription_brokersubscriptiondata` FOREIGN KEY (`LobSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_page_brokersubscriptiondata` FOREIGN KEY (`PageId`) REFERENCES `cquestionairepage` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionairetype_brokersubscriptiondata` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_section_brokersubdata` FOREIGN KEY (`SectionId`) REFERENCES `cquestionairsections` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_set_brokersubscriptiondata` FOREIGN KEY (`SetId`) REFERENCES `cquestionaireset` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_storebrand_brokersubsriptiondata` FOREIGN KEY (`StoreBrandId`) REFERENCES `sstorebrand` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_storeserevr_brokersubscriptiondata` FOREIGN KEY (`StoreServerId`) REFERENCES `sstoreserver` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pbrokersubscriptiondata`
--

LOCK TABLES `pbrokersubscriptiondata` WRITE;
/*!40000 ALTER TABLE `pbrokersubscriptiondata` DISABLE KEYS */;
/*!40000 ALTER TABLE `pbrokersubscriptiondata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pcontent`
--

DROP TABLE IF EXISTS `pcontent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pcontent` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Wallet_Id` int(11) DEFAULT NULL,
  `WalletId` char(50) DEFAULT NULL,
  `Policy_Id` int(11) DEFAULT NULL,
  `PolicyId` char(50) DEFAULT NULL,
  `StoreServerId` int(11) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`WalletId`,`PolicyId`),
  KEY `fk_policy_content_idx` (`Policy_Id`),
  KEY `fk_wallet_content_idx` (`Wallet_Id`),
  KEY `fk_storeserver_content_idx` (`StoreServerId`),
  CONSTRAINT `fk_policy_content` FOREIGN KEY (`Policy_Id`) REFERENCES `upolicy` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_storeserver_content` FOREIGN KEY (`StoreServerId`) REFERENCES `sstoreserver` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_wallet_content` FOREIGN KEY (`Wallet_Id`) REFERENCES `pwallet` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcontent`
--

LOCK TABLES `pcontent` WRITE;
/*!40000 ALTER TABLE `pcontent` DISABLE KEYS */;
/*!40000 ALTER TABLE `pcontent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puid`
--

DROP TABLE IF EXISTS `puid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puid` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UID` char(50) NOT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `QuestionaireType` char(10) DEFAULT NULL,
  `Wallet_Id` int(11) DEFAULT NULL,
  `WalletId` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UID_UNIQUE` (`UID`),
  KEY `fk_questionairetype_upid_idx` (`QuestionaireTypeId`),
  KEY `fk_wallet_upid_idx` (`Wallet_Id`),
  CONSTRAINT `fk_questionairetype_upid` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_wallet_upid` FOREIGN KEY (`Wallet_Id`) REFERENCES `uwallet` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puid`
--

LOCK TABLES `puid` WRITE;
/*!40000 ALTER TABLE `puid` DISABLE KEYS */;
/*!40000 ALTER TABLE `puid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puiddata`
--

DROP TABLE IF EXISTS `puiddata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puiddata` (
  `Id` int(11) NOT NULL,
  `UIDId` int(11) DEFAULT NULL,
  `UID` char(50) DEFAULT NULL,
  `FieldOwner` char(50) DEFAULT NULL,
  `PageFieldId` int(11) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SetNickName` char(50) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `SectionNickName` char(50) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `FieldName` char(50) DEFAULT NULL,
  `Multi` char(2) DEFAULT NULL,
  `FieldContent` text,
  `FieldCode` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`UID`,`FieldOwner`,`QuestionaireType`,`CardName`,`SetName`,`SectionName`,`PageName`,`FieldName`,`SetNickName`,`SectionNickName`,`Multi`),
  KEY `fk_uid_uiddata_idx` (`UIDId`),
  KEY `fk_pagefield_uiddata_idx` (`PageFieldId`),
  CONSTRAINT `fk_pagefield_uiddata` FOREIGN KEY (`PageFieldId`) REFERENCES `cquestionairepagefields` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uid_uiddata` FOREIGN KEY (`UIDId`) REFERENCES `puid` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puiddata`
--

LOCK TABLES `puiddata` WRITE;
/*!40000 ALTER TABLE `puiddata` DISABLE KEYS */;
/*!40000 ALTER TABLE `puiddata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pwallet`
--

DROP TABLE IF EXISTS `pwallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pwallet` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `WalletId` char(50) NOT NULL,
  `UIDId` int(11) DEFAULT NULL,
  `UID` char(50) DEFAULT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `Password` char(20) DEFAULT NULL,
  `RecoveryKey` char(50) DEFAULT NULL,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `ProductionType` char(10) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `WalletId_UNIQUE` (`WalletId`),
  KEY `fk_uid_wallet_idx` (`UIDId`),
  KEY `fk_setting_wallet_idx` (`VersionId`),
  CONSTRAINT `fk_setting_wallet` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_uid_wallet` FOREIGN KEY (`UIDId`) REFERENCES `puid` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pwallet`
--

LOCK TABLES `pwallet` WRITE;
/*!40000 ALTER TABLE `pwallet` DISABLE KEYS */;
/*!40000 ALTER TABLE `pwallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schannelsubscription`
--

DROP TABLE IF EXISTS `schannelsubscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schannelsubscription` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `StoreBrand` char(20) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `Channel` char(20) DEFAULT NULL,
  `Description` char(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreServer`,`StoreBrand`,`LoB`,`Channel`),
  KEY `fk_lobsubscriptiondef_channelsub_idx` (`LoBSubscriptionId`),
  CONSTRAINT `fk_lobsubscriptiondef_channelsub` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schannelsubscription`
--

LOCK TABLES `schannelsubscription` WRITE;
/*!40000 ALTER TABLE `schannelsubscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `schannelsubscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schannelsubscriptiondef`
--

DROP TABLE IF EXISTS `schannelsubscriptiondef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schannelsubscriptiondef` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `StoreBrand` char(20) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `ChannelSubscriptionId` int(11) DEFAULT NULL,
  `Channel` char(20) DEFAULT NULL,
  `Rule` int(2) DEFAULT NULL,
  `QuestionaireType` char(50) DEFAULT NULL,
  `CardName` char(20) DEFAULT NULL,
  `SetName` char(20) DEFAULT NULL,
  `SectionName` char(20) DEFAULT NULL,
  `PageName` char(20) DEFAULT NULL,
  `QuestionairePageFieldId` int(11) DEFAULT NULL,
  `FieldName` char(50) DEFAULT NULL,
  `Sign` char(2) DEFAULT NULL,
  `Value` char(100) DEFAULT NULL,
  `Operator` char(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreServer`,`StoreBrand`,`LoB`,`Channel`,`Rule`,`QuestionaireType`,`CardName`,`SetName`,`SectionName`,`PageName`,`FieldName`),
  KEY `fk_channelsubscription_channelsubscriptiondef_idx` (`ChannelSubscriptionId`),
  KEY `fk_pagefield_channelsubscriptiondef_idx` (`QuestionairePageFieldId`),
  CONSTRAINT `fk_channelsubscription_channelsubscriptiondef` FOREIGN KEY (`ChannelSubscriptionId`) REFERENCES `schannelsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagefield_channelsubscriptiondef` FOREIGN KEY (`QuestionairePageFieldId`) REFERENCES `cquestionairepagefields` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schannelsubscriptiondef`
--

LOCK TABLES `schannelsubscriptiondef` WRITE;
/*!40000 ALTER TABLE `schannelsubscriptiondef` DISABLE KEYS */;
/*!40000 ALTER TABLE `schannelsubscriptiondef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slobsubscription`
--

DROP TABLE IF EXISTS `slobsubscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slobsubscription` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServer` char(20) DEFAULT NULL,
  `StoreBrandId` int(11) DEFAULT NULL,
  `StoreBrand` char(20) DEFAULT NULL,
  `LoB` char(20) DEFAULT NULL,
  `LoBDefId` int(11) DEFAULT NULL,
  `LoBCategory` char(20) DEFAULT NULL,
  `SalesType` char(20) DEFAULT NULL,
  `Active` tinyint(4) DEFAULT NULL,
  `LoBLogo` blob,
  `Text1` char(50) DEFAULT NULL,
  `Text2` char(50) DEFAULT NULL,
  `DisplayOrder` int(4) DEFAULT NULL,
  `Bundle` tinyint(4) DEFAULT NULL,
  `Expiration` int(11) DEFAULT NULL,
  `ShieldGrey` blob,
  `ShieldProcessing` blob,
  `ShieldQuote` blob,
  `ShieldWallet` blob,
  `FileTypeLogo` blob,
  `ApplePay` tinyint(4) DEFAULT NULL,
  `ACH` tinyint(4) DEFAULT NULL,
  `CreditCard` tinyint(4) DEFAULT NULL,
  `QuestionaireTypeId` int(11) DEFAULT NULL,
  `BrokerQuestionaire` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreServer`,`StoreBrand`,`LoB`),
  KEY `fk_lobdef_lobsub_idx` (`LoBDefId`),
  KEY `fk_storebrand_lobsub_idx` (`StoreBrandId`),
  KEY `fk_questionairetype_lobsub_idx` (`QuestionaireTypeId`),
  CONSTRAINT `fk_lobdef_lobsub` FOREIGN KEY (`LoBDefId`) REFERENCES `clobdef` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questionairetype_lobsub` FOREIGN KEY (`QuestionaireTypeId`) REFERENCES `cquestionairetype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_storebrand_lobsub` FOREIGN KEY (`StoreBrandId`) REFERENCES `sstorebrand` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slobsubscription`
--

LOCK TABLES `slobsubscription` WRITE;
/*!40000 ALTER TABLE `slobsubscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `slobsubscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sstorebrand`
--

DROP TABLE IF EXISTS `sstorebrand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sstorebrand` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` char(10) DEFAULT NULL,
  `StoreServerId` int(11) DEFAULT NULL,
  `StoreSever` char(50) DEFAULT NULL,
  `StoreBrand` char(20) DEFAULT NULL,
  `Active` tinyint(4) DEFAULT NULL,
  `SalesType` char(20) DEFAULT NULL,
  `StoreLogo` blob,
  `StoreBanner` blob,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreSever`,`StoreBrand`),
  KEY `fk_storeserver_storebrand_idx` (`StoreServerId`),
  CONSTRAINT `fk_storeserver_storebrand` FOREIGN KEY (`StoreServerId`) REFERENCES `sstoreserver` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sstorebrand`
--

LOCK TABLES `sstorebrand` WRITE;
/*!40000 ALTER TABLE `sstorebrand` DISABLE KEYS */;
/*!40000 ALTER TABLE `sstorebrand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sstoreserver`
--

DROP TABLE IF EXISTS `sstoreserver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sstoreserver` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `VersionId` int(11) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `Location` varchar(20) DEFAULT NULL,
  `Port` int(11) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`Version`,`StoreServer`),
  KEY `fk_setting_storeserver_idx` (`VersionId`),
  CONSTRAINT `fk_setting_storeserver` FOREIGN KEY (`VersionId`) REFERENCES `csettings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sstoreserver`
--

LOCK TABLES `sstoreserver` WRITE;
/*!40000 ALTER TABLE `sstoreserver` DISABLE KEYS */;
INSERT INTO `sstoreserver` VALUES (1,1,'v1,0','polixia',NULL,NULL,NULL);
/*!40000 ALTER TABLE `sstoreserver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `svrauthactivity`
--

DROP TABLE IF EXISTS `svrauthactivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `svrauthactivity` (
  `Id` int(11) NOT NULL,
  `AuthProfileId` int(11) DEFAULT NULL,
  `AuthProfile` char(50) DEFAULT NULL,
  `AuthObjectTypeId` int(11) DEFAULT NULL,
  `AuthObjectType` char(50) DEFAULT NULL,
  `AuthActivityTypeId` int(11) DEFAULT NULL,
  `AuthActivityType` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`AuthProfile`,`AuthObjectType`,`AuthActivityType`),
  KEY `fk_authprofile_authactivity_idx` (`AuthProfileId`),
  KEY `fk_authobjecttype_authactivity_idx` (`AuthObjectTypeId`),
  KEY `fk_authactivitytype_authactivity_idx` (`AuthActivityTypeId`),
  CONSTRAINT `fk_authactivitytype_authactivity` FOREIGN KEY (`AuthActivityTypeId`) REFERENCES `svrauthactivitytype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_authobjecttype_authactivity` FOREIGN KEY (`AuthObjectTypeId`) REFERENCES `svrauthobjecttype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_authprofile_authactivity` FOREIGN KEY (`AuthProfileId`) REFERENCES `svrauthprofile` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `svrauthactivity`
--

LOCK TABLES `svrauthactivity` WRITE;
/*!40000 ALTER TABLE `svrauthactivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `svrauthactivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `svrauthactivitytype`
--

DROP TABLE IF EXISTS `svrauthactivitytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `svrauthactivitytype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AuthObjectTypeId` int(11) DEFAULT NULL,
  `AuthObjectType` char(50) DEFAULT NULL,
  `AuthActivityType` char(50) DEFAULT NULL,
  `Description` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`AuthObjectType`,`AuthActivityType`),
  KEY `fk_authobjecttype_authactivitytype_idx` (`AuthObjectTypeId`),
  CONSTRAINT `fk_authobjecttype_authactivitytype` FOREIGN KEY (`AuthObjectTypeId`) REFERENCES `svrauthobjecttype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `svrauthactivitytype`
--

LOCK TABLES `svrauthactivitytype` WRITE;
/*!40000 ALTER TABLE `svrauthactivitytype` DISABLE KEYS */;
/*!40000 ALTER TABLE `svrauthactivitytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `svrauthobject`
--

DROP TABLE IF EXISTS `svrauthobject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `svrauthobject` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AuthProfileId` int(11) DEFAULT NULL,
  `AuthProfile` char(50) DEFAULT NULL,
  `AuthObjectTypeId` int(11) DEFAULT NULL,
  `AuthObjectType` char(50) DEFAULT NULL,
  `AllowPLXEdit` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`AuthProfile`,`AuthObjectType`),
  KEY `fk_authprofile_authobject_idx` (`AuthProfileId`),
  KEY `fk_authobjecttype_authobject_idx` (`AuthObjectTypeId`),
  CONSTRAINT `fk_authobjecttype_authobject` FOREIGN KEY (`AuthObjectTypeId`) REFERENCES `svrauthobjecttype` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_authprofile_authobject` FOREIGN KEY (`AuthProfileId`) REFERENCES `svrauthprofile` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `svrauthobject`
--

LOCK TABLES `svrauthobject` WRITE;
/*!40000 ALTER TABLE `svrauthobject` DISABLE KEYS */;
/*!40000 ALTER TABLE `svrauthobject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `svrauthobjecttype`
--

DROP TABLE IF EXISTS `svrauthobjecttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `svrauthobjecttype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AuthObjectType` char(50) DEFAULT NULL,
  `Description` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `AuthObjectType_UNIQUE` (`AuthObjectType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `svrauthobjecttype`
--

LOCK TABLES `svrauthobjecttype` WRITE;
/*!40000 ALTER TABLE `svrauthobjecttype` DISABLE KEYS */;
/*!40000 ALTER TABLE `svrauthobjecttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `svrauthprofile`
--

DROP TABLE IF EXISTS `svrauthprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `svrauthprofile` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AuthProfile` char(50) DEFAULT NULL,
  `Description` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `AuthProfile_UNIQUE` (`AuthProfile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `svrauthprofile`
--

LOCK TABLES `svrauthprofile` WRITE;
/*!40000 ALTER TABLE `svrauthprofile` DISABLE KEYS */;
/*!40000 ALTER TABLE `svrauthprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `svrusers`
--

DROP TABLE IF EXISTS `svrusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `svrusers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` char(20) DEFAULT NULL,
  `UserType` char(20) DEFAULT NULL,
  `AuthProfileId` int(11) DEFAULT NULL,
  `AuthProfile` char(50) DEFAULT NULL,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `Password` char(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UserId_UNIQUE` (`UserId`),
  KEY `fk_authprofile_svruser_idx` (`AuthProfileId`),
  CONSTRAINT `fk_authprofile_svruser` FOREIGN KEY (`AuthProfileId`) REFERENCES `svrauthprofile` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `svrusers`
--

LOCK TABLES `svrusers` WRITE;
/*!40000 ALTER TABLE `svrusers` DISABLE KEYS */;
/*!40000 ALTER TABLE `svrusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upolicy`
--

DROP TABLE IF EXISTS `upolicy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upolicy` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PolicyID` char(50) DEFAULT NULL,
  `Version` char(10) DEFAULT NULL,
  `Location` char(10) DEFAULT NULL,
  `Type` char(10) DEFAULT NULL,
  `StoreServer` char(50) DEFAULT NULL,
  `StoreBrand` char(50) DEFAULT NULL,
  `LoBSubscriptionId` int(11) DEFAULT NULL,
  `Lob` char(50) DEFAULT NULL,
  `wallet_Id` int(11) DEFAULT NULL,
  `WalletId` char(50) DEFAULT NULL,
  `RecoveryKey` char(50) DEFAULT NULL,
  `Application_Id` int(11) DEFAULT NULL,
  `ApplicationId` char(50) DEFAULT NULL,
  `Broker_Id` int(11) DEFAULT NULL,
  `BrokerId` char(50) DEFAULT NULL,
  `BrokerRef` char(50) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `SvrUsersId` int(11) DEFAULT NULL,
  `User` char(20) DEFAULT NULL,
  `ShieldWallet` blob,
  `FileTypeLogo` blob,
  `Created` timestamp(6) NULL DEFAULT NULL,
  `Expires` timestamp(6) NULL DEFAULT NULL,
  `Accepted` timestamp(6) NULL DEFAULT NULL,
  `Rejected` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `PolicyID_UNIQUE` (`PolicyID`),
  KEY `fk_application_policy_idx` (`Application_Id`),
  KEY `fk_broker_policy_idx` (`Broker_Id`),
  KEY `fk_lobsubscription_policy_idx` (`LoBSubscriptionId`),
  KEY `fk_wallet_policy_idx` (`wallet_Id`),
  KEY `fk_svrUsers_policy_idx` (`SvrUsersId`),
  CONSTRAINT `fk_application_policy` FOREIGN KEY (`Application_Id`) REFERENCES `papplication` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_broker_policy` FOREIGN KEY (`Broker_Id`) REFERENCES `pbroker` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lobsubscription_policy` FOREIGN KEY (`LoBSubscriptionId`) REFERENCES `slobsubscription` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_svrusers_policy` FOREIGN KEY (`SvrUsersId`) REFERENCES `svrusers` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_wallet_policy` FOREIGN KEY (`wallet_Id`) REFERENCES `uwallet` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upolicy`
--

LOCK TABLES `upolicy` WRITE;
/*!40000 ALTER TABLE `upolicy` DISABLE KEYS */;
/*!40000 ALTER TABLE `upolicy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upolicyref`
--

DROP TABLE IF EXISTS `upolicyref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upolicyref` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PolicyId` char(50) DEFAULT NULL,
  `SysId` char(50) DEFAULT NULL,
  `PolicyRef` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `COMPOSITE` (`PolicyId`,`SysId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upolicyref`
--

LOCK TABLES `upolicyref` WRITE;
/*!40000 ALTER TABLE `upolicyref` DISABLE KEYS */;
/*!40000 ALTER TABLE `upolicyref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'peter@example.com','$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri',1),(2,'john@example.com','$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri',1),(3,'katie@example.com','$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uwallet`
--

DROP TABLE IF EXISTS `uwallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uwallet` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `WalletId` char(50) NOT NULL,
  `RecoveryId` char(50) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `WalletId_UNIQUE` (`WalletId`),
  UNIQUE KEY `RecoveryId_UNIQUE` (`RecoveryId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uwallet`
--

LOCK TABLES `uwallet` WRITE;
/*!40000 ALTER TABLE `uwallet` DISABLE KEYS */;
INSERT INTO `uwallet` VALUES (1,'1111','1111-111'),(2,'2222','2222-222'),(3,'3333','8b1ac48c-f291-42a0-93eb-bdd50e8103c1'),(4,'3456','391ccdf9-3fcb-401a-8f45-2238acbf566c'),(5,'8888','5e41d198-e631-4376-b19e-c19a0c485ff0'),(6,'9999','bcca162a-aa6f-4c68-b4ad-a09bccb7dcbd');
/*!40000 ALTER TABLE `uwallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-14 21:11:18

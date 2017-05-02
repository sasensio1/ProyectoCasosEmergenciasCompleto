CREATE TABLE "pointofdelivery__c" (
	"municipalityallocation__c" VARCHAR(255) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"repeatedcases__c" DOUBLE PRECISION NULL DEFAULT NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"meterproperty__c" VARCHAR(255) NULL DEFAULT NULL,
	"transformertype__c" VARCHAR(255) NULL DEFAULT NULL,
	"block__c" VARCHAR(255) NULL DEFAULT NULL,
	"transformernumber__c" VARCHAR(255) NULL DEFAULT NULL,
	"servicetype__c" VARCHAR(255) NULL DEFAULT NULL,
	"opencases__c" BOOLEAN NULL DEFAULT NULL,
	"metermodel__c" VARCHAR(255) NULL DEFAULT NULL,
	"paymentprocess__c" BOOLEAN NULL DEFAULT NULL,
	"connectionstatus__c" VARCHAR(255) NULL DEFAULT NULL,
	"ballotname__c" VARCHAR(255) NULL DEFAULT NULL,
	"electrodependant__c" VARCHAR(255) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"readingprocess__c" VARCHAR(255) NULL DEFAULT NULL,
	"grouptype__c" VARCHAR(255) NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"pointofdeliverystatus__c" VARCHAR(255) NULL DEFAULT NULL,
	"municipality__c" VARCHAR(1300) NULL DEFAULT NULL,
	"cutoffdate__c" TIMESTAMP NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"feedernumber__c" VARCHAR(255) NULL DEFAULT NULL,
	"lastmodifiedbyid" VARCHAR(18) NULL DEFAULT NULL,
	"condominiumsector__c" VARCHAR(255) NULL DEFAULT NULL,
	"metertype__c" VARCHAR(255) NULL DEFAULT NULL,
	"dangerzone__c" BOOLEAN NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"rate__c" VARCHAR(255) NULL DEFAULT NULL,
	"housetype__c" VARCHAR(255) NULL DEFAULT NULL,
	"disciplinarymeasure__c" VARCHAR(255) NULL DEFAULT NULL,
	"pointofdeliverynumber__c" VARCHAR(255) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"dvnumberpointofdelivery__c" VARCHAR(255) NULL DEFAULT NULL,
	"segmenttype__c" VARCHAR(255) NULL DEFAULT NULL,
	"fullelectric__c" VARCHAR(255) NULL DEFAULT NULL,
	"customerrating__c" VARCHAR(255) NULL DEFAULT NULL,
	"readingtype__c" VARCHAR(255) NULL DEFAULT NULL,
	"meternumber__c" VARCHAR(255) NULL DEFAULT NULL,
	"rationingschedule__c" VARCHAR(255) NULL DEFAULT NULL,
	"name" VARCHAR(80) NULL DEFAULT NULL,
	"electricalsubstationconnection__c" VARCHAR(255) NULL DEFAULT NULL,
	"ownerid" VARCHAR(18) NULL DEFAULT NULL,
	"meterbrand__c" VARCHAR(255) NULL DEFAULT NULL,
	"cuttingdebt__c" BOOLEAN NULL DEFAULT NULL,
	"connectiontype__c" VARCHAR(255) NULL DEFAULT NULL,
	"navigationcontactid__c" VARCHAR(255) NULL DEFAULT NULL,
	"transformername__c" VARCHAR(255) NULL DEFAULT NULL,
	"vip__c" VARCHAR(255) NULL DEFAULT NULL,
	"networkconnectionpoint__c" VARCHAR(255) NULL DEFAULT NULL,
	"route__c" VARCHAR(11) NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"companyid__c" VARCHAR(255) NULL DEFAULT NULL,
	"pointofdeliveryaddress__c" VARCHAR(1300) NULL DEFAULT NULL,
	"detailaddress__c" VARCHAR(18) NULL DEFAULT NULL,
	"distributionaddress__c" VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")
)
;

COMMENT ON COLUMN "pointofdelivery__c"."municipalityallocation__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."id" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."repeatedcases__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."createdbyid" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."meterproperty__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."transformertype__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."block__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."transformernumber__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."servicetype__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."opencases__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."metermodel__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."paymentprocess__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."connectionstatus__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."ballotname__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."electrodependant__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."sfid" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."readingprocess__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."grouptype__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."createddate" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."pointofdeliverystatus__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."municipality__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."cutoffdate__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."_hc_err" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."feedernumber__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."lastmodifiedbyid" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."condominiumsector__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."metertype__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."dangerzone__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."isdeleted" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."rate__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."housetype__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."disciplinarymeasure__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."pointofdeliverynumber__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."systemmodstamp" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."dvnumberpointofdelivery__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."segmenttype__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."fullelectric__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."customerrating__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."readingtype__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."meternumber__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."rationingschedule__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."name" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."electricalsubstationconnection__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."ownerid" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."meterbrand__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."cuttingdebt__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."connectiontype__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."navigationcontactid__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."transformername__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."vip__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."networkconnectionpoint__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."route__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."_hc_lastop" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."companyid__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."pointofdeliveryaddress__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."detailaddress__c" IS E'';
COMMENT ON COLUMN "pointofdelivery__c"."distributionaddress__c" IS E'';

CREATE SEQUENCE pointofdelivery__c_id_seq MINVALUE 0;
ALTER TABLE pointofdelivery__c ALTER id SET DEFAULT nextval('pointofdelivery__c_id_seq');
ALTER SEQUENCE pointofdelivery__c_id_seq OWNED BY pointofdelivery__c.id;

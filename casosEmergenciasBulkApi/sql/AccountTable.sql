CREATE TABLE "account" (
	"createddate" TIMESTAMP NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"address__c" VARCHAR(18) NULL DEFAULT NULL,
	"parentid" VARCHAR(18) NULL DEFAULT NULL,
	"companycategory__c" VARCHAR(255) NULL DEFAULT NULL,
	"identitynumber__c" VARCHAR(255) NULL DEFAULT NULL,
	"masterrecordid" VARCHAR(18) NULL DEFAULT NULL,
	"ownerid" VARCHAR(18) NULL DEFAULT NULL,
	"secondaryemail__c" VARCHAR(80) NULL DEFAULT NULL,
	"companyid__c" VARCHAR(255) NULL DEFAULT NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"sector__c" VARCHAR(255) NULL DEFAULT NULL,
	"businessname__c" VARCHAR(255) NULL DEFAULT NULL,
	"identitytype__c" VARCHAR(255) NULL DEFAULT NULL,
	"birthdate__c" DATE NULL DEFAULT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"mainphone__c" VARCHAR(40) NULL DEFAULT NULL,
	"accountcode__c" VARCHAR(255) NULL DEFAULT NULL,
	"additionalphone__c" VARCHAR(40) NULL DEFAULT NULL,
	"lastmodifiedbyid" VARCHAR(18) NULL DEFAULT NULL,
	"executive__c" VARCHAR(255) NULL DEFAULT NULL,
	"secondaryphone__c" VARCHAR(40) NULL DEFAULT NULL,
	"description" TEXT NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"usertypecompany__c" VARCHAR(255) NULL DEFAULT NULL,
	"primaryemail__c" VARCHAR(80) NULL DEFAULT NULL,
	"recordtypeid" VARCHAR(18) NOT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"type" VARCHAR(40) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"phone" VARCHAR(40) NULL DEFAULT NULL,
	"masterrecord__identitynumber__c" VARCHAR(255) NULL DEFAULT NULL,
	"motherslastname__c" VARCHAR(255) NULL DEFAULT NULL,
	"fatherslastname__c" VARCHAR(255) NULL DEFAULT NULL,
	"parent__identitynumber__c" VARCHAR(255) NULL DEFAULT NULL,
	"accountsource" VARCHAR(40) NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")
	)
;

COMMENT ON COLUMN "account"."createddate" IS E'';
COMMENT ON COLUMN "account"."_hc_err" IS E'';
COMMENT ON COLUMN "account"."address__c" IS E'';
COMMENT ON COLUMN "account"."parentid" IS E'';
COMMENT ON COLUMN "account"."companycategory__c" IS E'';
COMMENT ON COLUMN "account"."identitynumber__c" IS E'';
COMMENT ON COLUMN "account"."masterrecordid" IS E'';
COMMENT ON COLUMN "account"."ownerid" IS E'';
COMMENT ON COLUMN "account"."secondaryemail__c" IS E'';
COMMENT ON COLUMN "account"."companyid__c" IS E'';
COMMENT ON COLUMN "account"."createdbyid" IS E'';
COMMENT ON COLUMN "account"."_hc_lastop" IS E'';
COMMENT ON COLUMN "account"."sector__c" IS E'';
COMMENT ON COLUMN "account"."businessname__c" IS E'';
COMMENT ON COLUMN "account"."identitytype__c" IS E'';
COMMENT ON COLUMN "account"."birthdate__c" IS E'';
COMMENT ON COLUMN "account"."name" IS E'';
COMMENT ON COLUMN "account"."systemmodstamp" IS E'';
COMMENT ON COLUMN "account"."mainphone__c" IS E'';
COMMENT ON COLUMN "account"."accountcode__c" IS E'';
COMMENT ON COLUMN "account"."additionalphone__c" IS E'';
COMMENT ON COLUMN "account"."lastmodifiedbyid" IS E'';
COMMENT ON COLUMN "account"."executive__c" IS E'';
COMMENT ON COLUMN "account"."secondaryphone__c" IS E'';
COMMENT ON COLUMN "account"."description" IS E'';
COMMENT ON COLUMN "account"."id" IS E'';
COMMENT ON COLUMN "account"."usertypecompany__c" IS E'';
COMMENT ON COLUMN "account"."primaryemail__c" IS E'';
COMMENT ON COLUMN "account"."recordtypeid" IS E'';
COMMENT ON COLUMN "account"."isdeleted" IS E'';
COMMENT ON COLUMN "account"."type" IS E'';
COMMENT ON COLUMN "account"."sfid" IS E'';
COMMENT ON COLUMN "account"."phone" IS E'';
COMMENT ON COLUMN "account"."masterrecord__identitynumber__c" IS E'';
COMMENT ON COLUMN "account"."motherslastname__c" IS E'';
COMMENT ON COLUMN "account"."fatherslastname__c" IS E'';
COMMENT ON COLUMN "account"."parent__identitynumber__c" IS E'';
COMMENT ON COLUMN "account"."accountsource" IS E'';



CREATE SEQUENCE account_id_seq MINVALUE 0;
ALTER TABLE account ALTER id SET DEFAULT nextval('account_id_seq');
ALTER SEQUENCE account_id_seq OWNED BY account.id;



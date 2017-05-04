CREATE TABLE "street__c" (
	"recordtypeid" VARCHAR(18) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"currencyisocode" VARCHAR(3) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"region__c" VARCHAR(255) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"name" VARCHAR(80) NULL DEFAULT NULL,
	"literal_region__c" VARCHAR(255) NULL DEFAULT NULL,
	"lastmodifiedbyid" VARCHAR(18) NULL DEFAULT NULL,
	"municipality__c" VARCHAR(255) NULL DEFAULT NULL,
	"literal_municipality__c" VARCHAR(255) NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"lastmodifieddate" TIMESTAMP NULL,
	"literal_street_type__c" VARCHAR(255) NULL DEFAULT NULL,
	"street__c" VARCHAR(255) NULL DEFAULT NULL,
	"ownerid" VARCHAR(18) NULL DEFAULT NULL,
	"country__c" VARCHAR(255) NULL DEFAULT NULL,
	"company__c" VARCHAR(255) NULL DEFAULT NULL,
	"street_type__c" VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")
)
;

COMMENT ON COLUMN "street__c"."recordtypeid" IS E'';
COMMENT ON COLUMN "street__c"."_hc_err" IS E'';
COMMENT ON COLUMN "street__c"."isdeleted" IS E'';
COMMENT ON COLUMN "street__c"."currencyisocode" IS E'';
COMMENT ON COLUMN "street__c"."systemmodstamp" IS E'';
COMMENT ON COLUMN "street__c"."region__c" IS E'';
COMMENT ON COLUMN "street__c"."id" IS E'';
COMMENT ON COLUMN "street__c"."createddate" IS E'';
COMMENT ON COLUMN "street__c"."sfid" IS E'';
COMMENT ON COLUMN "street__c"."name" IS E'';
COMMENT ON COLUMN "street__c"."literal_region__c" IS E'';
COMMENT ON COLUMN "street__c"."lastmodifiedbyid" IS E'';
COMMENT ON COLUMN "street__c"."municipality__c" IS E'';
COMMENT ON COLUMN "street__c"."literal_municipality__c" IS E'';
COMMENT ON COLUMN "street__c"."_hc_lastop" IS E'';
COMMENT ON COLUMN "street__c"."createdbyid" IS E'';
COMMENT ON COLUMN "street__c"."lastmodifieddate" IS E'';
COMMENT ON COLUMN "street__c"."literal_street_type__c" IS E'';
COMMENT ON COLUMN "street__c"."street__c" IS E'';
COMMENT ON COLUMN "street__c"."ownerid" IS E'';
COMMENT ON COLUMN "street__c"."country__c" IS E'';
COMMENT ON COLUMN "street__c"."company__c" IS E'';
COMMENT ON COLUMN "street__c"."street_type__c" IS E'';


CREATE SEQUENCE street__c_id_seq MINVALUE 0;
ALTER TABLE street__c ALTER id SET DEFAULT nextval('street__c_id_seq');
ALTER SEQUENCE street__c_id_seq OWNED BY street__c.id;

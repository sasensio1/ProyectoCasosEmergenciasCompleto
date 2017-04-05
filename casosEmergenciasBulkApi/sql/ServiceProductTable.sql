CREATE TABLE "serviceproduct__c" (
	"relationshipduplicatedvalidator__c" VARCHAR(255) NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"asset__c" VARCHAR(18) NULL DEFAULT NULL,
	"typeofrelationship__c" VARCHAR(255) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"principal__c" BOOLEAN NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"createddate" TIMESTAMP NULL,
	"contact__c" VARCHAR(18) NULL DEFAULT NULL,
	"duplicatedvalidator__c" TEXT NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"name" VARCHAR(80) NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")
)
;

COMMENT ON COLUMN "serviceproduct__c"."relationshipduplicatedvalidator__c" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."isdeleted" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."sfid" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."asset__c" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."typeofrelationship__c" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."id" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."principal__c" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."systemmodstamp" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."createddate" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."contact__c" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."duplicatedvalidator__c" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."_hc_err" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."_hc_lastop" IS E'';
COMMENT ON COLUMN "serviceproduct__c"."name" IS E'';

CREATE SEQUENCE serviceproduct__c_id_seq MINVALUE 0;
ALTER TABLE serviceproduct__c ALTER id SET DEFAULT nextval('serviceproduct__c_id_seq');
ALTER SEQUENCE serviceproduct__c_id_seq OWNED BY serviceproduct__c.id;

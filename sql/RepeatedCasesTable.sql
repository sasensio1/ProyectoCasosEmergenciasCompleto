CREATE TABLE "repeatedcases__c" (
	"numberdays__c" DOUBLE PRECISION NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"numbercases__c" DOUBLE PRECISION NULL DEFAULT NULL,
	"name" VARCHAR(38) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"createddate" TIMESTAMP NULL,
	PRIMARY KEY ("sfid")
)
;

COMMENT ON COLUMN "repeatedcases__c"."numberdays__c" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."id" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."_hc_lastop" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."_hc_err" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."isdeleted" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."numbercases__c" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."name" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."sfid" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."systemmodstamp" IS E'';
COMMENT ON COLUMN "repeatedcases__c"."createddate" IS E'';

CREATE SEQUENCE repeatedcases__c_id_seq MINVALUE 0;
ALTER TABLE repeatedcases__c ALTER id SET DEFAULT nextval('repeatedcases__c_id_seq');
ALTER SEQUENCE repeatedcases__c_id_seq OWNED BY repeatedcases__c.id;

CREATE TABLE "asset" (
	"id" INTEGER NOT NULL DEFAULT NULL,
	"usageenddate" DATE NULL DEFAULT NULL,
	"lastmodifiedbyid" VARCHAR(18) NULL DEFAULT NULL,
	"name" VARCHAR(255) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"type__c" VARCHAR(1300) NULL DEFAULT NULL,
	"status" VARCHAR(40) NULL DEFAULT NULL,
	"installdate" DATE NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"price" DOUBLE PRECISION NULL DEFAULT NULL,
	"pointofdelivery__c" VARCHAR(18) NULL DEFAULT NULL,
	"contactid" VARCHAR(18) NULL DEFAULT NULL,
	"product2id" VARCHAR(18) NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"lastmodifieddate" TIMESTAMP NULL,
	"accountid" VARCHAR(18) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"purchasedate" DATE NULL DEFAULT NULL,
	"quantity" DOUBLE PRECISION NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"serialnumber" VARCHAR(80) NULL DEFAULT NULL,
	"description" TEXT NULL DEFAULT NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")
)
;

COMMENT ON COLUMN "asset"."id" IS E'';
COMMENT ON COLUMN "asset"."usageenddate" IS E'';
COMMENT ON COLUMN "asset"."lastmodifiedbyid" IS E'';
COMMENT ON COLUMN "asset"."name" IS E'';
COMMENT ON COLUMN "asset"."systemmodstamp" IS E'';
COMMENT ON COLUMN "asset"."type__c" IS E'';
COMMENT ON COLUMN "asset"."status" IS E'';
COMMENT ON COLUMN "asset"."installdate" IS E'';
COMMENT ON COLUMN "asset"."sfid" IS E'';
COMMENT ON COLUMN "asset"."createddate" IS E'';
COMMENT ON COLUMN "asset"."price" IS E'';
COMMENT ON COLUMN "asset"."pointofdelivery__c" IS E'';
COMMENT ON COLUMN "asset"."contactid" IS E'';
COMMENT ON COLUMN "asset"."product2id" IS E'';
COMMENT ON COLUMN "asset"."isdeleted" IS E'';
COMMENT ON COLUMN "asset"."lastmodifieddate" IS E'';
COMMENT ON COLUMN "asset"."accountid" IS E'';
COMMENT ON COLUMN "asset"."_hc_err" IS E'';
COMMENT ON COLUMN "asset"."purchasedate" IS E'';
COMMENT ON COLUMN "asset"."quantity" IS E'';
COMMENT ON COLUMN "asset"."_hc_lastop" IS E'';
COMMENT ON COLUMN "asset"."serialnumber" IS E'';
COMMENT ON COLUMN "asset"."description" IS E'';
COMMENT ON COLUMN "asset"."createdbyid" IS E'';

CREATE SEQUENCE asset_id_seq MINVALUE 0;
ALTER TABLE asset ALTER id SET DEFAULT nextval('asset_id_seq');
ALTER SEQUENCE asset_id_seq OWNED BY asset.id;


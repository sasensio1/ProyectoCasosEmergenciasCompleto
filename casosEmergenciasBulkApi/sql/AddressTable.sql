CREATE TABLE "address__c" (
	"utmcoordinatesxy__latitude__s" DOUBLE PRECISION NULL DEFAULT NULL,
	"coordinatey__c" VARCHAR(50) NULL DEFAULT NULL,
	"concatenatedaddress__c" VARCHAR(1300) NULL DEFAULT NULL,
	"utmcoordinatesxy__longitude__s" DOUBLE PRECISION NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"name" VARCHAR(80) NULL DEFAULT NULL,
	"coordinatex__c" VARCHAR(50) NULL DEFAULT NULL,
	"trackid__c" VARCHAR(255) NULL DEFAULT NULL,
	"streetmd__c" VARCHAR(18) NULL DEFAULT NULL,
	"region__c" VARCHAR(1300) NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"street_type__c" VARCHAR(1300) NULL DEFAULT NULL,
	"municipality__c" VARCHAR(1300) NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"department__c" VARCHAR(255) NULL DEFAULT NULL,
	"lastmodifiedbyid" VARCHAR(18) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"number__c" VARCHAR(255) NULL DEFAULT NULL,
	"companyid__c" VARCHAR(255) NULL DEFAULT NULL,
	"corner__c" VARCHAR(255) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	PRIMARY KEY ("sfid")
)
;
COMMENT ON COLUMN "address__c"."utmcoordinatesxy__latitude__s" IS E'';
COMMENT ON COLUMN "address__c"."coordinatey__c" IS E'';
COMMENT ON COLUMN "address__c"."concatenatedaddress__c" IS E'';
COMMENT ON COLUMN "address__c"."utmcoordinatesxy__longitude__s" IS E'';
COMMENT ON COLUMN "address__c"."createddate" IS E'';
COMMENT ON COLUMN "address__c"."_hc_err" IS E'';
COMMENT ON COLUMN "address__c"."createdbyid" IS E'';
COMMENT ON COLUMN "address__c"."id" IS E'';
COMMENT ON COLUMN "address__c"."name" IS E'';
COMMENT ON COLUMN "address__c"."coordinatex__c" IS E'';
COMMENT ON COLUMN "address__c"."trackid__c" IS E'';
COMMENT ON COLUMN "address__c"."streetmd__c" IS E'';
COMMENT ON COLUMN "address__c"."region__c" IS E'';
COMMENT ON COLUMN "address__c"."isdeleted" IS E'';
COMMENT ON COLUMN "address__c"."street_type__c" IS E'';
COMMENT ON COLUMN "address__c"."municipality__c" IS E'';
COMMENT ON COLUMN "address__c"."_hc_lastop" IS E'';
COMMENT ON COLUMN "address__c"."department__c" IS E'';
COMMENT ON COLUMN "address__c"."lastmodifiedbyid" IS E'';
COMMENT ON COLUMN "address__c"."sfid" IS E'';
COMMENT ON COLUMN "address__c"."number__c" IS E'';
COMMENT ON COLUMN "address__c"."companyid__c" IS E'';
COMMENT ON COLUMN "address__c"."corner__c" IS E'';
COMMENT ON COLUMN "address__c"."systemmodstamp" IS E'';


CREATE SEQUENCE address__c_id_seq MINVALUE 0;
ALTER TABLE address__c ALTER id SET DEFAULT nextval('address__c_id_seq');
ALTER SEQUENCE address__c_id_seq OWNED BY address__c.id;


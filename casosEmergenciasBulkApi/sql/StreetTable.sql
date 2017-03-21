CREATE TABLE "street__c" (
	"recordtypeid" VARCHAR(18) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"currencyisocode" VARCHAR(3) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"region__c" VARCHAR(255) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT E'',
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
	UNIQUE INDEX "UNIQUE" ("sfid")
)
;

CREATE SEQUENCE street__c_id_seq MINVALUE 0;
ALTER TABLE street__c ALTER id SET DEFAULT nextval('street__c_id_seq');
ALTER SEQUENCE street__c_id_seq OWNED BY street__c.id;
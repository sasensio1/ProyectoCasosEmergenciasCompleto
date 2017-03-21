CREATE TABLE "herokuuser__c" (
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"sentmail__c" BOOLEAN NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"country__c" VARCHAR(255) NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"mail__c" VARCHAR(80) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT E'',
	"_hc_err" TEXT NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"unity__c" VARCHAR(255) NULL DEFAULT NULL,
	"username__c" VARCHAR(255) NULL DEFAULT NULL,
	"password__c" VARCHAR(8) NULL DEFAULT NULL,
	"name" VARCHAR(80) NULL DEFAULT NULL,
	"active__c" BOOLEAN NULL DEFAULT NULL,
	UNIQUE INDEX "UNIQUE" ("sfid")
)
;

CREATE SEQUENCE herokuuser__c_id_seq MINVALUE 0;
ALTER TABLE herokuuser__c ALTER id SET DEFAULT nextval('herokuuser__c_id_seq');
ALTER SEQUENCE herokuuser__c_id_seq OWNED BY herokuuser__c.id;
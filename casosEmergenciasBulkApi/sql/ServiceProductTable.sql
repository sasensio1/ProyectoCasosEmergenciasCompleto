CREATE TABLE "serviceproduct__c" (
	"relationshipduplicatedvalidator__c" VARCHAR(255) NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"asset__c" VARCHAR(18) NULL DEFAULT NULL,
	"typeofrelationship__c" VARCHAR(255) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT E'',
	"principal__c" BOOLEAN NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"createddate" TIMESTAMP NULL,
	"contact__c" VARCHAR(18) NULL DEFAULT NULL,
	"duplicatedvalidator__c" TEXT NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"name" VARCHAR(80) NULL DEFAULT NULL,
	UNIQUE INDEX "UNIQUE" ("sfid")
)
;

CREATE SEQUENCE serviceproduct__c_id_seq MINVALUE 0;
ALTER TABLE serviceproduct__c ALTER id SET DEFAULT nextval('serviceproduct__c_id_seq');
ALTER SEQUENCE serviceproduct__c_id_seq OWNED BY serviceproduct__c.id;
CREATE TABLE "repeatedcases__c" (
	"numberdays__c" DOUBLE PRECISION NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT E'',
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"numbercases__c" DOUBLE PRECISION NULL DEFAULT NULL,
	"name" VARCHAR(38) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"createddate" TIMESTAMP NULL,
	UNIQUE INDEX "UNIQUE" ("sfid")
)
;

CREATE SEQUENCE repeatedcases__c_id_seq MINVALUE 0;
ALTER TABLE repeatedcases__c ALTER id SET DEFAULT nextval('repeatedcases__c_id_seq');
ALTER SEQUENCE repeatedcases__c_id_seq OWNED BY repeatedcases__c.id;
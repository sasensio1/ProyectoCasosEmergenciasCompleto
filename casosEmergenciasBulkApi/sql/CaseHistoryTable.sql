CREATE TABLE "casehistory" (
	"field" VARCHAR(255) NULL DEFAULT NULL,
	"newvalue" TEXT NULL DEFAULT NULL,
	"oldvalue" TEXT NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT E'',
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"caseid" VARCHAR(18) NULL DEFAULT NULL,
	UNIQUE INDEX "UNIQUE" ("sfid")
)
;

CREATE SEQUENCE casehistory_id_seq MINVALUE 0;
ALTER TABLE casehistory ALTER id SET DEFAULT nextval('casehistory_id_seq');
ALTER SEQUENCE casehistory_id_seq OWNED BY casehistory.id;
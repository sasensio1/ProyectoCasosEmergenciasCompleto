CREATE TABLE "casehistory" (
	"field" VARCHAR(255) NULL DEFAULT NULL,
	"newvalue" TEXT NULL DEFAULT NULL,
	"oldvalue" TEXT NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"caseid" VARCHAR(18) NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")


)
;

COMMENT ON COLUMN "casehistory"."field" IS E'';
COMMENT ON COLUMN "casehistory"."newvalue" IS E'';
COMMENT ON COLUMN "casehistory"."oldvalue" IS E'';
COMMENT ON COLUMN "casehistory"."isdeleted" IS E'';
COMMENT ON COLUMN "casehistory"."id" IS E'';
COMMENT ON COLUMN "casehistory"."createdbyid" IS E'';
COMMENT ON COLUMN "casehistory"."_hc_lastop" IS E'';
COMMENT ON COLUMN "casehistory"."_hc_err" IS E'';
COMMENT ON COLUMN "casehistory"."createddate" IS E'';
COMMENT ON COLUMN "casehistory"."sfid" IS E'';
COMMENT ON COLUMN "casehistory"."caseid" IS E'';

CREATE SEQUENCE casehistory_id_seq MINVALUE 0;
ALTER TABLE casehistory ALTER id SET DEFAULT nextval('casehistory_id_seq');
ALTER SEQUENCE casehistory_id_seq OWNED BY casehistory.id;


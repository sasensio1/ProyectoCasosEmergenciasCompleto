CREATE TABLE "casecomment" (
	"createddate" TIMESTAMP NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"lastmodifieddate" TIMESTAMP NULL,
	"createdbyid" VARCHAR(18) NULL DEFAULT NULL,
	"commentbody" VARCHAR(4000) NULL DEFAULT NULL,
	"parentid" VARCHAR(18) NULL DEFAULT NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"lastmodifiedbyid" VARCHAR(18) NULL DEFAULT NULL,
	"ispublished" BOOLEAN NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")


)
;

COMMENT ON COLUMN "casecomment"."createddate" IS E'';
COMMENT ON COLUMN "casecomment"."systemmodstamp" IS E'';
COMMENT ON COLUMN "casecomment"."lastmodifieddate" IS E'';
COMMENT ON COLUMN "casecomment"."createdbyid" IS E'';
COMMENT ON COLUMN "casecomment"."commentbody" IS E'';
COMMENT ON COLUMN "casecomment"."parentid" IS E'';
COMMENT ON COLUMN "casecomment"."isdeleted" IS E'';
COMMENT ON COLUMN "casecomment"."lastmodifiedbyid" IS E'';
COMMENT ON COLUMN "casecomment"."ispublished" IS E'';
COMMENT ON COLUMN "casecomment"."_hc_lastop" IS E'';
COMMENT ON COLUMN "casecomment"."_hc_err" IS E'';
COMMENT ON COLUMN "casecomment"."sfid" IS E'';
COMMENT ON COLUMN "casecomment"."id" IS E'';

CREATE SEQUENCE casecomment_id_seq MINVALUE 0;
ALTER TABLE casecomment ALTER id SET DEFAULT nextval('casecomment_id_seq');
ALTER SEQUENCE casecomment_id_seq OWNED BY casecomment.id;


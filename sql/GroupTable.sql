CREATE TABLE "group" (
	"id" INTEGER NOT NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"name" VARCHAR(40) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")

)
;

COMMENT ON COLUMN "group"."id" IS E'';
COMMENT ON COLUMN "group"."_hc_lastop" IS E'';
COMMENT ON COLUMN "group"."sfid" IS E'';
COMMENT ON COLUMN "group"."createddate" IS E'';
COMMENT ON COLUMN "group"."name" IS E'';
COMMENT ON COLUMN "group"."systemmodstamp" IS E'';
COMMENT ON COLUMN "group"."_hc_err" IS E'';

CREATE SEQUENCE group_id_seq MINVALUE 0;
ALTER TABLE "group" ALTER id SET DEFAULT nextval('group_id_seq');
ALTER SEQUENCE group_id_seq OWNED BY "group".id;


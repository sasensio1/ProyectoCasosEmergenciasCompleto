CREATE TABLE "user" (
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"name" VARCHAR(121) NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")
)
;

COMMENT ON COLUMN "user"."sfid" IS E'';
COMMENT ON COLUMN "user"."id" IS E'';
COMMENT ON COLUMN "user"."createddate" IS E'';
COMMENT ON COLUMN "user"."systemmodstamp" IS E'';
COMMENT ON COLUMN "user"."_hc_err" IS E'';
COMMENT ON COLUMN "user"."_hc_lastop" IS E'';
COMMENT ON COLUMN "user"."name" IS E'';

CREATE SEQUENCE user_id_seq MINVALUE 0;
ALTER TABLE "user" ALTER id SET DEFAULT nextval('user_id_seq');
ALTER SEQUENCE user_id_seq OWNED BY "user".id;

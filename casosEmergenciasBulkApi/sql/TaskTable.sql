CREATE TABLE "task" (
	"tasktype__c" VARCHAR(255) NULL DEFAULT NULL,
	"activitydate" DATE NULL DEFAULT NULL,
	"id" INTEGER NOT NULL DEFAULT NULL,
	"whatid" VARCHAR(18) NULL DEFAULT NULL,
	"calldisposition" VARCHAR(255) NULL DEFAULT NULL,
	"casephone__c" VARCHAR(40) NULL DEFAULT NULL,
	"status" VARCHAR(40) NULL DEFAULT NULL,
	"description" TEXT NULL DEFAULT NULL,
	"_hc_lastop" VARCHAR(32) NULL DEFAULT NULL,
	"sfid" VARCHAR(18) NULL DEFAULT NULL,
	"createddate" TIMESTAMP NULL,
	"isdeleted" BOOLEAN NULL DEFAULT NULL,
	"subject" VARCHAR(255) NULL DEFAULT NULL,
	"priority" VARCHAR(40) NULL DEFAULT NULL,
	"account__company__c" VARCHAR(255) NULL DEFAULT NULL,
	"accountid" VARCHAR(18) NULL DEFAULT NULL,
	"systemmodstamp" TIMESTAMP NULL,
	"_hc_err" TEXT NULL DEFAULT NULL,
	"ownerid" VARCHAR(18) NULL DEFAULT NULL,
	"tasksubtype" VARCHAR(40) NULL DEFAULT NULL,
	"whoid" VARCHAR(18) NULL DEFAULT NULL,
	PRIMARY KEY ("sfid")

)
;

COMMENT ON COLUMN "task"."tasktype__c" IS E'';
COMMENT ON COLUMN "task"."activitydate" IS E'';
COMMENT ON COLUMN "task"."id" IS E'';
COMMENT ON COLUMN "task"."whatid" IS E'';
COMMENT ON COLUMN "task"."calldisposition" IS E'';
COMMENT ON COLUMN "task"."casephone__c" IS E'';
COMMENT ON COLUMN "task"."status" IS E'';
COMMENT ON COLUMN "task"."description" IS E'';
COMMENT ON COLUMN "task"."_hc_lastop" IS E'';
COMMENT ON COLUMN "task"."sfid" IS E'';
COMMENT ON COLUMN "task"."createddate" IS E'';
COMMENT ON COLUMN "task"."isdeleted" IS E'';
COMMENT ON COLUMN "task"."subject" IS E'';
COMMENT ON COLUMN "task"."priority" IS E'';
COMMENT ON COLUMN "task"."account__company__c" IS E'';
COMMENT ON COLUMN "task"."accountid" IS E'';
COMMENT ON COLUMN "task"."systemmodstamp" IS E'';
COMMENT ON COLUMN "task"."_hc_err" IS E'';
COMMENT ON COLUMN "task"."ownerid" IS E'';
COMMENT ON COLUMN "task"."tasksubtype" IS E'';
COMMENT ON COLUMN "task"."whoid" IS E'';

CREATE SEQUENCE task_id_seq MINVALUE 0;
ALTER TABLE task ALTER id SET DEFAULT nextval('task_id_seq');
ALTER SEQUENCE task_id_seq OWNED BY task.id;


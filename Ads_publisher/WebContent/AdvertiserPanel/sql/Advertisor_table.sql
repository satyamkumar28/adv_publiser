--------------------------------------------------------
--  File created - Wednesday-September-14-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ADVERTISOR_TABLE
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."ADVERTISOR_TABLE" 
   (	"ADVID" NUMBER, 
	"ADVERTISERUSER" VARCHAR2(400 BYTE), 
	"TITLE" VARCHAR2(400 BYTE), 
	"THEMEIMAGE" BLOB, 
	"DESCRIPTION" VARCHAR2(400 BYTE), 
	"IMAGE1" BLOB, 
	"IMAGE2" BLOB, 
	"IMAGE3" BLOB, 
	"VIDEO" BLOB, 
	"TYPE" VARCHAR2(400 BYTE), 
	"CATEGORY" VARCHAR2(400 BYTE), 
	"SUBCATEGORY" VARCHAR2(400 BYTE), 
	"APPROVED" VARCHAR2(20 BYTE), 
	"PRIROTY" NUMBER(*,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("THEMEIMAGE") STORE AS (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) 
 LOB ("IMAGE1") STORE AS (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) 
 LOB ("IMAGE2") STORE AS (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) 
 LOB ("IMAGE3") STORE AS (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) 
 LOB ("VIDEO") STORE AS (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
--------------------------------------------------------
--  DDL for Index ADVERTISOR_TABLE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."ADVERTISOR_TABLE_PK" ON "SYSTEM"."ADVERTISOR_TABLE" ("ADVID", "ADVERTISERUSER") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table ADVERTISOR_TABLE
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."ADVERTISOR_TABLE" ADD CONSTRAINT "ADVERTISOR_TABLE_PK" PRIMARY KEY ("ADVID", "ADVERTISERUSER")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
 
  ALTER TABLE "SYSTEM"."ADVERTISOR_TABLE" MODIFY ("ADVID" NOT NULL ENABLE);
 
  ALTER TABLE "SYSTEM"."ADVERTISOR_TABLE" MODIFY ("ADVERTISERUSER" NOT NULL ENABLE);
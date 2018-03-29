DROP TABLE "anikiuser";
DROP TABLE "team";
DROP TABLE "role";
DROP TABLE "event";
DROP TABLE "contact";
DROP TABLE "todolist";
DROP TABLE "task";
DROP TABLE "contact_event";
DROP TABLE "contact_team";
DROP TABLE "note";
DROP TABLE "type";
DROP TABLE "article";
DROP TABLE "paymentmethod";
DROP TABLE "transaction";
DROP TABLE "anualbudget";
DROP TABLE "budget";

CREATE TABLE IF NOT EXISTS "anikiuser" (
  "user_mail" VARCHAR(255) NOT NULL,
  "user_name" VARCHAR(255) NULL,
  "user_first_name" VARCHAR(255) NULL,
  "user_password" VARCHAR(255) NULL,
  "user_phone" VARCHAR(255) NULL,
  PRIMARY KEY ("user_mail"))
;


-- -----------------------------------------------------
-- Table "Team"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "team" (
  "team_name" VARCHAR(255) NOT NULL,
  PRIMARY KEY ("team_name"))
;


-- -----------------------------------------------------
-- Table "Role"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "role" (
  "Team_team_id" SERIAL,
  "User_user_mail" VARCHAR(255) NOT NULL,
  "role_name" VARCHAR(255) NULL,
  PRIMARY KEY ("Team_team_id", "User_user_mail"))
;


-- -----------------------------------------------------
-- Table "events"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "event" (
  "event_id" SERIAL,
  "event_label" VARCHAR(255) NULL,
  "event_date_start" DATE NULL,
  "event_date_end" DATE NULL,
  "event_number_entrant" INT NULL,
  "team_name" VARCHAR(255) NOT NULL,
  PRIMARY KEY ("event_id"),
  FOREIGN KEY ("team_name") REFERENCES Team(team_name)
 );

-- -----------------------------------------------------
-- Table "contact"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "contact" (
  "contact_id" SERIAL,
  "contact_name" VARCHAR(255) NOT NULL,
  "contact_first_name" VARCHAR(255) NULL,
  "contact_adress" VARCHAR(255) NULL,
  "contact_mail" VARCHAR(255) NULL,
  "contact_phone" VARCHAR(255) NULL,
  PRIMARY KEY ("contact_id")
);

-- -----------------------------------------------------
-- Table "contact_event"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "contact_event" (
	"contact_id" INT REFERENCES contact,
	"event_id" INT REFERENCES event,
	PRIMARY KEY ("contact_id", "event_id")
);

-- -----------------------------------------------------
-- Table "contact_team"
-- -----------------------------------------------------
 CREATE TABLE IF NOT EXISTS "contact_team" (
	"contact_id" INT REFERENCES contact,
	"team_name" VARCHAR(255) REFERENCES team,
	PRIMARY KEY ("contact_id", "team_name")
);

-- -----------------------------------------------------
-- Table "Todolist"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "todolist" (
  "todolist_id" SERIAL,
  "todolist_name" VARCHAR(255) NULL,
  "Event_event_id" INT NOT NULL,
  PRIMARY KEY ("todolist_id", "Event_event_id"))

;


-- -----------------------------------------------------
-- Table "Task"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "task" (
  "task_id" SERIAL,
  "task_content" TEXT NULL,
  "Todolist_todolist_id" INT NOT NULL,
  PRIMARY KEY ("task_id", "Todolist_todolist_id"))

;


-- -----------------------------------------------------
-- Table "Note"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "note" (
  "note_id" SERIAL,
  "note_title" VARCHAR(255) NULL,
  "note_text" TEXT NULL,
  "Event_event_id" INT NOT NULL,
  PRIMARY KEY ("note_id", "Event_event_id"))

;


-- -----------------------------------------------------
-- Table "Type"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "type" (
  "type_id" SERIAL,
  "type_name" VARCHAR(255) NULL,
  PRIMARY KEY ("type_id"))
;


-- -----------------------------------------------------
-- Table "Article"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "article" (
  "article_id" SERIAL,
  "article_name" VARCHAR(255) NULL,
  "article_description" TEXT NULL,
  "article_number" INT NULL,
  "Type_type_id" INT NOT NULL,
  PRIMARY KEY ("article_id", "Type_type_id"))

;


-- -----------------------------------------------------
-- Table "Paymentmethode"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "paymentmethod" (
  "paymentmethode" SERIAL,
  "paymentmethode_label" VARCHAR(255) NULL,
  PRIMARY KEY ("paymentmethode"))
;


-- -----------------------------------------------------
-- Table "Anualbudget"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "anualbudget" (
  "annualBudget_listname" VARCHAR (10),
  "anualbudget_amount" numeric NULL,
  "anualbudget_year" VARCHAR(10) NULL,
  PRIMARY KEY ("anualbudget_year"))
;


-- -----------------------------------------------------
-- Table "Budget"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "budget" (
  "budget_id" SERIAL,
  "budget_amount" INT NULL,
  "Anualbudget_anualbudget_id" INT NOT NULL,
  "Team_team_id" INT NOT NULL,
  PRIMARY KEY ("budget_id", "Anualbudget_anualbudget_id", "Team_team_id")
  )
;


-- -----------------------------------------------------
-- Table "Transaction"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "transaction" (
  "transaction_id" SERIAL,
  "transaction_label" VARCHAR(255) NULL,
  "transaction_amount" numeric NULL,
  "transaction_date" DATE NULL,
  "transaction_state" INT NULL,
  "transaction_type" VARCHAR(45) NULL,
  "Event_event_id" INT NOT NULL,
  "Paymentmethode_paymentmethode" INT NOT NULL,
  "Anualbudget_anualbudget_id" INT NOT NULL,
  "Budget_budget_id" INT NOT NULL,
  PRIMARY KEY ("transaction_id", "Event_event_id", "Paymentmethode_paymentmethode", "Anualbudget_anualbudget_id", "Budget_budget_id"))

;
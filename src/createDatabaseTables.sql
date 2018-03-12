CREATE TABLE IF NOT EXISTS "User" (
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
CREATE TABLE IF NOT EXISTS "Team" (
  "team_id" SERIAL,
  "team_name" VARCHAR(255) NULL,
  PRIMARY KEY ("team_id"))
;


-- -----------------------------------------------------
-- Table "Role"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Role" (
  "Team_team_id" SERIAL,
  "User_user_mail" VARCHAR(255) NOT NULL,
  "role_name" VARCHAR(255) NULL,
  PRIMARY KEY ("Team_team_id", "User_user_mail"))
;


-- -----------------------------------------------------
-- Table "Event"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Event" (
  "event_id" SERIAL,
  "event_label" VARCHAR(255) NULL,
  "event_date_start" DATE NULL,
  "event_date_end" DATE NULL,
  "event_number_entrant" INT NULL,
  "Team_team_id" INT NOT NULL,
  PRIMARY KEY ("event_id", "Team_team_id"))

;


-- -----------------------------------------------------
-- Table "Contact"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Contact" (
  "contact_id" SERIAL,
  "contact_name" VARCHAR(255) NULL,
  "contact_first_name" VARCHAR(255) NULL,
  "contact_adress" VARCHAR(255) NULL,
  "contact_zip_code" VARCHAR(255) NULL,
  "contact_city" VARCHAR(255) NULL,
  "contact_mail" VARCHAR(255) NULL,
  "contact_phone" VARCHAR(255) NULL,
  "contact_business_name" VARCHAR(255) NULL,
  "Event_event_id" INT NOT NULL,
  "Team_team_id" INT NOT NULL,
  PRIMARY KEY ("contact_id", "Event_event_id", "Team_team_id"))

;


-- -----------------------------------------------------
-- Table "Todolist"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Todolist" (
  "todolist_id" SERIAL,
  "todolist_name" VARCHAR(255) NULL,
  "Event_event_id" INT NOT NULL,
  PRIMARY KEY ("todolist_id", "Event_event_id"))

;


-- -----------------------------------------------------
-- Table "Task"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Task" (
  "task_id" SERIAL,
  "task_content" TEXT NULL,
  "Todolist_todolist_id" INT NOT NULL,
  PRIMARY KEY ("task_id", "Todolist_todolist_id"))

;


-- -----------------------------------------------------
-- Table "Note"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Note" (
  "note_id" SERIAL,
  "note_title" VARCHAR(255) NULL,
  "note_text" TEXT NULL,
  "Event_event_id" INT NOT NULL,
  PRIMARY KEY ("note_id", "Event_event_id"))

;


-- -----------------------------------------------------
-- Table "Type"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Type" (
  "type_id" SERIAL,
  "type_name" VARCHAR(255) NULL,
  PRIMARY KEY ("type_id"))
;


-- -----------------------------------------------------
-- Table "Article"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Article" (
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
CREATE TABLE IF NOT EXISTS "Paymentmethode" (
  "paymentmethode" SERIAL,
  "paymentmethode_label" VARCHAR(255) NULL,
  PRIMARY KEY ("paymentmethode"))
;


-- -----------------------------------------------------
-- Table "Anualbudget"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Anualbudget" (
  "anualbudget_id" SERIAL,
  "anualbudget_amount" numeric NULL,
  "anualbudget_year" VARCHAR(10) NULL,
  PRIMARY KEY ("anualbudget_id"))
;


-- -----------------------------------------------------
-- Table "Budget"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "Budget" (
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
CREATE TABLE IF NOT EXISTS "Transaction" (
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
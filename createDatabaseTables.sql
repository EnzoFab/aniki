DROP TABLE "anikiuser" CASCADE;
DROP TABLE "role" CASCADE;
DROP TABLE "budget" CASCADE;
DROP TABLE "event" CASCADE;
DROP TABLE "team" CASCADE;
DROP TABLE "contact" CASCADE;
DROP TABLE "todolist" CASCADE;
DROP TABLE "task" CASCADE;
DROP TABLE "contact_event" CASCADE;
DROP TABLE "contact_team" CASCADE;
DROP TABLE "note" CASCADE;
DROP TABLE "type" CASCADE;
DROP TABLE "article" CASCADE;
DROP TABLE "paymentmethod" CASCADE;
DROP TABLE "transaction" CASCADE;
DROP TABLE "anualbudget" CASCADE;

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
-- Table "Budget"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "budget" (
  "budget_id" SERIAL UNIQUE,
  "budget_amount" INT NULL,
  "Anualbudget_anualbudget_id" INT NOT NULL,
  "Team_team_id" INT NOT NULL,
  PRIMARY KEY ("budget_id", "Anualbudget_anualbudget_id", "Team_team_id")
  )
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
  "budget_id" INT NULL,
  PRIMARY KEY ("event_id"),
  FOREIGN KEY ("team_name") REFERENCES Team(team_name),
  FOREIGN KEY ("budget_id") REFERENCES budget(budget_id)
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
  "type_name" VARCHAR(255) NULL,
  PRIMARY KEY ("type_name"))
;


-- -----------------------------------------------------
-- Table "Article"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "article" (
  "article_id" SERIAL,
  "article_name" VARCHAR(255) NULL,
  "article_description" VARCHAR(255) NULL,
  "article_number" INT NULL,
  "type_name" VARCHAR(255) NOT NULL,
  PRIMARY KEY ("article_id"),
  FOREIGN KEY ("type_name") REFERENCES type(type_name)
);


-- -----------------------------------------------------
-- Table "Paymentmethode"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "paymentmethod" (
  "paymentmethod_name" VARCHAR(255),
  PRIMARY KEY ("paymentmethod_name"))
;


-- -----------------------------------------------------
-- Table "Anualbudget"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "anualbudget" (
  "annualbudget_listname" VARCHAR (10),
  "anualbudget_amount" numeric NULL,
  "anualbudget_year" VARCHAR(10) NULL,
  PRIMARY KEY ("anualbudget_year"))
;





-- -----------------------------------------------------
-- Table "Transaction"
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS "transaction" (
  "transaction_id" SERIAL,
  "transaction_label" VARCHAR(255) NULL,
  "transaction_amount" INT NULL,
  "transaction_date" DATE NULL,
  "transaction_state" INT NULL,
  "transaction_type" VARCHAR(45) NULL,
  "event_id" INT NULL,
  "paymentmethod_name" VARCHAR(255) NULL,
  "anualbudget_year" VARCHAR(10) NULL REFERENCES anualbudget,
  PRIMARY KEY ("transaction_id"),
  FOREIGN KEY ("event_id") REFERENCES event(event_id),
  FOREIGN KEY ("paymentmethod_name") REFERENCES paymentmethod(paymentmethod_name),
  FOREIGN KEY ("anualbudget_year") REFERENCES anualbudget(anualbudget_year)
);

INSERT INTO paymentmethod VALUES ('CB');
INSERT INTO paymentmethod VALUES ('Virement');
INSERT INTO paymentmethod VALUES ('Chèque');
INSERT INTO paymentmethod VALUES ('Paypal');

INSERT INTO team VALUES ('Beach');
INSERT INTO team VALUES ('Gala');
INSERT INTO team VALUES ('Ski');

INSERT INTO contact (contact_name, contact_first_name, contact_adress, contact_mail, contact_phone) VALUES ('James', 'TERRIEN', '18 rue Saint-Firmin', 'james@gmail.com', '0622151403');

INSERT INTO anualbudget ("annualBudget_listname", anualbudget_amount, anualbudget_year) VALUES ('taber',10000, 2017);
INSERT INTO budget (budget_id, budget_amount, "Anualbudget_anualbudget_id", "Team_team_id") VALUES (2,1500,1,2);
INSERT INTO transaction (transaction_label,transaction_amount,transaction_date,transaction_state,transaction_type) VALUES ('Campo',200,'2018-05-11',1,'debit');
INSERT INTO transaction (transaction_label,transaction_amount,transaction_date,transaction_state,transaction_type) VALUES ('Beach',200,'2018-05-18',1,'credit');
INSERT INTO anikiuser ("user_mail","user_name","user_first_name","user_password","user_phone") VALUES('enzo.fabre@etu.umontpellier.fr','FABRE','Enzo','Djeums','0658145639');

INSERT INTO type("type_name") VALUES('alcool');

INSERT INTO article
 ("article_name","article_description" ,"article_number","type_name")
 VALUES ('vodka','vodka de 0,70L ',45,'alcool')



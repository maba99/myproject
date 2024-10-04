CREATE TABLE ticket
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(45) NOT NULL,
    `description` VARCHAR(45) NOT NULL,
    status        VARCHAR(45) NOT NULL,
    employee_id   BIGINT NULL,
    CONSTRAINT pk_ticket PRIMARY KEY (id)
);

ALTER TABLE ticket
    ADD CONSTRAINT FK_TICKET_ON_EMPLOYEE FOREIGN KEY (employee_id) REFERENCES employee (id);
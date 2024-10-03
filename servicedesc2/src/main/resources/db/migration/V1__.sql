CREATE TABLE employee
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(45) NOT NULL,
    email    VARCHAR(45) NOT NULL,
    position VARCHAR(45) NOT NULL,
    user_id  BIGINT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE employee_role
(
    employee_id BIGINT NOT NULL,
    role_id     BIGINT NOT NULL,
    CONSTRAINT pk_employee_role PRIMARY KEY (employee_id, role_id)
);

ALTER TABLE employee
    ADD CONSTRAINT uc_employee_user UNIQUE (user_id);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE employee_role
    ADD CONSTRAINT fk_emprol_on_employee FOREIGN KEY (employee_id) REFERENCES employee (id);

ALTER TABLE employee_role
    ADD CONSTRAINT fk_emprol_on_role FOREIGN KEY (role_id) REFERENCES `role` (id);
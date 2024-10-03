CREATE TABLE `role`
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

ALTER TABLE `role`
    ADD CONSTRAINT uc_role_name UNIQUE (name);
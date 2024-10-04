CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(45)           NOT NULL,
    password VARCHAR(200)          NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);
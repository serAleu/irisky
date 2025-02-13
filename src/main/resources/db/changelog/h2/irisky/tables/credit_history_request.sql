--liquibase formatted sql

--changeset ser_aleu:7cb80112-e3fd-4a4b-8d72-e0d1ed70bffe runOnChange:true failOnError:true
--comment: CREATE TABLE credit_history_request
--preconditions onFail:MARK_RAN onError:MARK_RAN
--preconditions-sql-check expectedResult: 0 SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema = 'giga' table_name = 'credit_history_request'
CREATE TABLE giga.credit_history_request (
    id INT NOT NULL auto_increment,
    status VARCHAR(100),
    request JSON,
    added_at TIMESTAMP,
    response JSON NOT NULL,
    error_details VARCHAR,
    PRIMARY KEY (id)
)
--rollback DROP TABLE giga.credit_history_request
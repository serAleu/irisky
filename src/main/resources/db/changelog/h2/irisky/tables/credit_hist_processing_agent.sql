--liquibase formatted sql

--changeset ser_aleu:e44804e7-d9be-4338-a8ac-f3b6cf4eeb58 runOnChange:true failOnError:true
--comment: CREATE TABLE credit_hist_processing_agent
--preconditions onFail:MARK_RAN onError:MARK_RAN
--preconditions-sql-check expectedResult: 0 SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema = 'i_risky' table_name = 'credit_hist_processing_agent'
CREATE TABLE i_risky.credit_hist_processing_agent (
    genuuid VARCHAR NOT NULL,
    epk_id INT NOT NULL,
    credit_history_identifier VARCHAR(100),
    pi_is_valid BOOLEAN,
    status VARCHAR(100),
    start_dtm TIMESTAMP,
    finish_dtm TIMESTAMP,
    is_result_valid BOOLEAN,
    result VARCHAR,
    processing_json JSON,
    error_details VARCHAR,
    PRIMARY KEY (genuuid)
)
--rollback DROP TABLE i_risky.credit_hist_processing_agent
--liquibase formatted sql

--changeset ser_aleu:a3161fc4-89a8-4c14-b6bc-fb86246f3b42 runOnChange:true failOnError:true
--comment: CREATE TABLE processing_result_validation_agent
--preconditions onFail:MARK_RAN onError:MARK_RAN
--preconditions-sql-check expectedResult: 0 SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema = 'i_risky' table_name = 'processing_result_validation_agent'
CREATE TABLE i_risky.processing_result_validation_agent (
    id INT NOT NULL auto_increment,
    credit_hist_processing_agent_uuid VARCHAR NOT NULL,
    status VARCHAR(100),
    added_at TIMESTAMP,
    result VARCHAR,
    error_details VARCHAR,
    PRIMARY KEY (id)
)
--rollback DROP TABLE i_risky.processing_result_validation_agent
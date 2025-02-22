--liquibase formatted sql

--changeset ser_aleu:7cb80112-e3fd-4a4b-8d72-e0d1ed70bffe runOnChange:true failOnError:true
--comment: CREATE TABLE epk_client
--preconditions onFail:MARK_RAN onError:MARK_RAN
--preconditions-sql-check expectedResult: 0 SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema = 'i_risky' table_name = 'epk_client'
CREATE TABLE i_risky.epk_client (
    epk_id INT NOT NULL,
    phone_num VARCHAR(100),
    agreement_provided BOOLEAN,
    full_name VARCHAR(100),
    PRIMARY KEY (epk_id)
)
--rollback DROP TABLE i_risky.epk_client
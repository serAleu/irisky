--liquibase formatted sql

--changeset ser_aleu:2b891f23-3021-46db-9265-dbcd6ae754e9 runOnChange:true failOnError:true
CREATE SCHEMA IF NOT EXISTS I_RISKY;
--rollback DROP SCHEMA I_RISKY
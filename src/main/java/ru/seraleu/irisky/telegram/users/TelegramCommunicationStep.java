package ru.seraleu.irisky.telegram.users;

public enum TelegramCommunicationStep {

    START,
    QUESTION,
    CREDIT_HIST_REQUESTED,
    CREDIT_HIST_RECEIVED,
    INCORRECT_USER_COMMUNICATION,
    INCORRECT_GIGA_RESPONSE,
    NO_RESPONSE,
    EXCEPTION_RESPONSE
}

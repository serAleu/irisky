package ru.seraleu.irisky.enums;

public enum Status {
    BAD_REQUEST,
    SUCCESS,
    REWORK,
    RECEIVED,
    UNDEFINED,
    ERROR;

    public static Status defineStatus(String status) {
        return switch (status) {
            case "BAD_REQUEST" -> BAD_REQUEST;
            case "SUCCESS" -> SUCCESS;
            case "REWORK" -> REWORK;
            case "RECEIVED" -> RECEIVED;
            case "ERROR" -> ERROR;
            default -> UNDEFINED;
        };
    }
}

package ru.seraleu.irisky.telegram.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Callback {

    START("/callback/start"),
    CREDIT_HIST_REQUEST("/callback/credit-hist-request");

    private final String path;
}

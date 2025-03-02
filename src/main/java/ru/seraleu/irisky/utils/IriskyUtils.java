package ru.seraleu.irisky.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class IriskyUtils {

    public static String formatReport(String report) {
        StringUtils.replace(report, "\n", "");
        StringBuilder reportBuilder = new StringBuilder();
        AtomicInteger counter = new AtomicInteger(0);
        AtomicBoolean isNextStage = new AtomicBoolean(false);
        AtomicBoolean isNeedToRemoveNextSpace = new AtomicBoolean(false);
        report.chars()
                .mapToObj(c -> (char) c)
                .toList().forEach(character -> {
                    if ('*' == character) {
                        if (0 == counter.get()) {
                            reportBuilder.append(System.lineSeparator()).append(System.lineSeparator());
                        }
                        if(3 > counter.get()) {
                            counter.getAndIncrement();
                        } else {
                            isNextStage.set(true);
                            counter.set(0);
                        }
                    }
                    if(!isNeedToRemoveNextSpace.get()) {
                        reportBuilder.append(character);
                    }
                    isNeedToRemoveNextSpace.set(false);
                    if(isNextStage.get()) {
                        reportBuilder.append(System.lineSeparator());
                        isNextStage.set(false);
                        isNeedToRemoveNextSpace.set(true);
                    }
                });
        return reportBuilder.toString();
    }
}

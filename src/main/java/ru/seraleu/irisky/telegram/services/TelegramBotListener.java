package ru.seraleu.irisky.telegram.services;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class TelegramBotListener {

//    @Value("${telegram.web.auth.token}")
//    private String telegramBotToken;

    final TelegramBot bot = new TelegramBot("7758534076:AAH5F0c0uUYFsecTJU6-5aB1lg4_dNduu44");

    public void listen() {
        bot.setUpdatesListener(updates -> UpdatesListener.CONFIRMED_UPDATES_ALL, e -> {
            System.out.println("че");
            if (e.response() != null) {
                e.response().errorCode();
                e.response().description();
            } else {
                e.printStackTrace();
            }
        });

//        long chatId = update.message().chat().id();
//        SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
    }
}

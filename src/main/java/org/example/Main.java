package org.example;

import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDABuilder bot;

    public static void main(String[] args) throws LoginException {
        String token = "token";
        bot = JDABuilder.createDefault(token);
        listener();

        bot.build();
    }

    public static void listener(){
        bot.addEventListeners(new MessageListener());
    }
}
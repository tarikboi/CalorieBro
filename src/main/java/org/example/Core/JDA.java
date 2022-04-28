package org.example.Core;

import net.dv8tion.jda.api.JDABuilder;
import javax.security.auth.login.LoginException;

public class JDA {
    public static JDABuilder bot;
    public static String botToken;
    public static String apiKey;

    public JDA(String botToken, String apiKey){
        this.botToken = botToken;
        this.apiKey = apiKey;
    }

    public static void jdaBuilder() throws LoginException {
        bot = JDABuilder.createDefault(botToken);
        listener();
        bot.build();
    }

    public static void listener(){
        bot.addEventListeners(new MessageListener(apiKey));
    }
}
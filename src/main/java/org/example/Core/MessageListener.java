package org.example.Core;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class MessageListener extends ListenerAdapter {
    String apiKey;

    public MessageListener(String apiKey){
        this.apiKey = apiKey;
    }

    public void onMessageReceived(MessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        String food = messageSent.toLowerCase();

        if(food.contains("!caloriebro") || food.contains("!cb")){
            APIConnector api = new APIConnector(apiKey);
            try {
                Random rn = new Random();
                int i = rn.nextInt(108);
                String compliment = Files.readAllLines(Paths.get("src/main/resources/complimentList.txt")).get(i);
                String messageToSend = api.getCalories(food);
                if(messageToSend.equalsIgnoreCase("null")){
                    event.getChannel().sendMessage("Hmm I don't know that one.. Btw " + compliment.toLowerCase()).queue();
                } else{
                    event.getChannel().sendMessage(api.getCalories(food) + " calories. Btw " + compliment.toLowerCase()).queue();
                }
            } catch (ParseException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
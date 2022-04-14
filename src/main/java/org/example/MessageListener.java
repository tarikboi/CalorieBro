package org.example;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class MessageListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        String message = messageSent.toLowerCase();

        if(message.contains("!caloriebro") || message.contains("!cb")){
            APIConnector api = new APIConnector();
            try {
                Random rn = new Random();
                int i = rn.nextInt(108);
                String compliment = Files.readAllLines(Paths.get("src/main/resources/complimentList.txt")).get(i);
                String messageToSend = api.getCalories(message);

                if(messageToSend.equalsIgnoreCase("null")){
                    event.getChannel().sendMessage("Hmm I don't know that one.. Btw " + compliment.toLowerCase()).queue();
                } else{
                    event.getChannel().sendMessage(api.getCalories(message) + " calories. Btw " + compliment.toLowerCase()).queue();
                }
            } catch (ParseException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


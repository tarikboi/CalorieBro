package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;

public class APIConnector {
    public String getCalories(String food) throws ParseException, FileNotFoundException {
        String url = "https://calorieninjas.p.rapidapi.com/v1/nutrition?query=" + food;
        String token = "token";

        HttpResponse<String> response = Unirest.get(url)
                .header("X-RapidAPI-Host", "calorieninjas.p.rapidapi.com")
                .header("X-RapidAPI-Key", token)
                .asString();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response.getBody());
        JSONArray array = (JSONArray) jsonObject.get("items");

        Double calories = null;
        for (int i = 0; i < array.size(); i++) {
            JSONObject recipesObject = (JSONObject) array.get(i);
            calories = (Double) recipesObject.get("calories");
        }
            return String.valueOf(calories);
    }
}

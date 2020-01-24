package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    /**
     * Constructor.
     *
     * It creates a Sandwich object from a JSON object
     *
     * @param json string in JSON format containing the sandwich info
     * @return full formed sandwich object.
     */

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();
        JSONObject sandwichJSON = null;
        JSONObject sandwitchNameJSON = null;

        try {
            sandwichJSON = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // JSON object with sandwich's name and aka

        try {
            sandwitchNameJSON = sandwichJSON.getJSONObject("name");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // sandwich name

        try {
            String sandwich_name = sandwitchNameJSON.getString("mainName");
            sandwich.setMainName(sandwich_name);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // sandwich aka

        try {

            JSONArray sandwitchAKAJSON = sandwitchNameJSON.getJSONArray("alsoKnownAs");

            List<String> sandwich_aka = new ArrayList<>();

            if(sandwitchAKAJSON.length() == 0){
                sandwich_aka.add("only known as " + sandwich.getMainName().toLowerCase());
            }

            for(int i=0; i < sandwitchAKAJSON.length(); i++) {
                sandwich_aka.add(sandwitchAKAJSON.getString(i));
            }

            sandwich.setAlsoKnownAs(sandwich_aka);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // sandwich place of origin

        try {
            String origin_place  = sandwichJSON.getString("placeOfOrigin");

            if(origin_place.equals("")){
                origin_place = "Unknown";
            }

            sandwich.setPlaceOfOrigin(origin_place);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // sandwich place of origin

        try {
            String sandwich_description  = sandwichJSON.getString("description");
            sandwich.setDescription(sandwich_description);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // sandwich image

        try {
            String sandwich_image  = sandwichJSON.getString("image");
            sandwich.setImage(sandwich_image);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // sandwich ingredients

        try {

            JSONArray sandwichIngredientsJSON = sandwichJSON.getJSONArray("ingredients");

            List<String> sandwich_ingredients = new ArrayList<>();

            for(int i=0; i < sandwichIngredientsJSON.length(); i++){
                sandwich_ingredients.add(sandwichIngredientsJSON.getString(i));
            }

            sandwich.setIngredients(sandwich_ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}

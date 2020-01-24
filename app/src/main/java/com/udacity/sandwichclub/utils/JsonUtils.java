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

        try {

            Sandwich sandwich = new Sandwich();

            JSONObject sandwichJSON = new JSONObject(json);
            JSONObject sandwichNameJSON = sandwichJSON.getJSONObject("name");
            JSONArray sandwichAKAJSON = sandwichNameJSON.getJSONArray("alsoKnownAs");
            JSONArray sandwichIngredientsJSON = sandwichJSON.getJSONArray("ingredients");


            List<String> sandwich_aka = new ArrayList<>();
            List<String> sandwich_ingredients = new ArrayList<>();

            String sandwich_name;
            String origin_place;
            String sandwich_description;
            String sandwich_image;

            int i;

            // Set sandwich mainName

            sandwich_name = sandwichNameJSON.getString("mainName");

            sandwich.setMainName(sandwich_name);

            // Set sandwich aka. If no aka set only known as mainName

            if(sandwichAKAJSON.length() == 0){
                sandwich_aka.add("only known as " + sandwich.getMainName().toLowerCase());
            }

            for(i = 0; i < sandwichAKAJSON.length(); i++) {
                sandwich_aka.add(sandwichAKAJSON.getString(i));
            }

            sandwich.setAlsoKnownAs(sandwich_aka);

            // Set sandwich origin place. If no origin place set unknown

            origin_place  = sandwichJSON.getString("placeOfOrigin");

            if(origin_place.equals("")){
                origin_place = "Unknown";
            }

            sandwich.setPlaceOfOrigin(origin_place);

            // Set sandwich description

            sandwich_description  = sandwichJSON.getString("description");
            sandwich.setDescription(sandwich_description);

            // Set sandwich image

            sandwich_image  = sandwichJSON.getString("image");
            sandwich.setImage(sandwich_image);

            // Set sandwich ingredients

            for(i=0; i < sandwichIngredientsJSON.length(); i++){
                sandwich_ingredients.add(sandwichIngredientsJSON.getString(i));
            }

            sandwich.setIngredients(sandwich_ingredients);

            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }
}

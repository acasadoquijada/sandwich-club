package com.udacity.sandwichclub.utils;

import android.util.Log;
import android.widget.Toast;

import com.udacity.sandwichclub.MainActivity;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    // I need all of this:

    /*
    private String mainName;
    private List<String> alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;
     */

    public static Sandwich parseSandwichJson(String json) {

        // I obtain a JSON object with all the info about the Sandwich

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

            List<String> sandwich_aka = new ArrayList<>(sandwitchAKAJSON.length());

            for(int i=0; i < sandwich_aka.size(); i++)
                sandwich_aka.set(i,sandwitchAKAJSON.getString(i));

            sandwich.setAlsoKnownAs(sandwich_aka);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // sandwich place of origin

        try {
            String origin_place  = sandwichJSON.getString("placeOfOrigin");
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

            JSONArray sandwichIngredientsJSON = sandwitchNameJSON.getJSONArray("ingredients");

            List<String> sandwich_ingredients = new ArrayList<>(sandwichIngredientsJSON.length());

            for(int i=0; i < sandwich_ingredients.size(); i++)
                sandwich_ingredients.set(i,sandwichIngredientsJSON.getString(i));

            sandwich.setIngredients(sandwich_ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}

package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    // Need to populate the UI with the different values

    /**
     * This method populates the UI with the sandwich information.
     *
     * @param sandwich object containing all the information about the sandwich
     */

    private void populateUI(Sandwich sandwich) {

        TextView descriptionTextView = findViewById(R.id.description_tv);

        TextView originTextView = findViewById(R.id.origin_tv);

        TextView ingredientsTextView = findViewById(R.id.ingredients_tv);

        TextView akaTextView = findViewById(R.id.also_known_tv);

        descriptionTextView.setText(sandwich.getDescription());

        originTextView.setText(sandwich.getPlaceOfOrigin());

        populateUIList(sandwich.getIngredients(),ingredientsTextView);

        populateUIList(sandwich.getAlsoKnownAs(),akaTextView);

    }

    /**
     * Helper method to populate the information stored in List<String>
     *
     * @param list list of strings with the information needed
     * @param textView UI object to be populated with the content of list
     */

    private void populateUIList(List<String> list, TextView textView){
        for(int i = 0; i < list.size(); i++){
            textView.append(R.string.bullet_point + " " + list.get(i));
            if(i+1 < list.size()){
                textView.append("\n");
            }
        }
    }
}

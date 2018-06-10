package ch.builditbigger.displayjokes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    private static final String JOKE_PARAM = "joke-param";

    public static void startActvity(Context context, String joke) {
        Intent jokeIntent = new Intent(context, DisplayJokeActivity.class);
        jokeIntent.putExtra(JOKE_PARAM, joke);
        context.startActivity(jokeIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        if (getIntent().hasExtra(JOKE_PARAM)) {
            TextView jokeTextView = findViewById(R.id.jokeTextView);
            jokeTextView.setText(getIntent().getStringExtra(JOKE_PARAM));
        }
    }
}

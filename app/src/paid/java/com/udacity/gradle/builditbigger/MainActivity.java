package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.task.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.task.JokeReceivedCallback;

import ch.builditbigger.displayjokes.DisplayJokeActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBarSpinner;
    private View mContentFragment;

    private JokeReceivedCallback callback = new JokeReceivedCallback() {
        @Override
        public void jokeReceived(String joke) {
            if (joke == null) {
                Toast.makeText(MainActivity.this, MainActivity.this
                        .getResources().getString(R.string.error_user_message),
                        Toast.LENGTH_SHORT).show();
            } else {
                DisplayJokeActivity.startActvity(MainActivity.this, joke);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBarSpinner = findViewById(R.id.progressBarSpinner);
        mContentFragment = findViewById(R.id.fragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showContent();
    }

    private void showContent() {
        mProgressBarSpinner.setVisibility(View.INVISIBLE);
        mContentFragment.setVisibility(View.VISIBLE);
    }

    private void showProgressBar() {
        mProgressBarSpinner.setVisibility(View.VISIBLE);
        mContentFragment.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        showProgressBar();
        new EndpointsAsyncTask().execute(callback);
    }
}

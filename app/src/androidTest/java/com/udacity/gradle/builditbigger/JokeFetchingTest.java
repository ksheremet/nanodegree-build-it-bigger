package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.task.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.task.JokeReceivedCallback;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class JokeFetchingTest {
    @Test
    public void verifyJokeFetched() {
        try {
            // https://stackoverflow.com/questions/2321829/
            final CountDownLatch signal = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(new JokeReceivedCallback() {
                @Override
                public void jokeReceived(String joke) {
                    assertNotNull(joke);
                    assertTrue(!joke.isEmpty());
                    signal.countDown();
                }
            });
            signal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

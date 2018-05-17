package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    final CountDownLatch countDownLatch = new CountDownLatch(1);

    /*ref: https://web.archive.org/web/20170618224249/http://www.making-software.com/2012/10/31/testable-android-asynctask/*/

    @Test
    public void testAsync() throws Throwable {

        final EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask() {

            @Override
            protected String doInBackground(Void... voids) {
                return super.doInBackground(voids);
            }

            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertFalse(result.equals(""));
                countDownLatch.countDown();
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                endpointsAsyncTask.execute();
            }
        };

        runnable.run();

        countDownLatch.await(30, TimeUnit.SECONDS);
    }
}

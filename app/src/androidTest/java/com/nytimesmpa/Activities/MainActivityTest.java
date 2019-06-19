package com.nytimesmpa.Activities;


import android.app.Instrumentation;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import com.nytimesmpa.R;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivitTestRule = new ActivityTestRule<>(MainActivity.class);
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ArticleDetailActivity.class.getName(), null, false);

    private MainActivity mainActivity = null;

    @Before
    public void setUp() throws Exception {
        mainActivity = mainActivityActivitTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }

    @Test
    public void testLaunch() throws Exception {


        assertNotNull(mainActivity.findViewById(R.id.rv_articles));
        Thread.sleep(2000);
        if (isNetworkConnected() && mainActivity.mostViewArticleModelArrayList.size() > 0) {
            onView(withId(R.id.rv_articles)).perform(RecyclerViewActions.scrollToPosition(6));
            Thread.sleep(2000);
            onView(withId(R.id.rv_articles)).perform(RecyclerViewActions.actionOnItemAtPosition(6, click()));
            Thread.sleep(5000);
        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
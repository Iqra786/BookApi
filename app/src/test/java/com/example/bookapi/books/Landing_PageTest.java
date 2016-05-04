package com.example.bookapi.books;

import android.os.Build;

import com.example.bookapi.books.json_model.Item;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;


import static junit.framework.Assert.assertNotNull;


/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, packageName = "com.example.bookapi.books")
@RunWith(RobolectricGradleTestRunner.class)
public class Landing_PageTest {

    private Landing_Page mLanding_Page;

    @Before
    public void setup() {
        mLanding_Page = Robolectric.buildActivity(Landing_Page.class).create().get();
    }

    @Test
    public void checkActivityNotNull() {
        assertNotNull("Landing Page is not instantiated", mLanding_Page);
    }
}

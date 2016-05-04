package com.example.bookapi.books;

import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, packageName = "com.example.bookapi.books")
@RunWith(RobolectricGradleTestRunner.class)
public class BookDetailTest {


    private BookDetail mBook_Detail;

    @Before
    public void setup() {
        mBook_Detail = Robolectric.buildActivity(BookDetail.class).create().get();
    }

    @Test
    public void checkActivityNotNull() {
        assertNotNull("Book deatil is not instantiated", mBook_Detail);
    }

    @Test
    public void viewTest(){
        TextView textView = (TextView) mBook_Detail.findViewById(R.id.tv_Fragment_Book_Detail_Heading_Average_Rating_Text);
        assertNotNull("TextView is null" , textView);
        textView.setText("hello");
        assertEquals("hello", textView.getText().toString());
    }

}

package com.example.bookapi.books;

import android.os.Build;

import com.example.bookapi.books.json_model.Item;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, packageName = "com.example.bookapi.books")
@RunWith(RobolectricGradleTestRunner.class)
public class BookAdaptorTest {

    @Test
    public void noDataSetTest() {
        BookAdaptor mBookAdaptor = new BookAdaptor(null);
        assertNotNull("Adaptor not instantiated", mBookAdaptor);
        assertEquals(mBookAdaptor.getItemCount(), 0);
    }

    @Test
    public void itemCount() {
        BookAdaptor mBookAdaptor = new BookAdaptor(null);
        Item items = new Item();
        mBookAdaptor.setBookList(asList(items, items, items));
        assertThat(mBookAdaptor.getItemCount(), equalTo(3));
    }

    @Test
    public void getItemAtPosition() {
        BookAdaptor mBookAdaptor = new BookAdaptor(null);
        Item item1 = new Item();
        Item item2 = new Item();
        mBookAdaptor.setBookList(asList(item1, item2));
        assertThat(mBookAdaptor.getItemAtPosition(0), equalTo(item1));
        assertThat(mBookAdaptor.getItemAtPosition(1), equalTo(item2));
    }
}

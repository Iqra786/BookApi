package com.example.bookapi.books;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.bookapi.books.json_model.Item;

import java.util.List;


/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */


public class BookDetail extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_book_detail);
        TextView book_Name = (TextView) findViewById(R.id.tv_Fragment_Book_Detail_Heading_Book_Name_Text);
        TextView author_Name = (TextView) findViewById(R.id.tv_Fragment_Book_Detail_Author_Name);
        TextView book_Desc = (TextView) findViewById(R.id.tv_Fragment_Book_Detail_Desc_Text);
        TextView book_Published_Date = (TextView) findViewById(R.id.tv_Fragment_Book_Detail_Published_Text);
        TextView book_Category = (TextView) findViewById(R.id.tv_Fragment_Book_Detail_Heading_Category_Text);
        TextView book_Pages_Count = (TextView) findViewById(R.id.tv_Fragment_Book_Detail_Heading_Pages_Count_Text);
        TextView book_Avg_Rating = (TextView) findViewById(R.id.tv_Fragment_Book_Detail_Heading_Average_Rating_Text);


        Item item = (Item) getIntent().getSerializableExtra("data");
        if (item != null) {
            if (item.getVolumeInfo() != null) {
                book_Name.setText(item.getVolumeInfo().getTitle());
                List<String> authors = item.getVolumeInfo().getAuthors();
                StringBuilder authors_Name = new StringBuilder();
                for (String author : authors) {
                    authors_Name = authors_Name.append(author + " " + ",");
                }
                author_Name.setText(authors_Name.toString());
            }

            if (item.getVolumeInfo().getDescription() != null) {
                book_Desc.setText(item.getVolumeInfo().getDescription().toString().isEmpty() ? "No data" : item.getVolumeInfo().getDescription());
            } else {
                book_Desc.setText("No Data");
            }

            if (item.getVolumeInfo().getPublishedDate() != null) {
                book_Published_Date.setText(item.getVolumeInfo().getPublishedDate());
            }


            List<String> categories = item.getVolumeInfo().getCategories();
            StringBuilder display_Category = new StringBuilder();
            for (String category : categories) {
                display_Category = display_Category.append(category + " " + ",");
            }

            book_Category.setText(display_Category.toString().isEmpty() ? "No data" : display_Category.toString());

            if (item.getVolumeInfo().getPageCount() != null) {
                book_Pages_Count.setText(item.getVolumeInfo().getPageCount().toString().isEmpty() ? "No data" : item.getVolumeInfo().getPageCount().toString());
            } else {
                book_Pages_Count.setText("No Data");
            }

            if (item.getVolumeInfo().getAverageRating() != null) {
                book_Avg_Rating.setText(item.getVolumeInfo().getAverageRating().toString().isEmpty() ? "No data" : item.getVolumeInfo().getAverageRating().toString());
            } else {
                book_Avg_Rating.setText("No Data");
            }

        }


    }
}

    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book_detail, container, false);
        TextView book_Name = (TextView) v.findViewById(R.id.tv_Fragment_Book_Detail_Heading_Book_Name_Text);
        TextView author_Name = (TextView) v.findViewById(R.id.tv_Fragment_Book_Detail_Author_Name);
        TextView book_Desc = (TextView) v.findViewById(R.id.tv_Fragment_Book_Detail_Desc_Text);
        TextView book_Published_Date = (TextView) v.findViewById(R.id.tv_Fragment_Book_Detail_Published_Text);
        TextView book_Category = (TextView) v.findViewById(R.id.tv_Fragment_Book_Detail_Heading_Category_Text);
        TextView book_Pages_Count = (TextView) v.findViewById(R.id.tv_Fragment_Book_Detail_Heading_Pages_Count_Text);
        TextView book_Avg_Rating = (TextView) v.findViewById(R.id.tv_Fragment_Book_Detail_Heading_Average_Rating_Text);


        Bundle bundle = getArguments();
        if (bundle != null) {
            Item item = (Item) bundle.getSerializable("data");
            if (item != null) {
                if (item.getVolumeInfo() != null) {
                    book_Name.setText(item.getVolumeInfo().getTitle());
                    List<String> authors = item.getVolumeInfo().getAuthors();
                    StringBuilder authors_Name = new StringBuilder();
                    for (String author : authors) {
                        authors_Name = authors_Name.append(author + " " + ",");
                    }
                    author_Name.setText(authors_Name.toString());
                }

                if (item.getVolumeInfo().getDescription() != null) {
                    book_Desc.setText(item.getVolumeInfo().getDescription().toString().isEmpty() ? "No data" : item.getVolumeInfo().getDescription());
                } else {
                    book_Desc.setText("No Data");
                }

                if (item.getVolumeInfo().getPublishedDate() != null) {
                    book_Published_Date.setText(item.getVolumeInfo().getPublishedDate());
                }


                List<String> categories = item.getVolumeInfo().getCategories();
                StringBuilder display_Category = new StringBuilder();
                for (String category : categories) {
                    display_Category = display_Category.append(category + " " + ",");
                }

                book_Category.setText(display_Category.toString().isEmpty() ? "No data" : display_Category.toString());

                if (item.getVolumeInfo().getPageCount() != null) {
                    book_Pages_Count.setText(item.getVolumeInfo().getPageCount().toString().isEmpty() ? "No data" : item.getVolumeInfo().getPageCount().toString());
                } else {
                    book_Pages_Count.setText("No Data");
                }

                if (item.getVolumeInfo().getAverageRating() != null) {
                    book_Avg_Rating.setText(item.getVolumeInfo().getAverageRating().toString().isEmpty() ? "No data" : item.getVolumeInfo().getAverageRating().toString());
                } else {
                    book_Avg_Rating.setText("No Data");
                }

            }
        }

        return v;
    }*/
//}

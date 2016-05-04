package com.example.bookapi.books;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookapi.books.json_model.Item;
import com.example.bookapi.books.json_model.VolumeInfo;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */


public class BookAdaptor extends RecyclerView.Adapter<BookAdaptor.ViewHolder> implements Serializable {

    private transient List<Item> mBooksList = new ArrayList<>();
    private transient onItemClickListener mOnItemClickListener;


    public BookAdaptor(onItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.row_book_adaptor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mBooksList.get(position);
        holder.onBind(item, mOnItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mBooksList.size();
    }


    public void setBookList(List<Item> booksList) {
        if (booksList != null) {
            mBooksList.addAll(booksList);
        }
        notifyDataSetChanged();
    }

    public void clearAdaptor() {
        if (mBooksList != null && mBooksList.size() > 0) {
            mBooksList.clear();
            notifyDataSetChanged();
        }
    }

    public Item getItemAtPosition(int position) {
        return mBooksList.get(position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Serializable {
        private TextView tv_Title;
        private ImageView customImageView;
        private onItemClickListener itemClicked;


        public ViewHolder(View itemView) {
            super(itemView);
            tv_Title = (TextView) itemView.findViewById(R.id.tv_Row_Book_Adaptor);
            tv_Title.setOnClickListener(this);
            customImageView = (ImageView) itemView.findViewById(R.id.civ_Row_Book_Adaptor);
            customImageView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.civ_Row_Book_Adaptor:
                   navigation(v);
                    break;
                case R.id.tv_Row_Book_Adaptor:
                    navigation(v);
                    break;
            }
        }

        private void navigation(View v) {
            if (itemClicked != null) {
                Item item = (Item) v.getTag();
                if (item != null) {
                    itemClicked.onItemClick(item);
                }
            }
        }


        public void onBind(final Item item, final onItemClickListener onItemClickListener) {
            itemClicked = onItemClickListener;
            VolumeInfo volumeInfo = item.getVolumeInfo();
            tv_Title.setText(volumeInfo.getTitle());
            customImageView.setTag(item);
            tv_Title.setTag(item);
            if (volumeInfo.getImageLinks() != null && volumeInfo.getImageLinks().getThumbnail() != null) {
                Picasso.with(customImageView.getContext().getApplicationContext()).load(volumeInfo.getImageLinks().getThumbnail()).into(customImageView);
            } else {
                customImageView.setImageResource(R.mipmap.images);
            }
        }



    }


}

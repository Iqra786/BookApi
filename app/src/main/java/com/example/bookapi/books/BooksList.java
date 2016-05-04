package com.example.bookapi.books;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.bookapi.books.json_model.Item;


import java.util.List;

/**
 * Created by muhammad ali
 * Created on 04/05/2016.
 */


public class BooksList extends Fragment implements com.example.bookapi.books.Callback, onItemClickListener, View.OnClickListener {


    private BookAdaptor mBookAdaptor;
    private RecyclerView mRecyclerView;
    private EditText et_SearchText;
    private SearchProgress mPD;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.main_RecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        Button btn_Search = (Button) view.findViewById(R.id.btn_Search);
        btn_Search.setOnClickListener(this);
        et_SearchText = (EditText) view.findViewById(R.id.et_Search_Books);
        mRecyclerView.setLayoutManager(layoutManager);
        mBookAdaptor = new BookAdaptor(this);
        mRecyclerView.setAdapter(mBookAdaptor);
        if (savedInstanceState != null) {
            mBookAdaptor = (BookAdaptor) savedInstanceState.getSerializable("Adaptor");
            mRecyclerView.setAdapter(mBookAdaptor);
            mBookAdaptor.notifyDataSetChanged();
        }

        FragmentManager fm = getFragmentManager();
        mPD = (SearchProgress) fm.findFragmentByTag("search");


        return view;
    }


    @Override
    public void onSuccess(List<Item> articles) {
        Log.v("OnResponse", "No Error");
        mBookAdaptor.setBookList(articles);
        et_SearchText.getText().clear();
        dismissProgressDialog();
    }

    @Override
    public void onFailure(String error) {
        Log.e("onFailure", error);
        dismissProgressDialog();
        Toast.makeText(getContext() , "NO INTERNET OR SERVICE IS NOT AVAIALBLE",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("Adaptor", mBookAdaptor);

    }


    @Override
    public void onItemClick(Item item) {
        callDetailActivity(item);
    }

    private void callDetailActivity(Item item) {
        Intent intent = new Intent(getContext().getApplicationContext(), BookDetail.class);
        intent.putExtra("data", item);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Search:
                String bookName = et_SearchText.getText().toString();
                if (!bookName.isEmpty()) {
                    mBookAdaptor.clearAdaptor();
                    clearKeyboard();
                    RetrofitBookApi retrofitBookApi = new RetrofitBookApi(this);
                    retrofitBookApi.fetchBooks(bookName);
                    showProgressDialog();
                }
                break;
        }

    }


    private void showProgressDialog() {
        mPD = new SearchProgress();
        mPD.show(getFragmentManager(), "search");

    }

    private void dismissProgressDialog() {
        if (mPD != null) {
            mPD.dismiss();
        }
    }

    private void clearKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et_SearchText.getWindowToken(), 0);
    }

}

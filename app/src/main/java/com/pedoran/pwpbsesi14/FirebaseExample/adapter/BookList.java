package com.pedoran.pwpbsesi14.FirebaseExample.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pedoran.pwpbsesi14.FirebaseExample.entity.Book;
import com.pedoran.pwpbsesi14.R;

import java.util.List;

public class BookList extends ArrayAdapter<Book> {
    private Activity context;
    private List<Book> bookList;

    public BookList(Activity context, List<Book> bookList) {
        super(context, R.layout.item_book,bookList);
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_book,null,true);
        TextView tvTitle = v.findViewById(R.id.tv_title);
        TextView tvDiff = v.findViewById(R.id.tv_diff);

        Book book = bookList.get(position);
        tvTitle.setText(book.getBookTitle());
        tvDiff.setText(book.getBookDifficulty());

        return v;
    }
}

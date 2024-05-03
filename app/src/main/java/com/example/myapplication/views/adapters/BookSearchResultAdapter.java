package com.example.myapplication.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.models.Item;
import java.util.ArrayList;
import java.util.List;


public class BookSearchResultAdapter extends RecyclerView.Adapter<BookSearchResultAdapter.BookSearchResultHolder> {

    private List<Item> results = new ArrayList<>();


    @NonNull
    @Override
    public BookSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        return new BookSearchResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSearchResultHolder holder, int position) {
        //получить объект по позиции

        //написать заголовок в textView

        //по ссылке на картинку показать ee в imageView ЕСЛИ ОНА ЕСТЬ! Glide

    }

    public void setResults(List<Item> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class BookSearchResultHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public BookSearchResultHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.title);
        }
    }
}

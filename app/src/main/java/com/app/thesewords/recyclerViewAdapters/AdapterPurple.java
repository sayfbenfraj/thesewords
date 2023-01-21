package com.app.thesewords.recyclerViewAdapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.thesewords.R;

import java.util.List;

// The adapter class which
// extends RecyclerView Adapter
public class AdapterPurple extends RecyclerView.Adapter<AdapterPurple.MyView> {

    // List with String type
    private List<Drawable> cardDrawableList;

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public static class MyView extends RecyclerView.ViewHolder{

        // Text View
        ImageView card;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);
            // initialise TextView with id
            card = view.findViewById(R.id.cardViewPurple);
        }
    }

    // Constructor for adapter class
    // which takes a list of String type
    public AdapterPurple(List<Drawable> cardDrawableHorizontalList)
    {
            this.cardDrawableList      = cardDrawableHorizontalList;
    }

    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // Inflate item.xml using LayoutInflator
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_purple, parent, false);
        // return itemView
        int height = parent.getLayoutParams().height;
        itemView.getLayoutParams().height = height;
        // return itemView

        return new MyView(itemView);
    }

    // Override onBindViewHolder which deals
    // with the setting of different data
    // and methods related to clicks on
    // particular items of the RecyclerView.
    @Override
    public void onBindViewHolder(final MyView holder, final int position)
    {
        // Set the text of each item of
        // Recycler view with the list item
        holder.card.setImageDrawable(cardDrawableList.get(position));
  ;
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount()
    {
        return cardDrawableList.size();
    }

}

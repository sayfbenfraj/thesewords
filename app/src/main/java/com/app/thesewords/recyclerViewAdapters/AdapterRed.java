package com.app.thesewords.recyclerViewAdapters;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.app.thesewords.R;
import com.app.thesewords.RecyclerViewInterface;

import java.util.List;

// The adapter class which
// extends RecyclerView Adapter
public class AdapterRed extends RecyclerView.Adapter<AdapterRed.MyView> {

    private final RecyclerViewInterface recyclerViewInterface;
    // List with String type
    private List<String> cardTextList;
    private List<Drawable> cardDrawableList;

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public static class MyView extends RecyclerView.ViewHolder{

        // Text View
        ImageView card;
        TextView  cardText;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view, RecyclerViewInterface recyclerViewInterface)
        {
            super(view);
            // initialise TextView with id
            card = view.findViewById(R.id.card);
            cardText = view.findViewById(R.id.cardText);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClickRed(view, pos);
                        }
                    }
                }
            });
        }

    }

    // Constructor for adapter class
    // which takes a list of String type
    public AdapterRed(List<String> cardTextHorizontalList,
                      List<Drawable> cardDrawableHorizontalList,
                      RecyclerViewInterface recyclerViewInterface)
    {
            this.cardTextList          = cardTextHorizontalList;
            this.cardDrawableList      = cardDrawableHorizontalList;
            this.recyclerViewInterface = recyclerViewInterface;
    }

    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // Inflate item.xml using LayoutInflator
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        int height = parent.getLayoutParams().height;
        itemView.getLayoutParams().height = height;
        // return itemView
        return new MyView(itemView, recyclerViewInterface);
    }

    // Override onBindViewHolder which deals
    // with the setting of different data
    // and methods related to clicks on
    // particular items of the RecyclerView.
    @Override
    public void onBindViewHolder(final MyView holder, final int position)
    {
        // Set the text of each item of
        // Recycler view with the list items
        if (cardTextList.isEmpty())
        {
            Toast.makeText(holder.itemView.getContext(), "got clicked", Toast.LENGTH_LONG).show();
        }
        else
        {
            holder.cardText.setText(cardTextList.get(position));
            holder.card.setImageDrawable(cardDrawableList.get(position));
        }

    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount()
    {
        return cardTextList.size();
    }

}

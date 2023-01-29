package com.app.thesewords.recyclerViewAdapters;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.app.thesewords.CardModel;
import com.app.thesewords.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// The adapter class which
// extends RecyclerView Adapter
public class AdapterPurple extends RecyclerView.Adapter<AdapterPurple.MyView> {

    // List with String type
    private final List<Drawable> cardDrawableList;
    private final List<String> cardTextList;

    // View Holder class which
    // extends RecyclerView.ViewHolder
    public static class MyView extends RecyclerView.ViewHolder{

        // Text View
        ImageView card;
        TextView  cardText;

        // parameterised constructor for View Holder class
        // which takes the view as a parameter
        public MyView(View view)
        {
            super(view);
            // initialise TextView with id
            card = view.findViewById(R.id.card);
            cardText = view.findViewById(R.id.cardText);
        }
    }

    // Constructor for adapter class
    // which takes a list of String type
    public AdapterPurple(ArrayList<CardModel> cardModalArrayList)
    {
        List<String>   cardTextHorizontalList = new ArrayList<>();
        List<Drawable> cardDrawableHorizontalList  = new ArrayList<>();

        for (int i = 0; i < cardModalArrayList.size(); i++) {
            CardModel card = cardModalArrayList.get(i);
            String title     = card.getTitle();
            byte[] thumbnail = card.getThumbnail();
            Drawable image = new BitmapDrawable(BitmapFactory.decodeByteArray(thumbnail,
                    0, thumbnail.length));
             cardTextHorizontalList.add(title);
            cardDrawableHorizontalList.add(image);
        }
        this.cardDrawableList = cardDrawableHorizontalList;
        this.cardTextList     = cardTextHorizontalList;
    }
    // Override onCreateViewHolder which deals
    // with the inflation of the card layout
    // as an item for the RecyclerView.

    @NonNull
    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // Inflate item.xml using LayoutInflator
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        // return itemView
        itemView.getLayoutParams().height = parent.getLayoutParams().height;
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
        holder.cardText.setText(cardTextList.get(position));
    }

    public void addItem(CardModel card) {
        cardTextList.add(card.getTitle());
        byte[] thumbnail = card.getThumbnail();
        Drawable image = new BitmapDrawable(BitmapFactory.decodeByteArray(thumbnail,
                0, thumbnail.length));
        cardDrawableList.add(image);
        card.getThumbnail();
        notifyItemInserted(cardTextList.size());
    }

    // Override getItemCount which Returns
    // the length of the RecyclerView.
    @Override
    public int getItemCount()
    {
        return cardTextList.size();
    }

    public ArrayList getCardTextListList(){
        return (ArrayList) cardTextList;
    }

    public void delete(int position){
        cardTextList.remove(position);
        cardDrawableList.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = cardTextList.size();
        cardTextList.clear();
        cardDrawableList.clear();
        notifyItemRangeRemoved(0, size);
    }

}

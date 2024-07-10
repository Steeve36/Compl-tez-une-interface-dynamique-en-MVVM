package com.openclassrooms.tajmahal.ui.restaurant.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.openclassrooms.tajmahal.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Integer> integerArrayList;

    private RequestManager glide;

    public ReviewAdapter(Context context, ArrayList<Integer> integerArrayList) {
        this.context = context;
        this.integerArrayList = integerArrayList;
        this.glide = glide;
    }

    @NonNull
    @Override
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.single_image_recycler_adapter,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {

        // Utiliser Glide ici pour montrer les images
        Glide.with(context)
                .load(integerArrayList.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profileUser);
        }
    }


    /**
     * AUTRE CODE PRECEDEMENT MIS
     *
     * public class ReviewViewHolder extends RecyclerView.ViewHolder {
     *
     *     TextView userName = (TextView) itemView.findViewById( R.id.userName );
     *     TextView reviewField = (TextView) itemView.findViewById( R.id.reviewField);
     *
     *     ImageView profileUser = (ImageView) imageView.findViewById( R.id.profileUser)
     *
     *     public ReviewViewHolder(View itemView) {
     *         super(itemView);
     *     }
     *
     *     public void Review (Review review){
     *         this.userName.setText(review.getUsername());
     *         this.reviewField.setText(review.getComment());
     *     }
     * }
     *
     */
}

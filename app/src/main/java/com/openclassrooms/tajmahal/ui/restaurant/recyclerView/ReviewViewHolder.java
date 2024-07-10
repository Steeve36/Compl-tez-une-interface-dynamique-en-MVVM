package com.openclassrooms.tajmahal.ui.restaurant.recyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;

public class ReviewViewHolder extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Integer> integerArrayList;
    private ReviewAdapter reviewAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        integerArrayList = new ArrayList<>();
        integerArrayList.add(R.drawable.photo_profile);

        reviewAdapter = new ReviewAdapter(this,integerArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(reviewAdapter);
    }

    /**
     * AUTRE CODE PRECEDEMENT MIS
     *
     * package com.openclassrooms.tajmahal.ui.restaurant.recyclerView;
     *
     * import android.content.Context;
     * import android.view.LayoutInflater;
     * import android.view.View;
     * import android.view.ViewGroup;
     * import android.widget.ImageView;
     * import android.widget.TextView;
     *
     * import androidx.annotation.NonNull;
     * import androidx.recyclerview.widget.RecyclerView;
     *
     * import com.bumptech.glide.Glide;
     * import com.google.android.material.textfield.TextInputEditText;
     * import com.openclassrooms.tajmahal.R;
     * import com.openclassrooms.tajmahal.domain.model.Review;
     *
     * public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
     *
     *     private final Context context;
     *     private final ArrayList<Integer> integerArraylist;
     *
     *     public ReviewAdapter(Context context, ArrayList<Integer> integerArraylist) {
     *         this.context = context;
     *         this.integerArraylist = integerArraylist;
     *     }
     *
     *     @NonNull
     *     @Override
     *     public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     *         View view = LayoutInflater.from(parent.getContext()).inflate(androidx.appcompat.R.layout.single_image_recycler_adapter,parent, false);
     *         return new ViewHolder(view);
     *     }
     *
     *     @Override
     *     public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {
     *
     *     }
     *
     *     // Montrer les images grace à Glide
     *     Glide.with(contexte){
     *                 .load(integerArraylist.get(position))
     *                 .into(holder.imageView);
     *     }
     *
     *
     *
     *     @Override
     *     public int getItemCount() {
     *         return integerArraylist.size();
     *     }
     *
     *     public class ViewHolder extends RecyclerView.ViewHolder {
     *
     *         ImageView profileUser;
     *         public ViewHolder(@NonNull View itemView) {
     *             super(itemView);
     *             profileUser = itemView.findViewById(R.id.profileUser);
     *         }
     *     }
     * }
     */

}

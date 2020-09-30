package com.bobaappsinc.veiwpager2imageslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravellocationViewHolder> {

    private List<Travellocation> travellocations;

    public TravelLocationAdapter(List<Travellocation> travellocations) {
        this.travellocations = travellocations;
    }

    @NonNull
    @Override
    public TravellocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravellocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravellocationViewHolder holder, int position) {
        holder.setLocationData(travellocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travellocations.size();
    }

    static class TravellocationViewHolder extends RecyclerView.ViewHolder{
        private KenBurnsView kbvLocation ;
        private TextView textTitle,textLocation,textStrating;
        public TravellocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            textTitle = itemView.findViewById(R.id.textTitle);
            textLocation = itemView.findViewById(R.id.textLocation);
            textStrating = itemView.findViewById(R.id.textStarRating);
        }
        void setLocationData(Travellocation travellocation){
            Picasso.get().load(travellocation.imageUrl).into(kbvLocation);
            textTitle.setText(travellocation.titile);
            textLocation.setText(travellocation.locaiton);
            textStrating.setText(String.valueOf(travellocation.startRating));
        }
    }
}

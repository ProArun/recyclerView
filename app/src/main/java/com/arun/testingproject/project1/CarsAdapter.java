package com.arun.testingproject.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arun.testingproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.MyViewHolder> {
    private ArrayList<CarsModel> carsModels = new ArrayList<>();
    private Context context;

    public CarsAdapter(Context context, ArrayList<CarsModel> carsModels) {
        this.carsModels = carsModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cars_list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.car_name.setText(carsModels.get(position).getName());
        holder.car_desc.setText(carsModels.get(position).getDesc());

        Picasso.get().load(carsModels.get(position).getImage()).into(holder.car_image);
    }

    @Override
    public int getItemCount() {
        return carsModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView car_image;
        private TextView car_name, car_desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            car_image = (ImageView) itemView.findViewById(R.id.car_image);
            car_name = (TextView) itemView.findViewById(R.id.car_name);
            car_desc = (TextView) itemView.findViewById(R.id.car_desc);
        }
    }
}

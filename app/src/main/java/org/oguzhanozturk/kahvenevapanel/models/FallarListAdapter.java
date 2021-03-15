package org.oguzhanozturk.kahvenevapanel.models;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.oguzhanozturk.kahvenevapanel.R;
import org.oguzhanozturk.kahvenevapanel.activities.FalCevapActivity;
import java.util.ArrayList;

public class FallarListAdapter extends RecyclerView.Adapter<FallarListAdapter.FallarListViewHolder> {



    private ArrayList<FalData> data;

    public FallarListAdapter(ArrayList<FalData> data){

        this.data = data;

    }

    @NonNull
    @Override
    public FallarListViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.fallar_list_card,parent,false);

        final FallarListViewHolder holder = new FallarListViewHolder(card);

        card.findViewById(R.id.listCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), FalCevapActivity.class);

                Bundle dataBundle = new Bundle();

                dataBundle.putString("id",data.get(holder.getLayoutPosition()).getId());
                dataBundle.putString("isim",data.get(holder.getLayoutPosition()).getIsim());
                dataBundle.putString("cinsiyet",data.get(holder.getLayoutPosition()).getCinsiyet());
                dataBundle.putInt("yas",data.get(holder.getLayoutPosition()).getYas());
                dataBundle.putString("medeni_durum",data.get(holder.getLayoutPosition()).getMedeniDurum());
                dataBundle.putString("ilgi",data.get(holder.getLayoutPosition()).getIlgi());
                dataBundle.putString("mesaj",data.get(holder.getLayoutPosition()).getMessage());
                dataBundle.putString("tarih",data.get(holder.getLayoutPosition()).getTarih());
                dataBundle.putStringArrayList("imageUrls",data.get(holder.getLayoutPosition()).getUrlString());

                intent.putExtra("data",dataBundle);
                parent.getContext().startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FallarListViewHolder holder, int position) {

        holder.cardFalDate.setText("Gönderilen Tarih :" + data.get(position).getTarih());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FallarListViewHolder extends RecyclerView.ViewHolder{

        private TextView cardFalDate;


        public FallarListViewHolder(@NonNull View itemView) {
            super(itemView);

            cardFalDate = (TextView)itemView.findViewById(R.id.cardFalDateText);

        }
    }

}

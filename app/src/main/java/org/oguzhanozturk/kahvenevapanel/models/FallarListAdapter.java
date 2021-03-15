package org.oguzhanozturk.kahvenevapanel.models;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FallarListAdapter extends RecyclerView.Adapter<FallarListAdapter.FallarListViewHolder> {



    private ArrayList<FalData> data;

    public FallarListAdapter(ArrayList<FalData> data){

        this.data = data;

    }

    @NonNull
    @Override
    public FallarListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FallarListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FallarListViewHolder extends RecyclerView.ViewHolder{


        public FallarListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

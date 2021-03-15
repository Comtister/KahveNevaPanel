package org.oguzhanozturk.kahvenevapanel.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.oguzhanozturk.kahvenevapanel.R;
import org.oguzhanozturk.kahvenevapanel.activities.FalListActivity;
import org.oguzhanozturk.kahvenevapanel.models.FalData;
import org.oguzhanozturk.kahvenevapanel.models.FallarListAdapter;

import java.util.ArrayList;

public class FalListView {

    private View rootView;
    private FalListActivity ownController;

    private RecyclerView falList;
    private FallarListAdapter adapter;

    public FalListView(Context context , ViewGroup viewGroup){

    rootView = LayoutInflater.from(context).inflate(R.layout.activity_fal_list,viewGroup);
    ownController = (FalListActivity)context;

    }

    public void initViews(){

        falList = (RecyclerView)rootView.findViewById(R.id.falList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext(),RecyclerView.VERTICAL,false);
        falList.setLayoutManager(layoutManager);

    }

    public void setDataList(ArrayList<FalData> data){

        adapter = new FallarListAdapter(data);
        falList.setAdapter(adapter);


    }

    public View getRootView() {
        return rootView;
    }
}

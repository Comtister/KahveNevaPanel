package org.oguzhanozturk.kahvenevapanel.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.oguzhanozturk.kahvenevapanel.R;
import org.oguzhanozturk.kahvenevapanel.interfaces.FalDataFetchListener;
import org.oguzhanozturk.kahvenevapanel.models.FalData;
import org.oguzhanozturk.kahvenevapanel.models.FirestoreManager;
import org.oguzhanozturk.kahvenevapanel.views.FalListView;

import java.util.ArrayList;

public class FalListActivity extends AppCompatActivity {


    private FalListView ownView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownView = new FalListView(this,null);
        setContentView(ownView.getRootView());
        ownView.initViews();
        fetchFalDatas();


    }


    private void fetchFalDatas(){

        FirestoreManager firestoreManager = new FirestoreManager(this);
        firestoreManager.fetchFals(new FalDataFetchListener() {
            @Override
            public void onSuccesListener(ArrayList<FalData> data) {
                ownView.setDataList(data);
            }

            @Override
            public void onFailListener(Exception e) {

            }
        });


    }

}

package org.oguzhanozturk.kahvenevapanel.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import org.oguzhanozturk.kahvenevapanel.views.MainView;

public class MainActivity extends AppCompatActivity {

    private MainView ownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownView = new MainView(this,null);
        setContentView(ownView.getRootView());
        ownView.initViews();

    }


    public void gotoFalBakScreen(){

        Intent intent = new Intent(this,FalListActivity.class);
        startActivity(intent);

    }

}
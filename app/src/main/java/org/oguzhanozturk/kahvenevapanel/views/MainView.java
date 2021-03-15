package org.oguzhanozturk.kahvenevapanel.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.oguzhanozturk.kahvenevapanel.R;
import org.oguzhanozturk.kahvenevapanel.activities.MainActivity;
import org.oguzhanozturk.kahvenevapanel.activities.SignUpActivity;

public class MainView {

    private View rootView;
    private MainActivity mainController;


    private Button falBakBtn;

    public MainView(Context context , ViewGroup viewGroup){

        rootView = LayoutInflater.from(context).inflate(R.layout.activity_main,viewGroup);
        mainController = (MainActivity)context;

    }

    public void initViews(){

        falBakBtn = (Button)rootView.findViewById(R.id.falBakBtn);

        falBakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainController.gotoFalBakScreen();
            }
        });

    }

    public View getRootView() {
        return rootView;
    }
}

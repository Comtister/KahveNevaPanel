package org.oguzhanozturk.kahvenevapanel.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.oguzhanozturk.kahvenevapanel.R;
import org.oguzhanozturk.kahvenevapanel.activities.FalCevapActivity;

public class FalCevapView {

    private View rootView;
    private FalCevapActivity ownController;

    private TextView isimText;
    private TextView yasText;
    private TextView cinsiyetText;
    private TextView medeniDurumText;
    private TextView ilgiText;
    private TextView mesajText;

    private ImageView foto1;
    private ImageView foto2;
    private ImageView foto3;


    public FalCevapView(Context context , ViewGroup viewGroup){

        rootView = LayoutInflater.from(context).inflate(R.layout.activity_fal_cevap,viewGroup);
        ownController = (FalCevapActivity)context;


    }

    public void initView(){

        isimText = (TextView)rootView.findViewById(R.id.isimText);
        yasText = (TextView)rootView.findViewById(R.id.yasText);
        cinsiyetText = (TextView)rootView.findViewById(R.id.CinsiyetText);
        medeniDurumText = (TextView)rootView.findViewById(R.id.medeniDurumText);
        ilgiText = (TextView)rootView.findViewById(R.id.ilgiText);
        mesajText = (TextView)rootView.findViewById(R.id.mesajText);


    }

    public View getRootView() {
        return rootView;
    }
}

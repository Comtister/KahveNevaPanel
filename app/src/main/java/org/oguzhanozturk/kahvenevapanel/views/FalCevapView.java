package org.oguzhanozturk.kahvenevapanel.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import org.oguzhanozturk.kahvenevapanel.R;
import org.oguzhanozturk.kahvenevapanel.activities.FalCevapActivity;
import java.util.ArrayList;

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

    private EditText cevap;
    private Button cevapBtn;

    private String tarih;
    private String id;


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

        foto1 = (ImageView)rootView.findViewById(R.id.imageView);
        foto2 = (ImageView)rootView.findViewById(R.id.imageView2);
        foto3 = (ImageView)rootView.findViewById(R.id.imageView3);

        cevap = (EditText)rootView.findViewById(R.id.cevapEditText);
        cevapBtn = (Button)rootView.findViewById(R.id.gonderBtn);

        cevapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ownController.cevapGonder(cevap.getText().toString() , id , tarih );
            }
        });

    }

    public void setDatas(String isim , String cinsiyet , int yas , String medeniDurum , String ilgi , String mesaj,String tarih , String id){

        isimText.setText(isim);
        yasText.setText(String.valueOf(yas));
        cinsiyetText.setText(cinsiyet);
        medeniDurumText.setText(medeniDurum);
        ilgiText.setText(ilgi);
        mesajText.setText(mesaj);
        this.tarih = tarih;
        this.id = id;
    }

    public void setImages(ArrayList<String> imageUrls){

        Picasso.get().load(imageUrls.get(0).replaceAll("\\[","")).into(foto1);
        Picasso.get().load(imageUrls.get(1).replaceAll(" ","")).into(foto2);
        Picasso.get().load(imageUrls.get(2).replaceAll("]","").replaceAll(" ","")).into(foto3);


    }

    public View getRootView() {
        return rootView;
    }
}

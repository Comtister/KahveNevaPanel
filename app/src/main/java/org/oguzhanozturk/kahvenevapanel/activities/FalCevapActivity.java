package org.oguzhanozturk.kahvenevapanel.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.oguzhanozturk.kahvenevapanel.interfaces.CevapUpdateListener;
import org.oguzhanozturk.kahvenevapanel.models.FirestoreManager;
import org.oguzhanozturk.kahvenevapanel.views.FalCevapView;

import java.util.ArrayList;

public class FalCevapActivity extends AppCompatActivity {

    private FalCevapView ownView;
    private Bundle datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownView = new FalCevapView(this,null);
        setContentView(ownView.getRootView());
        ownView.initView();

        Intent intent = getIntent();
        datas =  intent.getBundleExtra("data");
        setDatas();

    }


    private void setDatas(){

        String id = datas.getString("id");
        String isim = datas.getString("isim");
        String cinsiyet = datas.getString("cinsiyet");
        int yas = datas.getInt("yas");
        String medeniDurum = datas.getString("medeni_durum");
        String ilgi = datas.getString("ilgi");
        String mesaj = datas.getString("mesaj");
        String tarih = datas.getString("tarih");
        ArrayList<String> imageUrls = datas.getStringArrayList("imageUrls");

        ownView.setDatas(isim,cinsiyet,yas,medeniDurum,ilgi,mesaj,tarih,id);
        ownView.setImages(imageUrls);
    }

    public void cevapGonder(String cevap , String id , String tarih){

        FirestoreManager firestoreManager = new FirestoreManager(this);
        firestoreManager.updateCevap(cevap, id, tarih, new CevapUpdateListener() {
            @Override
            public void onSucces() {
                finish();
            }

            @Override
            public void onFail(Exception e) {

            }
        });


    }

}

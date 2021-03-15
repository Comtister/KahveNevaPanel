package org.oguzhanozturk.kahvenevapanel.models;

import android.net.Uri;

import java.net.URL;
import java.util.ArrayList;

public class FalData {

    private String cevap;
    private String cinsiyet;
    private int id;
    private  String ilgi;
    private ArrayList<Uri> imageUrls;
    private String isim;
    private String mail;
    private String medeniDurum;
    private String message;
    private int yas;

    public FalData(String cevap, String cinsiyet, int id, String ilgi, ArrayList<Uri> imageUrls, String isim, String mail, String medeniDurum, String message, int yas) {
        this.cevap = cevap;
        this.cinsiyet = cinsiyet;
        this.id = id;
        this.ilgi = ilgi;
        this.imageUrls = imageUrls;
        this.isim = isim;
        this.mail = mail;
        this.medeniDurum = medeniDurum;
        this.message = message;
        this.yas = yas;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIlgi() {
        return ilgi;
    }

    public void setIlgi(String ilgi) {
        this.ilgi = ilgi;
    }

    public ArrayList<Uri> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<Uri> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMedeniDurum() {
        return medeniDurum;
    }

    public void setMedeniDurum(String medeniDurum) {
        this.medeniDurum = medeniDurum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}

package org.oguzhanozturk.kahvenevapanel.models;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import org.oguzhanozturk.kahvenevapanel.interfaces.AuthProcessListener;
import org.oguzhanozturk.kahvenevapanel.interfaces.CevapUpdateListener;
import org.oguzhanozturk.kahvenevapanel.interfaces.FalDataFetchListener;
import org.oguzhanozturk.kahvenevapanel.interfaces.FirestoreManagerInterface;
import org.oguzhanozturk.kahvenevapanel.constants.NetworkError;

import java.util.ArrayList;
import java.util.UUID;

public class FirestoreManager extends NetworkManager implements FirestoreManagerInterface {

    public FirestoreManager(Context context) {
        super(context);
    }


    public void fetchFals(final FalDataFetchListener falDataFetchListener){

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collectionGroup("gonderilen").whereEqualTo("cevap","").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        ArrayList<FalData> data = new ArrayList<>();

                        for(DocumentSnapshot documentSnapshot : queryDocumentSnapshots.getDocuments()){

                            String[] imageUrlBuffer = documentSnapshot.get("images").toString().split(",");
                            ArrayList<Uri> imageUrls = new ArrayList<>();

                            for(int i = 0 ; i < imageUrlBuffer.length ; i++ ){
                                imageUrls.add(Uri.parse(imageUrlBuffer[i]));
                            }
                            Log.i("dada",String.valueOf(queryDocumentSnapshots.size()));
                            data.add(new FalData(documentSnapshot.get("cevap").toString(),documentSnapshot.get("cinsiyet").toString(), documentSnapshot.get("id").toString(),
                                    documentSnapshot.get("ilgi").toString(),imageUrls,documentSnapshot.get("isim").toString(),documentSnapshot.get("mail").toString(),
                                    documentSnapshot.get("medeni_durum").toString(),documentSnapshot.get("message").toString(),Integer.valueOf(documentSnapshot.get("yas").toString()),documentSnapshot.getId()));


                        }

                        falDataFetchListener.onSuccesListener(data);

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                falDataFetchListener.onFailListener(e);
                e.printStackTrace();
                e.getLocalizedMessage();
            }
        });



    }

    public void updateCevap(String cevap , String profileId , String date , final CevapUpdateListener cevapUpdateListener){

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        System.out.println(cevap);
        System.out.println(profileId);
        System.out.println(date);
        db.collection("Fallar").document(profileId).collection("gonderilen").document(date)
                .update("cevap",cevap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        cevapUpdateListener.onSucces();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

    }


    @Override
    public void saveAccountFirestore(Teller teller, final AuthProcessListener authProcessListener) {


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("falcilar").add(teller).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
               authProcessListener.onSucces();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                authProcessListener.onFailure(NetworkError.Upload_Error);
            }
        });


    }

}

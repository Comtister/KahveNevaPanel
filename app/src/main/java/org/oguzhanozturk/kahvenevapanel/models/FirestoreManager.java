package org.oguzhanozturk.kahvenevapanel.models;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import org.oguzhanozturk.kahvenevapanel.interfaces.AuthProcessListener;
import org.oguzhanozturk.kahvenevapanel.interfaces.FirestoreManagerInterface;
import org.oguzhanozturk.kahvenevapanel.constants.NetworkError;

public class FirestoreManager extends NetworkManager implements FirestoreManagerInterface {

    public FirestoreManager(Context context) {
        super(context);
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

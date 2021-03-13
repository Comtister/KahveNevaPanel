package org.oguzhanozturk.kahvenevapanel.models;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import org.oguzhanozturk.kahvenevapanel.interfaces.AuthProcessListener;
import org.oguzhanozturk.kahvenevapanel.interfaces.FirestoreManagerInterface;
import org.oguzhanozturk.kahvenevapanel.constants.NetworkError;

public class AuthManager extends NetworkManager {

    private FirestoreManagerInterface firestoreManagerInterface;

    public AuthManager(Context context) {
        super(context);
        this.firestoreManagerInterface = new FirestoreManager(context);
    }

    public void singIn(final String name , final String surname , final String mail , final String password , final AuthProcessListener authProcessListener) {

        final FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.i("Task","Başarılı");
                    Teller teller = new Teller(name,surname,mail,password);
                    firestoreManagerInterface.saveAccountFirestore(teller,authProcessListener);
                }else {
                    Log.i("problem oldu",task.getException().toString());
                    authProcessListener.onFailure(NetworkError.SignUp_Error);
                }
            }
        });



    }

    public void login(String mail , String password , final AuthProcessListener authProcessListener){

        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                authProcessListener.onSucces();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                authProcessListener.onFailure(NetworkError.Login_Error);
            }
        });


    }

}

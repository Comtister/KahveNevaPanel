package org.oguzhanozturk.kahvenevapanel.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import org.oguzhanozturk.kahvenevapanel.interfaces.AuthProcessListener;
import org.oguzhanozturk.kahvenevapanel.constants.NetworkError;
import org.oguzhanozturk.kahvenevapanel.models.AuthManager;
import org.oguzhanozturk.kahvenevapanel.views.SignUpView;

public class SignUpActivity  extends AppCompatActivity {

    private SignUpView ownView;

    private static final int signCode = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownView = new SignUpView(this,null);
        ownView.initViews();
        setContentView(ownView.getRootView());
        FirebaseApp.initializeApp(this);
    }


    public void kayitTamamla(String nameText , String surnameText , String password , String password2 , String mail , String code){

        if(nameText == "" || surnameText == "" || password == "" || password2 == "" || mail == "" || code == ""){
            ownView.showDataError();
            return;
        }

        if(!(password.equals(password2))) {
            ownView.showPassError();
            return;
        }

        if(!(Integer.valueOf(code) == signCode)){
            ownView.showCodeError();
            return;
        }



        AuthManager authManager = new AuthManager(this);

        authManager.singIn(nameText, surnameText, mail, password, new AuthProcessListener() {
            @Override
            public void onSucces() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(NetworkError error) {
                ownView.showAuthError();
            }
        });


    }

}

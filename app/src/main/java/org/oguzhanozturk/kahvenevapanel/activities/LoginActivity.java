package org.oguzhanozturk.kahvenevapanel.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.oguzhanozturk.kahvenevapanel.constants.NetworkError;
import org.oguzhanozturk.kahvenevapanel.interfaces.AuthProcessListener;
import org.oguzhanozturk.kahvenevapanel.models.AuthManager;
import org.oguzhanozturk.kahvenevapanel.views.LoginView;

public class LoginActivity extends AppCompatActivity {

    private LoginView ownView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownView = new LoginView(this,null);
        setContentView(ownView.getRootView());
        ownView.initViews();
    }

    public void gotoMainScreen(String mail , String password){

        AuthManager authManager = new AuthManager(this);
        authManager.login(mail, password, new AuthProcessListener() {
            @Override
            public void onSucces() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(NetworkError error) {
                ownView.showMailError();
            }
        });


    }

    public void gotoRegisterScreen(){

        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);

    }

}

package org.oguzhanozturk.kahvenevapanel.views;


import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import org.oguzhanozturk.kahvenevapanel.activities.LoginActivity;
import org.oguzhanozturk.kahvenevapanel.R;

public class LoginView {

    private View rootView;
    private LoginActivity viewController;

    private EditText mailText;
    private EditText passwordText;

    private Button kayitBtn;
    private Button girisBtn;


    public LoginView(Context context, ViewGroup viewGroup){

        rootView = LayoutInflater.from(context).inflate(R.layout.activity_login,viewGroup);
        viewController = (LoginActivity) context;

    }

    public void initViews(){

        kayitBtn = (Button)rootView.findViewById(R.id.kayitBtn);
        girisBtn = (Button)rootView.findViewById(R.id.girisBtn);
        mailText = (EditText)rootView.findViewById(R.id.editTextTextEmailAddress);
        passwordText = (EditText)rootView.findViewById(R.id.editTextTextPassword);

        girisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewController.gotoMainScreen(mailText.getText().toString() , passwordText.getText().toString());
            }
        });

        kayitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewController.gotoRegisterScreen();
            }
        });

    }


    public void showMailError(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(rootView.getContext());
        dialog.setTitle("Girilen bilgiler hatalı");
        dialog.setNeutralButton("Kapat",null);
        dialog.show();

    }

    public View getRootView() {
        return rootView;
    }
}

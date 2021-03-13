package org.oguzhanozturk.kahvenevapanel.views;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import org.oguzhanozturk.kahvenevapanel.R;
import org.oguzhanozturk.kahvenevapanel.activities.SignUpActivity;

public class SignUpView {

    private View rootView;
    private SignUpActivity signUpController;

    private EditText nameText;
    private EditText surnameText;
    private EditText mailText;
    private EditText passText;
    private EditText passText2;
    private EditText codeText;

    private Button kayitTamamlaBtn;

    public SignUpView(Context context, ViewGroup viewGroup){

        rootView = LayoutInflater.from(context).inflate(R.layout.activity_sign_up,viewGroup);
        signUpController = (SignUpActivity)context;

    }

    public void initViews(){

        nameText = (EditText)rootView.findViewById(R.id.nameText);
        surnameText = (EditText)rootView.findViewById(R.id.surnameText);
        mailText = (EditText)rootView.findViewById(R.id.mailText);
        passText = (EditText)rootView.findViewById(R.id.passText);
        passText2 = (EditText)rootView.findViewById(R.id.passText2);
        codeText = (EditText)rootView.findViewById(R.id.codeText);

        kayitTamamlaBtn = (Button)rootView.findViewById(R.id.kayitOlBtn);

        kayitTamamlaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpController.kayitTamamla(nameText.getText().toString(),surnameText.getText().toString(),passText.getText().toString() ,
                        passText2.getText().toString(),mailText.getText().toString(),codeText.getText().toString());
            }
        });

    }

    public void showPassError(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(rootView.getContext());
        dialog.setTitle("Hata şifreler eşleşmiyor");
        dialog.setNeutralButton("Kapat",null);
        dialog.show();

    }

    public void showCodeError(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(rootView.getContext());
        dialog.setTitle("Kayıt Kodu Yanlış");
        dialog.setNeutralButton("Kapat",null);
        dialog.show();

    }

    public void showDataError(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(rootView.getContext());
        dialog.setTitle("Tüm alanları doldurunuz");
        dialog.setNeutralButton("Kapat",null);
        dialog.show();

    }

    public void showAuthError(){

        AlertDialog.Builder dialog = new AlertDialog.Builder(rootView.getContext());
        dialog.setTitle("Bir problem oldu");
        dialog.setNeutralButton("Kapat",null);
        dialog.show();

    }

    public View getRootView() {
        return rootView;
    }
}

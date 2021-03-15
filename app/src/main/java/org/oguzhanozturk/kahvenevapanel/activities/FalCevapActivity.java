package org.oguzhanozturk.kahvenevapanel.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.oguzhanozturk.kahvenevapanel.views.FalCevapView;

public class FalCevapActivity extends AppCompatActivity {

    private FalCevapView ownView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownView = new FalCevapView(this,null);
        setContentView(ownView.getRootView());
        ownView.initView();
    }
}

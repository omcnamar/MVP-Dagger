package com.olegsagenadatrytwo.mvp_dagger.view.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.olegsagenadatrytwo.mvp_dagger.R;
import com.olegsagenadatrytwo.mvp_dagger.injection.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    public static final String TAG = "MainActivity";
    @Inject
    MainActivityPresenter presenter;

    private EditText etName;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainActivityComponent.create().inject(this);

        presenter.attachView(this);
        presenter.setContext(this);

        //bind views
        etName = (EditText) findViewById(R.id.etName);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    //on click for button
    public void doMagic(View view) {
        presenter.savePerson(etName.getText().toString());
    }

    public void getPerson(View view) {
        String name = presenter.getPerson();
        tvName.setText(name);
    }

    @Override
    public void showerror(String a) {

    }

    @Override
    public void isPersonSaved(boolean isSaved) {
        Log.d(TAG, "isPersonSaved: " + isSaved);
        if(isSaved){
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void sendPerson(String person) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.removeView();
    }
}

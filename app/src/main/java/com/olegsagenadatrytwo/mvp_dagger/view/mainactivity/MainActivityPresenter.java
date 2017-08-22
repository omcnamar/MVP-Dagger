package com.olegsagenadatrytwo.mvp_dagger.view.mainactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by omcna on 8/21/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    public static final String TAG = "MainActivityPresenter";
    private static final String MY_PREF_FILE = "personStorage";
    MainActivityContract.View view;
    private Context context;

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public void removeView() {
        this.view  = null;
    }

    @Override
    public void savePerson(String person) {

        Log.d(TAG, "savePerson: ");
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", person);

        boolean success = editor.commit();
        view.isPersonSaved(success);

    }

    @Override
    public String getPerson() {

        SharedPreferences sharedPreferences2 = context.getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        String person = sharedPreferences2.getString("name", "default name");
        return person;
    }
}

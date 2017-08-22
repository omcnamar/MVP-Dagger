package com.olegsagenadatrytwo.mvp_dagger.view.mainactivity;

import android.content.Context;

import com.olegsagenadatrytwo.mvp_dagger.BasePresenter;
import com.olegsagenadatrytwo.mvp_dagger.BaseView;

/**
 * Created by omcna on 8/21/2017.
 */

public interface MainActivityContract {

    interface View extends BaseView{

        void isPersonSaved(boolean isSaved);
        void sendPerson(String person);

    }

    interface Presenter extends BasePresenter<View>{

        void savePerson(String person);
        String getPerson();
        void setContext(Context context);
    }

}

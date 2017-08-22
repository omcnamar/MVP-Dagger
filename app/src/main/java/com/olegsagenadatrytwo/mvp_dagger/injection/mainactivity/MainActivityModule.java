package com.olegsagenadatrytwo.mvp_dagger.injection.mainactivity;

import com.olegsagenadatrytwo.mvp_dagger.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by omcna on 8/21/2017.
 */

@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }

}

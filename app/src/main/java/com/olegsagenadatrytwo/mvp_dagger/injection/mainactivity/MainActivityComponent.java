package com.olegsagenadatrytwo.mvp_dagger.injection.mainactivity;

import com.olegsagenadatrytwo.mvp_dagger.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by omcna on 8/21/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}

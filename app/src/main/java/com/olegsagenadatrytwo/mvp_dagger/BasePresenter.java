package com.olegsagenadatrytwo.mvp_dagger;

/**
 * Created by omcna on 8/21/2017.
 */

public interface BasePresenter<V extends BaseView>{

    void attachView(V view);
    void removeView();
}

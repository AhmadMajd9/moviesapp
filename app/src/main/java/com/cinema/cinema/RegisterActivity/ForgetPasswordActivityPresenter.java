package com.cinema.cinema.RegisterActivity;


public class ForgetPasswordActivityPresenter implements ForgetPasswordActivityPresenterInterface {
    private ForgetPasswordActivityViewInterface view;

    public ForgetPasswordActivityPresenter(ForgetPasswordActivityViewInterface view){
        this.view = view;
    }

    @Override
    public void forget(String email) {

    }
}
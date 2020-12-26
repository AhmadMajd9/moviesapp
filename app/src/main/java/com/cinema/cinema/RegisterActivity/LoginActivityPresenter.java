package com.cinema.cinema.RegisterActivity;


public class LoginActivityPresenter implements LoginActivityPresenterInterface {
    private LoginActivityViewInterface view;

    public LoginActivityPresenter(LoginActivityViewInterface view){
        this.view = view;
    }

    @Override
    public void login(String email, String password) {

    }
}

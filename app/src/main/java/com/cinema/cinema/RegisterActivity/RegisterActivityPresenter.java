package com.cinema.cinema.RegisterActivity;


public class RegisterActivityPresenter implements RegisterActivityPresenterInterface {
    private RegisterActivityViewInterface view;

    public RegisterActivityPresenter(RegisterActivityViewInterface view){
        this.view = view;
    }

    @Override
    public void createAccount(String email, String password, String name, String phone) {

    }
}
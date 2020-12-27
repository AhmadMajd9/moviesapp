package com.cinema.cinema;


public class MainActivityPresenter implements MainActivityPresenterInterface {
    private MainActivityViewInterface view;

    public MainActivityPresenter(MainActivityViewInterface view){
        this.view = view;
    }

    @Override
    public void getMoviesData() {

    }
}
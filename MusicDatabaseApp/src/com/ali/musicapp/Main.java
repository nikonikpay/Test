package com.ali.musicapp;

import model.DataSource;

public class Main {
    public static void main(String[] args) {


        DataSource dataSource  = new DataSource();

        dataSource.openConnection();

        if (dataSource.openConnection()) {
            System.out.println("The connection is successfully open");
        }
        dataSource.closeConnection();

    }
}

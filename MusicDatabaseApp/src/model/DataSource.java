package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private Connection connection;

    public static final String DB_NAME = "sound.db";
    public static final String CONNECTION_NAME = "jdbc:sqlite:/Users/ugalaxiacompany/Downloads/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";


    public static final String TABLE_ARTISTS = "artist";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";


    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";


    public boolean openConnection(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(CONNECTION_NAME);
            return true;
        }catch (SQLException | ClassNotFoundException e){

            System.out.println("Something went wrong in connection"+ e.getMessage());

            return false;

        }
    }

    public void closeConnection(){
        try{
            if (connection != null) {
                connection.close();
            }
        }catch (SQLException e) {
            System.out.println("Something is wrong with closing connection"+e.getMessage());
        }
    }



}

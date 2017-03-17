/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Movie;
import model.User;
import view.Home;
import java.util.ArrayList;


/**
 *
 * @author Sisi R
 */
public class MainController {
    public Home myhome;
    public DatabaseConnector dbc;
    
    public MainController(){
         /* Create and display the form */
        myhome = new Home(this);
        dbc = new DatabaseConnector();
        //getMovies();
        myhome .setVisible(true);
}
    
   
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainController myController = new MainController();
            }
        });

          //testing only
         //MainController mc = new MainController();  
                
    }
    
    public ArrayList<Movie> getMovies(){
        String[] ids = dbc.findMovieId("today").split(" ");
        ArrayList<Movie> movies = new ArrayList<>();
        for (String id: ids){
            Movie m = dbc.findMovie(id);
            if (m != null){};
        }
        return null;
    }
    
    public String login(String text, char[] pwd) {
        String password = new String(pwd);
        User user;
        try{
            user = dbc.findUser(text);
            if(user.getPassword().equals(password))
            {
                System.out.print("User" +user.getPassword()+" " + user.getName());
                return user.getName();}
            else
                //wrong pwd
                return "1";
        }
        catch(Exception ex)
        {
            //invalid account
            return "0";
        }
        }
    
    public void updateMovie(String description, String director, String language, String starring){
        //implementation
    }
            
}

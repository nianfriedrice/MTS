/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import model.Movie;
import model.User;
import view.Home;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.Schedule;
import view.IndexPanel;


/**
 *
 * @author Sisi R
 */
public class MainController {
    public Home myhome;
    public DatabaseConnector dbc;
    HashMap<String, ImageIcon> imgs = new HashMap<>();
    int width  = 195;
    int height = 260;
    
     public MainController(){
         /* Create and display the form */
         //System.out.println("Constructing MainController");
        dbc = new DatabaseConnector();
        getMovies();
        myhome = new Home(this);
        myhome .setVisible(true);
}
    public ImageIcon getImageIcon(String url){
        if (imgs.containsKey(url))
            return imgs.get(url);

        BufferedImage img = null;
        try {
            System.out.println("Loading img from: " + url);
            img = ImageIO.read(new URL(url));           
         } catch (Exception ex) {
            Logger.getLogger(IndexPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (img == null){
            //add default image           
        }
        Image image = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image);
        imgs.put(url, icon);
        return icon;
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
    
    //testing only
    private ArrayList<Movie> testMovies;
    
    public void getMovies(){
        testMovies =  dbc.findAllMovie();
    }
    
    public List<Movie> getOnShow(){
        return testMovies.subList(0, 3);
    }
    
    public List<Movie> getUpcoming(){
        testMovies.get(0).setImageUrl("https://img1.od-cdn.com/ImageType-400/2508-1/41D/577/75/%7B41D57775-571B-4EFB-8253-11C536575CC3%7DImg400.jpg");
        testMovies.get(1).setImageUrl("http://moviemaza24.com/wp-content/uploads/2017/03/G7F3619-300x400.jpg");
        testMovies.get(2).setImageUrl("https://img1.od-cdn.com/ImageType-400/2508-1/41D/577/75/%7B41D57775-571B-4EFB-8253-11C536575CC3%7DImg400.jpg");
        return testMovies.subList(0, 0 + 3);
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
    
    public List<Schedule> findSchedulesByDate (String Date)
    {
        return dbc.findSchedulesByDate(Date);
    }
            
}

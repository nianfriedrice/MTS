/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Movie;
import model.User;
import view.Home;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Cinema;
import model.Schedule;
import model.Ticket;
import view.IndexPanel;


/**
 *
 * @author Sisi R
 */
public class MainController {
    public Home myhome;
    public DatabaseConnector dbc;
    private List<Movie> onShowMovies;
    private List<Movie> upComingMovies;
    HashMap<String, ImageIcon> imgs = new HashMap<>();
    HashMap<Integer, String> houseCinema = new HashMap<>(); //map houseID cinemaName
    HashMap<Integer, Movie> movieMap = new HashMap<>(); //movieID to Movie
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
     
     public void findMovie(String name){
         Movie found = null;
         for(Movie m:this.onShowMovies){
             if (name.equals(m.getName())){
                 found = m;
                 break;
             }
         }
         for(Movie m: this.upComingMovies){
             if (name.equals(m.getName())){
                 found = m;
                 break;
             }
         }
         myhome.goToMovie(found);
     }
    public ImageIcon getImageIcon(String url){
        if (imgs.containsKey(url))
            return imgs.get(url);
        ImageIcon icon = null;
        BufferedImage img = null;
        try {
            System.out.println("Loading img from: " + url);
            img = ImageIO.read(new URL(url));       
            Image image = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
             icon = new ImageIcon(image);
         } catch (Exception ex) {
            Logger.getLogger(IndexPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (icon == null){
            icon = new ImageIcon(getClass().getResource("/view/movie_default.png"));
            //add default image           
        }
        imgs.put(url, icon);
        return icon;
    }
   public void updateTicketTable(Ticket ticket){
            dbc.createTicket(ticket);
    }
    public String getCinemaName(int houseID){
        if (houseCinema.containsKey(houseID))
            return houseCinema.get(houseID);
        String cinema = dbc.findCinema(houseID).getName();
        System.out.println(houseID + " " + cinema);
        houseCinema.put(houseID, cinema);
        return cinema;
    }
    
    public DatabaseConnector getDBC(){
        return dbc;
    }    
    public String[] getCinema(String[] houseID){
        String[] cinemaName = new String[houseID.length];
        return cinemaName;
    }
       public Movie getMovies(int mid){
        Movie target = null;
        if (movieMap.containsKey(mid))
            return movieMap.get(mid);
        ArrayList<Movie> allM = dbc.findAllMovie();
        for(Movie m: allM){
            if (m.getMovieId() == mid){
                movieMap.put(mid, m);
                target = m;
                break;
            }
        }
        return target;
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
    
      
    public void getMovies(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
//        System.out.println("Today: " + dateFormat.format(today));
        List<Movie> allMovies =  dbc.findFutureMovie(dateFormat.format(today));
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        onShowMovies = new ArrayList<>();
        upComingMovies = new ArrayList<>();
        for (Movie m: allMovies){
//            System.out.println(m.getReleaseDate());
            try {
                Date date = dateFormat.parse(m.getReleaseDate());
                if (date.before(today)){
                    onShowMovies.add(m);
                }
                else {
                    upComingMovies.add(m);
                }
            } catch (ParseException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        System.out.println(onShowMovies.size());
//        System.out.println(upComingMovies.size());
    }
    
    public List<Movie> getAllOnShow(){
        return onShowMovies;
    }
    public List<Movie> getAllUpcoming(){
        return upComingMovies;
    }
    
    public List<Movie> getOnShow(){
        return onShowMovies.subList(0, 3);
    }
    
    public List<Movie> getUpcoming(){
        return upComingMovies.subList(0, 3);
    }
    
        public String covertContent(String s, FontMetrics fontMetrics, int w){
        //StringBuilder builder = new StringBuilder("<html>");
        String result = "<html>";
        char[] chars = s.toCharArray();
        for (int i = 0, j = 1;; j++) {
            if (fontMetrics.charsWidth(chars, i, j) < w-5) {
                if (i + j < chars.length) continue;
                result += s.subSequence(i, i+j);
                break;
            }
            result += s.substring(i, i+ j -1) + "<br/>";
            i = j - 1;
            j = 1;
        }
        result += "</html>";
        return result;
    }
        
    public void resizeFont(JLabel label, int width, int height){
        Font labelFont = label.getFont();
        String labelText = label.getText();
        int stringWidth = label.getFontMetrics(labelFont).stringWidth(labelText);
         int componentWidth;
         int componentHeight;
        if (width == -1){
            componentWidth = label.getWidth();
        } else {
            componentWidth = width;
        }
        if (height == -1){
            componentHeight = label.getHeight();
        } else {
            componentHeight = height;
        }
        
        // Find out how much the font can grow in width.
        double widthRatio = (double)componentWidth / (double)stringWidth;
        if (widthRatio < 1){
            int newFontSize = (int)(labelFont.getSize() * widthRatio);
            
            // Pick a new font size so it will not be larger than the height of label.
            int fontSizeToUse = Math.min(newFontSize, componentHeight);
            // Set the label's font size to the newly determined size.
            label.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
        }
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
    
    public void updateMovie(String name, String imageUrl, String description, String language, boolean if3D, int length, String category, String director, String starring, String releaseDate, String offDate, float score){
        //implementation
        
        //dbc.updateMovie(name, imageUrl, description, language, false, length, category, director, starring, releaseDate, offDate, score);
    }
    
    public List<Schedule> findSchedulesByDate (String Date)
    {
        return dbc.findSchedules(Date);
    }
    
    public void createSchedule (Schedule s)
    {
         dbc.createSchedule(s);
    }
    
    public void updateSchedule (Schedule s)
    {
        System.out.println("MovieName: " + s.getMovieName() +" StartTime: " + s.getStartTime() + " houseName: " + s.getHouseName()); 
        dbc.updateSchedule(s);
    }
    
    public void deleteSchedule (String movieName, boolean if3D, String startTime)
    {
        System.out.println(movieName +" "+ if3D +" " +startTime);
        dbc.deleteSchedule(movieName,if3D,startTime);
    }
        
    
    public void getBookingRecord(int userId){
        ArrayList<Ticket> tickets = dbc.findAllTicket();
        for(Ticket t:tickets)
        {
            if(t.getUserId() == userId)
            {
            }
        }
    }
    
    public void createCinema(Cinema c)
    {
        dbc.createCinema(c);
    }
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import model.Movie;
import model.Schedule;
import view.Home;

/**
 *
 * @author LRX
 */
public class MovieFilter extends JPanel{
    ArrayList<Schedule> schedules;
    List<Movie> movies;
    MainController mc;
    Home home;
    JComboBox cinemaBox;
    JComboBox dateBox;
    JComboBox versionBox;
    ActionListener boxActionListener;
    JPanel movieDisplay;
    Font font = new java.awt.Font("Segoe UI", 1, 14);
    Color backC = new Color(255,240,255);
    Color foreC = new Color(241,104,122);
    int panelX = 10;
    int panelY = 50;
    int width  = 195;
    int height = 260;
        
    public MovieFilter(){
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        schedules = new ArrayList<>();
        movies = new ArrayList<>();
        cinemaBox = new JComboBox();
        cinemaBox.addItem("Cinema");
        dateBox = new JComboBox();
        dateBox.addItem("Date");
        versionBox =  new JComboBox();
        versionBox.addItem("Version");
        cinemaBox.setFont(font);
        dateBox.setFont(font);
        versionBox.setFont(font);
        cinemaBox.setBounds(10, 10, 200, 20);
        dateBox.setBounds(250, 10, 100, 20);        
        versionBox.setBounds(400, 10, 100, 20);
        cinemaBox.setBackground(backC);
        dateBox.setBackground(backC);
        versionBox.setBackground(backC);
        cinemaBox.setForeground(foreC);
        dateBox.setForeground(foreC);
        versionBox.setForeground(foreC);
        
        movieDisplay = new JPanel();
        movieDisplay.setBackground(backC);
        movieDisplay.setLayout(null);

        JScrollPane pane = new JScrollPane(movieDisplay); 
        pane.setBounds(10, 50, 700, 600);
        
        
//        this.add(cinemaBox);
//        this.add(dateBox);
//        this.add(versionBox);
//        this.add(pane,BorderLayout.CENTER);
        movieDisplay = this;
        
        boxActionListener  = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                filter((String) cinemaBox.getSelectedItem(), (String) dateBox.getSelectedItem(), (String) versionBox.getSelectedItem());
                movieDisplay.revalidate();
                movieDisplay.repaint();
            }
        };
        cinemaBox.addActionListener(boxActionListener);
        dateBox.addActionListener(boxActionListener);
        versionBox.addActionListener(boxActionListener);
    }
    
    private void filter(String cin, String date, String ver){
        ArrayList<Schedule> sch = schedules;
        //filter schedules
        
        //update movie list
        updateMovies(sch);
    }
    
    private void updateMovies(ArrayList<Schedule> source){
        Set midList = new HashSet();
        for (Schedule s: source)
            midList.add(s.getMovieId());
        movies.clear();
         for (Iterator iter = midList.iterator(); iter.hasNext();) {
             int mid = (int) iter.next();
             movies.add(mc.getMovies(mid));
         }
    }
    
    public void setMC(MainController myMC){
        mc = myMC;
    }
    public void setHome(Home h){
        home = h;
    }
    public void setSchedules(ArrayList<Schedule> sch){
        schedules = sch;
    }
    
    public void setMovies(List<Movie> ms){
        movies = ms;
        this.repaint();
    }
    
    private void drawOneMovie(Movie m, int x, int y){
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(mc.getImageIcon(m.getImageUrl())); 
        imgLabel.setBounds(x, y, width, height);
                imgLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home.goToMovie(m);
            }
        });
        movieDisplay.add(imgLabel);
    }
    
    private void drawMovie(){
        int margin = 10;
        int startX = margin;
        int startY = margin;
        int row = 0;
        int col = 0;
        for (Movie m: movies){
            drawOneMovie(m, startX + (width + margin) * col, startY + (height + margin) * row);
            col++;
            if (col == 3){
                row++;
                col = 0;
            }
        }
    }
  
    @Override
    public void paintComponent(Graphics g){
        if (!movies.isEmpty()){
            drawMovie();
        }
    }
}

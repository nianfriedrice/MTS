/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import model.Movie;

/**
 *
 * @author LRX
 */
public class moviePanel extends JPanel{
    MainController mc;
    Home home;
    List<Movie> movies;
    int row = 0;
    int x =0;
    int y = 50;
    int margin = 20;
    public moviePanel(){}
    
    public void setMovies(List<Movie> m){
        movies = m;
        row = m.size() / 3;
    }
    public void setMC(MainController myMC){
        mc = myMC;
    }
    
    public void setHome(Home h){
        home = h;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        for (int i = 0; i < row; i++){
            IndexPanel panel = new IndexPanel();
            panel.setHome(home);
            int start = i*3;
            int end = (i+1) * 3;
            if (end > movies.size())
                end = movies.size();
            panel.setMovies(movies.subList(start, end));
            this.add(panel);
        }
    }
    
}

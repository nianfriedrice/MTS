/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.MainController;
import java.awt.Color;
import java.awt.Event;
import java.awt.FontMetrics;
import javax.swing.OverlayLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.util.List;
import model.Movie;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author LRX
 */
public class IndexPanel extends JPanel{
    Home home = null;
    MainController mc = null;
    List<Movie> movies;
    int width  = 195;
    int height = 260;
    int margin = 32;
    int x = margin;
    int y = 0;
    HashMap<String, ImageIcon> imgs;

        
    public IndexPanel(){
        super();
        this.setLayout(new javax.swing.OverlayLayout(this));
        this.setBackground(new Color(255, 255,255));
    } 
    
    public void setHome(Home h){
        home = h;
    }
    
    public void setMovies(List<Movie> m){
        movies = m;
    }
    
    public void setMainController(MainController myMC){
        mc = myMC;
    }
        
    //teting only
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);  
        for(int i = 0; i < movies.size(); i++)
            drawMovie(movies.get(i), x +width * i + i* margin, y);
    }
    
    private JPanel createCover(Movie m){
        JPanel cover = new JPanel();
        Color myColour = new Color(0,0,0, 100);
        cover.setBackground(myColour);
        cover.setVisible(false);

        //create movie info        
        JLabel title = new JLabel();
        title.setFont(new java.awt.Font("Segoe UI", 0, 20)); 
        title.setForeground(Color.WHITE);
        title.setText(m.getName());
//        title.setText(mc.covertContent(m.getName(), title.getFontMetrics(title.getFont())), width);
        mc.resizeFont(title, width-5, 50);
        //add component
        cover.add(title);   
        return cover;
    }
    
    private JLabel createScore(Movie m, int curX, int curY){
        JLabel score = new JLabel(String.format("%.2f/5.0", m.getScore()));
        score.setFont(new java.awt.Font("Segoe UI", 0, 15));
        score.setForeground(Color.WHITE);
        score.setBounds(curX+ width - 60 , curY+height-50, 60, 70);
        return score;
    }
        
    //png
    private void drawMovie(Movie m, int curX, int curY){
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(mc.getImageIcon(m.getImageUrl())); 
        imgLabel.setBounds(curX, curY, width, height);
        JPanel cover = createCover(m);
        cover.setBounds(curX, curY, width, height);
//        imgLabel.setVisible(false);
        this.add(createScore(m, curX, curY));
        this.add(cover);
        this.add(imgLabel);

        imgLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home.goToMovie(m);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                //System.out.println("Detect mouse enter!!");
                cover.setVisible(true);
                cover.revalidate();
                cover.repaint();
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //System.out.println("Detect mouse exit!!");
                cover.setVisible(false);
                cover.revalidate();
                cover.repaint();
            }
        });
        
    }
   
    
}

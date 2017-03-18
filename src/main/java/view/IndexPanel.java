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
<<<<<<< HEAD
    MainController mc = null;
=======
>>>>>>> refs/remotes/origin/rachel
    List<Movie> movies;
    int width  = 195;
    int height = 260;
    int margin = 32;
    int x = margin;
    int y = 0;
<<<<<<< HEAD
    HashMap<String, ImageIcon> imgs;
=======
    HashMap<String, ImageIcon> imgs = new HashMap<>();
>>>>>>> refs/remotes/origin/rachel

        
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
    
<<<<<<< HEAD
    public void setMainController(MainController myMC){
        mc = myMC;
    }
        
=======
    private ImageIcon getImageIcon(String url){
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
    
>>>>>>> refs/remotes/origin/rachel
    //teting only
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);  
        for(int i = 0; i < movies.size(); i++)
            testDrawMovie(movies.get(i), x +width * i + i* margin, y);
    }
    
    private JPanel createCover(Movie m){
        JPanel cover = new JPanel();
        Color myColour = new Color(0,0,0, 100);
        cover.setBackground(myColour);
        cover.setVisible(false);

        //create movie info        
        JLabel title = new JLabel();
        title.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        title.setForeground(Color.WHITE);
        title.setText(covertContent(m.getName(), title.getFontMetrics(title.getFont())));
        //add component
        cover.add(title);   
        return cover;
    }
    
    private String covertContent(String s, FontMetrics fontMetrics){
        StringBuilder builder = new StringBuilder("<html>");
        char[] chars = s.toCharArray();
        for (int i = 0, j = 1;; j++) {
            if (fontMetrics.charsWidth(chars, i, j) < width-5) {
                if (i + j < chars.length) continue;
                builder.append(chars, i, j);
                break;
            }
            builder.append(chars, i, j - 1).append("<br/>");
            i = j - 1;
            j = 1;
        }
        builder.append("</html>");
        return builder.toString();   
    }
    
    //png
    private void testDrawMovie(Movie m, int curX, int curY){
        JLabel imgLabel = new JLabel();
<<<<<<< HEAD
        imgLabel.setIcon(mc.getImageIcon(m.getImageUrl())); 
=======
        imgLabel.setIcon(getImageIcon(m.getImageUrl())); 
>>>>>>> refs/remotes/origin/rachel
        imgLabel.setBounds(curX, curY, width, height);
        JPanel cover = createCover(m);
        cover.setBounds(curX, curY, width, height);
              
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
    
    
    //jpg
    private void drawMovie(Graphics g, Movie m, int curX, int curY){
        Image image = null;
        try {
            String url = m.getImageUrl();
            System.out.println(url);
            image = Toolkit.getDefaultToolkit().createImage(new URL(url));
            //image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            g.drawImage(image, curX, curY, this);
         } catch (Exception ex) {
            Logger.getLogger(IndexPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (image == null){
            //add default image           
        }
    }
    
}

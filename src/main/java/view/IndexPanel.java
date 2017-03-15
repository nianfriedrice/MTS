/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.util.ArrayList;
import model.Movie;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author LRX
 */
public class IndexPanel extends JPanel{
    Home home = null;
    int width  = 195;
    int height = 260;
    int x = 23;
    int y = 0;
        
    public IndexPanel(Home myHome ){
        super();
        home = myHome;
        this.setBackground(new Color(255, 255,255));
    } 
    
    //teting only
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage image = null;
        try {
            image = ImageIO.read(new URL("http://101.78.175.101:3380/img/mountain.jpg"));
         } catch (Exception ex) {
            Logger.getLogger(IndexPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (image == null){
            //add default image
            
        }
        Image img = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        g.drawImage(img, x, y, this);
    }
    
}

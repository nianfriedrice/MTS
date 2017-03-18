/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DatabaseConnector;
import controller.MainController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Schedule;

/**
 *
 * @author LRX
 */
public class SeatPlan extends JPanel{
    MainController mc;
    int width;
    int height;
    int margin = 5;
    int box;
    int seatPanelWidth;
    String seatPlan = "";
    JPanel screenPanel;
    JLabel screenLabel;
    Schedule schedule;
    Boolean mode; //True: editable; Flase: uneditable;
    //Color setting
    Color backC = new Color(255,240,255);
    Color foreC = new Color(241,104,122);
    Color soldC = new Color(244, 66, 66);
    Color selectedC = new Color(61, 39, 104);
    Color availableC = new Color(86, 86, 86);
    Color wheelC = new Color(0,255,0);
    
    public SeatPlan(){
    }
    
    public void setMC(MainController myMC){
        mc = myMC;
    }
    
    public void setSize(int w, int h, int b){
        width = w;
        height = h;
        box = b;
        seatPanelWidth = (int) (w * 0.8);
    }
    
    public void setSeatPlan(String plan){
        seatPlan = plan;
    }
    
    public void setSchedule(Schedule sch){
        schedule = sch;
    }
    
    public void setMode(Boolean m){
        mode = m;
    }
    
    private void setLabel(JLabel label){
         Font labelFont = new java.awt.Font("Segoe UI", 1, 14);
         label.setFont(labelFont);
         label.setForeground(Color.BLACK);
    }
    
    private void drawLabels(Graphics2D g){
        this.setBackground(backC);
        g.setColor(foreC);
        g.fillRect(margin, margin, seatPanelWidth-margin, 20);
        JLabel screen = new JLabel("SCREEN");
        screen.setHorizontalAlignment(SwingConstants.CENTER);
        screen.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        screen.setForeground(Color.BLACK);
        screen.setBounds(margin+(seatPanelWidth-80)/2, margin, 80, 20);
        this.add(screen);
        
        g.setColor(this.availableC);
        g.fillRect(seatPanelWidth + margin *2, height - box * 10, box, box);
        JLabel available = new JLabel("available");
        available.setBounds(seatPanelWidth + margin *3 + box , height - box * 10 - margin, 80, 20);
        setLabel(available);
        this.add(available);
        
        g.setColor(this.soldC);
        g.fillRect(seatPanelWidth + margin *2, height - box * 8, box, box);
        JLabel sold = new JLabel("sold");
        sold.setBounds(seatPanelWidth + margin *3 + box , height - box * 8 - margin, 80, 20);
        setLabel(sold);
        this.add(sold);
        
        g.setColor(this.selectedC);
        g.fillRect(seatPanelWidth + margin *2, height - box * 6, box, box);
        JLabel selected = new JLabel("selected");
        selected.setBounds(seatPanelWidth + margin *3 + box , height - box * 6 - margin, 80, 20);
        setLabel(selected);
        this.add(selected);
        
        g.setColor(this.wheelC);
        g.fillRect(seatPanelWidth + margin *2, height - box * 4, box, box);
        JLabel wheelChair = new JLabel("wheel chair");
        wheelChair.setBounds(seatPanelWidth + margin *3 + box , height - box * 4 - margin, 80, 20);
        setLabel(wheelChair);
        this.add(wheelChair);
                
    }
    
    private void drawSeats(Graphics2D g){
        DatabaseConnector dbc = mc.getDBC();
        String seatPlan = dbc.findHouse(schedule.getHouseId()).getSeatPlan();
//        System.out.println(seatPlan);
        int row = 0;
        int col = 0;
        int seatNum = 1;
        String[] rows = seatPlan.split("\n");
        for (int i = 0; i < rows.length; i++){
            System.out.println(rows[i]);
        }
    }
    
    private Boolean checkSetting(){
//        if (width <= 0 || height <= 0 || seatPlan.equals(""))
//            return false;
        return true;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); 
        if (checkSetting()){
            Graphics2D g2d = (Graphics2D) g;
            drawLabels(g2d);
            drawSeats(g2d);
        }
    }
}

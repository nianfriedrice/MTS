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
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.Schedule;
import model.Ticket;

/**
 *
 * @author LRX
 */
public class SeatPlan extends JPanel{
    MainController mc;
    Home home;
    DatabaseConnector dbc = null;
    int width;
    int height;
    int margin = 5;
    int box;
    int seatPanelWidth;
    String seatPlan = "";
    JPanel screenPanel;
    JLabel screenLabel;
    Schedule schedule;
   ArrayList<Ticket> tickets = null;
   ArrayList<Seat> seats = null;
   ArrayList<Seat> selectedSeats = null;
    Boolean mode; //True: editable; Flase: uneditable;
    //Color setting
    Color backC = new Color(255,240,255);
    Color foreC = new Color(241,104,122);
    Color soldC = new Color(86, 86, 86);
    Color selectedC = new Color(0, 255, 0);
    Color availableC = new Color(244, 66, 66);
    Color wheelC = new Color(255,255,0);
    
    JButton submit = null;
    
    
    public SeatPlan(){
        seats = new ArrayList<>();
        selectedSeats = new ArrayList<>();
        submit = new JButton("SUBMIT");
        submit.setForeground(foreC);
        submit.setFont(new java.awt.Font("Segoe UI", 0, 14));
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    String msg = "Do you confirm to buy the following tickets:\n";
                    for (Seat s: selectedSeats)
                        msg += " " + s.seatID;
                    int reply =  JOptionPane.showConfirmDialog(null, msg, "Confirm Booking", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        buy();
                        selectedSeats.clear();
                    }
                    else {
                        selectedSeats.clear();
                    }
                    updateTickets();
                    updatePanel();
                }
            });
        submit.setVisible(false);
        this.setLayout(null);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                   Point p = evt.getPoint();
//                   System.out.println("Mouse Clicked!!!");
                   selectSeat(p);
                }
            });
    }
    
    private void updatePanel(){
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
    
    private void buy(){
        //call MC to buy
        ArrayList<String> idList = new ArrayList<>();
        for (Seat s: selectedSeats)
            idList.add(s.seatID);
        home.addTickets(schedule, idList);
    }
    
    public void setHome(Home h){
        home = h;
    }
    
    public void setMC(MainController myMC){
        mc = myMC;
    }
    
    public void setSize(int w, int h, int b){
        width = w;
        height = h;
        box = b;
        seatPanelWidth = (int) (w * 0.8);
        submit.setBounds(w - 150 - margin, h - 80 - margin, 100, 30);
        this.repaint();
    }
    
    public void updateTickets(){
        tickets = dbc.findAllTicket();
    }
    
    public void updateSeatPlan(){
        seatPlan = dbc.findHouse(schedule.getHouseId()).getSeatPlan();
    }
    
    public void setSchedule(Schedule sch){
        if (dbc == null) {
            dbc = mc.getDBC();
        }
        schedule = sch;
        updateSeatPlan();
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
        g.fillRect(seatPanelWidth + margin *2, margin + box *2, box, box);
        JLabel available = new JLabel("available");
        available.setBounds(seatPanelWidth + margin *3 + box , margin+box +3, 80, 20);
        setLabel(available);
        this.add(available);
        
        g.setColor(this.soldC);
        g.fillRect(seatPanelWidth + margin *2, margin + box * 4, box, box);
        JLabel sold = new JLabel("sold");
        sold.setBounds(seatPanelWidth + margin *3 + box , margin + box * 3 +3, 80, 20);
        setLabel(sold);
        this.add(sold);
        
        g.setColor(this.selectedC);
        g.fillRect(seatPanelWidth + margin *2, margin + box * 6, box, box);
        JLabel selected = new JLabel("selected");
        selected.setBounds(seatPanelWidth + margin *3 + box , margin + box * 5 +3, 80, 20);
        setLabel(selected);
        this.add(selected);
        
        g.setColor(this.wheelC);
        g.fillRect(seatPanelWidth + margin *2,margin + box * 8, box, box);
        JLabel wheelChair = new JLabel("wheel chair");
        wheelChair.setBounds(seatPanelWidth + margin *3 + box , margin + box * 7 +3 , 80, 20);
        setLabel(wheelChair);
        this.add(wheelChair);
                
    }
    
    private void drawRect(Graphics2D g, Color c, int x, int y){
        g.setColor(c);
        g.fillRect(x, y, box, box);
    }
    
    private Boolean hasSold(String row, int col){
        if (dbc == null) {
            dbc = mc.getDBC();
        }
        if (tickets == null)
            tickets = dbc.findAllTicket();
        for (Ticket t: tickets){
            if (t.getScheduleId() == schedule.getScheduleId() && t.getSeatRow().equals(row) && t.getSeatColumn() == col)
                return true;
        }
        return false;
    }
    
    private Boolean isSelected(String seatID){
        for (Seat s: selectedSeats){
            if (s.seatID.equals(seatID)) {
                if (home.getLogin()){
                    submit.setVisible(true);
                    return true;
                } 
            }
        }
        return false;
    }
    
    private void drawSeats(Graphics2D g){
        if (dbc == null) {
            dbc = mc.getDBC();
        }
//        System.out.println(seatPlan);
        String[] rows = seatPlan.split("\n");
        int startX = 5;
        int startY = 30;
        seats.clear();
//        System.out.println("Before: Seats length" + seats.size());
        for (int i = 0; i < rows.length; i++){
            String line = rows[i].trim();
//            System.out.println(line);
            String head = line.substring(0, 1);
            if (!head.equals("/")){
                drawLineHead(head, startX, startY+ i * (box+margin));
                int col = 1;
                int seatNum = 1;
                while (col < line.length()){
                    char c = line.charAt(col);
                    int x = startX+ (box+margin)* (col+1);
                    int y = startY+ i * (box+margin);
                    if (c != '0' && isSelected(head+seatNum)){
                        drawRect(g, selectedC, x, y);
                    } else {
                        switch(c){
                            case '0':
                                break;
                            case '1':
                                if (hasSold(head, seatNum)){
                                    drawRect(g, soldC, x, y);
                                } else {
                                    drawRect(g,availableC , x, y); 
                                }
                                break;
                            case '2':
                                if (hasSold(head, seatNum)){
                                    drawRect(g, soldC, x, y);
                                } else {
                                    drawRect(g,wheelC , x, y);
                                }
                                break;
                        }
                    }
                    g.setFont(new java.awt.Font("Segoe UI", 1, 10));
                    if (c != '0'){
                        if (c == '2')
                            g.setColor(Color.BLACK);
                        else 
                            g.setColor(Color.WHITE);
                        if (seatNum < 10)
                            g.drawString(String.valueOf(seatNum), x+margin /2, y+margin + 3);
                        else
                            g.drawString(String.valueOf(seatNum), x - 2, y+margin + 3);
                            seats.add(new Seat(head+seatNum, x, y));
                            seatNum++;
//drawLabel(seatNum, startX+ (box+margin)* (col+1), startY+ i * (box+margin));
                    }
                    col++;
                }
            }
        }
//                System.out.println("After: Seats length" + seats.size());
    }
    
    private void drawLineHead(String c, int x, int y){
        JLabel head = new JLabel(c);
        Font labelFont = new java.awt.Font("Segoe UI", 1, 10);
        head.setFont(labelFont);
        head.setForeground(Color.BLACK);
        head.setBounds(x, y, box, box);
        this.add(head);
    }
    
    private Boolean checkSetting(){
        if (width <= 0 || height <= 0 || schedule == null)
            return false;
        return true;
    }
    
//    private Boolean isInBox(Seat s, Point p){
//        double sX = s.position.getX();
//        double sY = s.position.getY();
//        double pX = p.getX();
//        double pY = p.getY();
//        if (pX < sX || pX > sX + box)
//            return false;
//        if (pY < sY || pY > sY + box)
//            return false;
//        return true;
//    }
        
    private void selectSeat(Point2D p){
        for (Seat s: seats){
            if (s.position.distance(p) <= box / 2 ){
                System.out.println("Found seat" + s.seatID);
                System.out.println("Seatedseats:" + selectedSeats.size());
                Boolean isContain = false;
                for (Seat ss: selectedSeats)
                    if (ss.seatID.equals(s.seatID)){
                        isContain = true;
                        selectedSeats.remove(ss);
                        if (selectedSeats.isEmpty())
                            submit.setVisible(false);
                        break;
                    }
                if (!isContain)
                    if (home.getLogin()){
                           selectedSeats.add(s);
                           submit.setVisible(true);
                       } else {
                           JOptionPane.showMessageDialog(null,  "Please log in to book tickets!", "LOGIN REQUIRED",  JOptionPane.WARNING_MESSAGE);
                       }
                break;
                }
        }
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); 
        if (checkSetting()){
            this.add(submit);
            Graphics2D g2d = (Graphics2D) g;
            drawLabels(g2d);
            drawSeats(g2d);
        }
    }
    
    class Seat{
        Point2D position;
        String seatID;
        Seat(String id, int xPosition, int yPosition){
            seatID = id;
            position = (Point2D) new Point(xPosition + box / 2, yPosition + box /2);
        }
    }
}

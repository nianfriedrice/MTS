/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DatabaseConnector;
import controller.MainController;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Movie;
import model.Schedule;
import model.User;

/**
 *
 * @author Sisi R
 */
public class Home extends javax.swing.JFrame {
    MainController mc;
    public boolean permission = false;
    private boolean isLogin = false;
    int testingMode = 1;
    ArrayList<Schedule> sch3d = new ArrayList<>();
    ArrayList<Schedule> sch2d = new ArrayList<>();
    DatabaseConnector dbc = mc.getDBC();
    /**
     * Creates new form Home
     */
    public Home(MainController mc) {
        this.mc = mc;
        setMon();
        initComponents();
        this.setResizable(false);
        groupButton();
    }
    
    private void setMon(){
        String[] monName = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL","AUG", "SEP", "OCT", "NOV", "DEC"};
        Date date = new Date();
        Calendar cal=  Calendar.getInstance();
        cal.setTime(date);
        year = cal.get(Calendar.YEAR);
        int curM = cal.get(Calendar.MONTH);
        firMon = monName[curM-1];
        secMon = monName[curM];
        thrMon = monName[curM +2];
    }
    
    private ArrayList<model.Movie> getMovies(){
        return null;
    }
          
    protected void updateDetail(Movie m){
        movieName.setText(m.getName());
        score.setText(String.format("%.2f", m.getScore()));
//        System.out.println("Score: "+ score.getText());
        mc.resizeFont(movieName,-1,-1);
//        System.out.println(m.getDescription());
        description.setText(m.getDescription());
        director.setText(m.getDirector());
        language.setText(m.getLanguage());
        starring.setText(m.getStarring());
        image.setIcon(mc.getImageIcon(m.getImageUrl()));
//        System.out.println(m.getCategory());
        type.setText(m.getCategory());
        time.setText(String.valueOf(m.getLength()) + "min");
        releaseDate.setText(m.getReleaseDate());
        
        schedulePanel.removeAll();
        schedulePanel.revalidate();
        schedulePanel.repaint();
        sch3d.clear();
        sch2d.clear();
        
        //clear comboBox
        dateComboBox.removeAllItems();
        cinemaComboBox.removeAllItems();
        versionComboBox.removeAllItems();
        dateComboBox.addItem("Date");
        cinemaComboBox.addItem("Cinema");
        versionComboBox.addItem("Version");
        
        sch3d = dbc.findSchedules(m.getName(), true);
        if (sch3d.size() > 0){
            versionComboBox.addItem("3D");
        }
        sch2d = dbc.findSchedules(m.getName(), false);
        if (sch2d.size() > 0){
            versionComboBox.addItem("2D");
        }
        //update combo box
        ArrayList<String> dateSet = new ArrayList<>();
        ArrayList<String> cineSet = new ArrayList<>();
        for (Schedule s:sch3d) {
            String date =s.getStartTime().substring(5, 10);
            String cinema = mc.getCinemaName(s.getHouseId());
            if (!dateSet.contains(date)) {
                dateSet.add(date);
                dateComboBox.addItem(date);
            }
            if (!cineSet.contains(cinema)){
                cineSet.add(cinema);
                cinemaComboBox.addItem(cinema);
            }
        }
         for (Schedule s: sch2d) {
            String date =s.getStartTime().substring(5, 10);
            String cinema = mc.getCinemaName(s.getHouseId());
            if (!dateSet.contains(date)) {
                dateSet.add(date);
                dateComboBox.addItem(date);
            }
            if (!cineSet.contains(cinema)){
                cineSet.add(cinema);
                cinemaComboBox.addItem(cinema);
            }
         }
         
         if (testingMode ==1){
            dateComboBox.setSelectedItem("03-16");
            cinemaComboBox.setSelectedItem("FESTIVAL GRAND CINEMA");
            versionComboBox.setSelectedItem("3D");
        }
    }
    
    protected void goToMovie(Movie m){
        updateDetail(m);
        updatePanel(DisplayPanel, "movieDetail");
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        menu = new view.GradientPanel();
        homeMenu = new view.GradientPanel();
        bookingBtn = new javax.swing.JLabel();
        aboutUs = new javax.swing.JLabel();
        homeButton = new javax.swing.JLabel();
        allMoviesBtn = new javax.swing.JLabel();
        adminPanel = new view.GradientPanel();
        aboutUs1 = new javax.swing.JLabel();
        homeButton1 = new javax.swing.JLabel();
        editMovieBtn = new javax.swing.JLabel();
        scheduleBtn = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        rightBar = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        registerBtn = new javax.swing.JLabel();
        loginBtn = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        user = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        DisplayPanel = new javax.swing.JPanel();
        Index = new javax.swing.JPanel();
        OnNowLabel = new javax.swing.JLabel();
        upcomingLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        onShowPanel = new view.IndexPanel();
        jPanel4 = new javax.swing.JPanel();
        upComing = new view.IndexPanel();
        Login = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        pwd = new javax.swing.JPasswordField();
        loginEnterBtn = new javax.swing.JButton();
        warningLabel = new javax.swing.JLabel();
        Register = new javax.swing.JPanel();
        registerTitle = new javax.swing.JLabel();
        Register1 = new javax.swing.JLabel();
        Register2 = new javax.swing.JLabel();
        Register3 = new javax.swing.JLabel();
        Register4 = new javax.swing.JLabel();
        Register5 = new javax.swing.JLabel();
        Register6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Register7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Register8 = new javax.swing.JLabel();
        Register9 = new javax.swing.JLabel();
        loginNameTextField = new javax.swing.JTextField();
        preferredNameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        confirmedPasswordField = new javax.swing.JPasswordField();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        submitBtn = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        registerInfoLabel = new javax.swing.JLabel();
        MovieDetail = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        movieName = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        name6 = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        scorePanel = new javax.swing.JPanel();
        score = new javax.swing.JLabel();
        scoreInput = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        type = new view.EditableJLabel();
        time = new view.EditableJLabel();
        releaseDate = new view.EditableJLabel();
        starring = new view.EditableJLabel();
        director = new view.EditableJLabel();
        description = new view.EditableJLabel();
        language = new view.EditableJLabel();
        purchasePanel = new javax.swing.JPanel();
        bookTicket = new javax.swing.JLabel();
        cinemaComboBox = new javax.swing.JComboBox<>();
        versionComboBox = new javax.swing.JComboBox<>();
        dateComboBox = new javax.swing.JComboBox<>();
        schedulePlan = new javax.swing.JPanel();
        updateTime = new javax.swing.JButton();
        allMovies = new javax.swing.JTabbedPane();
        upcoming = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        sortField1 = new javax.swing.JPanel();
        yearLabel = new javax.swing.JLabel();
        firMonLabel = new javax.swing.JLabel();
        secMonLabel = new javax.swing.JLabel();
        thrMonLabel = new javax.swing.JLabel();
        movieContainer1 = new javax.swing.JPanel();
        onShow = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        sortField = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        movieContainer = new javax.swing.JPanel();
        BookingRecord = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aboutUsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        Purchase = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        schedulePanel = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        scheduleTable = new javax.swing.JTable();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setLayout(new java.awt.CardLayout());

        bookingBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookingBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/person logo 36px.png"))); // NOI18N
        bookingBtn.setText("My Bookings");
        bookingBtn.setPreferredSize(new java.awt.Dimension(100, 40));
        bookingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookingBtnMouseExited(evt);
            }
        });

        aboutUs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aboutUs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/contactus logo 36px.png"))); // NOI18N
        aboutUs.setText("About Us");
        aboutUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutUsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutUsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutUsMouseExited(evt);
            }
        });

        homeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/home logo 36px.png"))); // NOI18N
        homeButton.setText("Home");
        homeButton.setPreferredSize(new java.awt.Dimension(75, 40));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
        });

        allMoviesBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allMoviesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/movie logo.png"))); // NOI18N
        allMoviesBtn.setText("All Movies");
        allMoviesBtn.setPreferredSize(new java.awt.Dimension(100, 40));
        allMoviesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allMoviesBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                allMoviesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                allMoviesBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout homeMenuLayout = new javax.swing.GroupLayout(homeMenu);
        homeMenu.setLayout(homeMenuLayout);
        homeMenuLayout.setHorizontalGroup(
            homeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeMenuLayout.createSequentialGroup()
                .addGroup(homeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(allMoviesBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(homeMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(homeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aboutUs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        homeMenuLayout.setVerticalGroup(
            homeMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(allMoviesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutUs, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(492, Short.MAX_VALUE))
        );

        menu.add(homeMenu, "homeMenu");

        aboutUs1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        aboutUs1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/contactus logo 36px.png"))); // NOI18N
        aboutUs1.setText("About Us");
        aboutUs1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutUs1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutUs1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutUs1MouseExited(evt);
            }
        });

        homeButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/home logo 36px.png"))); // NOI18N
        homeButton1.setText("Home");
        homeButton1.setPreferredSize(new java.awt.Dimension(75, 40));
        homeButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButton1MouseExited(evt);
            }
        });

        editMovieBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editMovieBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/edit logo.png"))); // NOI18N
        editMovieBtn.setText("Edit Movie");
        editMovieBtn.setPreferredSize(new java.awt.Dimension(100, 40));
        editMovieBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMovieBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editMovieBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editMovieBtnMouseExited(evt);
            }
        });

        scheduleBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        scheduleBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/schedule.png"))); // NOI18N
        scheduleBtn.setText("Schedule");
        scheduleBtn.setPreferredSize(new java.awt.Dimension(100, 40));
        scheduleBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduleBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scheduleBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scheduleBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aboutUs1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editMovieBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scheduleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(editMovieBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutUs1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(488, Short.MAX_VALUE))
        );

        menu.add(adminPanel, "AdminPanel");

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 133, 720));

        header.setBackground(new java.awt.Color(241, 109, 122));
        header.setPreferredSize(new java.awt.Dimension(430, 783));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/cinema logo 48px.png"))); // NOI18N
        title.setText("Hello World Movie");
        header.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, -1));

        searchBar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchBar.setForeground(new java.awt.Color(102, 102, 102));
        searchBar.setText("Search...");
        searchBar.setToolTipText("");
        searchBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        searchBar.setMargin(new java.awt.Insets(2, 2, 0, 0));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        header.add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 5, 200, 35));

        rightBar.setBackground(header.getBackground());
        rightBar.setLayout(new java.awt.CardLayout());

        login.setBackground(header.getBackground());

        registerBtn.setBackground(new java.awt.Color(255, 255, 255));
        registerBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerBtn.setText("Register");
        registerBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        registerBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        registerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerBtnMouseExited(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtn.setText("Login ");
        loginBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        loginBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnMouseExited(evt);
            }
        });

        jSeparator.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator.setAlignmentX(0.2F);
        jSeparator.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jSeparator.setMinimumSize(new java.awt.Dimension(0, 10));
        jSeparator.setPreferredSize(new java.awt.Dimension(30, 5));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addGap(0, 97, Short.MAX_VALUE)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rightBar.add(login, "login");

        user.setBackground(header.getBackground());

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name.setText("Hi,");
        name.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        name.setMaximumSize(new java.awt.Dimension(30, 30));
        name.setMinimumSize(new java.awt.Dimension(30, 30));
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nameMouseExited(evt);
            }
        });

        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.setAlignmentX(0.5F);
        logout.setMaximumSize(new java.awt.Dimension(30, 30));
        logout.setMinimumSize(new java.awt.Dimension(30, 30));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setAlignmentX(0.2F);
        jSeparator5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jSeparator5.setMinimumSize(new java.awt.Dimension(0, 10));
        jSeparator5.setPreferredSize(new java.awt.Dimension(30, 5));

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userLayout.createSequentialGroup()
                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(userLayout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rightBar.add(user, "user");

        header.add(rightBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 2, 250, 40));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 856, 44));

        DisplayPanel.setBackground(new java.awt.Color(255, 255, 255));
        DisplayPanel.setPreferredSize(new java.awt.Dimension(681, 634));
        DisplayPanel.setLayout(new java.awt.CardLayout());

        Index.setBackground(new java.awt.Color(255, 255, 255));
        Index.setPreferredSize(new java.awt.Dimension(720, 720));
        Index.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OnNowLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OnNowLabel.setText("On Now");
        Index.add(OnNowLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        upcomingLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        upcomingLabel.setText("Upcoming");
        Index.add(upcomingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        onShowPanel.setHome(this);
        onShowPanel.setMainController(mc);
        onShowPanel.setMovies(mc.getOnShow());

        javax.swing.GroupLayout onShowPanelLayout = new javax.swing.GroupLayout(onShowPanel);
        onShowPanel.setLayout(onShowPanelLayout);
        onShowPanelLayout.setHorizontalGroup(
            onShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        onShowPanelLayout.setVerticalGroup(
            onShowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel2.add(onShowPanel);

        Index.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 700, 260));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.OverlayLayout(jPanel4));

        upComing.setHome(this);
        upComing.setMainController(mc);
        upComing.setMovies(mc.getUpcoming());

        javax.swing.GroupLayout upComingLayout = new javax.swing.GroupLayout(upComing);
        upComing.setLayout(upComingLayout);
        upComingLayout.setHorizontalGroup(
            upComingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        upComingLayout.setVerticalGroup(
            upComingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel4.add(upComing);

        Index.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 700, 260));

        DisplayPanel.add(Index, "index");

        Login.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("User name");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdActionPerformed(evt);
            }
        });

        loginEnterBtn.setBackground(new java.awt.Color(153, 153, 255));
        loginEnterBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginEnterBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginEnterBtn.setText("Login");
        loginEnterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginEnterBtnMouseClicked(evt);
            }
        });
        loginEnterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEnterBtnActionPerformed(evt);
            }
        });

        warningLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginEnterBtn)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(warningLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(pwd)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
                .addContainerGap(410, Short.MAX_VALUE))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(warningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loginEnterBtn)
                .addContainerGap(562, Short.MAX_VALUE))
        );

        DisplayPanel.add(Login, "login");

        Register.setBackground(new java.awt.Color(255, 255, 255));

        registerTitle.setBackground(new java.awt.Color(0, 0, 0));
        registerTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        registerTitle.setText("Register");

        Register1.setBackground(new java.awt.Color(0, 0, 0));
        Register1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register1.setText("Preferred Name");
        Register1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        Register2.setBackground(new java.awt.Color(0, 0, 0));
        Register2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register2.setText("Login Name");
        Register2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        Register3.setBackground(new java.awt.Color(0, 0, 0));
        Register3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register3.setText("Confirmed Password");
        Register3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        Register4.setBackground(new java.awt.Color(0, 0, 0));
        Register4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register4.setText("Password");
        Register4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        Register5.setBackground(new java.awt.Color(0, 0, 0));
        Register5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register5.setText("Gender");

        Register6.setBackground(new java.awt.Color(0, 0, 0));
        Register6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register6.setText("Required Information");
        Register6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Register7.setBackground(new java.awt.Color(0, 0, 0));
        Register7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register7.setText("Additional Information");
        Register7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Register8.setBackground(new java.awt.Color(0, 0, 0));
        Register8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register8.setText("Birth Date ");

        Register9.setBackground(new java.awt.Color(0, 0, 0));
        Register9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        Register9.setText("Contact No.");

        loginNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginNameTextFieldActionPerformed(evt);
            }
        });

        preferredNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferredNameTextFieldActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel14.setText(" / ");

        jTextField4.setText("MM");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel15.setText(" / ");

        jTextField6.setText("YYYY");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setText("DD");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SUBMIT");

        maleRadioButton.setText("Male");
        maleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleRadioButtonActionPerformed(evt);
            }
        });

        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegisterLayout = new javax.swing.GroupLayout(Register);
        Register.setLayout(RegisterLayout);
        RegisterLayout.setHorizontalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Register6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Register7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RegisterLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(RegisterLayout.createSequentialGroup()
                                        .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(loginNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Register2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                            .addComponent(Register4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                        .addGap(74, 74, 74)
                                        .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Register3, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                            .addComponent(Register1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(preferredNameTextField)
                                            .addComponent(confirmedPasswordField)))
                                    .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RegisterLayout.createSequentialGroup()
                                            .addComponent(Register9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField5))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RegisterLayout.createSequentialGroup()
                                            .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(RegisterLayout.createSequentialGroup()
                                                    .addComponent(maleRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(femaleRadioButton)
                                                    .addGap(63, 63, 63))
                                                .addGroup(RegisterLayout.createSequentialGroup()
                                                    .addComponent(Register5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(71, 71, 71)))
                                            .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(Register8, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(RegisterLayout.createSequentialGroup()
                                                    .addGap(2, 2, 2)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel14)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel15)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(RegisterLayout.createSequentialGroup()
                                .addComponent(registerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(registerInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterLayout.createSequentialGroup()
                                .addComponent(submitBtn)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterLayout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(80, 80, 80))))))
        );
        RegisterLayout.setVerticalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterLayout.createSequentialGroup()
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(registerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(registerInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Register6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addComponent(Register2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addComponent(Register1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preferredNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Register4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Register3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmedPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Register7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Register8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maleRadioButton)
                    .addComponent(femaleRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Register9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        DisplayPanel.add(Register, "register");
        Register.getAccessibleContext().setAccessibleName("");

        MovieDetail.setBackground(new java.awt.Color(255, 255, 255));
        MovieDetail.setPreferredSize(new java.awt.Dimension(350, 20));
        MovieDetail.setRequestFocusEnabled(false);
        MovieDetail.setVerifyInputWhenFocusTarget(false);
        MovieDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/movie_default.png"))); // NOI18N
        MovieDetail.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 20, 200, 270));

        name1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name1.setText("Director:");
        MovieDetail.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        movieName.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        movieName.setText("MovieName");
        MovieDetail.add(movieName, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 24, 307, 50));

        name3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name3.setText("Language:");
        MovieDetail.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 225, -1, -1));

        name4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name4.setText("Stars:");
        MovieDetail.add(name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 263, -1, -1));

        name6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name6.setText("Description: ");
        MovieDetail.add(name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 102, -1, 70));

        confirmBtn.setVisible(false);
        confirmBtn.setBackground(new java.awt.Color(100, 180, 120));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmBtn.setText("Confirm");
        confirmBtn.setOpaque(true);
        confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBtnMouseClicked(evt);
            }
        });
        MovieDetail.add(confirmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 100, 36));

        jLabel10.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("|");
        jLabel10.setToolTipText("");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setPreferredSize(new java.awt.Dimension(2, 25));
        MovieDetail.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 20, 22));

        jLabel11.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("|");
        jLabel11.setToolTipText("");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MovieDetail.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 30, 22));

        scorePanel.setBackground(new java.awt.Color(255, 255, 255));
        scorePanel.setLayout(new java.awt.CardLayout());

        score.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        score.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        score.setText("0.00");
        score.setToolTipText("");
        score.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scoreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scoreMouseExited(evt);
            }
        });
        scorePanel.add(score, "display");

        scoreInput.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        scoreInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "3.0", "3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0", "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8", "4.9", "5.0" }));
        scoreInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                scoreInputKeyPressed(evt);
            }
        });
        scorePanel.add(scoreInput, "input");

        MovieDetail.add(scorePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 60, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("/5");
        MovieDetail.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 69, 40, -1));

        type.setLayout(new java.awt.CardLayout());
        type.initiate("type");
        MovieDetail.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 40, 20));

        time.setLayout(new java.awt.CardLayout());
        time.initiate("Length");
        MovieDetail.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 50, 20));

        releaseDate.setLayout(new java.awt.CardLayout());
        releaseDate.initiate("Release dateComboBox");
        MovieDetail.add(releaseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 110, 20));

        starring.setLayout(new java.awt.CardLayout());
        starring.initiate("Stars");
        MovieDetail.add(starring, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 370, 20));

        director.setLayout(new java.awt.CardLayout());
        director.initiate("director");
        MovieDetail.add(director, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 370, 20));

        description.setLayout(new java.awt.CardLayout());
        description.initiate("description");
        MovieDetail.add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 370, 80));

        language.setLayout(new java.awt.CardLayout());
        language.initiate("Language");
        MovieDetail.add(language, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 370, 20));

        purchasePanel.setBackground(new java.awt.Color(255, 255, 255));

        bookTicket.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bookTicket.setForeground(new java.awt.Color(241, 109, 122));
        bookTicket.setText("Book Ticket");

        cinemaComboBox.setBackground(new java.awt.Color(255, 153, 153));
        cinemaComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cinemaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cinema" }));

        versionComboBox.setBackground(new java.awt.Color(255, 153, 153));
        versionComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        versionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Version" }));

        dateComboBox.setBackground(new java.awt.Color(255, 153, 153));
        dateComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date" }));

        schedulePlan.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout schedulePlanLayout = new javax.swing.GroupLayout(schedulePlan);
        schedulePlan.setLayout(schedulePlanLayout);
        schedulePlanLayout.setHorizontalGroup(
            schedulePlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        schedulePlanLayout.setVerticalGroup(
            schedulePlanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );

        updateTime.setBackground(new java.awt.Color(255, 153, 153));
        updateTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateTime.setText("SUBMIT");
        updateTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout purchasePanelLayout = new javax.swing.GroupLayout(purchasePanel);
        purchasePanel.setLayout(purchasePanelLayout);
        purchasePanelLayout.setHorizontalGroup(
            purchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchasePanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(purchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(purchasePanelLayout.createSequentialGroup()
                        .addComponent(schedulePlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(purchasePanelLayout.createSequentialGroup()
                        .addComponent(bookTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cinemaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(versionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateTime))))
        );
        purchasePanelLayout.setVerticalGroup(
            purchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purchasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(purchasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTicket)
                    .addComponent(cinemaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(versionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(schedulePlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MovieDetail.add(purchasePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 710, 360));

        DisplayPanel.add(MovieDetail, "movieDetail");

        allMovies.setBackground(new java.awt.Color(255, 255, 255));
        allMovies.setForeground(new java.awt.Color(241, 109, 122));
        allMovies.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        upcoming.setBorder(null);
        upcoming.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        upcoming.setMaximumSize(new java.awt.Dimension(800, 1000));
        upcoming.setMinimumSize(new java.awt.Dimension(800, 600));
        upcoming.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 1029));

        sortField1.setBackground(new java.awt.Color(255, 255, 255));

        yearLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yearLabel.setText(""+year);
        yearLabel.setPreferredSize(new java.awt.Dimension(50, 20));

        firMonLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firMonLabel.setForeground(new java.awt.Color(0, 0, 255));
        firMonLabel.setText("<html><u>"+firMon+"</u></html>");
        firMonLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        firMonLabel.setMaximumSize(new java.awt.Dimension(50, 20));
        firMonLabel.setMinimumSize(new java.awt.Dimension(50, 20));
        firMonLabel.setPreferredSize(new java.awt.Dimension(50, 20));

        secMonLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        secMonLabel.setForeground(new java.awt.Color(0, 0, 255));
        secMonLabel.setText("<html><u>"+secMon+"</u></html>");
        secMonLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        secMonLabel.setMaximumSize(new java.awt.Dimension(50, 20));
        secMonLabel.setMinimumSize(new java.awt.Dimension(50, 20));
        secMonLabel.setPreferredSize(new java.awt.Dimension(50, 20));

        thrMonLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        thrMonLabel.setForeground(new java.awt.Color(0, 0, 255));
        thrMonLabel.setText("<html><u>"+thrMon+"</u></html>");
        thrMonLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        thrMonLabel.setMaximumSize(new java.awt.Dimension(50, 20));
        thrMonLabel.setMinimumSize(new java.awt.Dimension(50, 20));
        thrMonLabel.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout sortField1Layout = new javax.swing.GroupLayout(sortField1);
        sortField1.setLayout(sortField1Layout);
        sortField1Layout.setHorizontalGroup(
            sortField1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortField1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(firMonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secMonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(thrMonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sortField1Layout.setVerticalGroup(
            sortField1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sortField1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sortField1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(firMonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sortField1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(sortField1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secMonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thrMonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        movieContainer1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout movieContainer1Layout = new javax.swing.GroupLayout(movieContainer1);
        movieContainer1.setLayout(movieContainer1Layout);
        movieContainer1Layout.setHorizontalGroup(
            movieContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );
        movieContainer1Layout.setVerticalGroup(
            movieContainer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sortField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(movieContainer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sortField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movieContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );

        upcoming.setViewportView(jPanel5);

        allMovies.addTab("Upcoming", upcoming);

        onShow.setBorder(null);
        onShow.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        onShow.setMaximumSize(new java.awt.Dimension(800, 1000));
        onShow.setMinimumSize(new java.awt.Dimension(800, 600));
        onShow.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 1029));

        sortField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Sort by:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 255));
        jLabel29.setText("<html><u>threater</u></html>");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel29.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel29.setMinimumSize(new java.awt.Dimension(50, 20));
        jLabel29.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 255));
        jLabel30.setText("<html><u>name</u></html>");
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel30.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel30.setMinimumSize(new java.awt.Dimension(50, 20));
        jLabel30.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 255));
        jLabel31.setText("<html><u>versionComboBox</u></html>");
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel31.setMaximumSize(new java.awt.Dimension(50, 20));
        jLabel31.setMinimumSize(new java.awt.Dimension(50, 20));
        jLabel31.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout sortFieldLayout = new javax.swing.GroupLayout(sortField);
        sortField.setLayout(sortFieldLayout);
        sortFieldLayout.setHorizontalGroup(
            sortFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );
        sortFieldLayout.setVerticalGroup(
            sortFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sortFieldLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(sortFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        movieContainer.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout movieContainerLayout = new javax.swing.GroupLayout(movieContainer);
        movieContainer.setLayout(movieContainerLayout);
        movieContainerLayout.setHorizontalGroup(
            movieContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );
        movieContainerLayout.setVerticalGroup(
            movieContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(movieContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(sortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(movieContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(412, Short.MAX_VALUE))
        );

        onShow.setViewportView(jPanel3);

        allMovies.addTab("On Show", onShow);

        DisplayPanel.add(allMovies, "allMovies");

        BookingRecord.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Booking Record");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Datetime", "Movie", "House No.", "Num of Tickets", "Seat No.", "Price", "Reference ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 153));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setHeaderValue("");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Price");
        }

        javax.swing.GroupLayout BookingRecordLayout = new javax.swing.GroupLayout(BookingRecord);
        BookingRecord.setLayout(BookingRecordLayout);
        BookingRecordLayout.setHorizontalGroup(
            BookingRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookingRecordLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(BookingRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        BookingRecordLayout.setVerticalGroup(
            BookingRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookingRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );

        DisplayPanel.add(BookingRecord, "bookingRecord");

        aboutUsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/contactus logo large.png"))); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Hello World Movie System is designed by Group X\n\n\tGroup Member:\n                       \tRuixiang       Liang\n                       \tWenzhou      Wei\n                       \tSisi                Rao");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setEditable(false);
        jTextArea1.setFocusable(false);
        jTextArea1.setBorder(null);

        javax.swing.GroupLayout aboutUsPanelLayout = new javax.swing.GroupLayout(aboutUsPanel);
        aboutUsPanel.setLayout(aboutUsPanelLayout);
        aboutUsPanelLayout.setHorizontalGroup(
            aboutUsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutUsPanelLayout.createSequentialGroup()
                .addGroup(aboutUsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutUsPanelLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel1))
                    .addGroup(aboutUsPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        aboutUsPanelLayout.setVerticalGroup(
            aboutUsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutUsPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 290, Short.MAX_VALUE))
        );

        DisplayPanel.add(aboutUsPanel, "aboutUs");

        Purchase.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Moive Info");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Movie Title");

        jLabel18.setText("Seating Plan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(309, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(322, 322, 322))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel18)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PurchaseLayout = new javax.swing.GroupLayout(Purchase);
        Purchase.setLayout(PurchaseLayout);
        PurchaseLayout.setHorizontalGroup(
            PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PurchaseLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PurchaseLayout.setVerticalGroup(
            PurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PurchaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        DisplayPanel.add(Purchase, "purchase");

        schedulePanel.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(241, 109, 122));

        scheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "starttime", "movieid", "houseid", "scheduleid"
            }
        ));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(241, 109, 122));
        jLabel7.setText("Schedule Dashboard");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Select ShowDate:");

        javax.swing.GroupLayout schedulePanelLayout = new javax.swing.GroupLayout(schedulePanel);
        schedulePanel.setLayout(schedulePanelLayout);
        schedulePanelLayout.setHorizontalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulePanelLayout.createSequentialGroup()
                .addGroup(schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schedulePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(schedulePanelLayout.createSequentialGroup()
                        .addGroup(schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(schedulePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(schedulePanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(schedulePanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scheduleTable, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        schedulePanelLayout.setVerticalGroup(
            schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schedulePanelLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(schedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addComponent(scheduleTable, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 365, Short.MAX_VALUE))
        );

        DisplayPanel.add(schedulePanel, "Schedule");
        schedulePanel.getAccessibleContext().setAccessibleName("Schedule");

        getContentPane().add(DisplayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 51, 720, 720));
        DisplayPanel.getAccessibleContext().setAccessibleName("displayPanel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuBtnAction(javax.swing.JLabel btn, String type){
        switch(type){
            case "Enter":
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.setForeground(new Color(241,109,122));
                break;
            case "Exit":
                btn.setForeground(Color.BLACK);
                btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
        }
    }
    
    private void barBtnAction(javax.swing.JLabel btn, String type){
        switch(type){
            case "Enter":
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                break;
            case "Exit":
                btn.setForeground(Color.WHITE);
                btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
        }
    }
    
    
    private void updatePanel(javax.swing.JPanel panel, String cardName){
        CardLayout card = (CardLayout) panel.getLayout();
        card.show(panel, cardName);
    }
    
    
    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed
    
    private void loginNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginNameTextFieldActionPerformed

    private void preferredNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preferredNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preferredNameTextFieldActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseClicked
        // TODO add your handling code here:
        //read value

        //pass to controller

        //get result

        //print to popup window
        
    }//GEN-LAST:event_submitBtnMouseClicked

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBarActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "movieDetail");
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "purchase");
    }                                     

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "movieDetail");
    }//GEN-LAST:event_jLabel28MouseClicked

    private void loginEnterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginEnterBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_loginEnterBtnActionPerformed

    private void loginEnterBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginEnterBtnMouseClicked
        // TODO add your handling code here:
        String result;
        result = mc.login(username.getText(),pwd.getPassword());
        System.out.print("result:" +result);
        if(result.equals("Admin"))
        {
            this.permission = true;
            updatePermission(permission);
            confirmBtn.setVisible(true);
            updatePanel(DisplayPanel, "index");
            updatePanel(menu, "AdminPanel");
            updatePanel(rightBar, "user");
            name.setText("Hi, " + result + " ");
            isLogin = true;
        }
        else if(result.equals("1"))
        {
            isLogin = false;
            warningLabel.setText("Wrong Password. Please Try Again.");
        }
        else if(result.equals("0")){
            isLogin = false;
            warningLabel.setText("Login Failed. Please Try Again.");
        } else {
                updatePanel(rightBar, "user");
                name.setText("Hi, " + result + " ");
                isLogin = true;
        }
    }//GEN-LAST:event_loginEnterBtnMouseClicked

    private void updatePermission(boolean p){
        description.setPermission(p);
        language.setPermission(p);
        starring.setPermission(p);
        director.setPermission(p);
        type.setPermission(p);
        time.setPermission(p);
        releaseDate.setPermission(p);
    }
    private void registerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnMouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "register");
        //dbc.createUser(new User(preferredNameTextField.getText(), loginNameTextField.getText(), new String(passwordField.getPassword()), ));
    }//GEN-LAST:event_registerBtnMouseClicked

    private void registerBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnMouseEntered
        // TODO add your handling code here:
        registerBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_registerBtnMouseEntered

    private void registerBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnMouseExited
        // TODO add your handling code here:
        registerBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_registerBtnMouseExited

    private void groupButton( ) {

    ButtonGroup bg1 = new ButtonGroup( );

    bg1.add(maleRadioButton);
    bg1.add(femaleRadioButton);

}
    
    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
        // TODO add your handling code here:
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updatePanel(DisplayPanel, "login");
    }//GEN-LAST:event_loginBtnMouseClicked

    private void loginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseEntered
        // TODO add your handling code here:        
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_loginBtnMouseEntered

    private void loginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseExited
        // TODO add your handling code here:
        loginBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_loginBtnMouseExited

    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nameMouseClicked

    private void nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nameMouseEntered

    private void nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_nameMouseExited

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        permission = false;
        isLogin = false;
        confirmBtn.setVisible(false);
        updatePermission(permission);
        updatePanel(DisplayPanel, "index");
        updatePanel(menu, "homeMenu");
        updatePanel(rightBar, "login");
        
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        // TODO add your handling code here:
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        // TODO add your handling code here:
        logout.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_logoutMouseExited

    private void confirmBtnMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        System.out.println(description.getText() + director.getText() + language.getText() +  starring.getText());
        mc.updateMovie(description.getText(), director.getText(),language.getText(), starring.getText(), type.getText(), time.getText(), releaseDate.getText());
    }                                       

    private void jXDatePicker2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jXDatePicker2PropertyChange
        // TODO add your handling code here:
        if ("date".equals(evt.getPropertyName())) {
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
            String dateChosen = formater.format(jXDatePicker2.getDate());
            System.out.println(" Date Chosen: " + dateChosen);
            List<Schedule> results = mc.findSchedulesByDate(dateChosen);
            //update Schedule Table
            DefaultTableModel model = (DefaultTableModel) scheduleTable.getModel();
            model.setRowCount(0);            
            for (Schedule s:results)
            {
                String starttime = s.getStartTime();
                int movieid = s.getMovieId();
                int houseid = s.getHouseId();
                int scheduleid = s.getScheduleId();

                Object[] row = { starttime, movieid, houseid, scheduleid };
                model.addRow(row);
            }
           
         }
    }//GEN-LAST:event_jXDatePicker2PropertyChange

    private void scheduleTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_scheduleTableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_scheduleTableFocusLost

    private void allMoviesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allMoviesBtnMouseExited
        // TODO add your handling code here:
        menuBtnAction(allMoviesBtn, "Exit");
    }//GEN-LAST:event_allMoviesBtnMouseExited

    private void allMoviesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allMoviesBtnMouseEntered
        // TODO add your handling code here:
        menuBtnAction(allMoviesBtn, "Enter");
    }//GEN-LAST:event_allMoviesBtnMouseEntered

    private void allMoviesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allMoviesBtnMouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "allMovies");
    }//GEN-LAST:event_allMoviesBtnMouseClicked

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        menuBtnAction(homeButton, "Exit");
    }//GEN-LAST:event_homeButtonMouseExited

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        // TODO add your handling code here:
        menuBtnAction(homeButton, "Enter");
    }//GEN-LAST:event_homeButtonMouseEntered

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        updatePanel(DisplayPanel, "index");
    }//GEN-LAST:event_homeButtonMouseClicked

    private void aboutUsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsMouseExited
        // TODO add your handling code here:
        menuBtnAction(aboutUs, "Exit");
    }//GEN-LAST:event_aboutUsMouseExited

    private void aboutUsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsMouseEntered
        // TODO add your handling code here:
        menuBtnAction(aboutUs, "Enter");
    }//GEN-LAST:event_aboutUsMouseEntered

    private void aboutUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUsMouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "aboutUs");
    }//GEN-LAST:event_aboutUsMouseClicked

    private void bookingBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingBtnMouseExited
        // TODO add your handling code here:
        menuBtnAction(bookingBtn, "Exit");
    }//GEN-LAST:event_bookingBtnMouseExited

    private void bookingBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingBtnMouseEntered
        // TODO add your handling code here:
        menuBtnAction(bookingBtn, "Enter");
    }//GEN-LAST:event_bookingBtnMouseEntered

    private void bookingBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingBtnMouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "bookingRecord");
    }//GEN-LAST:event_bookingBtnMouseClicked

    private void scheduleBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleBtnMouseExited
        // TODO add your handling code here:
        menuBtnAction(scheduleBtn, "Exit");
    }//GEN-LAST:event_scheduleBtnMouseExited

    private void scheduleBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleBtnMouseEntered
        // TODO add your handling code here:
        menuBtnAction(scheduleBtn, "Enter");
    }//GEN-LAST:event_scheduleBtnMouseEntered

    private void scheduleBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduleBtnMouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel,"Schedule");
    }//GEN-LAST:event_scheduleBtnMouseClicked

    private void editMovieBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMovieBtnMouseExited
        // TODO add your handling code here:
        menuBtnAction(editMovieBtn, "Exit");
    }//GEN-LAST:event_editMovieBtnMouseExited

    private void editMovieBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMovieBtnMouseEntered
        // TODO add your handling code here:
        menuBtnAction(editMovieBtn, "Enter");
    }//GEN-LAST:event_editMovieBtnMouseEntered

    private void editMovieBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMovieBtnMouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "allMovies");
    }//GEN-LAST:event_editMovieBtnMouseClicked

    private void homeButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButton1MouseExited
        // TODO add your handling code here:
        menuBtnAction(homeButton1, "Exit");
    }//GEN-LAST:event_homeButton1MouseExited

    private void homeButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButton1MouseEntered
        // TODO add your handling code here:
        menuBtnAction(homeButton1, "Enter");
    }//GEN-LAST:event_homeButton1MouseEntered

    private void homeButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButton1MouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "index");
    }//GEN-LAST:event_homeButton1MouseClicked

    private void aboutUs1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUs1MouseExited
        // TODO add your handling code here:
        menuBtnAction(aboutUs1, "Exit");
    }//GEN-LAST:event_aboutUs1MouseExited

    private void aboutUs1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUs1MouseEntered
        // TODO add your handling code here:
        menuBtnAction(aboutUs1, "Enter");
    }//GEN-LAST:event_aboutUs1MouseEntered

    private void aboutUs1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutUs1MouseClicked
        // TODO add your handling code here:
        updatePanel(DisplayPanel, "aboutUs");
    }//GEN-LAST:event_aboutUs1MouseClicked

    private void scoreInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_scoreInputKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
            score.setText((String)scoreInput.getSelectedItem());
            updatePanel(scorePanel, "display");
        }
        if (evt.getKeyCode() == KeyEvent.VK_DELETE){
            updatePanel(scorePanel, "display");
        }
    }//GEN-LAST:event_scoreInputKeyPressed

    private void scoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scoreMouseExited
        // TODO add your handling code here:
        //        updatePanel(scorePanel, "display");
    }//GEN-LAST:event_scoreMouseExited

    private void scoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scoreMouseEntered
        // TODO add your handling code here:
        if (isLogin || testingMode == 1){
            scoreInput.setSelectedItem(String.format("%.1f", Float.parseFloat(score.getText())));
            updatePanel(scorePanel, "input");
        } else {
            //popup window ask for log in
        }

    }//GEN-LAST:event_scoreMouseEntered

    private void scoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scoreMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_scoreMouseClicked

    private void updateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTimeActionPerformed
        // TODO add your handling code here:
        schedulePlan.removeAll();
        schedulePlan.revalidate();
        schedulePlan.repaint();
        String date = (String) dateComboBox.getSelectedItem();
        String cinema = (String) cinemaComboBox.getSelectedItem();
        String version = (String) versionComboBox.getSelectedItem();
        JLabel msgLabel = null;
        Boolean errorflag = false;
        String msg = "Please specify ";
        if (date.equals("Date")){
            msg += "date, ";
            errorflag = true;
        }
        if (cinema.equals("Cinema")){
            msg += "cinema, ";
            errorflag = true;
        }
        if (version.equals("Version")){
            msg += "version, ";
            errorflag = true;
        }
        if (errorflag){
            msgLabel = new JLabel(msg.substring(0, msg.length()-2)+"!");
            msgLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); 
            msgLabel.setForeground(new java.awt.Color(255, 102, 102));
            msgLabel.setBounds(5,5, 300, 20);
            schedulePlan.add(msgLabel);
            schedulePlan.revalidate();
            schedulePlan.repaint();
        }  else {
            if (version.equals("2D"))
                drawSchedule(findSchedule(sch2d, date, cinema));
            else 
                drawSchedule(findSchedule(sch3d, date, cinema));
        } 
    }//GEN-LAST:event_updateTimeActionPerformed

    private void pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdActionPerformed

    private void maleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleRadioButtonActionPerformed

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private ArrayList<Schedule> findSchedule(ArrayList<Schedule> schedules, String date, String cinema){
        ArrayList<Schedule> returnList = new ArrayList<>(); 
        for (Schedule s: schedules){
            if (s.getStartTime().substring(5, 10).equals(date) && mc.getCinemaName(s.getHouseId()).equals(cinema))
                returnList.add(s);
        }
        return returnList;
    }
    
    private void drawSeats(Schedule sch){
        schedulePlan.removeAll();
        schedulePlan.revalidate();
        schedulePlan.repaint();
        JLabel time = new JLabel(sch.getStartTime().substring(11, 16) + " V ");
        time.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        time.setForeground(new java.awt.Color(255, 102, 102));
        time.setBounds(5, 5, 80, 20);
        time.addMouseListener(new MouseAdapter()  
            {  
                public void mouseClicked(MouseEvent e)  {
                            updateTime.doClick();
                }  
            }); 
        schedulePlan.add(time);
        SeatPlan seatPlan = new SeatPlan();
        seatPlan.setMC(mc);
        seatPlan.setSchedule(sch);
        seatPlan.setMode(false);
        seatPlan.setSize(schedulePanel.getWidth() - 10, schedulePlan.getHeight() - 10, 10);
        
        seatPlan.setBounds(5, 30, schedulePanel.getWidth() -10 , schedulePlan.getHeight() - 30);
        schedulePlan.add(seatPlan);
        schedulePlan.revalidate();
        schedulePlan.repaint();
    }
    
    private void drawSchedule(ArrayList<Schedule> sch){
        schedulePlan.removeAll();
        schedulePlan.revalidate();
        schedulePlan.repaint();
        int x = 5;
        int y = 5;
        int margin = 10;
        int width = 50;
        int height = 50;
        int col = 0;
        JLabel tmp;
        for (int i = 0; i < sch.size();i++){
            tmp = new JLabel(sch.get(i).getStartTime().substring(11, 16));
            tmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
            tmp.setForeground(new java.awt.Color(255, 102, 102));
            tmp.setBounds(x+ (margin+ width) * col, y, width, height);
            Schedule tmpS = sch.get(i);
            tmp.addMouseListener(new MouseAdapter()  
            {  
                public void mouseClicked(MouseEvent e)  {
                            drawSeats(tmpS);
                }  
            }); 
            schedulePlan.add(tmp);
            col++;
            if (col % 10 == 0){
                y +=height + margin;
                x = 0;
                col = 0;
            }
        }
        schedulePlan.revalidate();
        schedulePlan.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BookingRecord;
    private javax.swing.JPanel DisplayPanel;
    private javax.swing.JPanel Index;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel MovieDetail;
    private javax.swing.JLabel OnNowLabel;
    private javax.swing.JPanel Purchase;
    private javax.swing.JPanel Register;
    private javax.swing.JLabel Register1;
    private javax.swing.JLabel Register2;
    private javax.swing.JLabel Register3;
    private javax.swing.JLabel Register4;
    private javax.swing.JLabel Register5;
    private javax.swing.JLabel Register6;
    private javax.swing.JLabel Register7;
    private javax.swing.JLabel Register8;
    private javax.swing.JLabel Register9;
    private javax.swing.JLabel aboutUs;
    private javax.swing.JLabel aboutUs1;
    private javax.swing.JPanel aboutUsPanel;
    private view.GradientPanel adminPanel;
    private javax.swing.JTabbedPane allMovies;
    private javax.swing.JLabel allMoviesBtn;
    private javax.swing.JLabel bookTicket;
    private javax.swing.JLabel bookingBtn;
    private javax.swing.JComboBox<String> cinemaComboBox;
    private javax.swing.JLabel confirmBtn;
    private javax.swing.JPasswordField confirmedPasswordField;
    private javax.swing.JComboBox<String> dateComboBox;
    private view.EditableJLabel description;
    private view.EditableJLabel director;
    private javax.swing.JLabel editMovieBtn;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JLabel firMonLabel;
    private javax.swing.JPanel header;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel homeButton1;
    private view.GradientPanel homeMenu;
    private javax.swing.JLabel image;
    public javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private view.EditableJLabel language;
    private javax.swing.JPanel login;
    private javax.swing.JLabel loginBtn;
    public javax.swing.JButton loginEnterBtn;
    private javax.swing.JTextField loginNameTextField;
    private javax.swing.JLabel logout;
    private javax.swing.JRadioButton maleRadioButton;
    private view.GradientPanel menu;
    private javax.swing.JPanel movieContainer;
    private javax.swing.JPanel movieContainer1;
    private javax.swing.JLabel movieName;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name6;
    private javax.swing.JScrollPane onShow;
    private view.IndexPanel onShowPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField preferredNameTextField;
    private javax.swing.JPanel purchasePanel;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JLabel registerBtn;
    private javax.swing.JLabel registerInfoLabel;
    private javax.swing.JLabel registerTitle;
    private view.EditableJLabel releaseDate;
    private javax.swing.JPanel rightBar;
    private javax.swing.JLabel scheduleBtn;
    private javax.swing.JPanel schedulePanel;
    private javax.swing.JPanel schedulePlan;
    private javax.swing.JTable scheduleTable;
    private javax.swing.JLabel score;
    private javax.swing.JComboBox<String> scoreInput;
    private javax.swing.JPanel scorePanel;
    private javax.swing.JTextField searchBar;
    private javax.swing.JLabel secMonLabel;
    private javax.swing.JPanel sortField;
    private javax.swing.JPanel sortField1;
    private view.EditableJLabel starring;
    private javax.swing.JLabel submitBtn;
    private javax.swing.JLabel thrMonLabel;
    private view.EditableJLabel time;
    private javax.swing.JLabel title;
    private view.EditableJLabel type;
    private view.IndexPanel upComing;
    private javax.swing.JScrollPane upcoming;
    private javax.swing.JLabel upcomingLabel;
    private javax.swing.JButton updateTime;
    private javax.swing.JPanel user;
    private javax.swing.JTextField username;
    private javax.swing.JComboBox<String> versionComboBox;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
   
    //customie variable declaration
    private int year;
    private String curMon, firMon, secMon, thrMon;

    
interface ValueChangedListener {
	public void valueChanged(String value, JComponent source);
        
}
}

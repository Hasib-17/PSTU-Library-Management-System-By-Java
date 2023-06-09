/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pstu_librarysystem;

import java.awt.BorderLayout;
import java.awt.GradientPaint;
import java.awt.Point;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Hasibur Rahman
 */
public class Home_Page extends javax.swing.JFrame {

    /**
     * Creates new form Home_Page
     */
    
    //Color mouseEnterColor = new Color(51,0,51);
     DefaultTableModel model;
    
    public Home_Page() {
        initComponents();
        setDataToCard();
        showPieChart();
        setStudentDetails();
        setBookDetails();
        
    }
    
     // to set data into the Student table
    public void setStudentDetails(){
        try{
             
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select * from student_details");
            
            while(rs.next()){
               
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("student_name");
                String course = rs.getString("course");
                String session = rs.getString("session");
                
                
                Object[] obj = {studentId,studentName,course,session};
                model = (DefaultTableModel)tbl_studentdetails.getModel();
                model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     // to set data into the book table
    public void setBookDetails(){
        try{
             
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("select * from book_details");
            
            while(rs.next()){
               
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String Author = rs.getString("author");
                int Quantity = rs.getInt("quantity");
                
                Object[] obj = {bookId,bookName,Author,Quantity};
                model = (DefaultTableModel)tbl_bookdetails.getModel();
                model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public void setDataToCard(){
        
       
       long l = System.currentTimeMillis();
       Date toDaysDate = new Date(l);
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery("select count(*) from book_details");
            rs.next();
            lbl_noOfBooks.setText(Integer.toString(rs.getInt(1)));
            
             rs = st.executeQuery("select count(*) from student_details");
             rs.next();
             lbl_noOfStudents.setText(Integer.toString(rs.getInt(1)));
             
             rs= st.executeQuery("select count(*) from issue_book_details where status='"+"pending"+"'");
             rs.next();
             lbl_issueBook.setText(Integer.toString(rs.getInt(1)));
             
             
             rs= st.executeQuery("select count(*) from issue_book_details where due_date < '"+toDaysDate+"' and status = '"+"pending"+"'");
             rs.next();
             lbl_defaulterList.setText(Integer.toString(rs.getInt(1)));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
             String sql = "select book_name , count(*) as issue_count from issue_book_details group by book_id";
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                barDataset.setValue(rs.getString("book_name"), new Double( rs.getDouble("issue_count") ) );   
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
      
      
      
       
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issued Book Data",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
        piePlot.setSectionPaint(1, java.awt.Color.BLUE);
        piePlot.setSectionPaint(2,java.awt.Color.BLACK);
        piePlot.setSectionPaint(3, java.awt.Color.GREEN);
        piePlot.setSectionPaint(4, java.awt.Color.YELLOW);
        piePlot.setSectionPaint(5, java.awt.Color.CYAN);
       
       
       
        piePlot.setBackgroundPaint(java.awt.Color.white);
       
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        manage = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dash = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        stu = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        issue = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Return = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        view = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Viewissue = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        list = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_issueBook = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookdetails = new rojeru_san.complementos.RSTableMetro();
        panelPieChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(167, 12, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 50, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 10, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("Welcome,Admin");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 10, 230, 50));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("X");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1870, 10, 30, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 70));

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setBackground(new java.awt.Color(255, 0, 0));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeMouseExited(evt);
            }
        });
        home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel3.setText("Home Page");
        home.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel3.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 290, 50));

        manage.setBackground(new java.awt.Color(51, 0, 0));
        manage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageMouseExited(evt);
            }
        });
        manage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel5.setText("Manage Book");
        manage.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel3.add(manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 290, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Feature");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        dash.setBackground(new java.awt.Color(51, 0, 0));
        dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashMouseExited(evt);
            }
        });
        dash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel7.setText("Dashboard");
        dash.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel3.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 290, 50));

        stu.setBackground(new java.awt.Color(51, 0, 0));
        stu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuMouseExited(evt);
            }
        });
        stu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel8.setText("Manage Students");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        stu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel3.add(stu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 290, 50));

        issue.setBackground(new java.awt.Color(51, 0, 0));
        issue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issueMouseExited(evt);
            }
        });
        issue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel9.setText("Issue Book");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        issue.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 160, -1));

        jPanel3.add(issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 50));

        Return.setBackground(new java.awt.Color(51, 0, 0));
        Return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReturnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReturnMouseExited(evt);
            }
        });
        Return.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel10.setText("Return Book");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        Return.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 150, -1));

        jPanel3.add(Return, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 290, 50));

        view.setBackground(new java.awt.Color(51, 0, 0));
        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewMouseExited(evt);
            }
        });
        view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel11.setText("View Record");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        view.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 170, -1));

        jPanel3.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 290, 50));

        Viewissue.setBackground(new java.awt.Color(51, 0, 0));
        Viewissue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewissueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ViewissueMouseExited(evt);
            }
        });
        Viewissue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel12.setText("View Issue Book");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        Viewissue.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel3.add(Viewissue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 290, 50));

        list.setBackground(new java.awt.Color(51, 0, 0));
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listMouseExited(evt);
            }
        });
        list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel13.setText("Defaulter List");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        list.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel3.add(list, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 290, 50));

        rSButtonHover1.setBackground(new java.awt.Color(167, 12, 241));
        rSButtonHover1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        rSButtonHover1.setText("Logout");
        rSButtonHover1.setActionCommand("Logout    .");
        rSButtonHover1.setColorHover(new java.awt.Color(255, 0, 0));
        rSButtonHover1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rSButtonHover1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonHover1MouseClicked(evt);
            }
        });
        jPanel3.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 790, 290, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 290, 960));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        lbl_noOfBooks.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("10");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lbl_noOfBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_noOfBooks)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 260, 140));

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        jLabel16.setText("Students Details");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 190, 40));

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setText("No. of Students");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 190, 40));

        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(167, 12, 241)));

        lbl_noOfStudents.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfStudents.setText("10");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lbl_noOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_noOfStudents)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 260, 140));

        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(167, 12, 241)));

        lbl_defaulterList.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterList.setText("10");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lbl_defaulterList, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_defaulterList)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 100, -1, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 0, 0)));

        lbl_issueBook.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        lbl_issueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_issueBook.setText("10");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lbl_issueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_issueBook)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, -1, -1));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setText("Defaulter List");
        jPanel14.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 50, 190, 40));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel21.setText("Issued Books");
        jPanel14.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 190, 40));

        tbl_studentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Faculty", "Session"
            }
        ));
        tbl_studentdetails.setColorBackgoundHead(new java.awt.Color(167, 12, 241));
        tbl_studentdetails.setColorBordeFilas(new java.awt.Color(167, 12, 241));
        tbl_studentdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentdetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_studentdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentdetails.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_studentdetails);

        jPanel14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 680, 790, 220));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setText("No. of Books");
        jPanel14.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 190, 40));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 25)); // NOI18N
        jLabel24.setText("Book Details");
        jPanel14.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 190, 40));

        tbl_bookdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book Name", "Author", "Quantity"
            }
        ));
        tbl_bookdetails.setColorBackgoundHead(new java.awt.Color(167, 12, 241));
        tbl_bookdetails.setColorBordeFilas(new java.awt.Color(167, 12, 241));
        tbl_bookdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookdetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_bookdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookdetails.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_bookdetails);

        jPanel14.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 790, 220));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel14.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 410, 540, 450));

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 1620, 960));

        setSize(new java.awt.Dimension(1905, 1024));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
       
       int a = JOptionPane.showConfirmDialog(null,"Do you really want to close the application?","Select",JOptionPane.YES_NO_OPTION);
       if(a==0){
         System.exit(0);  
       }
       
    }//GEN-LAST:event_jLabel14MouseClicked

    private void homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseEntered
        // TODO add your handling code here:
       home.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_homeMouseEntered

    private void homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseExited
        // TODO add your handling code here:
        home.setBackground(java.awt.Color.red);
    }//GEN-LAST:event_homeMouseExited

    private void dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseEntered
        // TODO add your handling code here:
      dash.setBackground(java.awt.Color.MAGENTA);
    }//GEN-LAST:event_dashMouseEntered

    private void dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseExited
        // TODO add your handling code here:
        dash.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_dashMouseExited

    private void manageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageMouseEntered
        // TODO add your handling code here:
        manage.setBackground(java.awt.Color.MAGENTA);
    }//GEN-LAST:event_manageMouseEntered

    private void manageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageMouseExited
        // TODO add your handling code here:
        manage.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_manageMouseExited

    private void stuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuMouseEntered
        // TODO add your handling code here:
        stu.setBackground(java.awt.Color.MAGENTA);
    }//GEN-LAST:event_stuMouseEntered

    private void stuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuMouseExited
        // TODO add your handling code here:
        stu.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_stuMouseExited

    private void issueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueMouseEntered
        // TODO add your handling code here:
        issue.setBackground(java.awt.Color.MAGENTA);
    }//GEN-LAST:event_issueMouseEntered

    private void issueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueMouseExited
        // TODO add your handling code here:
        issue.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_issueMouseExited

    private void ReturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnMouseEntered
        // TODO add your handling code here:
        Return.setBackground(java.awt.Color.MAGENTA);
    }//GEN-LAST:event_ReturnMouseEntered

    private void ReturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReturnMouseExited
        // TODO add your handling code here:
        Return.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_ReturnMouseExited

    private void viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseEntered
        // TODO add your handling code here:
        view.setBackground(java.awt.Color.MAGENTA);
    }//GEN-LAST:event_viewMouseEntered

    private void viewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseExited
        // TODO add your handling code here:
         view.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_viewMouseExited

    private void ViewissueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewissueMouseEntered
        // TODO add your handling code here:
        Viewissue.setBackground(java.awt.Color.MAGENTA);
    }//GEN-LAST:event_ViewissueMouseEntered

    private void ViewissueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewissueMouseExited
        // TODO add your handling code here:
         Viewissue.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_ViewissueMouseExited

    private void listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseEntered
        // TODO add your handling code here:
        list.setBackground(java.awt.Color.MAGENTA);
    }//GEN-LAST:event_listMouseEntered

    private void listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseExited
        // TODO add your handling code here:
         list.setBackground(java.awt.Color.BLACK);
    }//GEN-LAST:event_listMouseExited

    private void manageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageMouseClicked
        // TODO add your handling code here:
        ManageBook book = new ManageBook();
        book.setVisible(true);
        dispose();
    }//GEN-LAST:event_manageMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        IssueBook book = new IssueBook();
        book.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
         ReturnBook book = new ReturnBook();
         book.setVisible(true);
         dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        ManageStudents s1 = new ManageStudents();
         s1.setVisible(true);
         dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        ViewAllRecord r = new ViewAllRecord();
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        ViewIssueBook issue = new ViewIssueBook();
        issue.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        DefaulterList defaulterlist = new DefaulterList();
        defaulterlist.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel13MouseClicked

    private void rSButtonHover1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonHover1MouseClicked
        // TODO add your handling code here:
        
        int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
        if(a==JOptionPane.YES_OPTION){
            SignUp_Page sp = new SignUp_Page();
            sp.setVisible(true);
            dispose();
            //User login class call.
        }
    }//GEN-LAST:event_rSButtonHover1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
       int b= JOptionPane.showConfirmDialog(null, "Are you want new user added?");
       if(b==JOptionPane.YES_OPTION){
           SignUp_Page sp = new SignUp_Page();
           sp.setVisible(true);
           dispose();
       }
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Return;
    private javax.swing.JPanel Viewissue;
    private javax.swing.JPanel dash;
    private javax.swing.JPanel home;
    private javax.swing.JPanel issue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_issueBook;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfStudents;
    private javax.swing.JPanel list;
    private javax.swing.JPanel manage;
    private javax.swing.JPanel panelPieChart;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private javax.swing.JPanel stu;
    private rojeru_san.complementos.RSTableMetro tbl_bookdetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentdetails;
    private javax.swing.JPanel view;
    // End of variables declaration//GEN-END:variables
}

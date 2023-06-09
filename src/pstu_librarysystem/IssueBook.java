/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pstu_librarysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Hasibur Rahman
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookID.getText());
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
             PreparedStatement pst = con.prepareStatement("select * from book_details where book_id=?");
             pst.setInt(1, bookId);
            ResultSet rs= pst.executeQuery();
            
            if(rs.next()){
                
                lbl_bookid.setText(rs.getString("book_id"));
                lbl_bookname.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            }else{
                
                lbl_bookError.setText("Invalid Book ID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
    
    
    
     public void getStudentDetails(){
        int studentId = Integer.parseInt(txt_studentid.getText());
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
             PreparedStatement pst = con.prepareStatement("select * from student_details where student_id=?");
             pst.setInt(1, studentId);
            ResultSet rs= pst.executeQuery();
            
            if(rs.next()){
                
                lbl_studentid.setText(rs.getString("student_id"));
                lbl_studentname.setText(rs.getString("student_name"));
                lbl_faculty.setText(rs.getString("course"));
                lbl_session.setText(rs.getString("session"));
            }else{
                lbl_studentError.setText("Invalid Student ID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    
     public boolean issueBook(){
         boolean isIssued = false;
         int bookId = Integer.parseInt(txt_bookID.getText());
         int studentId = Integer.parseInt(txt_studentid.getText());
         String bookName = lbl_bookname.getText();
         String studentName = lbl_studentname.getText();
         
         Date uIssueDate = date_issue.getDatoFecha();
         Date uDueDate = date_due.getDatoFecha();
         
         Long l1 = uIssueDate.getTime();
         long l2 = uDueDate.getTime();
         
         java.sql.Date sIssueDate = new java.sql.Date(l1);
         java.sql.Date sDueDate = new java.sql.Date(l2);
         
         try{
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
               String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status)values(?,?,?,?,?,?,?)";
               PreparedStatement pst = con.prepareStatement(sql);
               pst.setInt(1, bookId);
               pst.setString(2, bookName);
               pst.setInt(3, studentId);
               pst.setString(4, studentName);
               pst.setDate(5, sIssueDate);
               pst.setDate(6, sDueDate);
               pst.setString(7, "pending");
               
              int rowCount = pst.executeUpdate();
              if(rowCount >0 ){
                  isIssued = true;
              }else{
                  isIssued = false;
              }
         }catch(Exception e){
             e.printStackTrace();
         }
         return isIssued;
     }
     
     //Updating Book Count
     public void updateBookCount(){
        
         int bookId = Integer.parseInt(txt_bookID.getText());
         try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
              String sql = "update book_details set quantity = quantity-1 where book_id=?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1, bookId);
               int rowCount = pst.executeUpdate();
              if(rowCount >0 ){
                 JOptionPane.showMessageDialog(this, "Book count Updated");
                 int initialCount = Integer.parseInt(lbl_quantity.getText());
                 lbl_quantity.setText(Integer.toString(initialCount-1));
              }else{
                 JOptionPane.showMessageDialog(this, "Can't Update Book count.\nPlease try again ");
              }
         }catch(Exception e){
             e.printStackTrace();
         }
         
     }
     
     //Checking wheather book already allocated or not
     public boolean isAlreadyIssued(){
         
         boolean isAlreadyIssued =false;
         int bookId = Integer.parseInt(txt_bookID.getText());
         int studentId = Integer.parseInt(txt_studentid.getText());
         
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
              String sql = "select * from issue_book_details where book_id=? and student_id and status=?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1, bookId);
              pst.setInt(2, studentId);
            //  pst.setString(3, "pending");
              
              ResultSet rs =pst.executeQuery();
              if(rs.next() ){
                  isAlreadyIssued=true;
              }else{
                  isAlreadyIssued=false;
              }
         }catch(Exception e){
             e.printStackTrace();
         }
         return isAlreadyIssued;
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSButtonHover2 = new rojerusan.RSButtonHover();
        jLabel1 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_bookid = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_session = new javax.swing.JLabel();
        lbl_faculty = new javax.swing.JLabel();
        lbl_studentid = new javax.swing.JLabel();
        lbl_studentname = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_bookID = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        date_issue = new rojeru_san.componentes.RSDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        date_due = new rojeru_san.componentes.RSDateChooser();
        Issue_Book = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(167, 12, 241)));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonHover2.setBackground(new java.awt.Color(167, 12, 241));
        rSButtonHover2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Rewind_48px.png"))); // NOI18N
        rSButtonHover2.setText("Back");
        rSButtonHover2.setColorHover(new java.awt.Color(0, 153, 0));
        rSButtonHover2.setColorTextHover(new java.awt.Color(255, 255, 0));
        rSButtonHover2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Book Details");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 350, 90));

        lbl_bookError.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel2.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, 300, 30));

        lbl_quantity.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 640, 190, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 140, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Author :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 140, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book ID :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 110, 30));

        lbl_bookid.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_bookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 170, 30));

        lbl_bookname.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 260, 30));

        lbl_author.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 310, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Quantity :");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 140, 30));

        main_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 810));

        jPanel1.setBackground(new java.awt.Color(167, 12, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_session.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_session.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_session, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 650, 190, 30));

        lbl_faculty.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_faculty.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_faculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 280, 30));

        lbl_studentid.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_studentid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 160, 30));

        lbl_studentname.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_studentname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 240, 30));

        lbl_studentError.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 720, 320, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Student ID :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 140, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Student Name :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 160, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Faculty :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 100, 30));

        jLabel12.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel12.setText("Student Details");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 90));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Session :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 100, 30));

        main_panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 460, 810));

        rSButtonHover1.setBackground(new java.awt.Color(167, 12, 241));
        rSButtonHover1.setText("X");
        rSButtonHover1.setColorHover(new java.awt.Color(255, 0, 51));
        rSButtonHover1.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        rSButtonHover1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonHover1MouseClicked(evt);
            }
        });
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        main_panel.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 60, -1));

        jLabel10.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel10.setText("Issue Books");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 0, 0)));
        main_panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 300, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Enter Book ID:");
        main_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 310, 140, 30));

        txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(167, 12, 241)));
        txt_bookID.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        txt_bookID.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        txt_bookID.setPlaceholder("Enter Book id...");
        txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIDFocusLost(evt);
            }
        });
        main_panel.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 290, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Enter issue Date:");
        main_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, 160, 30));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(167, 12, 241)));
        txt_studentid.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        txt_studentid.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        txt_studentid.setPlaceholder("Enter Students id...");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        main_panel.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 390, 260, 50));

        date_issue.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(167, 12, 241)));
        date_issue.setColorBackground(new java.awt.Color(167, 12, 241));
        date_issue.setColorButtonHover(new java.awt.Color(255, 0, 0));
        date_issue.setColorForeground(new java.awt.Color(102, 102, 102));
        date_issue.setPlaceholder("Select issue Date");
        main_panel.add(date_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 520, 260, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Enter Student ID:");
        main_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 410, 160, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Enter due Date:");
        main_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 650, 160, 30));

        date_due.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(167, 12, 241)));
        date_due.setColorBackground(new java.awt.Color(167, 12, 241));
        date_due.setColorButtonHover(new java.awt.Color(255, 0, 0));
        date_due.setColorForeground(new java.awt.Color(102, 102, 102));
        date_due.setPlaceholder("Select due Date");
        main_panel.add(date_due, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 640, 260, -1));

        Issue_Book.setBackground(new java.awt.Color(255, 0, 0));
        Issue_Book.setText("Issue a Book");
        Issue_Book.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Issue_Book.setFont(new java.awt.Font("Garamond", 1, 20)); // NOI18N
        Issue_Book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Issue_BookActionPerformed(evt);
            }
        });
        main_panel.add(Issue_Book, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 720, 290, 70));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1411, 803));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        // TODO add your handling code here:

        Home_Page home = new Home_Page();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonHover1MouseClicked

    }//GEN-LAST:event_rSButtonHover1MouseClicked

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void txt_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIDFocusLost
        // TODO add your handling code here:
        
        if(!txt_bookID.getText().equals("")){
            getBookDetails();
        }
        
        
    }//GEN-LAST:event_txt_bookIDFocusLost

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        // TODO add your handling code here:
         if(!txt_studentid.getText().equals("")){
            getStudentDetails();
        }
        
    }//GEN-LAST:event_txt_studentidFocusLost

    private void Issue_BookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Issue_BookActionPerformed
     
        if(lbl_quantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this,"Book is not available");
            
        }else{
            if(isAlreadyIssued()==false){
            
             if(issueBook()== true) {
         JOptionPane.showMessageDialog(this,"Book Issued successfully");
         updateBookCount();
     }else{
        JOptionPane.showMessageDialog(this,"Sry!!Can't  Issue Book "); 
     }
        }else{
            
            JOptionPane.showMessageDialog(this,"This students already carry this book "); 
        }
            
        }
        
        
        
        
        
       
    }//GEN-LAST:event_Issue_BookActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Issue_Book;
    private rojeru_san.componentes.RSDateChooser date_due;
    private rojeru_san.componentes.RSDateChooser date_issue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_faculty;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_session;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentid;
    private javax.swing.JLabel lbl_studentname;
    private javax.swing.JPanel main_panel;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSButtonHover rSButtonHover2;
    private app.bolivia.swing.JCTextField txt_bookID;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}

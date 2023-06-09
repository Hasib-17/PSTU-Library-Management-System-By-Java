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
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }

//to fetch the issue book details from the database and display it to panel
    public void getIssueBookDetails(){
        
        int bookId = Integer.parseInt(txt_bookID.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
              String sql = "select * from issue_book_details where book_id=? and student_id=? and status =?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1, bookId);
              pst.setInt(2, studentId);
              pst.setString(3, "pending");
              
             ResultSet rs= pst.executeQuery();
             if(rs.next()){
                 
                 lbl_bookid.setText(rs.getString("id"));
                 lbl_bookname.setText(rs.getString("book_name"));
                 lbl_studentName.setText(rs.getString("student_name"));
                 lbl_issueDaate.setText(rs.getString("issue_date"));
                 lbl_dueDate.setText(rs.getString("due_date"));
                 lbl_bookError.setText("");
             }else{
                 lbl_bookError.setText("No Record Found..");
                 lbl_bookid.setText("");
                 lbl_bookname.setText("");
                 lbl_studentName.setText("");
                 lbl_issueDaate.setText("");
                 lbl_dueDate.setText("");
                 
             }
        }catch(Exception e){
            
            e.printStackTrace();
        }
        
    }
    
    //Return the book
    public boolean returnBook(){
        boolean isReturned = false;
        int bookId = Integer.parseInt(txt_bookID.getText());
        int studentId = Integer.parseInt(txt_studentid.getText());
        
        try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
              String sql = "update issue_book_details set status = ? where book_id=? and student_id=? and status =?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setString(1, "returned");
              pst.setInt(2, bookId);
              pst.setInt(3, studentId);
              pst.setString(4, "pending");
              
             int rowCount = pst.executeUpdate();
             if(rowCount >0){
                isReturned = true; 
             }else{
                 isReturned = false;
             }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isReturned;
    }
    


     
     //Updating Book Count
     public void updateBookCount(){
        
         int bookId = Integer.parseInt(txt_bookID.getText());
         try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
              String sql = "update book_details set quantity = quantity+1 where book_id=?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1, bookId);
               int rowCount = pst.executeUpdate();
              if(rowCount >0 ){
                 JOptionPane.showMessageDialog(this, "Book count Updated");
                 
              }else{
                 JOptionPane.showMessageDialog(this, "Can't Update Book count.\nPlease try again ");
              }
         }catch(Exception e){
             e.printStackTrace();
         }
         
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
        jLabel1 = new javax.swing.JLabel();
        lbl_issueDaate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_bookid = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_dueDate = new javax.swing.JLabel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_bookID = new app.bolivia.swing.JCTextField();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        Find_Book = new rojerusan.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        rSButtonHover2 = new rojerusan.RSButtonHover();
        Return_Book = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(167, 12, 241)));
        main_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(167, 12, 241));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel1.setText("Book Details");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 350, 90));

        lbl_issueDaate.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_issueDaate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_issueDaate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 680, 260, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Book Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 140, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student name:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 160, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Book ID :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 110, 30));

        lbl_bookid.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_bookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 280, 30));

        lbl_bookname.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 370, 30));

        lbl_studentName.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 350, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Issue Date:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 680, 140, 30));

        lbl_bookError.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 890, 420, 40));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Due Date:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 780, 140, 30));

        lbl_dueDate.setFont(new java.awt.Font("Times New Roman", 0, 25)); // NOI18N
        lbl_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 780, 320, 30));

        rSButtonHover1.setBackground(new java.awt.Color(255, 51, 0));
        rSButtonHover1.setText("X");
        rSButtonHover1.setColorHover(new java.awt.Color(167, 12, 241));
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
        jPanel2.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 80, -1));

        main_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, 770, 1030));

        jLabel10.setFont(new java.awt.Font("Impact", 0, 45)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel10.setText("Return Books");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 6, 0, new java.awt.Color(255, 0, 0)));
        main_panel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 340, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Enter Book ID:");
        main_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 720, 180, 30));

        txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(167, 12, 241)));
        txt_bookID.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        txt_bookID.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        txt_bookID.setPlaceholder("Enter Book id...");
        txt_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIDFocusLost(evt);
            }
        });
        main_panel.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 700, 260, 50));

        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(167, 12, 241)));
        txt_studentid.setDisabledTextColor(new java.awt.Color(255, 51, 51));
        txt_studentid.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        txt_studentid.setPlaceholder("Enter Students id...");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        main_panel.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 800, 260, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Enter Student ID:");
        main_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 820, 200, 30));

        Find_Book.setBackground(new java.awt.Color(255, 0, 0));
        Find_Book.setText("Find a Book");
        Find_Book.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Find_Book.setFont(new java.awt.Font("Garamond", 1, 20)); // NOI18N
        Find_Book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Find_BookActionPerformed(evt);
            }
        });
        main_panel.add(Find_Book, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 900, 290, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/library-2.png"))); // NOI18N
        main_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 960, 550));

        rSButtonHover2.setBackground(new java.awt.Color(167, 12, 241));
        rSButtonHover2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Rewind_48px.png"))); // NOI18N
        rSButtonHover2.setText("Back");
        rSButtonHover2.setColorHover(new java.awt.Color(255, 0, 0));
        rSButtonHover2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        main_panel.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        Return_Book.setBackground(new java.awt.Color(255, 0, 0));
        Return_Book.setText("Return a Book");
        Return_Book.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Return_Book.setFont(new java.awt.Font("Garamond", 1, 20)); // NOI18N
        Return_Book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Return_BookActionPerformed(evt);
            }
        });
        main_panel.add(Return_Book, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 900, 290, 70));

        getContentPane().add(main_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1940, 1030));

        setSize(new java.awt.Dimension(1942, 1024));
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
        
        
        
        
    }//GEN-LAST:event_txt_bookIDFocusLost

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txt_studentidFocusLost

    private void Find_BookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Find_BookActionPerformed
     
   getIssueBookDetails();
        
       
    }//GEN-LAST:event_Find_BookActionPerformed

    private void Return_BookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Return_BookActionPerformed
        // TODO add your handling code here:
        if(returnBook()== true){
            
            JOptionPane.showMessageDialog(this, "Book returned Successfully..");
            updateBookCount();
        }else{
            JOptionPane.showMessageDialog(this, "Book returned Failed..");
        }
    }//GEN-LAST:event_Return_BookActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Find_Book;
    private rojerusan.RSMaterialButtonCircle Return_Book;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_dueDate;
    private javax.swing.JLabel lbl_issueDaate;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel main_panel;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSButtonHover rSButtonHover2;
    private app.bolivia.swing.JCTextField txt_bookID;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}

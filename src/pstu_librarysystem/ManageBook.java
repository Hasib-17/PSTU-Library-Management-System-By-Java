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
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Hasibur Rahman
 */
public class ManageBook extends javax.swing.JFrame {

    /**
     * Creates new form ManageBook
     */
    
             String book_name,author;
             int book_id,quantity;
             int rowCount;
             DefaultTableModel model;
    public ManageBook() {
        initComponents();
        
        setBookDetails();
        
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
    // To add book to book details table
    public boolean addBook(){
        boolean isAdded = false;
        book_id = Integer.parseInt(txt_bookID.getText());
        book_name = txt_bookname.getText();
        author = txt_author.getText();
        quantity = Integer.parseInt(txt_quantity.getText());
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
           // String sql = "insert into book_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement("insert into book_details(book_id,book_name,author,quantity)values(?,?,?,?)");
            pst.setInt(1, book_id);
            pst.setString(2, book_name);
            pst.setString(3, author);
            pst.setInt(4, quantity);
            
           rowCount = pst.executeUpdate();
           if(rowCount > 0){
               isAdded=true;
           }
           else{
               isAdded = false;
           }  
        }catch(Exception e){
            e.printStackTrace();
        }
        return isAdded;
    }
    
    //To update Book details
    
    public boolean updateBook(){
       boolean isUpdated = false;
        book_id = Integer.parseInt(txt_bookID.getText());
        book_name = txt_bookname.getText();
        author = txt_author.getText();
        quantity = Integer.parseInt(txt_quantity.getText());  
        
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
            String sql = "update book_details set book_name = ?,author = ?, quantity =? where book_id=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, book_name);
            pst.setString(2, author);
            pst.setInt(3, quantity);
            pst.setInt(4, book_id);
            
           int rowCount = pst.executeUpdate();
           if(rowCount > 0){
               isUpdated =true;
           }
           else{
               isUpdated = false;
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isUpdated;
    }
    
    //method to delete  book details
    public boolean deleteBook(){
        boolean isDeleted = false;
        book_id = Integer.parseInt(txt_bookID.getText());
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
            String sql = "delete from book_details where book_id=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            
           int rowCount= pst.executeUpdate();
           if(rowCount > 0){
               isDeleted = true;
           }else{
               
               isDeleted = false;
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return isDeleted;
    }
    
    
    
    
    //Method to clear table
    
    public void ClearTable(){
       DefaultTableModel model = (DefaultTableModel) tbl_bookdetails.getModel();
       model.setRowCount(0);
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
        txt_bookID = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_bookname = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_author = new app.bolivia.swing.JCTextField();
        txt_quantity = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Delete = new rojerusan.RSMaterialButtonCircle();
        Add = new rojerusan.RSMaterialButtonCircle();
        Update = new rojerusan.RSMaterialButtonCircle();
        rSButtonHover2 = new rojerusan.RSButtonHover();
        jPanel2 = new javax.swing.JPanel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel9 = new javax.swing.JLabel();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(167, 12, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_bookID.setBackground(new java.awt.Color(167, 12, 241));
        txt_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        txt_bookID.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        txt_bookID.setPlaceholder("Enter Book id...");
        jPanel1.add(txt_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 280, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter Book ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 30, 30));

        txt_bookname.setBackground(new java.awt.Color(167, 12, 241));
        txt_bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        txt_bookname.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        txt_bookname.setPlaceholder("Enter Book Name...");
        jPanel1.add(txt_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 280, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Book Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 210, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 210, 30));

        txt_author.setBackground(new java.awt.Color(167, 12, 241));
        txt_author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        txt_author.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        txt_author.setPlaceholder("Author Name...");
        jPanel1.add(txt_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 280, 50));

        txt_quantity.setBackground(new java.awt.Color(167, 12, 241));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        txt_quantity.setPlaceholder("Quantity...");
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 280, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, -1, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quantity");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 210, 30));

        Delete.setBackground(new java.awt.Color(255, 0, 51));
        Delete.setText("delete");
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 700, 140, 60));

        Add.setBackground(new java.awt.Color(255, 0, 51));
        Add.setText("ADD");
        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        Add.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jPanel1.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 140, 60));

        Update.setBackground(new java.awt.Color(255, 0, 51));
        Update.setText("Update");
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        Update.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        Update.setRippleColor(new java.awt.Color(255, 255, 0));
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 700, 140, 60));

        rSButtonHover2.setBackground(new java.awt.Color(204, 0, 51));
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
        jPanel1.add(rSButtonHover2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 840));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(rSButtonHover1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 60, -1));

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
        tbl_bookdetails.setColorFilasForeground1(new java.awt.Color(167, 12, 241));
        tbl_bookdetails.setColorFilasForeground2(new java.awt.Color(167, 12, 241));
        tbl_bookdetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_bookdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookdetails.setRowHeight(40);
        tbl_bookdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookdetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 920, 250));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel9.setText("Manage  Books");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 51, 0)));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 340, 50));

        rSButtonHover3.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonHover3.setText("Go to Bongobondhu Corner>>");
        rSButtonHover3.setColorHover(new java.awt.Color(167, 12, 241));
        rSButtonHover3.setColorText(new java.awt.Color(167, 12, 241));
        rSButtonHover3.setFont(new java.awt.Font("Times New Roman", 1, 44)); // NOI18N
        rSButtonHover3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonHover3MouseClicked(evt);
            }
        });
        jPanel2.add(rSButtonHover3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, 650, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 1070, 840));

        setSize(new java.awt.Dimension(1724, 836));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        // TODO add your handling code here:
       
         Home_Page home = new Home_Page();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonHover1MouseClicked
       
    }//GEN-LAST:event_rSButtonHover1MouseClicked

    private void tbl_bookdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookdetailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_bookdetails.getSelectedRow();
        TableModel model = tbl_bookdetails.getModel();
        txt_bookID.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookname.setText(model.getValueAt(rowNo, 1).toString());
        txt_author.setText(model.getValueAt(rowNo, 2).toString());
        txt_quantity.setText(model.getValueAt(rowNo, 2).toString());
        
    }//GEN-LAST:event_tbl_bookdetailsMouseClicked

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        try{
            if(addBook()== true){
            JOptionPane.showMessageDialog(this, "Book Added");
            ClearTable();
            setBookDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "Book Addition Failed");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
         try{
            if(updateBook()== true){
            JOptionPane.showMessageDialog(this, "Book Updated");
            ClearTable();
            setBookDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "Book Updation Failed");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
         try{
            if(deleteBook()== true){
            JOptionPane.showMessageDialog(this, "Book Deleted");
            ClearTable();
            setBookDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "Book Deletion Failed");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_DeleteActionPerformed

    private void rSButtonHover3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonHover3MouseClicked
        // TODO add your handling code here:
        BongobondhuCorner bn = new BongobondhuCorner();
        bn.setVisible(true);
        dispose();
    }//GEN-LAST:event_rSButtonHover3MouseClicked

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
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Add;
    private rojerusan.RSMaterialButtonCircle Delete;
    private rojerusan.RSMaterialButtonCircle Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSButtonHover rSButtonHover1;
    private rojerusan.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.complementos.RSTableMetro tbl_bookdetails;
    private app.bolivia.swing.JCTextField txt_author;
    private app.bolivia.swing.JCTextField txt_bookID;
    private app.bolivia.swing.JCTextField txt_bookname;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}

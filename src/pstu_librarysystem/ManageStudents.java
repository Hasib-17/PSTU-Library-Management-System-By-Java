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
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBook
     */
    
             String student_name,course,session;
             int student_id;
             int rowCount;
             DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        
        setStudentDetails();
        
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
    // To add book to student details table
    public boolean addStudent(){
        boolean isAdded = false;
        student_id = Integer.parseInt(txt_studentID.getText());
        student_name = txt_studentname.getText();
        course = combo_course.getSelectedItem().toString();
        session = combo_session.getSelectedItem().toString();
        
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
           // String sql = "insert into book_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement("insert into student_details(student_id,student_name,course,session)values(?,?,?,?)");
            pst.setInt(1, student_id);
            pst.setString(2, student_name);
            pst.setString(3, course);
            pst.setString(4, session);
            
            
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
    
    //To update student details
    
    public boolean updateStudent(){
       boolean isUpdated = false;
        student_id = Integer.parseInt(txt_studentID.getText());
        student_name = txt_studentname.getText();
        course = combo_course.getSelectedItem().toString();
        session = combo_session.getSelectedItem().toString();
         
        
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
            String sql = "update student_details set student_name = ?,course = ?, session =? where student_id=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, student_name);
            pst.setString(2, course);
            pst.setString(3, session);
            pst.setInt(4, student_id);
            
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
    
    //method to delete  student details
    public boolean deleteStudent(){
        boolean isDeleted = false;
        student_id = Integer.parseInt(txt_studentID.getText());
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pstu_library","root","");
            String sql = "delete from student_details where student_id=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_id);
            
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
       DefaultTableModel model = (DefaultTableModel) tbl_studentdetails.getModel();
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
        txt_studentID = new app.bolivia.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_studentname = new app.bolivia.swing.JCTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Delete = new rojerusan.RSMaterialButtonCircle();
        Add = new rojerusan.RSMaterialButtonCircle();
        Update = new rojerusan.RSMaterialButtonCircle();
        rSButtonHover2 = new rojerusan.RSButtonHover();
        combo_session = new rojerusan.RSComboMetro();
        combo_course = new rojerusan.RSComboMetro();
        jPanel2 = new javax.swing.JPanel();
        rSButtonHover1 = new rojerusan.RSButtonHover();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(167, 12, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_studentID.setBackground(new java.awt.Color(167, 12, 241));
        txt_studentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        txt_studentID.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentID.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_studentID.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_studentID.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        txt_studentID.setPlaceholder("Enter student id...");
        jPanel1.add(txt_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 280, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter Student ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 30, 30));

        txt_studentname.setBackground(new java.awt.Color(167, 12, 241));
        txt_studentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 255, 255)));
        txt_studentname.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentname.setCaretColor(new java.awt.Color(255, 255, 255));
        txt_studentname.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_studentname.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        txt_studentname.setPlaceholder("Enter Students Name...");
        jPanel1.add(txt_studentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 280, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter Student Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 210, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 210, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, -1, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Session");
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

        combo_session.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2020-2021", "2019-2020", "2018-2019", "2017-2018", "2016-2017", "2015-2016", "2014-2015", "2013-2014", "2012-2013", "2011-2012", "2010-2011", "2009-2010" }));
        combo_session.setColorArrow(new java.awt.Color(167, 12, 241));
        combo_session.setColorBorde(new java.awt.Color(255, 255, 255));
        combo_session.setColorFondo(new java.awt.Color(167, 12, 241));
        combo_session.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(combo_session, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 280, -1));

        combo_course.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "B.Sc in CSE", "B.Sc in Agriculture", "B.Sc in BA", "B.Sc in Fisherise", "B.Sc in LLA", "B.Sc in ESDM", "B.Sc in NFS", "M.Sc in CSIT", "M.Sc in Agriculture", "M.Sc in BA", "M.Sc in EEE", " " }));
        combo_course.setColorArrow(new java.awt.Color(167, 12, 241));
        combo_course.setColorBorde(new java.awt.Color(255, 255, 255));
        combo_course.setColorFondo(new java.awt.Color(167, 12, 241));
        combo_course.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 280, -1));

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

        tbl_studentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Course Name", "Session"
            }
        ));
        tbl_studentdetails.setColorBackgoundHead(new java.awt.Color(167, 12, 241));
        tbl_studentdetails.setColorBordeFilas(new java.awt.Color(167, 12, 241));
        tbl_studentdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentdetails.setColorFilasForeground1(new java.awt.Color(167, 12, 241));
        tbl_studentdetails.setColorFilasForeground2(new java.awt.Color(167, 12, 241));
        tbl_studentdetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_studentdetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentdetails.setRowHeight(40);
        tbl_studentdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentdetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 920, 250));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 43)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/adminIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel9.setText("Manage  Students");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(255, 51, 0)));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 470, 90));

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

    private void tbl_studentdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentdetailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_studentdetails.getSelectedRow();
        TableModel model = tbl_studentdetails.getModel();
        txt_studentID.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentname.setText(model.getValueAt(rowNo, 1).toString());
        combo_course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_session.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
        
    }//GEN-LAST:event_tbl_studentdetailsMouseClicked

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        try{
            if(addStudent()== true){
            JOptionPane.showMessageDialog(this, "Student information Added");
            ClearTable();
            setStudentDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "Students Addition Failed");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
         try{
            if(updateStudent()== true){
            JOptionPane.showMessageDialog(this, "Students info Updated");
            ClearTable();
            setStudentDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "Students Updation Failed");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
         try{
            if(deleteStudent()== true){
            JOptionPane.showMessageDialog(this, "Students info Deleted");
            ClearTable();
            setStudentDetails();
        }
        else{
            JOptionPane.showMessageDialog(this, "Students Deletion Failed");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Add;
    private rojerusan.RSMaterialButtonCircle Delete;
    private rojerusan.RSMaterialButtonCircle Update;
    private rojerusan.RSComboMetro combo_course;
    private rojerusan.RSComboMetro combo_session;
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
    private rojeru_san.complementos.RSTableMetro tbl_studentdetails;
    private app.bolivia.swing.JCTextField txt_studentID;
    private app.bolivia.swing.JCTextField txt_studentname;
    // End of variables declaration//GEN-END:variables
}

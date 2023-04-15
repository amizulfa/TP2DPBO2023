/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package komponen;

import Class.ImageFunction;
import Main.Beranda;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Class.dbConnection;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
/**
 *
 * @author User
 */
public class formKategori extends javax.swing.JFrame {
    private int id_kategori;
    private String nama_kategori;
    private String gambar;
    private Beranda br;
    ImageFunction imgHandler = new ImageFunction();
    static dbConnection db = new dbConnection();
    private File myImg;
    private File selFile;
    /**
     * Creates new form formEdit
     */
    public formKategori(Beranda br) {
        initComponents();
        this.br = br;
        setAddForm();
    }
    
    public formKategori(int id, Beranda br) {
        initComponents();
        this.id_kategori = id;
        this.br = br;
        setEditForm();
    }
    
    public void setKategori(){
        try{
            String sql = "SELECT * FROM kategori WHERE id_kategori = '"+this.id_kategori+"'";
            ResultSet res = db.selectQuery(sql);
            while(res.next()){
                this.id_kategori = res.getInt("id_kategori");
                this.nama_kategori = res.getString("nama_kategori");
                this.gambar = res.getString("gambar");
                BufferedImage fileImg = null;
                this.myImg = new File("src/image/Kategori/"+res.getString("gambar"));
                fileImg = ImageIO.read(this.myImg);
                Image dimg = fileImg.getScaledInstance(90, 120,ImageFunction.SCALE_SMOOTH);
                LabelGambar.setIcon(new javax.swing.ImageIcon(dimg));
            }            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(formKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setAddForm(){
        labelJudul.setText("Form Tambah Data Kategori");
        btnAdd.setVisible(true);
        btnEdit.setVisible(false);
    }
    
    public void setEditForm(){
        setKategori();
        btnAdd.setVisible(false);
        btnClear.setVisible(false);
        labelJudul.setText("Form Update Data Kategori");
        upNamaKategori.setText(this.nama_kategori);
        labelImg.setText(this.gambar);
    }
    
    public void uploadImg(String img){
         try {
            Path copied = Paths.get("src/image/Kategori/"+img);
            Path originalPath = Paths.get(imgHandler.getFile().getAbsolutePath());
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException e) {
              JOptionPane.showMessageDialog(null, e.getMessage());
              e.printStackTrace();
          }
    }
    
    public void clearForm(){
        upNamaKategori.setText("");
        labelImg.setText("");
        imgHandler = new ImageFunction();
        LabelGambar.setIcon(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelJudul = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        upNamaKategori = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        labelImg = new javax.swing.JLabel();
        LabelGambar = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        labelJudul.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        labelJudul.setForeground(new java.awt.Color(0, 0, 0));
        labelJudul.setText("Form Kategori");
        getContentPane().add(labelJudul);
        labelJudul.setBounds(100, 10, 220, 21);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Nama Kategori");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 42, 86, 16);

        upNamaKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upNamaKategoriActionPerformed(evt);
            }
        });
        getContentPane().add(upNamaKategori);
        upNamaKategori.setBounds(40, 64, 320, 28);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Foto Kategori");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(42, 104, 80, 16);

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(42, 130, 91, 28);

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setForeground(new java.awt.Color(0, 0, 0));
        btnClear.setText("Cancel");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear);
        btnClear.setBounds(242, 296, 73, 28);

        btnAdd.setBackground(new java.awt.Color(0, 0, 204));
        btnAdd.setText("Submit");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(163, 296, 73, 28);

        btnEdit.setBackground(new java.awt.Color(51, 255, 0));
        btnEdit.setForeground(new java.awt.Color(0, 0, 0));
        btnEdit.setText("Update");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(78, 296, 73, 28);

        labelImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labelImg);
        labelImg.setBounds(145, 200, 215, 28);

        LabelGambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(LabelGambar);
        LabelGambar.setBounds(42, 170, 91, 108);

        btnReset.setBackground(new java.awt.Color(255, 255, 0));
        btnReset.setForeground(new java.awt.Color(0, 0, 0));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset);
        btnReset.setBounds(321, 296, 73, 28);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Downloads\\download1.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 340);

        setSize(new java.awt.Dimension(414, 376));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void upNamaKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upNamaKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_upNamaKategoriActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        nama_kategori = upNamaKategori.getText();
        if((nama_kategori != null)){
            if(imgHandler.getFile()!=null){
                uploadImg(this.gambar);
                
            }
            int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin mengubah data ini ?", "Edit Data", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION){
                try{
                    String sql = "UPDATE `kategori` SET nama_kategori = '"+nama_kategori+"' WHERE id_kategori = '"+id_kategori+"'";
                    db.updateQuery(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    clearForm();
                    this.br.setPanel();
                    this.dispose();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lengkapi Form", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        nama_kategori = upNamaKategori.getText();
        if((nama_kategori != null) &&(imgHandler.getFile() != null)){
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
            this.gambar = ft.format(dNow)+"_"+imgHandler.getFile().getName();
            
            try{
                uploadImg(this.gambar);
                String sql = "INSERT INTO `kategori` ( `nama_kategori`, `gambar`) VALUES ( '"+nama_kategori+"','"+gambar+"')";
                db.updateQuery(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                this.br.setPanel();
                
                this.dispose();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lengkapi Form", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            // TODO add your handling code here:
            imgHandler.Browse();
            //menampilkan path gambar
            labelImg.setText(imgHandler.getPath());
            
            //menampilkan gambar
            Image see = ImageIO.read(imgHandler.getFile());
            LabelGambar.setIcon(new ImageIcon(see.getScaledInstance(90, 120, Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            Logger.getLogger(formKategori.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(formKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelGambar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelImg;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JTextField upNamaKategori;
    // End of variables declaration//GEN-END:variables
}

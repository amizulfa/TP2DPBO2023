/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package komponen;

import Class.ImageFunction;
import komponen.formKategori;
import Main.Beranda;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import komponen.formProduk;
import Class.dbConnection;
/**
 *
 * @author User
 */
public class CardKategori extends javax.swing.JPanel {
    private final int id;
    private boolean isKategori = true;
    static dbConnection db = new dbConnection();
    private Beranda br;
    private File myImg;
    /**
     * Creates new form Card
     * @param id
     * @param isKategori
     * @param br
     */

    public CardKategori(int id, Beranda br) {
        initComponents();
        this.id = id;
        this.br = br;
        setKategori();

    }
    
    public void setKategori(){
        try{
            String sql = "SELECT * FROM kategori WHERE id_kategori = '"+this.id+"'";
            ResultSet res = db.selectQuery(sql);
            while(res.next()){
                labelKategori.setText(res.getString("nama_kategori"));
                BufferedImage fileImg = null;
                this.myImg = new File("src/image/Kategori/"+res.getString("gambar"));
                fileImg = ImageIO.read(this.myImg);
                Image dimg = fileImg.getScaledInstance(90, 120,ImageFunction.SCALE_SMOOTH);
                img.setIcon(new javax.swing.ImageIcon(dimg));
                
            }            
        }catch(SQLException|IOException e){
            System.out.println(e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        labelKategori = new javax.swing.JLabel();
        buttonEdit = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        img = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nama Kategori");

        labelKategori.setForeground(new java.awt.Color(0, 0, 0));
        labelKategori.setText("jLabel3");

        buttonEdit.setBackground(new java.awt.Color(0, 0, 255));
        buttonEdit.setText("Edit");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonHapus.setBackground(new java.awt.Color(255, 0, 0));
        buttonHapus.setText("Hapus");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(labelKategori)
                        .addContainerGap(129, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonHapus)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEdit)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelKategori))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonEdit)
                            .addComponent(buttonHapus)))
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        // TODO add your handling code here:
        if(isKategori){
            formKategori fk = new formKategori(this.id, this.br);
            fk.setVisible(true);
        }else{
            formProduk fp = new formProduk(this.id, this.br);
            fp.setVisible(true);
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Delete Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM produk WHERE id_kategori="+id;
            db.updateQuery(sql);
            
            sql = "DELETE from kategori WHERE id_kategori="+id;
            db.updateQuery(sql);
            try {
                // TODO add your handling code here:
                
                if(myImg != null) myImg.delete();
                this.br.setPanel();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_buttonHapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelKategori;
    // End of variables declaration//GEN-END:variables
}

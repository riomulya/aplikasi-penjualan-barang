package com.penjualan.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.penjualan.db.DatabaseConnection;
import com.penjualan.db.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Form_Input_Transaksi extends javax.swing.JPanel {

    public Form_Input_Transaksi() {
        initComponents();
        jumlahBeli.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Jumlah Beli");

        idTransaksi.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari Transaksi Berdasarkan ID");

        jumlahBeliUpdate.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Update Jumlah Beli");
        String cariPelanggan = "SELECT nama from pelanggan";

        String cariBarang = "SELECT nama from barang";
//        String cariPelanggan = ""
        Query.getDataListTransaksi(listBarang, cariBarang);
        Query.getDataListTransaksi(listPelanggan, cariPelanggan);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new com.penjualan.swing.PanelBorder();
        p1 = new javax.swing.JLabel();
        jumlahBeli = new javax.swing.JTextField();
        simpanBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        idTransaksi = new javax.swing.JTextField();
        jumlahBeliUpdate = new javax.swing.JTextField();
        p = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        listBarang = new javax.swing.JComboBox<>();
        listPelanggan = new javax.swing.JComboBox<>();
        listPelanggan1 = new javax.swing.JComboBox<>();
        listBarang1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(242, 242, 242));

        p1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 102, 102));
        p1.setText("Input Data Transaksi");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(p1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(p1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        simpanBtn.setText("Simpan");
        simpanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        idTransaksi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                idTransaksiCaretUpdate(evt);
            }
        });

        jumlahBeliUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBeliUpdateActionPerformed(evt);
            }
        });

        p.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p.setForeground(new java.awt.Color(255, 102, 102));
        p.setText("Update dan Delete Data Transaksi");

        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        listBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listPelanggan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listPelanggan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listBarang1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlahBeliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(listBarang1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(listPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updateBtn, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jumlahBeli)
                            .addComponent(listBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simpanBtn))
                    .addComponent(p))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(listPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpanBtn))
                .addGap(18, 18, 18)
                .addComponent(jumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(p)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(updateBtn)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listPelanggan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jumlahBeliUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
        int idBar = Query.getIdBarang(listBarang);

        int idPel = Query.getIdPelanggan(listPelanggan);
      
        if (idBar == 0 && idPel == 0) {
            JOptionPane.showMessageDialog(null, "Barang tidak ditemukan.", "Insert Data Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Query.insertDataTransaksi(idPel, idBar, Integer.parseInt(jumlahBeli.getText()));
    }//GEN-LAST:event_simpanBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE from transaksi_penjualan where id_transaksi = ?;";
        Query.deleteData(sql, Integer.parseInt(idTransaksi.getText()));
        idTransaksi.setText("");
        jumlahBeliUpdate.setText("");
        listBarang1.removeAllItems();
        listPelanggan1.removeAllItems();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        Query.updateDataTransaksi(Integer.parseInt(jumlahBeliUpdate.getText()),Integer.parseInt(idTransaksi.getText()));
    }//GEN-LAST:event_updateBtnActionPerformed

    private void jumlahBeliUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahBeliUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahBeliUpdateActionPerformed

    private void idTransaksiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_idTransaksiCaretUpdate
        // TODO add your handling code here:
        String idPel, idBar;
        if (idTransaksi.getText().isEmpty()) {
            jumlahBeliUpdate.setText("");
            listBarang1.removeAllItems();
            listPelanggan1.removeAllItems();
        }
        try {
            Connection c = DatabaseConnection.getConnection();
            Statement s = c.createStatement();
            String sql = "Select * from transaksi_penjualan where id_transaksi ='" + this.idTransaksi.getText() + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                jumlahBeliUpdate.setText(r.getString("jumlah"));
//                Query.getDataListBarangTransaksi(listBarang1);
//                Query.getDataListPelangganTransaksi(listPelanggan1);
                String getDataBarang = "SELECT nama FROM barang WHERE id_barang = '" + r.getString("id_barang") + "'";
                Query.getDataListTransaksi(listBarang1, getDataBarang);
                String getDataPelanggan = "SELECT nama FROM pelanggan WHERE id_pelanggan ='" + r.getString("id_pelanggan") + "'";
                Query.getDataListTransaksi(listPelanggan1, getDataPelanggan);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Pesan error: " + e.getMessage());
            System.out.println("Kode error: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
        }
    }//GEN-LAST:event_idTransaksiCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField idTransaksi;
    private javax.swing.JTextField jumlahBeli;
    private javax.swing.JTextField jumlahBeliUpdate;
    private javax.swing.JComboBox<String> listBarang;
    private javax.swing.JComboBox<String> listBarang1;
    private javax.swing.JComboBox<String> listPelanggan;
    private javax.swing.JComboBox<String> listPelanggan1;
    private javax.swing.JLabel p;
    private javax.swing.JLabel p1;
    private com.penjualan.swing.PanelBorder panelBorder2;
    private javax.swing.JButton simpanBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

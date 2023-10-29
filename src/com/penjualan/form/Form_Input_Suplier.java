package com.penjualan.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.penjualan.db.DatabaseConnection;
import com.penjualan.db.Query;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Form_Input_Suplier extends javax.swing.JPanel {

    public Form_Input_Suplier() {
        initComponents();

        kontakPemasok.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Kontak Pemasok");
        kontakPemasok1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Kontak Pemasok");

        alamatPemasok.setText("Alamat Pelanggan");

        alamatPemasok.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (alamatPemasok.getText().equals("Alamat Pelanggan")) {
                    alamatPemasok.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (alamatPemasok.getText().isEmpty()) {
                    alamatPemasok.setText("Alamat Pelanggan");
                }
            }
        });

        alamatPemasok1.setText("Alamat Pelanggan");

        alamatPemasok1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (alamatPemasok1.getText().equals("Alamat Pelanggan")) {
                    alamatPemasok1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (alamatPemasok1.getText().isEmpty()) {
                    alamatPemasok1.setText("Alamat Pelanggan");
                }
            }
        });

        namaPemasok.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Pemasok");
        namaPemasok1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Pemasok");
        idPemasok.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari Transaksi Berdasarkan ID");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new com.penjualan.swing.PanelBorder();
        p1 = new javax.swing.JLabel();
        namaPemasok = new javax.swing.JTextField();
        kontakPemasok = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatPemasok = new javax.swing.JTextArea();
        simpanBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        idPemasok = new javax.swing.JTextField();
        kontakPemasok1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamatPemasok1 = new javax.swing.JTextArea();
        p = new javax.swing.JLabel();
        namaPemasok1 = new javax.swing.JTextField();
        deleteBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));

        p1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 102, 102));
        p1.setText("Input Data Pemasok");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(207, 207, 207)
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

        alamatPemasok.setColumns(20);
        alamatPemasok.setRows(5);
        alamatPemasok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alamatPemasokFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(alamatPemasok);

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

        idPemasok.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                idPemasokCaretUpdate(evt);
            }
        });

        alamatPemasok1.setColumns(20);
        alamatPemasok1.setRows(5);
        alamatPemasok1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alamatPemasok1FocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(alamatPemasok1);

        p.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p.setForeground(new java.awt.Color(255, 102, 102));
        p.setText("Update dan Delete Data Pemasok");

        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(p))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(simpanBtn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(deleteBtn)
                                        .addGap(28, 28, 28)
                                        .addComponent(updateBtn))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(namaPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(kontakPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(idPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(kontakPemasok1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(namaPemasok1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(41, 41, 41)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 262, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(namaPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kontakPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(simpanBtn)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(p)
                        .addGap(49, 49, 49)
                        .addComponent(idPemasok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(namaPemasok1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(kontakPemasok1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(deleteBtn))
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
        Query.insertDataSupplier(namaPemasok.getText(), alamatPemasok.getText(), kontakPemasok.getText());
    }//GEN-LAST:event_simpanBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        String sql = "DELETE FROM pemasok WHERE id_pemasok = ?";
        Query.deleteData(sql, Integer.parseInt(idPemasok.getText()));
        namaPemasok1.setText("");
        kontakPemasok1.setText("");
        alamatPemasok1.setText("");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        Query.updateDataPemasok(Integer.parseInt(idPemasok.getText()), namaPemasok1.getText(), alamatPemasok1.getText(), kontakPemasok1.getText());
    }//GEN-LAST:event_updateBtnActionPerformed

    private void alamatPemasok1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamatPemasok1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatPemasok1FocusGained

    private void alamatPemasokFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamatPemasokFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatPemasokFocusGained

    private void idPemasokCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_idPemasokCaretUpdate
        // TODO add your handling code here:
        if (idPemasok.getText().isEmpty()) {
            namaPemasok1.setText("");
            kontakPemasok1.setText("");
            alamatPemasok1.setText("");
        }
        try {
            Connection c = DatabaseConnection.getConnection();
            Statement s = c.createStatement();
            String sql = "Select * from pemasok where id_pemasok ='" + this.idPemasok.getText() + "'";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                namaPemasok1.setText(r.getString("nama"));
                kontakPemasok1.setText(r.getString("kontak"));
                alamatPemasok1.setText(r.getString("alamat"));
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan" + e);
        }
    }//GEN-LAST:event_idPemasokCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatPemasok;
    private javax.swing.JTextArea alamatPemasok1;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField idPemasok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kontakPemasok;
    private javax.swing.JTextField kontakPemasok1;
    private javax.swing.JTextField namaPemasok;
    private javax.swing.JTextField namaPemasok1;
    private javax.swing.JLabel p;
    private javax.swing.JLabel p1;
    private com.penjualan.swing.PanelBorder panelBorder2;
    private javax.swing.JButton simpanBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

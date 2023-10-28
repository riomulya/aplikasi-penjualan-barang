package com.penjualan.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.penjualan.db.DatabaseConnection;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.UIManager;

public class Form_Input_Barang extends javax.swing.JPanel {

    public Form_Input_Barang() {
        initComponents();
        namaBarang.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Barang");
        hargaBarang.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Harga Barang");

        UIManager.put("TextArea.emptyText", "Deskripsi Barang");

        deskripsiBarang.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "kok gabisa");
        deskripsiBarang1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Deskripsi Barang");
        
        deskripsiBarang.setText("Deskripsi Barang");
        
        deskripsiBarang.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (deskripsiBarang.getText().equals("Deskripsi Barang")) {
                    deskripsiBarang.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (deskripsiBarang.getText().isEmpty()) {
                    deskripsiBarang.setText("Deskripsi Barang");
                }
            }
        });
        
        deskripsiBarang1.setText("Deskripsi Barang");
        
        deskripsiBarang1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (deskripsiBarang1.getText().equals("Deskripsi Barang")) {
                    deskripsiBarang1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (deskripsiBarang1.getText().isEmpty()) {
                    deskripsiBarang1.setText("Deskripsi Barang");
                }
            }
        });

        namaBarang1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Barang");
        idBarang.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Cari Barang Berdasarkan ID");
        hargaBarang1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Harga Barang");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new com.penjualan.swing.PanelBorder();
        p1 = new javax.swing.JLabel();
        namaBarang = new javax.swing.JTextField();
        hargaBarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        deskripsiBarang = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        idBarang = new javax.swing.JTextField();
        hargaBarang1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsiBarang1 = new javax.swing.JTextArea();
        p = new javax.swing.JLabel();
        namaBarang1 = new javax.swing.JTextField();
        deleteBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));

        p1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 102, 102));
        p1.setText("Input Data Barang");

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

        deskripsiBarang.setColumns(20);
        deskripsiBarang.setRows(5);
        deskripsiBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deskripsiBarangFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(deskripsiBarang);

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        idBarang.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                idBarangCaretUpdate(evt);
            }
        });

        deskripsiBarang1.setColumns(20);
        deskripsiBarang1.setRows(5);
        deskripsiBarang1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deskripsiBarang1FocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(deskripsiBarang1);

        p.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p.setForeground(new java.awt.Color(255, 102, 102));
        p.setText("Update dan Delete Data Barang");

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
                                .addGap(178, 178, 178)
                                .addComponent(p))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(deleteBtn)
                                        .addGap(28, 28, 28)
                                        .addComponent(updateBtn))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(hargaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(namaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(p)
                        .addGap(49, 49, 49)
                        .addComponent(idBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(namaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(hargaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deskripsiBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deskripsiBarangFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_deskripsiBarangFocusGained

    private void deskripsiBarang1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deskripsiBarang1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_deskripsiBarang1FocusGained

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBtnActionPerformed

    private void idBarangCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_idBarangCaretUpdate
        // TODO add your handling code here:
        
        try {
            Connection c = DatabaseConnection.getConnection();
            Statement s = c.createStatement();
            String sql = "Select * from barang where id_barang ='" + this.idBarang.getText() + "'";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
              namaBarang1.setText(r.getString("nama"));
              deskripsiBarang1.setText(r.getString("deskripsi"));
              hargaBarang1.setText(r.getString("harga"));
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Kesalahan" + e);
        }
    }//GEN-LAST:event_idBarangCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextArea deskripsiBarang;
    private javax.swing.JTextArea deskripsiBarang1;
    private javax.swing.JTextField hargaBarang;
    private javax.swing.JTextField hargaBarang1;
    private javax.swing.JTextField idBarang;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTextField namaBarang1;
    private javax.swing.JLabel p;
    private javax.swing.JLabel p1;
    private com.penjualan.swing.PanelBorder panelBorder2;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

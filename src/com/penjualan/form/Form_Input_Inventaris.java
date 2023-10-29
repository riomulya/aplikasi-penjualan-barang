package com.penjualan.form;

import com.formdev.flatlaf.FlatClientProperties;
import com.penjualan.db.DatabaseConnection;

import com.penjualan.db.Query;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Form_Input_Inventaris extends javax.swing.JPanel {

    public Form_Input_Inventaris() {
        initComponents();

        stokBarang.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Stok Barang");

        updateStok.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nama Barang");
        updateStok.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Update Stok Barang");

        Query.getDataListBarang(listBarang);
        Query.getDataListBarangInventaris(listBarang1);
        listBarang1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) listBarang1.getSelectedItem();
                    // Manipulasi komponen lain, seperti JTextField
                    int idBar = Query.getIdBarang(listBarang1);
                    if (idBar == 0) {
                        JOptionPane.showMessageDialog(null, "Id inventaris tidak ditemukan.", "Delete Data Gagal", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        Connection c = DatabaseConnection.getConnection();
                        Statement s = c.createStatement();
                        String sql = "Select * from inventaris_barang where id_barang ='" + idBar + "'";
                        ResultSet r = s.executeQuery(sql);

                        while (r.next()) {
                            updateStok.setText(r.getString("stok"));
                        }
                        r.close();
                        s.close();
                    } catch (SQLException er) {
                        System.out.println("Pesan error: " + er.getMessage());
                        System.out.println("Kode error: " + er.getErrorCode());
                        System.out.println("SQLState: " + er.getSQLState());
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new com.penjualan.swing.PanelBorder();
        p1 = new javax.swing.JLabel();
        stokBarang = new javax.swing.JTextField();
        simpanBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        p = new javax.swing.JLabel();
        updateStok = new javax.swing.JTextField();
        deleteBtn = new javax.swing.JButton();
        listBarang1 = new javax.swing.JComboBox<>();
        listBarang = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(242, 242, 242));

        p1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 102, 102));
        p1.setText("Input Data Stok Inventaris Barang");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(p1)
                .addContainerGap(261, Short.MAX_VALUE))
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

        p.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p.setForeground(new java.awt.Color(255, 102, 102));
        p.setText("Update dan Delete Stok Data Inventaris Barang");

        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        listBarang1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listBarang1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listBarang1ItemStateChanged(evt);
            }
        });
        listBarang1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                listBarang1MouseMoved(evt);
            }
        });
        listBarang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listBarang1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listBarang1MouseEntered(evt);
            }
        });
        listBarang1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                listBarang1CaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                listBarang1InputMethodTextChanged(evt);
            }
        });
        listBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listBarang1ActionPerformed(evt);
            }
        });

        listBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(updateStok, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(listBarang1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateBtn)
                                    .addComponent(deleteBtn)))
                            .addComponent(p))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(listBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stokBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(simpanBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(listBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpanBtn))
                .addGap(118, 118, 118)
                .addComponent(p)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn))
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void simpanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBtnActionPerformed
        // TODO add your handling code here:
        int idBar = Query.getIdBarang(listBarang);
        if (idBar == 0) {
            JOptionPane.showMessageDialog(null, "Barang tidak ditemukan.", "Insert Data Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Query.insertDataInventaris(idBar, Integer.parseInt(stokBarang.getText()));
        listBarang.removeItemAt(listBarang.getSelectedIndex());
        stokBarang.setText("");
    }//GEN-LAST:event_simpanBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int idBar = Query.getIdBarang(listBarang1);
        if (idBar == 0) {
            JOptionPane.showMessageDialog(null, "Id inventaris tidak ditemukan.", "Delete Data Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String sql = "DELETE from inventaris_barang where id_barang = ?;";
        Query.deleteData(sql, idBar);
        listBarang1.removeItemAt(listBarang1.getSelectedIndex());
//        System.out.println(lis);
        stokBarang.setText("");
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int idBar = Query.getIdBarang(listBarang1);
        if (idBar == 0) {
            JOptionPane.showMessageDialog(null, "Id inventaris tidak ditemukan.", "Delete Data Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Query.updateDataInventaris(Integer.parseInt(updateStok.getText()), idBar);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void listBarang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBarang1MouseClicked
        // TODO add your handling code here:
//        int idBar = Query.getIdBarang(listBarang1);
//        if (idBar == 0) {
//            JOptionPane.showMessageDialog(null, "Id inventaris tidak ditemukan.", "Delete Data Gagal", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        try {
//            Connection c = DatabaseConnection.getConnection();
//            Statement s = c.createStatement();
//            String sql = "Select * from inventaris_barang where id_barang ='" + idBar+ "'";
//            ResultSet r = s.executeQuery(sql);
//
//            while (r.next()) {
//                updateStok.setText(r.getString("stok"));
//            }
//            r.close();
//            s.close();
//        } catch (SQLException e) {
//            System.out.println("Pesan error: " + e.getMessage());
//            System.out.println("Kode error: " + e.getErrorCode());
//            System.out.println("SQLState: " + e.getSQLState());
//        }
    }//GEN-LAST:event_listBarang1MouseClicked

    private void listBarang1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBarang1MouseEntered
        // TODO add your handling code here:

        int idBar = Query.getIdBarang(listBarang1);
        if (idBar == 0) {
            JOptionPane.showMessageDialog(null, "Id inventaris tidak ditemukan.", "Delete Data Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Connection c = DatabaseConnection.getConnection();
            Statement s = c.createStatement();
            String sql = "Select * from inventaris_barang where id_barang ='" + idBar + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                updateStok.setText(r.getString("stok"));
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Pesan error: " + e.getMessage());
            System.out.println("Kode error: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
        }
    }//GEN-LAST:event_listBarang1MouseEntered

    private void listBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listBarang1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_listBarang1ActionPerformed

    private void listBarang1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listBarang1ItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_listBarang1ItemStateChanged

    private void listBarang1CaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_listBarang1CaretPositionChanged
        // TODO add your handling code here:
        int idBar = Query.getIdBarang(listBarang1);
        if (idBar == 0) {
            JOptionPane.showMessageDialog(null, "Id inventaris tidak ditemukan.", "Delete Data Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Connection c = DatabaseConnection.getConnection();
            Statement s = c.createStatement();
            String sql = "Select * from inventaris_barang where id_barang ='" + idBar + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                updateStok.setText(r.getString("stok"));
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Pesan error: " + e.getMessage());
            System.out.println("Kode error: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
        }

    }//GEN-LAST:event_listBarang1CaretPositionChanged

    private void listBarang1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_listBarang1InputMethodTextChanged
        // TODO add your handling code here:
        int idBar = Query.getIdBarang(listBarang1);
        if (idBar == 0) {
            JOptionPane.showMessageDialog(null, "Id inventaris tidak ditemukan.", "Delete Data Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Connection c = DatabaseConnection.getConnection();
            Statement s = c.createStatement();
            String sql = "Select * from inventaris_barang where id_barang ='" + idBar + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                updateStok.setText(r.getString("stok"));
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Pesan error: " + e.getMessage());
            System.out.println("Kode error: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
        }

    }//GEN-LAST:event_listBarang1InputMethodTextChanged

    private void listBarang1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listBarang1MouseMoved
        // TODO add your handling code here:
        int idBar = Query.getIdBarang(listBarang1);
        if (idBar == 0) {
            JOptionPane.showMessageDialog(null, "Id inventaris tidak ditemukan.", "Delete Data Gagal", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Connection c = DatabaseConnection.getConnection();
            Statement s = c.createStatement();
            String sql = "Select * from inventaris_barang where id_barang ='" + idBar + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                updateStok.setText(r.getString("stok"));
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Pesan error: " + e.getMessage());
            System.out.println("Kode error: " + e.getErrorCode());
            System.out.println("SQLState: " + e.getSQLState());
        }

    }//GEN-LAST:event_listBarang1MouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> listBarang;
    private javax.swing.JComboBox<String> listBarang1;
    private javax.swing.JLabel p;
    private javax.swing.JLabel p1;
    private com.penjualan.swing.PanelBorder panelBorder2;
    private javax.swing.JButton simpanBtn;
    private javax.swing.JTextField stokBarang;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField updateStok;
    // End of variables declaration//GEN-END:variables
}

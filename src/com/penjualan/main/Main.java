package com.penjualan.main;

import com.formdev.flatlaf.FlatLightLaf;
import com.penjualan.event.EventMenu;
import com.penjualan.form.Form_About_Me;

import com.penjualan.form.Form_Barang;
import com.penjualan.form.Form_Input_Barang;
import com.penjualan.form.Form_Input_Inventaris;
import com.penjualan.form.Form_Input_Pelanggan;
import com.penjualan.form.Form_Input_Suplier;
import com.penjualan.form.Form_Input_Transaksi;
import com.penjualan.form.Form_Inventaris;
import com.penjualan.form.Form_Pelanggan;
import com.penjualan.form.Form_Suplier;
import com.penjualan.form.Form_Transaksi_Penjualan;
import com.penjualan.form.LoginForm;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main extends javax.swing.JFrame {

    private Form_Barang dataBarang;
    private Form_Pelanggan dataPelanggan;
    private Form_Transaksi_Penjualan dataTransaksi;
    private Form_Suplier dataSupplier;
    private Form_Inventaris dataInventaris;
    private Form_Input_Barang inputBarang;
    private Form_Input_Pelanggan inputPelanggan;
    private Form_Input_Suplier inputSuplier;
    private Form_Input_Inventaris inputInventaris;
    private Form_Input_Transaksi inputTransaksi;
    private Form_About_Me aboutMe;

//    private Form_1 form1;
//    private Form_2 form2;
//    private Form_3 form3;
    public Main() {
        initComponents();

        FlatLightLaf.setup();
        initDesign();
        init();
    }

    public void initDesign() {
        UIManager.put("Component.focusWidth", 1);
        UIManager.put("TabbedPane.selectedBackground", Color.white);
        UIManager.put("Button.arc", 15);
        UIManager.put("", 15);
        UIManager.put("Component.arc", 15);
        UIManager.put("ProgressBar.arc", 15);
        UIManager.put("TextComponent.arc", 15);
        UIManager.put("Component.arrowType", "chevron");
        UIManager.put("ScrollBar.thumbArc", 999);
        UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
    }

    private void init() {
        setBackground(new Color(0, 0, 0, 0));  //  Remove background
        dataBarang = new Form_Barang();
        dataPelanggan = new Form_Pelanggan();
        dataInventaris = new Form_Inventaris();
        dataSupplier = new Form_Suplier();
        dataTransaksi = new Form_Transaksi_Penjualan();
        inputBarang = new Form_Input_Barang();
        inputPelanggan = new Form_Input_Pelanggan();
        inputSuplier = new Form_Input_Suplier();
        inputInventaris = new Form_Input_Inventaris();
        inputTransaksi = new Form_Input_Transaksi();
        aboutMe = new Form_About_Me();

        //  set when system open start with home form
        menu1.initMoving(this);

        menu1.addEventMenu(new EventMenu() {
            @Override
            public void menuIndexChange(int index) {
                switch (index) {
                    case 0:
                        setForm(dataBarang);
                        break;
                    case 1:
                        setForm(inputBarang);
                        break;
                    case 2:
                        setForm(dataPelanggan);
                        break;
                    case 3:
                        setForm(inputPelanggan);
                        break;
                    case 4:
                        setForm(dataSupplier);
                        break;
                    case 5:
                        setForm(inputSuplier);

                        break;
                    case 6:
                        setForm(dataInventaris);
                        break;
                    case 7:
                        setForm(inputInventaris);
                        break;
                    case 8:
                        setForm(dataTransaksi);
                        break;
                    case 9:
                        setForm(inputTransaksi);
                        break;
                    case 10:
                        setForm(aboutMe);
                        break;
                    case 11:
                        int result = JOptionPane.showConfirmDialog(mainPanel, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
                        if (result == JOptionPane.YES_OPTION) {
                            System.exit(0); // Menutup aplikasi
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Form Tidak ditemukan", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            }
        }
        );
        setForm(new LoginForm());
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.penjualan.swing.PanelBorder();
        menu1 = new com.penjualan.component.Menu();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private com.penjualan.component.Menu menu1;
    private com.penjualan.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}

package com.penjualan.form;

import static com.penjualan.db.Query.getDataBarang;
import com.penjualan.swing.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Form_About_Me extends javax.swing.JPanel {

    public Form_About_Me() {
        initComponents();
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
    }
 @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#ee0979"), 0, getHeight(), Color.decode("#ff6a00"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
//        if (selectedIndex >= 0) {
//            int menuX = 10;
//            int height = 35;
//            int width = getWidth();
//            g2.setColor(new Color(242, 242, 242));
//            g2.fillRoundRect(menuX, menuY, width, height, 35, 35);
//            Path2D.Float f = new Path2D.Float();
//            f.moveTo(width - 30, menuY);
//            f.curveTo(width - 10, menuY, width, menuY, width, menuY - 30);
//            f.lineTo(width, menuY + height + 30);
//            f.curveTo(width, menuY + height, width - 10, menuY + height, width - 30, menuY + height);
//
//            g2.fill(f);
//        }
        super.paintComponent(grphcs);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientBorderInput1 = new com.penjualan.component.GradientBorderInput();
        p1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(722, 454));

        p1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p1.setForeground(new java.awt.Color(255, 102, 102));
        p1.setText("About Me");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Nama : Rio Mulya Syawal");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 51));
        jLabel6.setText("UNIVERSITAS PAMULANG");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Kelas : 05TPLP015");

        javax.swing.GroupLayout gradientBorderInput1Layout = new javax.swing.GroupLayout(gradientBorderInput1);
        gradientBorderInput1.setLayout(gradientBorderInput1Layout);
        gradientBorderInput1Layout.setHorizontalGroup(
            gradientBorderInput1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBorderInput1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(gradientBorderInput1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(gradientBorderInput1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(gradientBorderInput1Layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(p1))
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)))
                .addContainerGap(224, Short.MAX_VALUE))
        );
        gradientBorderInput1Layout.setVerticalGroup(
            gradientBorderInput1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBorderInput1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(p1)
                .addGap(110, 110, 110)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradientBorderInput1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradientBorderInput1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.penjualan.component.GradientBorderInput gradientBorderInput1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel p1;
    // End of variables declaration//GEN-END:variables
}

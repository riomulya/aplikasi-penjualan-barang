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
        p.setBackground(Color.WHITE);
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

        gradientBorder1 = new com.penjualan.component.GradientBorder();
        p = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(550, 700));

        gradientBorder1.setPreferredSize(new java.awt.Dimension(550, 560));

        p.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        p.setForeground(new java.awt.Color(255, 102, 102));
        p.setText("About Me");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Nama : Rio Mulya Syawal");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Kelas : 05TPLP015");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Nim : 211011401091");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("UNIVERSITAS PAMULANG");

        javax.swing.GroupLayout gradientBorder1Layout = new javax.swing.GroupLayout(gradientBorder1);
        gradientBorder1.setLayout(gradientBorder1Layout);
        gradientBorder1Layout.setHorizontalGroup(
            gradientBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBorder1Layout.createSequentialGroup()
                .addGroup(gradientBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientBorder1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(p))
                    .addGroup(gradientBorder1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(gradientBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(gradientBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        gradientBorder1Layout.setVerticalGroup(
            gradientBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p)
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradientBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(gradientBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.penjualan.component.GradientBorder gradientBorder1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel p;
    // End of variables declaration//GEN-END:variables
}

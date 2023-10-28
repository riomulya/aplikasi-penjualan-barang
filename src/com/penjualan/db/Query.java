/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penjualan.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class Query {

    public static Connection connection = null;
    public static PreparedStatement statement = null;
    public static ResultSet resultSet = null;

    public static String getErrorMsg() {
        if (connection == null) {
            return "Terjadi kesalahan koneksi";
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                return "Terjadi kesalahan saat menutup ResultSet: " + e.getMessage();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                return "Terjadi kesalahan saat menutup PreparedStatement: " + e.getMessage();
            }
        }
        return ""; // Tidak ada kesalahan
    }

    public static boolean getUser(JTextField nama, JTextField password) {
        try {
            connection = DatabaseConnection.getConnection();
            String customQuery = "SELECT count(*) FROM users WHERE nama = ? and password = password(?)";
            statement = connection.prepareStatement(customQuery);
            statement.setString(1, nama.getText()); // Menggunakan PreparedStatement untuk menghindari SQL Injection
            statement.setString(2, password.getText());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getInt("count(*)") == 1) {
                    return true;
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        return "";
        return false;
    }

    public static void insertDataPenjualan(String nama, String area, String tipe, int harga, int lamaCicilan, double cicilanBln) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO tbl_penjualan_rumah (nama, area, tipe, harga, lama_cicilan, cicilan_bln) VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query);

            // Mengikat nilai parameter
            statement.setString(1, nama);
            statement.setString(2, area);
            statement.setString(3, tipe);
            statement.setInt(4, harga);
            statement.setInt(5, lamaCicilan);
            statement.setDouble(6, cicilanBln);

            // Menjalankan pernyataan INSERT
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data telah disisipkan ke dalam tabel.");
            } else {
                System.out.println("Gagal menyisipkan data ke dalam tabel.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Tutup statement dan koneksi
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void getDataBarang(DefaultTableModel tableData, String query) {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int idBarang = resultSet.getInt("id_barang");
                String namaBarang = resultSet.getString("nama");
                String deskripsi = resultSet.getString("deskripsi");
                double harga = resultSet.getDouble("harga");

                // Tambahkan data ke model tabel
                tableData.addRow(new Object[]{idBarang, namaBarang, deskripsi, harga});
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data barang: " + e.getMessage());
        } finally {
            // Tutup statement dan koneksi
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void getDataPelanggan(DefaultTableModel tableData, String query) {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int idPelanggan = resultSet.getInt("id_pelanggan");
                String namaPelanggan = resultSet.getString("nama");
                String alamat = resultSet.getString("alamat");
                String kontak = resultSet.getString("kontak");

                // Tambahkan data ke model tabel
                tableData.addRow(new Object[]{idPelanggan, namaPelanggan, alamat, kontak});
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data barang: " + e.getMessage());
        } finally {
            // Tutup statement dan koneksi
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void getDataPemasok(DefaultTableModel tableData, String query) {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int idPemasok = resultSet.getInt("id_pemasok");
                String namaPelanggan = resultSet.getString("nama");
                String alamat = resultSet.getString("alamat");
                String kontak = resultSet.getString("kontak");

                // Tambahkan data ke model tabel
                tableData.addRow(new Object[]{idPemasok, namaPelanggan, alamat, kontak});
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data barang: " + e.getMessage());
        } finally {
            // Tutup statement dan koneksi
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void getDataInventaris(DefaultTableModel tableData, String query) {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int idPelanggan = resultSet.getInt("id_inventaris");
                int idBarang = resultSet.getInt("id_barang");
                int stok = resultSet.getInt("stok");
                String alamat = resultSet.getString("alamat");
                String kontak = resultSet.getString("kontak");

                // Tambahkan data ke model tabel
                tableData.addRow(new Object[]{idPelanggan, idBarang, stok, kontak});
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data barang: " + e.getMessage());
        } finally {
            // Tutup statement dan koneksi
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

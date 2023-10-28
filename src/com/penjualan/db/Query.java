/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penjualan.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
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

    public static void insertDataBarang(String nama, String deskripsi, int harga) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO barang (nama, deskripsi, harga) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);

            // Mengikat nilai parameter
            statement.setString(1, nama);
            statement.setString(2, deskripsi);
            statement.setInt(3, harga);

            // Menjalankan pernyataan INSERT
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data telah disisipkan ke dalam tabel.", "Insert Data Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menyisipkan data ke dalam tabel.", "Insert Data Gagal", JOptionPane.ERROR_MESSAGE);
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

    public static void deleteData(String querry, int id) {
        try {
            connection = DatabaseConnection.getConnection();

            // Menjalankan pernyataan INSERT
            PreparedStatement preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, id);

            // Menjalankan perintah DELETE
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Data telah dihapus di dalam database", "Hapus Data Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Menghapus data di database", "Hapus Data Gagal", JOptionPane.ERROR_MESSAGE);
                System.out.println("Data tidak ditemukan atau gagal dihapus.");
            }

            // Menutup koneksi
            preparedStatement.close();
            connection.close();
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

    public static void updateDataBarang(int id, String nama, String deskripsi, int harga) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "UPDATE barang SET nama = ?, deskripsi = ?, harga = ? WHERE id_barang = ?";
            statement = connection.prepareStatement(query);

            // Mengikat nilai parameter
            statement.setString(1, nama);
            statement.setString(2, deskripsi);
            statement.setInt(3, harga);
            statement.setInt(4, id); // ID data yang akan diperbarui

            // Menjalankan pernyataan UPDATE
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui.", "Update Data Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data.", "Update Data Gagal", JOptionPane.ERROR_MESSAGE);
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

    public static void getDataListBarangInventaris(JComboBox comboBox) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT DISTINCT b.nama\n"
                    + "FROM barang b\n"
                    + "INNER JOIN inventaris_barang i ON b.id_barang = i.id_barang;";
            preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            comboBox.removeAllItems(); // Hapus item lama dari JComboBox

            while (resultSet.next()) {
                String item = resultSet.getString("nama");
                comboBox.addItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

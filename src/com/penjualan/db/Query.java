
package com.penjualan.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

    
    
    public static void getDataTransaksi(DefaultTableModel tableData) {
        try {
            connection = DatabaseConnection.getConnection();

            String query = "SELECT t.id_transaksi, p.nama AS nama_pelanggan, t.tanggal, "
                    + "b.nama AS nama_barang, b.harga AS harga_barang, "
                    + "t.jumlah, (b.harga * t.jumlah) AS total_harga "
                    + "FROM transaksi_penjualan t "
                    + "JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan "
                    + "JOIN barang b ON t.id_barang = b.id_barang";

            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idTransaksi = resultSet.getInt("id_transaksi");
                String namaPelanggan = resultSet.getString("nama_pelanggan");
                String tanggal = resultSet.getString("tanggal");
                String namaBarang = resultSet.getString("nama_barang");
                double hargaBarang = resultSet.getDouble("harga_barang");
                int jumlah = resultSet.getInt("jumlah");
                double totalHarga = resultSet.getDouble("total_harga");

                // Tambahkan data ke model tabel
                tableData.addRow(new Object[]{idTransaksi, namaPelanggan, tanggal,
                    namaBarang, hargaBarang, jumlah, totalHarga});
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data transaksi: " + e.getMessage());
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

     public static void getDataInventaris(DefaultTableModel tableData) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "SELECT i.id_inventaris, b.nama AS nama_barang, i.stok, i.tanggal_perubahan " +
                       "FROM inventaris_barang i " +
                       "JOIN barang b ON i.id_barang = b.id_barang";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idInventaris = resultSet.getInt("id_inventaris");
                String namaBarang = resultSet.getString("nama_barang");
                int stok = resultSet.getInt("stok");
                String tanggalPerubahan = resultSet.getString("tanggal_perubahan");

                // Tambahkan data ke model tabel
                tableData.addRow(new Object[]{idInventaris, namaBarang, stok, tanggalPerubahan});
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

    public static void insertDataPelanggan(String nama, String alamat, String kontak) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO pelanggan (nama, alamat, kontak) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);

            // Mengikat nilai parameter
            statement.setString(1, nama);
            statement.setString(2, alamat);
            statement.setString(3, kontak);

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

    public static void insertDataSupplier(String nama, String alamat, String kontak) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "INSERT INTO pemasok (nama, alamat, kontak) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);

            // Mengikat nilai parameter
            statement.setString(1, nama);
            statement.setString(2, alamat);
            statement.setString(3, kontak);

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

    public static void insertDataTransaksi(int id_pelanggan, int id_barang, int jumlah) {
        String query = "INSERT INTO transaksi_penjualan (id_pelanggan, tanggal, id_barang, jumlah) VALUES (?, NOW(), ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id_pelanggan);
            statement.setInt(2, id_barang);
            statement.setInt(3, jumlah);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data telah disisipkan ke dalam tabel.", "Insert Data Berhasil", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menyisipkan data ke dalam tabel.", "Insert Data Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getIdPelanggan(JComboBox comboBox) {
        String sql = "SELECT id_pelanggan FROM pelanggan WHERE nama = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, comboBox.getSelectedItem().toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id_pelanggan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getIdBarang(JComboBox comboBox) {
        String sql = "SELECT id_barang FROM barang WHERE nama = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, comboBox.getSelectedItem().toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id_barang");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
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

    public static void updateDataTransaksi(int jumlah, int id) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "UPDATE transaksi_penjualan SET jumlah = ? WHERE id_transaksi = ?";
            statement = connection.prepareStatement(query);

            // Mengikat nilai parameter
            statement.setInt(1, jumlah);
            statement.setInt(2, id);

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

    public static void getDataListBarang(JComboBox comboBox) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT DISTINCT b.nama\n"
                    + "FROM barang b\n"
                    + "LEFT JOIN inventaris_barang i ON b.id_barang = i.id_barang\n"
                    + "WHERE i.id_barang IS NULL;";
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

    public static void updateDataPelanggan(int id, String nama, String alamat, String kontak) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "UPDATE pelanggan SET nama = ?, alamat = ?, kontak = ? WHERE id_pelanggan = ?";
            statement = connection.prepareStatement(query);

            // Mengikat nilai parameter
            statement.setString(1, nama);
            statement.setString(2, alamat);
            statement.setString(3, kontak);
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

    public static Boolean deleteDataConstraint(int id, String checkQuery, String deleteQuery) {
        Connection connection = null;
        PreparedStatement deleteStatement = null;

        try {
            connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            // Cek apakah ada referensi ke barang dalam tabel transaksi_penjualan
//        String checkQuery = "SELECT COUNT(*) FROM transaksi_penjualan WHERE id_barang = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setInt(1, id);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next() && resultSet.getInt(1) > 0) {
                // Ada referensi ke barang, sebaiknya membatalkan penghapusan
                connection.rollback();
                JOptionPane.showMessageDialog(null, "Data tidak dapat dihapus karena masih digunakan dalam tabel transaksi.", "Hapus Data Gagal", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                // Tidak ada referensi ke barang, lanjutkan penghapusan
//            String deleteQuery = "DELETE FROM barang WHERE id_barang = ?";
                deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.setInt(1, id);
                int rowsAffected = deleteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    connection.commit();
                    System.out.println("Barang telah dihapus.");
                } else {
                    connection.rollback();
                    System.out.println("Gagal menghapus barang.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (deleteStatement != null) {
                try {
                    deleteStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static void updateDataPemasok(int id, String nama, String alamat, String kontak) {
        try {
            connection = DatabaseConnection.getConnection();
            String query = "UPDATE pemasok SET nama = ?, alamat = ?, kontak = ? WHERE id_pemasok = ?";
            statement = connection.prepareStatement(query);

            // Mengikat nilai parameter
            statement.setString(1, nama);
            statement.setString(2, alamat);
            statement.setString(3, kontak);
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

    public static void getDataListBarangTransaksi(JComboBox comboBox) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT DISTINCT b.nama\n"
                    + "FROM barang b\n"
                    + "INNER JOIN transaksi_penjualan i ON b.id_barang = i.id_barang;";
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

    public static void getDataListPelangganTransaksi(JComboBox comboBox) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnection.getConnection();
            String sql = "SELECT DISTINCT b.nama\n"
                    + "FROM pelanggan b\n"
                    + "INNER JOIN transaksi_penjualan i ON b.id_pelanggan = i.id_pelanggan;";
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

    public static void getDataListTransaksi(JComboBox comboBox, String query) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DatabaseConnection.getConnection();
//            String sql = "SELECT DISTINCT b.nama\n"
//                    + "FROM pelanggan b\n"
//                    + "INNER JOIN transaksi_penjualan i ON b.id_pelanggan = i.id_pelanggan;";
            preparedStatement = connection.prepareStatement(query);

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

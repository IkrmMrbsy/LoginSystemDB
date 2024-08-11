package org.example.Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Koneksi {
    //Objek dari tipe HikariDataSource
    //digunakan untuk mengelola koneksi ke database
    private static final HikariDataSource dataSource;

    static{
        //Membuat objek config dari kelas HikariConfig
        //digunakan untuk menyimpan pengaturan konfigurasi untuk koneksi ke database
        HikariConfig config = new HikariConfig();

        config.setUsername("root");//menetapkan nama pengguna untuk mengakses database
        config.setPassword("");//menetapkan kata sandi untuk mengakses database
        config.setJdbcUrl("jdbc:mysql://localhost:3306/loginsystemjava");//menetapkan URL untuk menghubungkan ke database

        //Ketiga properti di bawah bekerja bersama-sama untuk meningkatkan kinerja aplikasi
        //yang menggunakan database dengan mengelola cara pernyataan SQL dipreparasi
        //dan disimpan.
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(config);
    }

    //Metode getConnection
    //throws SQLException berarti metode ini bisa melemparkan (throw)
    // sebuah pengecualian SQLException jika ada kesalahan saat mencoba mendapatkan
    // koneksi ke database
    public static Connection getConnection() throws SQLException{
        //mengembalikan (return) objek Connection yang diambil dari dataSource
        // ini digunakan untuk menjalankan perintah-perintah SQL pada database.
        return dataSource.getConnection();
    }

    //Metode getDataSource
    public static DataSource getDataSource(){
        return dataSource;
    }

    //Metode Close
    //Metode ini digunakan untuk menutup (close) dataSource ketika aplikasi selesai
    // menggunakan koneksi ke database.
    public static void close(){
        //if (dataSource != null) memeriksa apakah dataSource sudah diinisialisasi
        if (dataSource != null){
            dataSource.close();//menutup dataSource jika memang sudah diinisialisasi.
        }
    }
}

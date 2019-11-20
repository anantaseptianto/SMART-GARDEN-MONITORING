package data_sensor;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Data_sensor {

static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/datasensor";
static final String USER = "root";
static final String PASS = "";

static Connection conn;
static Statement stmt;
static ResultSet rs;

static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
static BufferedReader input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) {
        try {
            // register driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                showMenu();
            }

            stmt.close();
            conn.close();
            } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void showMenu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertData();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    deleteData();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showData() {
        String sql = "SELECT * FROM jenis_sensor";

        try {
            rs = stmt.executeQuery(sql);
            
            System.out.println("+--------------------------------+");
            System.out.println("|    DATA SENSOR DI PERKEBUNAN  |");
            System.out.println("+--------------------------------+");

            while (rs.next()) {
                int id_sensor = rs.getInt("id_sensor");
                String kelembapan = rs.getString("kelembapan");
                String suhu= rs.getString("suhu");

                
                System.out.println(String.format("%d. %s  dan  (%s)", id_sensor, kelembapan,suhu));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void insertData() {
        try {
            // ambil input dari user
            System.out.print("kelembapan: ");
            String kelembapan = input.readLine().trim();
            System.out.print("suhu: ");
            String suhu = input.readLine().trim();
 
            // query simpan
            String sql = "INSERT INTO jenis_sensor (kelembapan, suhu) VALUE('%s', '%s')";
            sql = String.format(sql, kelembapan, suhu);

            // simpan buku
            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void updateData() {
        try {
            
            // ambil input dari user
            System.out.print("ID yang mau diedit: ");
            int id_sensor = Integer.parseInt(input.readLine());
            System.out.print("Kelembapan: ");
            String kelembapan = input.readLine().trim();
            System.out.print("suhu: ");
            String suhu = input.readLine().trim();

            // query update
            String sql = "UPDATE jenis_sensor SET kelembapan='%s', suhu='%s' WHERE id_sensor=%s";
            sql = String.format(sql, kelembapan, suhu, id_sensor);

            // update data buku
            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteData() {
        try {
            
            // ambil input dari user
            System.out.print("ID yang mau dihapus: ");
            int id_sensor = Integer.parseInt(input.readLine());
            
            // buat query hapus
            String sql = String.format("DELETE FROM jenis_sensor WHERE id_sensor=%d", id_sensor);

            // hapus data
            stmt.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

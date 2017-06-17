/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysql_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Taptuk
 */
public class MySQL_1 {
    //Deneme

    /**
     * @param args the command line arguments
     */
    //Bura iyi
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/gpstest";
            String kullaniciad = "root";
            String sifre = "123456";
            Connection con = null; Statement st = null; ResultSet rs = null;
            con = DriverManager.getConnection(url, kullaniciad, sifre);
            st = con.createStatement();
            System.out.println("Baglandi");
            //Veri gonderme
            String verigonder = "INSERT INTO Ornek (AD,SOYAD) VALUES ('Ornek','Isim')";
            st.execute(verigonder);
            System.out.println("Gonderildi");
            //Veri cekme
            String vericek = "SELECT AD,SOYAD FROM Ornek";
            rs = st.executeQuery(vericek);
            while(rs.next()) {
                System.out.println("Isim= "+rs.getString("AD")+"  Soyisim= "+rs.getString("SOYAD"));
            }
            System.out.println("Alindi");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();       
            
           System.out.println("Sürücü projeye eklenmemiş!");
        } catch (SQLException ex) {
            ex.printStackTrace();
          System.out.println("Veritabanına bağlantı sağlanamadı!");
        }
    }
    
}

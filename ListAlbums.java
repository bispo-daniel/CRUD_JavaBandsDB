import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class ListAlbums {
    static String everyRow;
    static void listAlbums(){
        everyRow = "";
        try {
            String sql = "Select a.album_id, a.album_name, a.album_birth, b.band_name from album a JOIN band b ON a.band_id_FK = b.band_id";
            Statement stt = Connect.connection.createStatement();
            ResultSet res = stt.executeQuery(sql);

            while(res.next()){
                int id = res.getInt(1);
                String name = res.getString(2);
                String year = res.getString(3);
                String band = res.getString(4);

                String row = "%d - %s - %s - %s \n";
                everyRow += String.format(row, id, name, year, band);
            }

            JOptionPane.showMessageDialog(null, everyRow);

        } catch (SQLException e){
            e.printStackTrace();
        }

        Main.menu();
    }
}
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UpdateAlbum {
    static void updateAlbumFunction(int albumId, String columnName, String newValue){
        try {
            String sql = "UPDATE album SET %s = ? WHERE album_id = %d";
            String formatedString = String.format(sql, columnName, albumId);
            PreparedStatement stt = Connect.connection.prepareStatement(formatedString);
            if(columnName == "band_id_FK"){
                int newBandId = Integer.parseInt(newValue);
                stt.setInt(1, newBandId);
            } else {
                stt.setString(1, newValue);
            }
            int res = stt.executeUpdate();
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Album updated!");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    static void updateAlbum(){
        String albumIdString = JOptionPane.showInputDialog(null, "Type the album's id to update");
        int albumId = Integer.parseInt(albumIdString);
        String optionString = JOptionPane.showInputDialog(null, "What do you want to update\n\n 1) Name\n 2) Year released\n 3) Band's id");
        int option = Integer.parseInt(optionString);
        String newValue = JOptionPane.showInputDialog(null, "Type the new value");

        switch(option){
            case 1:
                updateAlbumFunction(albumId, "album_name", newValue);
                    break;
            case 2:
                updateAlbumFunction(albumId, "album_birth", newValue);
                    break;
            case 3:
                updateAlbumFunction(albumId, "band_id_FK", newValue);
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option");
        }

        Main.menu();
    }
}
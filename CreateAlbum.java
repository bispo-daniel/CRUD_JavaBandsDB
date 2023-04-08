import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CreateAlbum {
    static void createAlbum(){
        String name = JOptionPane.showInputDialog(null, "Type the new album's name");
        String year = JOptionPane.showInputDialog(null, "Type the new album's year of release");
        String bandIdString = JOptionPane.showInputDialog(null, "Type the new album's band id");
        int bandId = Integer.parseInt(bandIdString);

        try {
            String sql = "INSERT INTO album (album_name, album_birth, band_id_FK) VALUES (?, ?, ?)";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);

            stt.setString(1, name);
            stt.setString(2, year);
            stt.setInt(3, bandId);
            int response = stt.executeUpdate();

            if(response > 0){
                String text = "Album %s successfully created!";
                JOptionPane.showMessageDialog(null, String.format(text, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Main.menu();
    }
}
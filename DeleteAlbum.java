import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DeleteAlbum {
    static void deleteAlbum(){
        String albumIdString = JOptionPane.showInputDialog(null, "Type the album's id to delete it");
        int albumId = Integer.parseInt(albumIdString);
        
        try {

            String sql = "DELETE FROM album WHERE album_id = ?";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);
            stt.setInt(1, albumId);
            int res = stt.executeUpdate();
            if(res > 0){
                String msg = "Album %d successfully deleted!";
                JOptionPane.showMessageDialog(null, String.format(msg, albumId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        Main.menu();
    }
}

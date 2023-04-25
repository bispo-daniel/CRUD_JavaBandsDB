import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeleteAlbum {
    static void deleteAlbum() throws SQLException{
        String albumIdString = JOptionPane.showInputDialog(null, "Type the album's id to delete it");
        int albumId = Integer.parseInt(albumIdString);
        
        AlbumDao albumDao = new AlbumDao();
        albumDao.delete(albumId);
        
        Main.menu();
    }
}
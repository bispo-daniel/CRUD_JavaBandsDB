import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UpdateAlbum {
    static void updateAlbum() throws SQLException {
        String albumIdString = JOptionPane.showInputDialog(null, "Type the album's id to update");
        int albumId = Integer.parseInt(albumIdString);

        String optionString = JOptionPane.showInputDialog(null, "What do you want to update\n\n 1) Name\n 2) Year released\n 3) Band's id");
        int option = Integer.parseInt(optionString);
        
        String newValue = JOptionPane.showInputDialog(null, "Type the new value");

        AlbumDao albumDao = new AlbumDao();

        switch(option){
            case 1:
                albumDao.update(albumId, "album_name", newValue);
                    break;
            case 2:
                albumDao.update(albumId, "album_birth", newValue);
                    break;
            case 3:
                albumDao.update(albumId, "band_id_FK", newValue);
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option");
        }

        Main.menu();
    }
}
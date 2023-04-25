import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CreateAlbum {
    static void createAlbum() throws SQLException {
        String name = JOptionPane.showInputDialog(null, "Type the new album's name");
        String year = JOptionPane.showInputDialog(null, "Type the new album's year of release");
        String bandIdString = JOptionPane.showInputDialog(null, "Type the new album's band id");
        int bandId = Integer.parseInt(bandIdString);

        AlbumClass newAlbum = new AlbumClass(name, year, bandId);

        AlbumDao albumDAO = new AlbumDao();
        albumDAO.save(newAlbum);

        Main.menu();
    }
}
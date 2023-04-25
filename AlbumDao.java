import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AlbumDao implements DAO<AlbumClass> {

    @Override
    public void save(AlbumClass album) throws SQLException {
        String sql = "INSERT INTO album (album_name, album_birth, band_id_FK) VALUES (?, ?, ?)";
        PreparedStatement stt = Connect.connection.prepareStatement(sql);

        stt.setString(1, album.getAlbumName());
        stt.setString(2, album.getAlbumBirth());
        stt.setInt(3, album.getBandId());
        int response = stt.executeUpdate();

        if(response > 0){
            String text = "Album %s successfully created!";
            JOptionPane.showMessageDialog(null, String.format(text, album.getAlbumName()));
        }
    }
}
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    static String everyRow;
    
    @Override 
    public String list() throws SQLException {
        everyRow = "";

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

        return everyRow;
    }

    @Override
    public void update(int id, String columnName, String newValue) throws SQLException {
        String sql = "UPDATE album SET %s = ? WHERE album_id = %d";
        
        String formatedString = String.format(sql, columnName, id);
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
    }

    @Override 
    public void delete(int albumId) throws SQLException {
        String sql = "DELETE FROM album WHERE album_id = ?";
        PreparedStatement stt = Connect.connection.prepareStatement(sql);
        stt.setInt(1, albumId);
        int res = stt.executeUpdate();
        
        if(res > 0){
            String msg = "Album %d successfully deleted!";
            JOptionPane.showMessageDialog(null, String.format(msg, albumId));
        }

    }
}
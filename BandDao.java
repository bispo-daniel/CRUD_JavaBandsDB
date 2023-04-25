import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BandDao implements DAO<BandClass> {

    @Override
    public void save(BandClass band) throws SQLException{
        

        String sql = "INSERT INTO band (band_name, band_birth) VALUES (?, ?)";
        PreparedStatement stt = Connect.connection.prepareStatement(sql);

        stt.setString(1, band.getBandName());
        stt.setString(2, band.getBandBirth());
        int response = stt.executeUpdate();

        if(response > 0){
            String text = "Band %s successfully created!";
            JOptionPane.showMessageDialog(null, String.format(text, band.getBandName()));
        }
    }

    String everyRow = "";
    
    @Override
    public String list() throws SQLException{

        String sql = "select * from band";
        Statement stt = Connect.connection.createStatement();
        ResultSet res = stt.executeQuery(sql);

        while(res.next()){
            int id = res.getInt(1);
            String name = res.getString(2);
            String year = res.getString(3);

            String row = "%d - %s - %s \n";
            everyRow += String.format(row, id, name, year);
        }

        return everyRow;
    }

    @Override
    public void update(int bandId, String columnName, String newValue) throws SQLException{
        try {
            String sql = "UPDATE band SET %s = ? WHERE band_id = %d";
            String formatedString = String.format(sql, columnName, bandId);

            PreparedStatement stt = Connect.connection.prepareStatement(formatedString);
            
            stt.setString(1, newValue);
            int res = stt.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Band updated!");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int bandId) throws SQLException {
        String sql = "DELETE FROM band WHERE band_id = ?";
        PreparedStatement stt = Connect.connection.prepareStatement(sql);
        stt.setInt(1, bandId);
        int res = stt.executeUpdate();

        if(res > 0){
            String msg = "Band %d successfully deleted!";
            JOptionPane.showMessageDialog(null, String.format(msg, bandId));
        }
    }
}

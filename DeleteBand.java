import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DeleteBand {
    static void deleteBand(){
        String bandIdString = JOptionPane.showInputDialog(null, "Type the band's id to delete it");
        int bandId = Integer.parseInt(bandIdString);
        
        try {

            String sql = "DELETE FROM band WHERE band_id = ?";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);
            stt.setInt(1, bandId);
            int res = stt.executeUpdate();
            if(res > 0){
                String msg = "Band %d successfully deleted!";
                JOptionPane.showMessageDialog(null, String.format(msg, bandId));
            }
        } catch (SQLException e) {
            if(e.getErrorCode() == 1451){
                JOptionPane.showMessageDialog(null, "You can't remove a band that still contains albums...\nIn order to remove this band, you must delete it's albums first.");
            } else {
                e.printStackTrace();
            }
        }
        
        Main.menu();
    }
}
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DeleteBand {
    static void deleteBand(){
        String bandIdString = JOptionPane.showInputDialog(null, "Type the band's id to delete it");
        int bandId = Integer.parseInt(bandIdString);
        
        try {

            BandDao bandDao = new BandDao();
            bandDao.delete(bandId);

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
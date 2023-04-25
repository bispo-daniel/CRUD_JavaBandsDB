import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UpdateBand {
    static void updateBand() throws SQLException {
        String bandIdString = JOptionPane.showInputDialog(null, "Type the band's id to update");
        int bandId = Integer.parseInt(bandIdString);

        String optionString = JOptionPane.showInputDialog(null, "What do you want to update\n\n 1) Name\n 2) Year of formation");
        int option = Integer.parseInt(optionString);
        
        String newValue = JOptionPane.showInputDialog(null, "Type the new value");

        BandDao bandDao = new BandDao();

        switch(option){
            case 1:
                bandDao.update(bandId, "band_name", newValue);
                    break;
            case 2:
                bandDao.update(bandId, "band_birth", newValue);
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option");
        }

        Main.menu();
    }
}
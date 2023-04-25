import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CreateBand {
    static void createBand() throws SQLException {
        String name = JOptionPane.showInputDialog(null, "Type the new band's name");
        String year = JOptionPane.showInputDialog(null, "Type the new band's year of formation");

        BandClass newBand = new BandClass(name, year);
        BandDao bandDao = new BandDao();
        bandDao.save(newBand);

        Main.menu();
    }
}
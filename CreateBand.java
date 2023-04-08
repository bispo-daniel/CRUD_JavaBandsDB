import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class CreateBand {
    static void createBand(){
        String name = JOptionPane.showInputDialog(null, "Type the new band's name");
        String year = JOptionPane.showInputDialog(null, "Type the new band's year of formation");

        try {
            String sql = "INSERT INTO band (band_name, band_birth) VALUES (?, ?)";
            PreparedStatement stt = Connect.connection.prepareStatement(sql);

            stt.setString(1, name);
            stt.setString(2, year);
            int response = stt.executeUpdate();

            if(response > 0){
                String text = "Band %s successfully created!";
                JOptionPane.showMessageDialog(null, String.format(text, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Main.menu();
    }
}
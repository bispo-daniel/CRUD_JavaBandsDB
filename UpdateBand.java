import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class UpdateBand {
    static void updateBandFunction(int bandId, String columnName, String newValue){
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

    static void updateBand(){
        String bandIdString = JOptionPane.showInputDialog(null, "Type the band's id to update");
        int bandId = Integer.parseInt(bandIdString);
        String optionString = JOptionPane.showInputDialog(null, "What do you want to update\n\n 1) Name\n 2) Year of formation");
        int option = Integer.parseInt(optionString);
        String newValue = JOptionPane.showInputDialog(null, "Type the new value");

        switch(option){
            case 1:
                updateBandFunction(bandId, "band_name", newValue);
                    break;
            case 2:
                updateBandFunction(bandId, "band_birth", newValue);
                    break;
            default:
                JOptionPane.showMessageDialog(null, "Type a valid option");
        }

        Main.menu();
    }
}
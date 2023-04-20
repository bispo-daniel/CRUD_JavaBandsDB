import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListBands {
    static String everyRow;
    static void listBands(){
        everyRow = "";
        try {
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

            JTextArea text = new JTextArea(20, 50);
                text.setText(everyRow);
                text.setWrapStyleWord(true);
                text.setLineWrap(true);
                text.setEditable(false);
                text.setFocusable(false);
                text.setOpaque(false);

            JScrollPane pane = new JScrollPane(text);
            JOptionPane.showMessageDialog(null, pane);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Main.menu();
    }
}
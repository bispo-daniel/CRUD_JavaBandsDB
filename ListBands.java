import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListBands {
    static void listBands() throws SQLException {

        BandDao bandDao = new BandDao();
        String everyRow = bandDao.list();

            JTextArea text = new JTextArea(20, 50);
                text.setText(everyRow);
                text.setWrapStyleWord(true);
                text.setLineWrap(true);
                text.setEditable(false);
                text.setFocusable(false);
                text.setOpaque(false);

            JScrollPane pane = new JScrollPane(text);
            JOptionPane.showMessageDialog(null, pane);
            
        Main.menu();
    }
}
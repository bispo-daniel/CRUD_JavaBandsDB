import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListAlbums {
    static void listAlbums() throws SQLException {
        AlbumDao album = new AlbumDao();
        String albumRows = album.list();
        
            JTextArea text = new JTextArea(20, 50);
                text.setText(albumRows);
                text.setWrapStyleWord(true);
                text.setLineWrap(true);
                text.setEditable(false);
                text.setFocusable(false);
                text.setOpaque(false);

            JScrollPane panel = new JScrollPane(text);
            JOptionPane.showMessageDialog(null, panel);
            
        Main.menu();
    }
}
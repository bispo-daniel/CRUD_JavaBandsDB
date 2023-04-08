import javax.swing.JOptionPane;

public class Main {
    static void menu(){
        try{
            String options = "Welcome!\n\n 1) Create Band\n 2) List Bands\n 3) Update Band\n 4) Delete Band\n "
                + "5) Create Album\n 6) List Albums\n 7) Update Album\n 8) Delete Album\n 0) Exit";
            String opString = JOptionPane.showInputDialog(null, options);
            int op = Integer.parseInt(opString);

            switch(op){
                case 0 :
                    System.exit(0);
                case 1:
                    CreateBand.createBand();
                    break;
                case 2:
                    ListBands.listBands();
                    break;
                case 3:
                    UpdateBand.updateBand();
                    break;
                case 4:
                    DeleteBand.deleteBand();
                    break;
                case 5:
                    CreateAlbum.createAlbum();
                    break;
                case 6:
                    ListAlbums.listAlbums();
                    break;
                case 7:
                    UpdateAlbum.updateAlbum();
                    break;
                case 8:
                    DeleteAlbum.deleteAlbum();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Type a valid option");
                    menu();
            }
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Type a number next time...");
            menu();
        }
    }
    public static void main(String[] args) {
        Connect.connect();
        menu();
    }
}
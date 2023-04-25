public class AlbumClass {
    private String albumName;
    private String albumBirth;
    private int bandId;

    //Constructor
    public AlbumClass(String name, String birth, int id){
        this.albumName = name;
        this.albumBirth = birth;
        this.bandId = id;
    }

    public String getAlbumName(){
        return albumName;
    } 
    public void setAlbumName(String name){
        albumName = name;
    }

    public String getAlbumBirth(){
        return albumBirth;
    } 
    public void setAlbumBirth(String birth){
        albumBirth = birth;
    }

    public int getBandId(){
        return bandId;
    } 
    public void setBandId(int id){
        bandId = id;
    }
}
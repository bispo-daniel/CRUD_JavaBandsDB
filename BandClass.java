public class BandClass {
    private String bandName;
    private String bandBirth;

    //Constructor
    public BandClass(String name, String birth){
        this.bandName = name;
        this.bandBirth = birth;
    }

    public String getBandName(){
        return bandName;
    } 
    public void setBandName(String name){
        bandName = name;
    }

    public String getBandBirth(){
        return bandBirth;
    } 
    public void setBandBirth(String birth){
        bandBirth = birth;
    }
}
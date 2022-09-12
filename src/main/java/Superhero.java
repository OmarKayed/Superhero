public class Superhero {
    private String navn;
    private String kræfter;
    private int fødtIÅrstal;
    private String ægteNavn;

    public Superhero (String navn, String kræfter, int fødtIÅrstal, String ægteNavn){
        this.navn = navn;
        this.kræfter = kræfter;
        this.fødtIÅrstal = fødtIÅrstal;
        this.ægteNavn = ægteNavn;
    }

    public String getNavn(){
            return navn;
    }

    public String getKræfter(){
        return kræfter;
    }

    public int getFødtIÅrstal(){
        return fødtIÅrstal;
    }

    public String getÆgteNavn(){
        return ægteNavn;
    }

}

public class Superhero {
    private String navn;
    private String kræfter;
    private String fødtIÅrstal;
    private String ægteNavn;

    public Superhero (String navn, String kræfter, String fødtIÅrstal, String ægteNavn){
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

    public String getFødtIÅrstal(){
        return fødtIÅrstal;
    }

    public String getÆgteNavn(){
        return ægteNavn;
    }

}

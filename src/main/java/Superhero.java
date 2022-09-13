public class Superhero {
    private String navn;
    private String kræfter;
    private int fødtIÅrstal;
    private String ægteNavn;
    private boolean ægteSuperhelt;

    public Superhero (String navn, String kræfter, int fødtIÅrstal, String ægteNavn, boolean ægteSuperhelt){
        this.navn = navn;
        this.kræfter = kræfter;
        this.fødtIÅrstal = fødtIÅrstal;
        this.ægteNavn = ægteNavn;
        this.ægteSuperhelt = ægteSuperhelt;
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

    public boolean getÆgteSuperhelt() {
        return ægteSuperhelt;
    }

}

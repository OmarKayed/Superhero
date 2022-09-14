import java.util.ArrayList;

public class Database {
private ArrayList < Superhero > superheroArrayList;
private int superheroesInTotal;

// Arrayen er blevet erstattet med en arrayliste, for at den ligesom kan expande når der bliver løbet tør for plads
public Database(){
    superheroArrayList = new ArrayList<>();

    // Når du opretter en superhelt starter man på 0, hvilket er hvorfor at totalen er 0
    superheroesInTotal = 0;
}
// Fremfor at min main laver en superhero, så gør min database det inde i mit array
public void createSuperhero (String navn, String kræfter, int fødtIÅrstal, String ægteNavn, boolean ægteSuperhelt){
    Superhero superhero = new Superhero(navn, kræfter,fødtIÅrstal, ægteNavn, ægteSuperhelt);
    superheroesInTotal=superheroArrayList.size();
    superheroArrayList.add(superhero);
    }

    public ArrayList<Superhero> getSuperheroArrayList() {
        return superheroArrayList;
    }

    public void createTestData () {
    createSuperhero("Batman", "Dragt", 1996, "Bruce Wayne",true);
    }
    public Superhero searchForSuperhero(String searchTerm) {
        for (Superhero superhero : superheroArrayList){
            String navn = superhero.getNavn().toLowerCase();
            if (navn.contains(searchTerm.toLowerCase())){
                return superhero;
            }
        }
        return null;
    }

}




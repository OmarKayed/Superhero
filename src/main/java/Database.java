    import java.util.ArrayList;

    public class Database {
    private ArrayList < Superhero > superheroArrayList;
    private int superheroesInTotal;
    // Fremfor at min main laver en superhero, så gør min database det inde i mit array, og dermed kan der være et uendeligt antal af superhelte
    // Arrayen er blevet erstattet med en arrayliste, for at den ligesom kan expande når der bliver løbet tør for plads
    public Database(){
    superheroArrayList = new ArrayList<>();

    superheroesInTotal = 0;  // Når du opretter en superhelt starter man på 0, siden at der ikke er oprettet nogle superhelte
}

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

    private ArrayList < Superhero > searchResults = new ArrayList<>();


    public Superhero searchForSuperhero(String searchTerm){
        Superhero searchResult = null;

        // Et loop igennem arraylisten med superheltene
        for (Superhero superhero : superheroArrayList){
            // Kan skrive fx Batman med småt
            String name = superhero.getNavn().toLowerCase();
            // Hvis superhelten findes, så kan superhelten findes
            if (name.contains(searchTerm.toLowerCase())){
                searchResults.add(superhero);
                searchResult = superhero;
            }
        }
        return searchResult;
    }

}




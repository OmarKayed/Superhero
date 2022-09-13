public class Database {
private Superhero [] superheroes;
private int superheroesInTotal;


// Holder styr på hvor mange helte der er at arbejde med, som fx 5 superhelte
public Database(){
    superheroes = new Superhero[5];
    // Når du opretter en superhelt starter man på 0, hvilket er hvorfor at totalen er 0
    superheroesInTotal = 0;
}
// Fremfor at min main laver en superhero, så gør min database det inde i mit array
public void createSuperhero (String navn, String kræfter, int fødtIÅrstal, String ægteNavn, boolean heroIsReal){
    Superhero superhero = new Superhero(navn, kræfter,fødtIÅrstal, ægteNavn);
    superheroes[superheroesInTotal++] = superhero;
    }

}

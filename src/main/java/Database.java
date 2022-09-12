public class Database {
private Superhero [] superheroes;
private int superheroesInTotal;

public Database(){
    superheroes = new Superhero[5];
    superheroesInTotal = 0;
}
public void createSuperhero (String navn, String kræfter, int fødtIÅrstal, String ægtenavn){
    Superhero superhero = new Superhero(navn, kræfter,fødtIÅrstal, ægtenavn);
    superheroes[superheroesInTotal++] = superhero;
    }

}

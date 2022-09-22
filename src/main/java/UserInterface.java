import java.util.ArrayList;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

public class UserInterface {
    static Scanner scanner = new Scanner(System.in);
    // Databasen bliver sat ind, eftersom at vi skal bruge dens data for at kunne skabe superhelte
    public static Database database = new Database();

    public void startProgram() {

        database.createTestData(); // Den skal fjernes senere hen

        // Programmet bliver sat ind i et loop, da vi har to valgmuligheder. enten at oprette en helt eller afslutte programmetr afslutte programmet
        do {
            System.out.println("Velkommen til superhelte programmet");
            System.out.println("1. Opret superhelt");
            System.out.println("2. Liste af superhelte");
            System.out.println("3. Søg efter en superhelt");
            System.out.println("4. Rediger en superhelt");
            System.out.println("5. Søg efter en specifik superhelt");
            System.out.println("6. Fjern en superhelt");
            System.out.println("9. Afslut");
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 1) {
                System.out.println();
                System.out.println("Indtast din superhelts navn ");
                String heroName = scanner.nextLine();

                System.out.println("Indtast superheltens rigtige navn");
                String heroReal = scanner.nextLine();

                System.out.println("Hvilke kræfter har din superhelt?");
                String heroPower = scanner.nextLine();

                System.out.println("Hvornår blev din superhelt skabt?");
                int heroCreation = scanner.nextInt();
                scanner.nextLine();

                // En boolean bliver skabt nu for at kunne identificere bruges input og ønske om at superhelten er ægte eller ejn er ægte eller ej
                System.out.println("Er din superhelt et ægte menneske? J/N");

                // Char bliver brugt til at kunne indtage brugerens input, så charAt(0), er at tage det førsre bogstave fra J ELLER N bogstave fra J ELLER N
                char heroRealInput = scanner.next().charAt(0);
                scanner.nextLine();
                boolean ægteSuperhelt = false;
                if (heroRealInput == 'J') {
                    ægteSuperhelt = true;
                } else if (heroRealInput == 'N') {
                    ægteSuperhelt = false;
                } else {
                    System.out.println("Ugyldigt input");
                }
                System.out.println();

                // Databasens input kan nu blive brugt her
                database.createSuperhero(heroName, heroPower, heroCreation, heroReal, ægteSuperhelt);
                printSuperheroList();

            } else if (input == 9) {
                System.exit(1);
            } else if (input == 2) {
                printSuperheroList();
            } else if (input == 3) {
                searchForSuperhero();
            } else if (input == 4) {
                editSuperhero();
            } else if (input == 5) {
                findSuperhero();
            } else if (input == 6) {
                deleteSuperhero();
            }

        } while (true);
    }

    // Printer en liste med alle mine get, så at jeg kan få et "overview" af de superhelte som bliver skabtskabt
    // Kan bruge database.getSuperheroArrayList fra min database, til at kunne modtage mine get metoder, hvor at superheltene kan blive skabt af brugerens inputr, hvor at superheltene kan blive skabt af brugerens input
    public static void printSuperheroList() {
        System.out.println("Liste af superhelte: \n");
        for (Superhero superhero : database.getSuperheroArrayList()) {
            System.out.println("Superheltens navn er: " + superhero.getNavn());
            System.out.println("Superheltens rigtige navn er: " + superhero.getÆgteNavn());
            System.out.println("Din superhelt har disse kræfter: " + superhero.getKræfter());
            System.out.println("Årstallet for superhelten er: " + superhero.getFødtIÅrstal());
            // Et loop bliver skabt her for at kunne få et andet input end true eller false, så hvis den er true får jeg et ja, og hvis mit input er false får jeg et nejen er true får jeg et ja, og hvis mit input er false får jeg et nej
            if (superhero.getÆgteSuperhelt() == true) {
                System.out.println("Er din superhelt et menneske? : Ja");
            } else {
                System.out.println("Er din superhelt et menneske? : Nej");
            }
        }
        System.out.println();
    }

    // Ved hjælp af database blev der skabt en metode for at kunne få brugeren til at se hvilken superhelt de har skabthelt de har skabt
    public static void searchForSuperhero() {
        int count = 0;
        int number = 0;
        System.out.println("Indtast din helt her: ");
        String searchTerm = scanner.nextLine();
        ArrayList<Superhero> searchResults = new ArrayList<>();
        ArrayList<Superhero> superhero = database.searchForMoreHeroes(searchTerm);
        boolean searchForSuperheroError = false;

        if (superhero.isEmpty()) { // Hvis brugerens input ikke er fundet, vil vi få et "null"
            System.out.println("Ingen helte fundet");
        } else {
            for (Superhero searchResult : searchResults) {
                if (searchResult != null) {
                    System.out.println(count + 1 + ": " + searchResult.getNavn());
                }
            }
            System.out.println("Vælg den helt der skal udskrives");
            do {
                try {
                    number = Integer.parseInt(scanner.nextLine()); // brugeren indsætter navnet på deres ønsket superhelt for at vælge en superhelt
                    searchForSuperheroError = false;
                    System.out.println("Superheltens navn er: " + searchResults.get(count) + searchResults.get(number).getNavn());
                    System.out.println("Superheltens rigtige navn er: " + searchResults.get(count) + searchResults.get(number).getÆgteNavn());
                    System.out.println("Din superhelt har disse kræfter: " + searchResults.get(count) + searchResults.get(number).getKræfter());
                    System.out.println("Årstallet for superhelten er: " + searchResults.get(count) + searchResults.get(number).getFødtIÅrstal());
                } catch (Exception exception) {
                    System.out.println("Du skal indtaste et navn - Prøv venligst igen");
                    searchForSuperheroError = true;
                }
            } while (searchForSuperheroError == true);
        }
    }

    public void editSuperhero() {
        System.out.println("rediger din helt her: ");
        String searchTerm = scanner.nextLine();
        ArrayList<Superhero> superheroes = database.searchForMoreHeroes(searchTerm);
        boolean editSuperheroError = false;
        for (Superhero searchResult : superheroes) {

            System.out.println("Rediger data og tryk ENTER. Hvis data ikke skal redigeres tryk ENTER");

            String nytNavn = scanner.nextLine();
            if (!nytNavn.isEmpty()) {
                searchResult.setNavn(nytNavn);
            }
            System.out.println("Superheltens rigtige navn er: " + searchResult.getÆgteNavn());
            String nytÆgteNavn = scanner.nextLine();
            if (!nytÆgteNavn.isEmpty()) {
                searchResult.setÆgteNavn(nytÆgteNavn);
            }
            System.out.println("Din superhelt har disse kræfter: " + searchResult.getKræfter());
            String nytKræfter = scanner.nextLine();
            if (!nytKræfter.isEmpty()) {
                searchResult.setKræfter(nytKræfter);
            }
            do {
                try {
                    System.out.println("Årstallet for superhelten er: " + searchResult.getFødtIÅrstal());
                    String nytFødtIÅrstal = scanner.nextLine();
                    editSuperheroError = false;
                    if (nytFødtIÅrstal != null) {
                        searchResult.setFødtIÅrstal(Integer.parseInt(nytFødtIÅrstal));
                    }
                } catch (Exception exception) {
                    System.out.println("Indtast venligst et gyldigt årstal");
                    editSuperheroError = true;
                }

            } while (editSuperheroError);
        }
    }


    public static void findSuperhero() {
        System.out.println("Indtast den helt du gerne vil finde");
        String searchTerm = scanner.nextLine();

        // searchTerm for et imput af databasen
        ArrayList<Superhero> searchResults = database.searchForMoreHeroes(searchTerm);

        int index = 1;
        if (searchResults.isEmpty()){
            System.out.println("Ingen superhelt blev fundet");
        }else {
            for (Superhero searchResult : searchResults) {
                System.out.println(index++ + ": " + searchResult.getNavn());
            }
            System.out.println("Vælg superhelten du vil have skrevet ud: ");
            int superheroChoice = 1;
            boolean inputError = false;
            do{
                try{
                    superheroChoice = Integer.parseInt(scanner.nextLine());
                    inputError = false;
                    System.out.println("Superhelte navn: " + searchResults.get(superheroChoice-1).getNavn());
                    System.out.println("Superkraft: " + searchResults.get(superheroChoice-1).getKræfter());
                    System.out.println("Virkeligt navn: " + searchResults.get(superheroChoice-1).getÆgteNavn());
                    System.out.println("Oprindelsesår: " + searchResults.get(superheroChoice-1).getFødtIÅrstal());
                    System.out.println("Er menneske: " + searchResults.get(superheroChoice-1).getÆgteSuperhelt());
                }
                catch (Exception exception){
                    System.out.println("Ugyldigt input, prøv igen");
                    inputError = true;
                }
            }while(inputError == true);
        }
    }

    public void deleteSuperhero(){
        System.out.println("Indtast den superhelt du gerne vil fjerne ");
        String searchTerm = scanner.nextLine();

        ArrayList<Superhero> searchResults = database.searchForMoreHeroes(searchTerm);

        if (searchResults.isEmpty()){
            System.out.println("Superhelten findes ikke");
        }else {
            int index = 1;
            for (Superhero searchResault : searchResults) {
                System.out.println(index++ + ": " + searchResault.getNavn());
            }
            System.out.println("Vælg den superhelt som du gerne vil få fjernet");

            int deleter = scanner.nextInt();
            Superhero superhero = searchResults.get(deleter-1);
            boolean isDeleted = database.deleteSuperhero(superhero);
            if (isDeleted){
                System.out.println("Superhelten blev slettet");
            }
            else {
                System.out.println("Superhelten blev ikke fjernet");
            }
        }
    }
    }





import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    // Databasen bliver sat ind, eftersom at vi skal bruge dens data for at kunne skabe superhelte
    public static Database database = new Database();

    public static void main(String[] args) {

        // Programmet bliver sat ind i et loop, da vi har to valgmuligheder. enten at oprette en helt eller afslutte programmet
        do {
            System.out.println("Velkommen til superhelte programmet");
            System.out.println("1. Opret superhelt");
            System.out.println("2. Liste af superhelte");
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

// En boolean bliver skabt nu for at kunne identificere bruges input og ønske om at superhelten er ægte eller ej
                System.out.println("Er din superhelt et ægte menneske? J/N");

// Char bliver brugt til at kunne indtage brugerens input, så charAt(0), er at tage det førsre bogstave fra J ELLER N
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
            }
        } while (true);
    }

    // Printer en liste med alle mine get, så at jeg kan få et "overview" af de superhelte som bliver skabt
    // Kan bruge database.getSuperheroArrayList fra min database, til at kunne modtage mine get metoder, hvor at superheltene kan blive skabt af brugerens input
        public static void printSuperheroList(){
            System.out.println("Liste af superhelte: \n");
            for (Superhero superhero : database.getSuperheroArrayList()){
                System.out.println("Superheltens navn er: " + superhero.getNavn());
                System.out.println("Superheltens rigtige navn er: " + superhero.getÆgteNavn());
                System.out.println("Din superhelt har disse kræfter: " + superhero.getKræfter());
                System.out.println("Årstallet for superhelten er: " + superhero.getFødtIÅrstal());
                // Et loop bliver skabt her for at kunne få et andet input end true eller false, så hvis den er true får jeg et ja, og hvis mit input er false får jeg et nej
                if (superhero.getÆgteSuperhelt() == true) {
                    System.out.println("Er din superhelt et menneske? : Ja");
                } else {
                    System.out.println("Er din superhelt et menneske? : Nej");
                }
            }
            System.out.println();
        }
    }

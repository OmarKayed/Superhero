import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    // Databasen bliver sat ind, eftersom at vi skal bruge dens data for at kunne skabe superhelte
    public static Database database = new Database();

    public static void main(String[] args){
        System.out.println("Velkommen til superhelte programmet");
        System.out.println("1. Opret superhelt");
        System.out.println("9. Afslut");
        // Programmet bliver sat ind i et loop, da vi har to valgmuligheder. enten at oprette en helt eller afslutte programmet

        int input = scanner.nextInt();
        scanner.nextLine();
        if (input==1){
            System.out.println("Indtast din superhelts navn ");
            String heroName = scanner.nextLine();

            System.out.println("Indtast superheltens rigtige navn");
            String heroReal = scanner.nextLine();

            System.out.println("Hvilke kræfter har din superhelt?");
            String heroPower = scanner.nextLine();

            System.out.println("Hvornår blev din superhelt skabt?");
            int heroCreation = scanner.nextInt();

// En boolean bliver skabt nu for at kunne identificere bruges input og ønske om at superhelten er ægte eller ej
            System.out.println("Er din superhelt et ægte menneske? J/N");
            char heroRealInput = scanner.next().charAt(0);
            boolean ægteSuperhelt = false;
            if (heroRealInput == 'j'){
                ægteSuperhelt = true;
            }else if (heroRealInput == 'n'){
                ægteSuperhelt = false;
            }else{
                System.out.println("Ugyldigt input");
            }
            // Databasens input kan nu blive brugt her
            database.createSuperhero(heroName,heroPower,heroCreation,heroReal, ægteSuperhelt);

        } else if(input==9){
            System.exit(1);
        }

    }
}

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Velkommen til superhelte programmet");
        System.out.println("1. Opret superhelt");
        System.out.println("9. Afslut");
        int input = scanner.nextInt();
        if (input==1){
            System.out.println("Indtast din superhelts navn ");
            String heroName = scanner.next();

            System.out.println("Hvilke kræfter har din superhelt?");
            String heroPower = scanner.next();

            System.out.println("Hvornår blev din superhelt skabt?");
            int heroCreation = scanner.nextInt();

            System.out.println("Er din superhelt et ægte menneske? Y/N");
            String heroReal = scanner.next();
            Superhero superhero1 = new Superhero(heroName, heroPower, heroCreation, heroReal);

        } else if(input==9){
            System.exit(1);
        }

    }
}

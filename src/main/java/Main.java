import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Velkommen til superhelte programmet");

        System.out.println("Indtast din superhelts navn ");
        String heroName = scanner.next();

        System.out.println("Hvilke kræfter har din superhelt?");
        String heroPower = scanner.next();

        System.out.println("Hvornår blev din superhelt skabt?");
        String heroCreation = scanner.next();

        System.out.println("Er din superhelt et ægte menneske? Y/N");
        String heroReal = scanner.next();
    }
}

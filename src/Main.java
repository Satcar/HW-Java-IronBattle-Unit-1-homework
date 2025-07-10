import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //pedir params un mago (nombre, hp)
        System.out.print("Nombre para el mago: ");
        String nombre1 = teclado.nextLine();
        System.out.print("HP para el mago: ");
        int hp1 = teclado.nextInt();

        Warrior guerrero1 = new Warrior(nombre1, hp1);

        //pedir params un guerrero (nombre, hp)
        System.out.print("Nombre para el mago: ");
        String nombre2 = teclado.nextLine();
        System.out.print("HP para el mago: ");
        int hp2 = teclado.nextInt();

        Warrior guerrero2 = new Warrior(nombre2, hp2);

        //arena para pelear
        while(true)
        {

            break;
        }

    }

}

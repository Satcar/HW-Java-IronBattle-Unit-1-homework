import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
        //pedir params un mago (nombre, hp)
        System.out.print("Nombre para el mago: ");
        String nombre1 = sc.nextLine();
        System.out.print("HP para el mago: ");
        int hp1;
        do {
            hp1 = sc.nextInt();
            sc.nextLine();
            if (hp1 < 50 || hp1 > 100) {
                System.out.println("Vida incorrecta, introduce un valor entre 50-100");
            }


        } while (hp1 < 50 || hp1 > 100);


        Warrior guerrero1 = new Warrior(nombre1, hp1);

        System.out.println("Nombre: " + nombre1 + " vida: " + hp1);
*/
        //menu
        // 1. crear guerro
        // 2. crear mago
        // 3. salir

/*
        int menuChoice;
        do {
            System.out.println("""

                    ----- MENU -----
                    1. Crear guerrero
                    2. Crear wizard
                    3. Salir
                    """);
            menuChoice = sc.nextInt();
            sc.nextLine();
            switch (menuChoice) {
                case 0:
                    // crear dos personajes aleatorios
                    break;

                case 1:
                    // crear guerrero
                    break;
                case 2:
                    // crear mago
                    break;

                default:
                    // sout con mensaje de error o un throw
            }
        } while (menuChoice != 3);




    }

*/
        Warrior w1 = new Warrior("Asd");
        System.out.println(w1);
        //System.out.println("Nombre: " + w1.getName() + " Stamina: " + w1.getStamina());


    }
}

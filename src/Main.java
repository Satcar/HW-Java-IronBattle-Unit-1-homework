import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        CÓMO FUNCIONA EL SIMULADOR DE BATALLA

        Los personajes se crean antes de que comience la batalla. Pueden tener el mismo tipo de personaje o tipos diferentes.
        La batalla es uno contra uno y se desarrolla por rondas. En cada ronda, ambos combatientes atacan al mismo tiempo (por lo tanto, incluso si uno de ellos da el golpe final, ambos recibirán daño).
        Así que el combate podría terminar en empate. En caso de empate, la batalla se reinicia hasta que haya un único ganador.
        Se mostrará un registro completo de la batalla en la línea de comandos. Cuando la batalla termine, también se mostrará el ganador.
        */

        /*
        REQUISITOS

        Para este proyecto debes cumplir con todo lo siguiente:
            1.	Navegar por un menú basado en texto utilizando la entrada y salida estándar.
            2.	Crear guerreros y magos personalizando individualmente sus estadísticas y nombre.
            3.	Realizar una batalla entre los personajes y determinar al ganador.
            4.	Mantener un registro detallado (en la salida estándar) de cada acción realizada durante los duelos.

        Extras (Bonus)
            1.	Importar personajes utilizando un archivo CSV.
            2.	Simular toda la batalla con un solo comando creando personajes aleatorios con estadísticas aleatorias y haciendo que se enfrenten en duelo.

        Notas importantes:
            •	Todos los integrantes del equipo deben contribuir de manera equitativa al proyecto, tanto en tiempo como en líneas de código escritas.
            •	Todo el código debe ser revisado antes de ser incorporado a la rama principal (master).
            •	Todos los miembros del equipo deben participar en la revisión de código.
            •	Cada repositorio debe tener un archivo README con instrucciones claras, archivos de demostración o cualquier documentación necesaria para que otros equipos no tengan problemas al revisar.
            •	Este proyecto está diseñado para ser un desafío. Tendrás que apoyarte mucho en tu equipo y en tu capacidad de investigación independiente. Aprender de forma autónoma es una característica clave de un buen desarrollador, y nuestro objetivo es convertirte en uno. Este proceso puede resultar frustrante, ¡pero aprenderás muchísimo!
        */

        Scanner sc = new Scanner(System.in);



//        //pedir params un mago (nombre, hp)
//        System.out.print("Nombre para el mago: ");
//        String nombre1 = sc.nextLine();
//        System.out.print("HP para el mago: ");
//        int hp1;
//        do {
//            hp1 = sc.nextInt();
//            sc.nextLine();
//            if (hp1 < 50 || hp1 > 100) {
//                System.out.println("Vida incorrecta, introduce un valor entre 50-100");
//            }
//
//
//        } while (hp1 < 50 || hp1 > 100);
//
//
//        Warrior guerrero1 = new Warrior(nombre1, hp1);
//
//        System.out.println("Nombre: " + nombre1 + " vida: " + hp1);

//        menu
//         1. crear guerro
//         2. crear mago
//         3. salir
//
//        int menuChoice;
//        do {
//            System.out.println("""
//
//                    ----- MENU -----
//                    1. Crear guerrero
//                    2. Crear wizard
//                    3. Salir
//                    """);
//            menuChoice = sc.nextInt();
//            sc.nextLine();
//            switch (menuChoice) {
//                case 0:
//                    // crear dos personajes aleatorios
//                    break;
//
//                case 1:
//                    // crear guerrero
//                    break;
//                case 2:
//                    // crear mago
//                    break;
//
//                default:
//                    // sout con mensaje de error o un throw
//            }
//        } while (menuChoice != 3);
//    }
//        Warrior w1 = new Warrior("Asd");
//        System.out.println(w1);
//        System.out.println("Nombre: " + w1.getName() + " Stamina: " + w1.getStamina());

    }
}

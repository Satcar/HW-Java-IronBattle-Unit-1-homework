import java.util.ArrayList;
import java.util.Random;
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

        //FIXME: pendiente introducción para que no salte el menú directamente

        int menuChoice;
        do {
            System.out.println("""
                    ----- MENÚ -----
                    1. Todo aleatorio
                    2. Selección manual de personajes
                    3. Añadir personajes desde CSV
                    4. Salir
                    """);
            System.out.print("Elige una opción: ");
            menuChoice = sc.nextInt();
            sc.nextLine();

            switch (menuChoice) {
                case 1: // Crear personajes aleatorios
                    Random random = new Random();
                    ArrayList<Character> characters = new ArrayList<>();
                    for (int i = 0; i < 2; i++) {
                        int numeroAleatorio = random.nextInt(2) + 1;
                        if (numeroAleatorio == 1) {
                            Warrior warrior = new Warrior("Jugador " + (i + 1));
                            characters.add(warrior);
                        } else if (numeroAleatorio == 2) {
                            Wizard wizard = new Wizard("Jugador " + (i + 1));
                            characters.add(wizard);
                        }
                    }
                    for (int i = 0; i < 50; i++) {
                        System.out.println();
                    }
                    System.out.println("--- PARTICIPANTES ---");
                    System.out.println(characters.get(0).toString());
                    System.out.println(characters.get(1).toString());

                    Battle battle = new Battle();
                    battle.iniciarBatalla(characters.get(0), characters.get(1));
                    break;

                case 2: // Selección manual personajes

                    break;
                case 3: // Selección personajes desde archivo CSV

                    break;

                case 4:
                    System.out.println("Salir programa");
                    break;
                default:
                    System.out.println("Opción no valida. Vuelve a intentarlo\n");
                    break;

            }
        } while (menuChoice != 4) ;
    }

    private static void battle(Character character, Character character1) {

    }
}
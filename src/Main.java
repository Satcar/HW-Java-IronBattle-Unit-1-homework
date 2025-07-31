import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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
        Random random = new Random();
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
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    System.out.println("--- PARTICIPANTES ---");
                    System.out.println(characters.get(0).toString());
                    System.out.println(characters.get(1).toString());

                    Thread.sleep(3000);

                    Battle battle = new Battle();
                    battle.iniciarBatalla(characters.get(0), characters.get(1));
                    break;

                case 2: // Selección manual personajes
                    String nombreJugador1;
                    String tipoJugador1;
                    Character jugador1 = null;

                    System.out.print("\nSelecciona un nombre para el/la personaje 1: ");
                    nombreJugador1 = sc.nextLine();

                    while (true) {
                        System.out.print("Selecciona el tipo de jugador 1 (guerrero/mago): ");
                        tipoJugador1 = sc.nextLine().toLowerCase();

                        if (tipoJugador1.equals("guerrero")) {
                            jugador1 = new Warrior(nombreJugador1);

                            // HP
                            while (true) {
                                System.out.print("Introduce la vida (HP) del guerrero (100-200): ");
                                if (sc.hasNextInt()) {
                                    int hp = sc.nextInt();
                                    sc.nextLine(); // limpiar buffer
                                    if (hp >= 100 && hp <= 200) {
                                        jugador1.setHp(hp);
                                        break;
                                    } else {
                                        System.out.println("La vida debe estar entre 100 y 200.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            // Stamina
                            while (true) {
                                System.out.print("Introduce el aguante (10-50): ");
                                if (sc.hasNextInt()) {
                                    int stamina = sc.nextInt();
                                    sc.nextLine();
                                    if (stamina >= 10 && stamina <= 50) {
                                        ((Warrior) jugador1).setStamina(stamina);
                                        break;
                                    } else {
                                        System.out.println("El aguante debe estar entre 10 y 50.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            // Strength
                            while (true) {
                                System.out.print("Introduce la fuerza (1-10): ");
                                if (sc.hasNextInt()) {
                                    int strength = sc.nextInt();
                                    sc.nextLine();
                                    if (strength >= 1 && strength <= 10) {
                                        ((Warrior) jugador1).setStrength(strength);
                                        break;
                                    } else {
                                        System.out.println("La fuerza debe estar entre 1 y 10.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número");
                                    sc.nextLine();
                                }
                            }
                            break;

                        } else if (tipoJugador1.equals("mago")) {
                            jugador1 = new Wizard(nombreJugador1);

                            // HP
                            while (true) {
                                System.out.print("Introduce la vida (HP) del mago (50-100): ");
                                if (sc.hasNextInt()) {
                                    int hp = sc.nextInt();
                                    sc.nextLine(); // limpiar buffer
                                    if (hp >= 50 && hp <= 100) {
                                        jugador1.setHp(hp);
                                        break;
                                    } else {
                                        System.out.println("La vida debe estar entre 50 y 100.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            // Mana
                            while (true) {
                                System.out.print("Introduce el maná (10-50): ");
                                if (sc.hasNextInt()) {
                                    int mana = sc.nextInt();
                                    sc.nextLine();
                                    if (mana >= 10 && mana <= 50) {
                                        ((Wizard) jugador1).setMana(mana);
                                        break;
                                    } else {
                                        System.out.println("El maná debe estar entre 10 y 50.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            // Intelligence
                            while (true) {
                                System.out.print("Introduce la inteligencia (1-50): ");
                                if (sc.hasNextInt()) {
                                    int intelligence = sc.nextInt();
                                    sc.nextLine();
                                    if (intelligence >= 1 && intelligence <= 50) {
                                        ((Wizard) jugador1).setIntelligence(intelligence);
                                        break;
                                    } else {
                                        System.out.println("La inteligencia debe estar entre 1 y 50.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }
                            break;

                        } else {
                            System.out.println("Tipo de jugador no válido. Intenta de nuevo.");
                        }
                    }

                    System.out.println("\n¡Genial! Creaste a " + jugador1);

                    String nombreJugador2;
                    String tipoJugador2;
                    Character jugador2 = null;

                    System.out.print("\nSelecciona un nombre para el/la personaje 2: ");
                    nombreJugador2 = sc.nextLine();

                    while (true) {
                        System.out.print("Selecciona el tipo de jugador 2 (guerrero/mago): ");
                        tipoJugador2 = sc.nextLine().toLowerCase();

                        if (tipoJugador2.equals("guerrero")) {
                            jugador2 = new Warrior(nombreJugador2);

                            // HP
                            while (true) {
                                System.out.print("Introduce la vida (HP) del guerrero (100-200): ");
                                if (sc.hasNextInt()) {
                                    int hp = sc.nextInt();
                                    sc.nextLine();
                                    if (hp >= 100 && hp <= 200) {
                                        jugador2.setHp(hp);
                                        break;
                                    } else {
                                        System.out.println("La vida debe estar entre 100 y 200.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            // Stamina
                            while (true) {
                                System.out.print("Introduce el aguante (10-50): ");
                                if (sc.hasNextInt()) {
                                    int stamina = sc.nextInt();
                                    sc.nextLine();
                                    if (stamina >= 10 && stamina <= 50) {
                                        ((Warrior) jugador2).setStamina(stamina);
                                        break;
                                    } else {
                                        System.out.println("El aguante debe estar entre 10 y 50.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            // Strength
                            while (true) {
                                System.out.print("Introduce la fuerza (1-10): ");
                                if (sc.hasNextInt()) {
                                    int strength = sc.nextInt();
                                    sc.nextLine();
                                    if (strength >= 1 && strength <= 10) {
                                        ((Warrior) jugador2).setStrength(strength);
                                        break;
                                    } else {
                                        System.out.println("La fuerza debe estar entre 1 y 10.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            break;

                        } else if (tipoJugador2.equals("mago")) {
                            jugador2 = new Wizard(nombreJugador2);

                            // HP
                            while (true) {
                                System.out.print("Introduce la vida (HP) del mago (50-100): ");
                                if (sc.hasNextInt()) {
                                    int hp = sc.nextInt();
                                    sc.nextLine();
                                    if (hp >= 50 && hp <= 100) {
                                        jugador2.setHp(hp);
                                        break;
                                    } else {
                                        System.out.println("La vida debe estar entre 50 y 100.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            // Mana
                            while (true) {
                                System.out.print("Introduce el maná (10-50): ");
                                if (sc.hasNextInt()) {
                                    int mana = sc.nextInt();
                                    sc.nextLine();
                                    if (mana >= 10 && mana <= 50) {
                                        ((Wizard) jugador2).setMana(mana);
                                        break;
                                    } else {
                                        System.out.println("El maná debe estar entre 10 y 50.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }

                            // Intelligence
                            while (true) {
                                System.out.print("Introduce la inteligencia (1-50): ");
                                if (sc.hasNextInt()) {
                                    int intelligence = sc.nextInt();
                                    sc.nextLine();
                                    if (intelligence >= 1 && intelligence <= 50) {
                                        ((Wizard) jugador2).setIntelligence(intelligence);
                                        break;
                                    } else {
                                        System.out.println("La inteligencia debe estar entre 1 y 50.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Introduce un número.");
                                    sc.nextLine();
                                }
                            }
                            break;

                        } else {
                            System.out.println("Tipo de jugador no válido. Intenta de nuevo.");
                        }
                    }

                    System.out.println("\n¡Genial! Creaste a " + jugador2);

                    Thread.sleep(3000);

                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }

                    System.out.println("Cargando personajes, configurando batalla...");
                    for (int i = 0; i < 45; i++) {
                        System.out.print('█');
                        Thread.sleep(250);
                    }

                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }

                    System.out.println("\n--- PARTICIPANTES ---");
                    System.out.println(jugador1);
                    System.out.println(jugador2);

                    Thread.sleep(3000);

                    Battle battle1 = new Battle();
                    battle1.iniciarBatalla(jugador1, jugador2);


                    break;
                case 3: // Selección personajes desde archivo CSV
                    System.out.println("\nEn construcción...\n\n");
                    break;

                case 4:
                    System.out.println("Has salido del programa. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no valida. Vuelve a intentarlo\n");
                    break;

            }
        } while (menuChoice != 4) ;
    }
}
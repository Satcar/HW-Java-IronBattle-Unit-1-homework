import java.util.Random;

public class Wizard extends Character implements Attacker {

    /*
    Clase Mago (Wizard)
    Esta clase deriva de la clase Character. Un Mago es un Personaje que lucha lanzando hechizos.
    Los hechizos infligen daño y requieren maná para poder lanzarse.

    La clase Wizard tendrá:
        ✅ Una variable llamada mana de tipo int, con un valor aleatorio entre 10 y 50, que representa un recurso que el mago consume para lanzar hechizos (miembro privado).
        ✅ Una variable llamada intelligence de tipo int, con un valor aleatorio entre 1 y 50, que mide cuán potentes son los hechizos del mago (miembro privado).
        ✅ Funciones públicas getter para acceder a estas variables.
        ✅ Funciones públicas setter para modificar estas variables.
        ✅ Un constructor con parámetros que reciba nombre, hp, mana e inteligencia.
        ✅ Una función pública que sobrecarga el método attack() implementado en la interfaz Attacker, que tomará un personaje como parámetro y reducirá su salud en función de la inteligencia del hechizo.
     */

    // Parámetros
    private int mana; //Recurso que consume el mago para hacer un hechizo
    private int intelligence; // Mide como de fuerte es el hechizo

    // Constructores

    public Wizard(String name) {
        super(name);
        Random aleatorio = new Random();
        this.setHp(aleatorio.nextInt(51) + 50); // Número aleatorio entre 50-100 ((0 a 50) + 50 = 50 a 100)
        this.mana = aleatorio.nextInt(41) + 10; // Número aleatorio entre 10-50 ((0 a 40) + 10 = 10 a 50)
        this.intelligence = aleatorio.nextInt(50) + 1; // Número aleatorio entre 1-50 ((0 a 49) + 1 = 1 a 50)
    }

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp);
        Random aleatorio = new Random();
        this.setHp(aleatorio.nextInt(51) + 50); // Número aleatorio entre 50-100 ((0 a 50) + 50 = 50 a 100)
        this.mana = aleatorio.nextInt(41) + 10; // Número aleatorio entre 10-50 ((0 a 40) + 10 = 10 a 50)
        this.intelligence = aleatorio.nextInt(50) + 1; // Número aleatorio entre 1-50 ((0 a 49) + 1 = 1 a 50)
    }

    //Getters & Setters
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /*
    Mago:

    Los magos son los maestros de lo arcano y su atributo principal es la inteligencia.
    En cada ronda, un mago intentará lanzar aleatoriamente una Bola de Fuego o un Golpe de Bastón.
    El daño de una Bola de Fuego es igual a su inteligencia (intelligence), y cada lanzamiento de Bola de Fuego reducirá su maná (mana) en 5 puntos.
    El daño de un Golpe de Bastón es igual a 2. Cada Golpe de Bastón recupera 1 punto de maná.

    Si un mago no tiene suficiente maná para lanzar una Bola de Fuego, realizará un Golpe de Bastón en su lugar.
    Si un mago no tiene suficiente maná ni siquiera para realizar un Golpe de Bastón, no infligirá daño y recuperará 2 puntos de maná.
    */

    // Métodos propios de Wizard
    @Override
    public String attack(Character enemigo) {

        int hit;
        String tipoAtaque;
        Random aleatorio = new Random();
        boolean fireball = aleatorio.nextBoolean();

        if (fireball) { // Seleccionado aleatoriamente: bola de fuego
            if (mana >= 5) {
                hit = getIntelligence();
                mana -= 5;
                tipoAtaque = "utilizó bola de fuego";
            } else if (mana >= 1) { // Si no puede bola de fuego, intenta realizar golpe de bastón
                hit = 2;
                mana += 1;
                tipoAtaque = "utilizó golpe de bastón";
            } else { // Si no puede realizar golpe de bastón, no ataca
                hit = 0;
                mana += 2;
                tipoAtaque = "no tiene maná suficiente, no puede atacar";
            }
        } else { // Seleccionado aleatoriamente: golpe de bastón
            if (mana >= 1) {
                hit = 2;
                mana += 1;
                tipoAtaque = "utilizó golpe de bastón";
            } else { // Si no puede realizar golpe de bastón, no ataca
                hit = 0;
                mana += 2;
                tipoAtaque = "no tiene maná suficiente, no puede atacar";
            }
        }
        enemigo.setHp(enemigo.getHp() - hit);
        return tipoAtaque + ". Causó: " + hit + " daño.";
    }

    @Override
    public String toString() {
        return getName() + " (MAGO/A): HP: " + getHp() + " | Mana: " + getMana() + " | Intelligence: " + getIntelligence();
    }
}

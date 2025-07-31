import java.util.Random;

public class Warrior extends Character implements Attacker {
    /*
    Clase Guerrero (Warrior)
    Esta clase deriva de la clase Character. Un Guerrero es un Personaje que lucha atacando. Los ataques infligen daño y, para realizar uno, se necesita resistencia (stamina).

    La clase Warrior tendrá:
        ✅ Una variable llamada stamina de tipo int, con un valor aleatorio entre 10 y 50, que representa un recurso que el guerrero consume para hacer un ataque (miembro privado)
        ✅ Una variable llamada strength de tipo int, con un valor aleatorio entre 1 y 10, que mide cuán fuerte es el ataque del guerrero (miembro privado)
        ✅ Funciones públicas "getter" para acceder a estas variables
        ✅ Funciones públicas "setter" para modificar estas variables
        ✅ Un constructor con parámetros que reciba nombre, hp, stamina y strength
        ✅ Una función pública que sobrecarga el metodo attack() implementado en la interfaz Attacker, que recibirá un personaje como parámetro y reducirá su salud en función de la fuerza del ataque
    */

    // Parámetros
    private int stamina; //Recurso que consume el guerrero para hacer un ataque
    private int strength; // Mide como de fuerte es el ataque

    // Constructores
    public Warrior(String name, int hp) {
        super(name, hp);
        Random aleatorio = new Random();
        this.setHp(aleatorio.nextInt(101) + 100); // Número aleatorio entre 100-200 ((0 a 100) + 100 = 100 a 200)
        this.stamina = aleatorio.nextInt(41) + 10; // Número aleatorio entre 10-50 ((0 a 40) + 10 = 10 a 50)
        this.strength = aleatorio.nextInt(10) + 1; // Número aleatorio entre 1-10 ((0 a 9) + 1 = 1 a 10)
    }

    public Warrior(String name) {
        super(name);
        Random aleatorio = new Random();
        this.setHp(aleatorio.nextInt(101) + 100);
        this.stamina = aleatorio.nextInt(41) + 10; // Número aleatorio entre 10-50. ((0 a 40) + 10 = 10 a 50)
        this.strength = aleatorio.nextInt(10) + 1; // Número aleatorio entre 1-10 ((0 a 9) + 1 = 1 a 10)
    }



    //Getters & Setters
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    /*
    Guerrero:

    Los guerreros son personajes fuertes y bien armados que se enfocan en el atributo de fuerza.
    En cada ronda, un guerrero realizará aleatoriamente un Ataque Fuerte o un Ataque Débil.
    El daño de un Ataque Fuerte es igual a su fuerza (strength), y cada golpe reducirá su resistencia (stamina) en 5 puntos.
    El daño de un Ataque Débil es la mitad de su fuerza (truncando los decimales).
    Cada Ataque Débil recupera 1 punto de resistencia.

    Si un guerrero no tiene la resistencia suficiente para realizar un Ataque Fuerte, hará un Ataque Débil en su lugar.
    Si un guerrero no tiene la resistencia suficiente ni siquiera para hacer un Ataque Débil, no infligirá daño y recuperará 2 puntos de resistencia.
    */

    // Métodos propios de Warrior
    @Override
    public String attack(Character enemigo) {

        int hit;
        String tipoAtaque;
        Random aleatorio = new Random();
        boolean isStrongAttack = aleatorio.nextBoolean();

        if (isStrongAttack) { // Seleccionado aleatoriamente: ataque fuerte
            if (stamina >= 5) {
                hit = getStrength();
                stamina -= 5;
                tipoAtaque = "utilizó ataque fuerte";
            } else if (stamina >= 1) { // Si no puede ataque fuerte, intenta realizar ataque débil
                hit = getStrength() / 2;
                stamina += 1;
                tipoAtaque = "utilizó ataque débil";
            } else { // Si no puede realizar ataque débil, no ataca
                hit = 0;
                stamina += 2;
                tipoAtaque = "no tiene stamina suficiente, no puede atacar";
            }
        } else { // Seleccionado aleatoriamente: ataque débil
            if (stamina >= 1) {
                hit = getStrength() / 2;
                stamina += 1;
                tipoAtaque = "utilizó ataque débil";
            } else { // Si no puede realizar ataque débil, no ataca
                hit = 0;
                stamina += 2;
                tipoAtaque = "no tiene stamina suficiente, no puede atacar";
            }
        }
        enemigo.setHp(enemigo.getHp() - hit);
        return tipoAtaque + ". Causó: " + hit + " daño.";
    }

    @Override
    public String toString() {
        return getName() + " (GUERRERO/A): HP: " + getHp() + " | Aguante: " + getStamina() + " | Fuerza: " + getStrength();
    }
}

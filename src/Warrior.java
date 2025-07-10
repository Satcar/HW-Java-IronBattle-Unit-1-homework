import java.util.Calendar;
import java.util.Random;

public class Warrior extends Character implements BattleInterface{
    /*
    Clase Guerrero (Warrior)
    Esta clase deriva de la clase Character. Un Guerrero es un Personaje que lucha atacando. Los ataques infligen daño y, para realizar uno, se necesita resistencia (stamina).

    La clase Warrior tendrá:
        ✅ Una variable llamada stamina de tipo int, con un valor aleatorio entre 10 y 50, que representa un recurso que el guerrero consume para hacer un ataque (miembro privado)
        ✅ Una variable llamada strength de tipo int, con un valor aleatorio entre 1 y 10, que mide cuán fuerte es el ataque del guerrero (miembro privado)
        ✅ Funciones públicas "getter" para acceder a estas variables
        ✅ Funciones públicas "setter" para modificar estas variables
        ✅ Un constructor con parámetros que reciba nombre, hp, stamina y strength
        🔜 Una función pública que sobrecarga el metodo attack() implementado en la interfaz Attacker, que recibirá un personaje como parámetro y reducirá su salud en función de la fuerza del ataque
    */

    // Parámetros
    private int stamina; //Recurso que consume el guerrero para hacer un ataque
    private int strength; // Mide como de fuerte es el ataque

    // Constructores
    public Warrior(String name, int hp) {
        super(name, hp);
        Random aleatorio = new Random();
        this.stamina = aleatorio.nextInt(41) + 10; // Número aleatorio entre 10-50. ((0 a 40) + 10 = 10 a 50)
        this.strength = aleatorio.nextInt(10) + 1; // 1-10 ((0 a 9) + 1 = 1 a 10)
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

    // Métodos propios de Warrior
    @Override
    public void attack(Character enemigo) {

    }
}

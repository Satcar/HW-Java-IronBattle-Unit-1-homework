
public class Battle {
    public void iniciarBatalla(Character c1, Character c2) {
        System.out.println("\n--- COMIENZA LA BATALLA ---");
        int ronda = 1;

        while (c1.getIsAlive() && c2.getIsAlive()) {
            System.out.println("\n>>> Ronda " + ronda);
            c1.attack(c2);
            c2.attack(c1);

            System.out.println(c1.getName() + " ataca.");
            System.out.println(c2.getName() + " ataca.");
            System.out.println("HP restante de " + c1.getName() + ": " + c1.getHp());
            System.out.println("HP restante de " + c2.getName() + ": " + c2.getHp());

            ronda++;
        }


        if (c1.getHp() <= 0 && c2.getHp() <= 0) {
            System.out.println("\n¡Empate! Ambos personajes han caído.");
        } else if (c1.getHp() <= 0) {
            System.out.println("\n¡" + c2.getName() + " gana la batalla!");
        } else {
            System.out.println("\n¡" + c1.getName() + " gana la batalla!");
        }
    }
}
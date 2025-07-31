
public class Battle {
    public void iniciarBatalla(Character c1, Character c2) throws InterruptedException {
        System.out.println("\n--- COMIENZA LA BATALLA ---");
        Warrior guerrero1 = null;
        Wizard mago1 = null;
        Warrior guerrero2 = null;
        Wizard mago2 = null;

        if (c1 instanceof Warrior) {
            guerrero1 = (Warrior) c1;
        } else if (c1 instanceof Wizard) {
            mago1 = (Wizard) c1;
        }

        if (c2 instanceof Warrior) {
            guerrero2 = (Warrior) c2;
        } else if (c2 instanceof Wizard) {
            mago2 = (Wizard) c2;
        }
        int ronda = 1;

        while (c1.getIsAlive() && c2.getIsAlive()) {
            System.out.println("\n>>> Ronda " + ronda + " <<<");

            String resultadoAtaque1 = c1.attack(c2);
            String resultadoAtaque2 = c2.attack(c1);

            if (guerrero1 != null) {
                System.out.println("--------------------------------------------------");
                System.out.print(c1.getName() + " (GUERRERO/A) " +resultadoAtaque1);
                System.out.println("\n---> HP: " + guerrero1.getHp() + " | Stamina: " + guerrero1.getStamina() + " | Strenght: " + guerrero1.getStrength());
            } else if (mago1 != null) {
                System.out.println("--------------------------------------------------");
                System.out.print(c1.getName() + " (MAGO/A) " +resultadoAtaque1);
                System.out.println("\n---> HP: " + mago1.getHp() + " | Maná: " + mago1.getMana() + " | Intelligence: " + mago1.getIntelligence());
            }
            if (guerrero2 != null) {
                System.out.print("\n" + c2.getName() + " (GUERRERO/A) " + resultadoAtaque2);
                System.out.println("\n--->: HP: " + guerrero2.getHp() + " | Stamina: " + guerrero2.getStamina() + " | Strenght: " + guerrero2.getStrength());
                System.out.println("--------------------------------------------------");
            } else if (mago2 != null) {
                System.out.print("\n" + c2.getName() + " (MAGO/A) " + resultadoAtaque2);
                System.out.println("\n---> HP: " + mago2.getHp() + " | Maná: " + mago2.getMana() + " | Intelligence: " + mago2.getIntelligence());
                System.out.println("--------------------------------------------------");
            }

            Thread.sleep(1000);

            ronda++;
        }

        if (c1.getHp() <= 0 && c2.getHp() <= 0) {
            System.out.println("\n¡Empate! Ambos personajes han caído.\n");
        } else if (c1.getHp() <= 0) {
            System.out.println("\n¡" + c2.getName() + " gana la batalla!\n\n");
        } else {
            System.out.println("\n¡" + c1.getName() + " gana la batalla!\n\n");
        }
    }
}

private static void Battle (Character c1, Character c2) {
    System.out.println("\n--- COMIENZA LA BATALLA ---");
    int ronda = 1;

    while (c1.getHp() > 0 && c2.getHp() > 0) {
        System.out.println("\n>>> Ronda " + ronda);
        int d1 = c1.attack();
        int d2 = c2.attack();

        c2.setHp(c2.getHp() - d1);
        c1.setHp(c1.getHp() - d2);

        System.out.println(c1.getName() + " ataca y causa " + d1 + " de daño.");
        System.out.println(c2.getName() + " ataca y causa " + d2 + " de daño.");
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
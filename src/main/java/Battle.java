public class Battle {
    public static boolean fight(Army st, Army nd) {
        int i = 0;
        int j = 0;
        while (true) {
            while (true) {
                if (damage(st, nd, i, j)) break;
                if (damage(nd, st, j, i)) break;
            }
            if (!nd.getWarrior(j).isAlive()) {
                j++;
            } else {
                i++;
            }
            if (st.isDefeated()) {
                return false;
            }
            if (nd.isDefeated()) {
                return true;
            }
        }
    }

    private static boolean damage(Army Attack, Army Defence, int i, int j) {
        Defence.getWarrior(j).damage(Attack.getWarrior(i));
        if ((Attack.getWarrior(i) instanceof Lancer) && (j < Defence.size() - 1)) {
            Defence.getWarrior(j + 1).halfDamage(Attack.getWarrior(i));
        }
        if ((i < Attack.size() - 1) && (Attack.getWarrior(i + 1) instanceof Healer)) {
            ((Healer) Attack.getWarrior(i + 1)).heal(Attack.getWarrior(i));
        }
        return !Defence.getWarrior(j).isAlive();
    }
}

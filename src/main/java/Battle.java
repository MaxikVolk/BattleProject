public class Battle {
    public static boolean fight(Army st, Army nd) {
        int i = 0;
        int j = 0;
        while (true) {
            if (Fight.fight(st.getWarrior(i), nd.getWarrior(j))) {
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
}

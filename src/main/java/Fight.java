public class Fight {
    public static boolean fight(Warrior st, Warrior nd) {
        while (true) {
            st.damage(nd);
            if (!nd.isAlive()) {
                return true;
            }
            nd.damage(st);
            if (!st.isAlive()) {
                return false;
            }
        }
    }

}

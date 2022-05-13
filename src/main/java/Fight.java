public class Fight {
    public static boolean fight(Warrior st,Warrior nd){
        while(true){
            nd.damage(st.getAttack());
            if(!nd.is_alive){
                return true;
            }
            st.damage(nd.getAttack());
            if(!st.is_alive){
                return false;
            }
        }
    }
}

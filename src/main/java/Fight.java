public class Fight {
    public static boolean fight(Warrior st,Warrior nd){
        while(true){
            nd.damage(st);
            if(!nd.isAlive()){
                return true;
            }
            st.damage(nd);
            if(!st.isAlive()){
                return false;
            }
        }
    }
}

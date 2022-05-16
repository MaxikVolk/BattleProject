public class Fight {
    public static boolean fight(Warrior st,Warrior nd){
        while(true){
            nd.damage(st);
            if(!nd.getIsAlive()){
                return true;
            }
            st.damage(nd);
            if(!st.getIsAlive()){
                return false;
            }
        }
    }
}

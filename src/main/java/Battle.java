public class Battle {
    public static boolean fight(Army st,Army nd){
        int i=0;
        int j=0;
        while(true) {
//            if(!st.army.get(i).is_alive){
//                i++;
//            }
//            if(!nd.army.get(j).is_alive){
//                j++;
//            }
            if(Fight.fight(st.army.get(i),nd.army.get(j))){
                j++;
            }
            else{
                i++;
            }
            if (!(st.army.get(st.army.size() - 1)).is_alive) {
                return false;
            }
            if (!(nd.army.get(nd.army.size() - 1)).is_alive) {
                return true;
            }
        }
    }
}

import java.util.Iterator;

public class Battle {
    public static boolean fight(Army st, Army nd) {
        st.moveUnits();
        nd.moveUnits();

//        Iterator<Warriors.Warrior> fst = st.getIterator();   Варіант з ітератором, не підходить
//        Iterator<Warriors.Warrior> snd = nd.getIterator();   нам якщо є Варлорд
//        Warriors.Warrior firstArmyWarrior = fst.next();
//        Warriors.Warrior secondArmyWarrior = snd.next();
//
//
//        while (true) {
//            if (Fight.fight(firstArmyWarrior, secondArmyWarrior)) {
//                if (snd.hasNext()) {
//                    nd.moveUnits();
//                    secondArmyWarrior = snd.next();
//                } else {
//                    return true;
//                }
//            } else if (fst.hasNext()) {
//                st.moveUnits();
//                firstArmyWarrior = fst.next();
//            } else {
//                return false;
//            }
//        }

        while(true){
            if(Fight.fight(st.getWarrior(0),nd.getWarrior(0))){
                nd.remove(0);
                nd.moveUnits();
                if(nd.getSize()<1){
                    return true;
                }
            }
            else {
                st.remove(0);
                st.moveUnits();
                if(st.getSize()<1){
                    return false;
                }
            }
        }

    }

    public static boolean straightFight(Army st, Army nd) {
        int stSize = st.getSize();
        int ndSize = nd.getSize();
        while (stSize > 0 && ndSize > 0) {
            stSize = st.getSize();
            ndSize = nd.getSize();
            for (int i = 0; i < stSize && i < ndSize; i++) {
                st.getWarrior(i).prepareStraightFight();
                nd.getWarrior(i).prepareStraightFight();
                Fight.fight(st.getWarrior(i), nd.getWarrior(i));
//                if(Fight.fight(st.getWarrior(i), nd.getWarrior(i))){
//                    nd.moveUnits();
//                }
//                else {
//                    st.moveUnits();
//                }
            }
            int l = 0;
            int j = 0;
            while (j < st.getSize() && l < nd.getSize()) {
                if (!st.getWarrior(j).isAlive()) {
                    st.removeWarrior(j);
                    l++;
                } else if (!nd.getWarrior(l).isAlive()) {
                    nd.removeWarrior(l);
                    j++;
                }
            }
        }
        return st.getSize() > 0;
    }
}


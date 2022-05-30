import java.util.Iterator;

public class Battle {
    public static boolean fight(Army st, Army nd) {
        Iterator<Warrior> fst = st.getIterator();
        Iterator<Warrior> snd = nd.getIterator();
        Warrior firstArmyWarrior = fst.next();
        Warrior secondArmyWarrior = snd.next();


        while (true) {
            if (Fight.fight(firstArmyWarrior, secondArmyWarrior)) {
                if (snd.hasNext()) {
                    secondArmyWarrior = snd.next();
                } else {
                    return true;
                }
            } else if (fst.hasNext()) {
                firstArmyWarrior = fst.next();
            } else {
                return false;
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


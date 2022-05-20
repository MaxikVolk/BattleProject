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
}


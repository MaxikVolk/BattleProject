import java.util.ArrayList;
import java.util.Iterator;

public class Army {
    private final ArrayList<Warrior> army = new ArrayList<>();

    public Army addUnits(WarriorType type, int n) {
        for (int i = 0; i < n; i++) {
            army.add(WarriorFactory.createWarrior(type));
            if (i > 0) {
                army.get(i - 1).setNextWarrior(army.get(i));
                army.get(i).setPreviousWarrior(army.get(i-1));
            }
        }
        return this;
    }

    public Iterator<Warrior> getIterator() {
        return army.iterator();
    }

}

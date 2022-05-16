import java.util.ArrayList;

public class Army {
    ArrayList<Warrior> army = new ArrayList<Warrior>();

    public Army add_units(WarriorType type, int n) {
        for (int i = 0; i < n; i++) {
            army.add(WarriorFactory.createWarrior(type));
    }
        return this;
    }
}

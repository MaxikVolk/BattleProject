import java.util.ArrayList;

public class Army {
    private ArrayList<Warrior> army = new ArrayList<Warrior>();

    public Army add_units(WarriorType type, int n) {
        for (int i = 0; i < n; i++) {
            army.add(WarriorFactory.createWarrior(type));
        }
        return this;
    }
    public Warrior getWarrior(int i){
        return army.get(i);
    }
    public boolean isDefeated() {
        return !army.get(army.size() - 1).isAlive();
    }
}

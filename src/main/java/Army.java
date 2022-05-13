import java.util.ArrayList;

public class Army {
    ArrayList<Warrior> army = new ArrayList<Warrior>();
    public void add_units(WarriorType type, int n){
        for(int i=army.size();i<n;i++){
            army.add(i,WarriorFactory.createWarrior(type));
        }
    }
}

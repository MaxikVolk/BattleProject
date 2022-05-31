import java.util.ArrayList;
import java.util.Iterator;

public class Army {
    private ArrayList<Warrior> army = new ArrayList<>();
    private boolean hasWarlord = false;

    public Army addUnits(WarriorType type, int n) {
        if (type == WarriorType.WARLORD) {
            if (!hasWarlord) {
                hasWarlord = true;
                army.add(WarriorFactory.createWarrior(type));
            }
            return this;

        }
        for (int i = 0; i < n; i++) {
            army.add(WarriorFactory.createWarrior(type));
            if (i > 0) {
                army.get(i - 1).setNextWarrior(army.get(i));
                army.get(i).setPreviousWarrior(army.get(i - 1));
            }
        }

        return this;
    }

    public void moveUnits() {
        if (hasWarlord) {
            ArrayList<Warrior> temp = new ArrayList<>();
            temp.ensureCapacity(army.size());
            for (int i = 0; i < army.size(); i++) {
                if (army.get(i) instanceof Warlord) {
                    army.ensureCapacity(army.size() + 1);
                    army.add(army.size(), army.get(i));
                    army.remove(i);
                    break;
                }
            }

            boolean check = false;
            for (int i = 0; i < army.size(); i++) {
                if (army.get(i) instanceof Lancer) {
                    temp.add(0, army.get(i));
                    army.remove(i);
                    check = true;
                    break;
                }
            }

            if (!check) {
                for (Warrior warrior : army) {
                    if (warrior.getAttack() != 0 && !(warrior instanceof Warlord)) {
                        temp.add(0, warrior);
                        army.remove(warrior);
                        check=true;
                        break;
                    }
                }
            }
            if (!check) {
                for (Warrior warrior : army) {
                    if (warrior instanceof Healer) {
                        temp.add(0, warrior);
                        army.remove(warrior);
                        check=true;
                        break;
                    }
                }
            }else {
                for (int i = 0; i < army.size(); i++) {
                    if (army.get(i) instanceof Healer) {
                        temp.add(1, army.get(i));
                        army.remove(i);
                        break;
                    }
                }
            }
            if (!check) {
                for (Warrior warrior : army) {
                    if (warrior instanceof Warlord) {
                        temp.add(0, warrior);
                        army.remove(warrior);
                        break;
                    }
                }
            }


            int j;//дуже поганий код
            if (temp.contains(new Healer())) {
                j = 2;
            } else {
                j = 1;
            }
            if (army.size() > 1) {
                for (int i = 0; i < army.size(); i++, j++) {
                    temp.add(j, army.get(i));
                }
            } else if (army.size() > 0) {
                temp.add(army.get(0));
            }//кінець дуже поганого коду


            army = temp;
            if (army.size() > 1) {
                army.get(0).nextWarrior = army.get(1);
                if (army.size() > 2) {
                    army.get(1).previousWarrior = army.get(0);
                }
            }
        }
    }


//    public Iterator<Warrior> getIterator() {
//        return army.iterator();
//    }

    public Warrior getWarrior(int i) {
        return army.get(i);
    }
    public void remove(int i){
        army.remove(i);
    }

    public void removeWarrior(int i) {
        army.remove(i);
    }

    public int getSize() {
        return army.size();
    }
}

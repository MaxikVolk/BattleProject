public class Vampire extends Warrior {
    private final int vampirism;

    {
        ATTACK = 4;
        health = 40;
        vampirism = 50;
    }

    @Override
    public void damage(Warrior def) {
        super.damage(def);
        if(def instanceof Defender){
            vampirism(((Defender) def).getDEFENCE());
        }
        else{
            vampirism();
        }
    }
    public void vampirism() {
        health += (ATTACK * vampirism / 100);
    }

    public void vampirism(int defence) {
        health += ((ATTACK - defence) * vampirism / 100);
    }

    @Override
    public int getAttack() {
        return this.ATTACK;
    }


}

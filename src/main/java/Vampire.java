public class Vampire extends Warrior {
    private int vampirism;

    {
        attack = 4;
        health = 40;
        vampirism = 50;
    }

    @Override
    public void damage(Warrior def) {
        super.damage(def);
        if (def instanceof Defender) {
            vampirism(((Defender) def).getDefence());
        } else {
            vampirism();
        }
    }

    @Override
    public Vampire equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        vampirism += weapon.getVampirism();
        return this;
    }

    public void vampirism() {
        health += (attack * vampirism / 100);
    }

    public void vampirism(int defence) {
        health += ((attack - defence) * vampirism / 100);
    }

    @Override
    public int getAttack() {
        return this.attack;
    }


}
package Warriors;

public class Defender extends Warrior {
    protected int defence;

    {
        health = 60;
        defence = 2;
        attack = 3;
    }

    @Override
    public void getDamage(int at) {
        if (at > defence) {
            health -= (at - defence);
        }
    }

    @Override
    public Defender equipWeapon(Weapons.Weapon weapon) {
        super.equipWeapon(weapon);
        defence += weapon.getDefence();
        return this;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }


    protected int getDefence() {
        return this.defence;
    }
}

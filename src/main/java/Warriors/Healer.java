package Warriors;

public class Healer extends Warrior {
    private int heal;

    {
        health = 60;
        attack = 0;
        heal = 2;
    }

    public void heal(Warrior warrior) {
        warrior.health += heal;
        if (warrior.health > warrior.MAX_HEALTH) {
            warrior.health = warrior.MAX_HEALTH;
        }
    }

    @Override
    public Healer equipWeapon(Weapons.Weapon weapon) {
        super.equipWeapon(weapon);
        heal += weapon.getHealPower();
        return this;
    }

    @Override
    public void notifySubscriber() {
        heal(previousWarrior);
    }
}

package Warriors;

public class Warrior {
    protected final int MAX_HEALTH;
    protected int attack;
    protected int health;
    protected Warrior nextWarrior;
    protected Warrior previousWarrior;

    {
        attack = 5;
        health = 50;
        MAX_HEALTH = health;
    }

    public Warrior() {
    }

    public Warrior equipWeapon(Weapons.Weapon weapon) {
        health += weapon.getHealth();
        attack += weapon.getAttack();
        return this;
    }

    public void damage(Warrior def) {
        if (nextWarrior != null) {
            nextWarrior.notifySubscriber();
        }
        def.getDamage(getAttack());
    }

    public void getDamage(int at) {
        health -= at;
    }

    public void prepareStraightFight() {
        this.nextWarrior = null;
        this.previousWarrior = null;
    }

    public void notifySubscriber() {
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public Warrior getNextWarrior() {
        return nextWarrior;
    }

    public void setNextWarrior(Warrior warrior) {
        this.nextWarrior = warrior;
    }

    public void setPreviousWarrior(Warrior warrior) {
        this.previousWarrior = warrior;
    }

}

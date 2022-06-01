package Weapons;

public class Weapon {
    protected int health;
    protected int attack;
    protected int defence;
    protected int vampirism;
    protected int healPower;

    {
        health = 0;
        attack = 0;
        defence = 0;
        vampirism = 0;
        healPower = 0;
    }

    public Weapon(int health, int attack, int defence, int vampirism, int healPower) {
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.vampirism = vampirism;
        this.healPower = healPower;
    }

    public Weapon() {
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealPower() {
        return healPower;
    }

    public int getVampirism() {
        return vampirism;
    }
}

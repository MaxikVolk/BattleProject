package Weapons;

public class Katana extends Weapon {
    {
        health = -20;
        attack = 6;
        defence = -5;
        vampirism = 50;
    }

    public Katana() {
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public int getDefence() {
        return this.defence;
    }

    @Override
    public int getVampirism() {
        return this.vampirism;
    }
}

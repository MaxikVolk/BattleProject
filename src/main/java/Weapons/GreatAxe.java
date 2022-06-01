package Weapons;

public class GreatAxe extends Weapon {
    {
        health = -15;
        attack = 5;
        defence = -2;
        vampirism = 10;
    }

    public GreatAxe() {
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

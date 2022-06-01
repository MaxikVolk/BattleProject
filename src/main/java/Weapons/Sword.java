package Weapons;

public class Sword extends Weapon {
    {
        health = 5;
        attack = 2;
    }

    public Sword() {
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

}

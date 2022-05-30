public class Sword extends Weapon {
    {
        health = 5;
        attack = 2;
    }

    Sword() {
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

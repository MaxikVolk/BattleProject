public class Warrior {
    protected int ATTACK;
    protected int health;

    {
        ATTACK = 5;
        health = 50;
    }

    Warrior() {
    }

    public void damage(Warrior at) {
        health -= at.getAttack();
        if (at instanceof Vampire) {
            ((Vampire) at).vampirism();
        }
    }

    public int getAttack() {
        return this.ATTACK;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return this.health;
    }

}

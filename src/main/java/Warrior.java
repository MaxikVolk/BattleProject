public class Warrior {
    protected int ATTACK;
    protected int health;
    protected int MAX_HEALTH;

    {
        ATTACK = 5;
        health = 50;
        MAX_HEALTH=health;
    }

    Warrior() {
    }

    public void damage(Warrior at) {
        health -= at.getAttack();
        if (at instanceof Vampire) {
            ((Vampire) at).vampirism();
        }
    }

    public void halfDamage(Warrior at) {
        health -= (at.getAttack() / 2);
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

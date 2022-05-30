public class Shield extends Weapon {
    {
        health = 20;
        attack = -1;
        defence = 2;
    }

    Shield() {
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
}

public class Knight extends Warrior {
    {
        ATTACK = 7;
    }
    @Override
    public int getAttack() {
        return this.ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }
}

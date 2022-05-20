public class Defender extends Warrior {
    private final int DEFENCE;

    {
        health = 60;
        DEFENCE = 2;
        ATTACK = 3;
    }

    @Override
    public void getDamage(int at) {
        if (at > DEFENCE) {
            health -= at - DEFENCE;
        }
    }

    @Override
    public int getAttack() {
        return this.ATTACK;
    }


    protected int getDEFENCE() {
        return this.DEFENCE;
    }
}

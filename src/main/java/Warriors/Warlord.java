package Warriors;

public class Warlord extends Defender {
    {
        health = 100;
        attack = 4;
        defence = 2;
    }


    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    protected int getDefence() {
        return this.defence;
    }
}

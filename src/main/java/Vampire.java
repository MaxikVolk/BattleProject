public class Vampire extends Warrior {
    private int vampirism;

    {
        ATTACK = 4;
        health = 40;
        vampirism = 50;
    }

    public void vampirism() {
        health += (ATTACK * vampirism / 100);
    }

    public void vampirism(int defence) {
        health += ((ATTACK - defence) * vampirism / 100);
    }

    @Override
    public int getAttack() {
        return this.ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public int getVampirism() {
        return this.vampirism;
    }
}

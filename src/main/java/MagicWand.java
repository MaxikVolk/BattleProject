public class MagicWand extends Weapon {
    {
        health = 30;
        attack = 3;
        healPower = 3;
    }

    MagicWand() {
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
    public int getHealPower() {
        return this.healPower;
    }

}

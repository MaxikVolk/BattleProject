public class Vampire extends Warrior{
    final int ATTACK;
    {
        ATTACK=4;
        health = 40;
        vampirism=50;
    }
    @Override
    public int getAttack(){
        return this.ATTACK;
    }
    @Override
    public int getHealth() {
        return this.health;
    }
}

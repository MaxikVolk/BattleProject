public class Defender extends Warrior{
    final int ATTACK;
    public int defence;
    {
        defence=2;
        ATTACK=3;
    }
    @Override
    public int getAttack(){
        return this.ATTACK;
    }
}

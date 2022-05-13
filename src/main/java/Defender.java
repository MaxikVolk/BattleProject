public class Defender extends Warrior{
    final int ATTACK;
    public int defence;
    {
        health=60;
        defence=2;
        ATTACK=3;
    }

    @Override
    public void damage(int dam){
        if(dam>defence) {
            health-=(dam-defence);
            if (health <= 0) {
                is_alive = false;
            }
        }
    }

    @Override
    public int getAttack(){
        return this.ATTACK;
    }
}

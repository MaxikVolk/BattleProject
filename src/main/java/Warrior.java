public class Warrior {
    final int ATTACK;
    public int health;
    public boolean is_alive;
    {
        ATTACK=5;
        health = 50;
        is_alive = true;
    }
    Warrior(){}
    public void damage(int dam){
        health-= dam;
        if(health<=0){
            is_alive=false;
        }
    }
    public int getAttack(){
        return this.ATTACK;
    }

}

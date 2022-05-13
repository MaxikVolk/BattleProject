public class Warrior {
    final int ATTACK =5;
    public int health;
    public boolean is_alive;
    {
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

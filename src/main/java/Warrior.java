public class Warrior {
    final int ATTACK;
    public int health;
    private boolean isAlive;
    public int vampirism;

    {
        ATTACK = 5;
        health = 50;
        isAlive = true;
        vampirism = 0;
    }

    Warrior() {
    }

    public void damage(Warrior at) {
        health -= at.getAttack();
        at.health += at.getAttack() * at.getVampirism() / 100;
        if (health <= 0) {
            kill();
        }
    }

    public int getAttack() {
        return this.ATTACK;
    }
    public boolean getIsAlive(){
        return this.isAlive;
    }
    public int getHealth() {
        return this.health;
    }
    public int getVampirism() {
        return this.vampirism;
    }
    public void kill(){
        isAlive=false;
    }

}

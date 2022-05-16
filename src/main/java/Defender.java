public class Defender extends Warrior{
    final int ATTACK;
    final int DEFENCE;
    {
        health=60;
        DEFENCE=2;
        ATTACK=3;
    }

    @Override
    public void damage(Warrior at){
        if(at.getAttack()>DEFENCE) {
            health-=(at.getAttack()-DEFENCE);
            at.health += (at.getAttack()-DEFENCE) * at.getVampirism() / 100;
            if (health <= 0) {
                kill();
            }
        }
    }
    @Override
    public int getAttack() {
        return this.ATTACK;
    }

    @Override
    public int getHealth() {
        return this.health;
    }
}

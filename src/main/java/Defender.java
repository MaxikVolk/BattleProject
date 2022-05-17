public class Defender extends Warrior{
    private final int DEFENCE;
    {
        health=60;
        DEFENCE=2;
        ATTACK=3;
    }

    @Override
    public void damage(Warrior at){
        if(at.getAttack()>DEFENCE) {
            health-=(at.getAttack()-DEFENCE);
            if(at instanceof Vampire){
                ((Vampire) at).vampirism(DEFENCE);
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

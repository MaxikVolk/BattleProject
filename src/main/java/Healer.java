public class Healer extends Warrior {
    private final int heal;

    {
        health = 60;
        ATTACK = 0;
        heal = 2;
    }

    public void heal(Warrior warrior) {
        warrior.health += heal;
        if (warrior.health > warrior.MAX_HEALTH) {
            warrior.health = warrior.MAX_HEALTH;
        }
    }
    @Override
    public void notifySubscriber(){
        heal(previousWarrior);
    }
}

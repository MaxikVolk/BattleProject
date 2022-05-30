public class Lancer extends Warrior {
    {
        attack = 6;
    }

    @Override
    public void damage(Warrior def) {
        super.damage(def);
        if (def.getNextWarrior() != null) {
            halfDamage(def.getNextWarrior());
        }
    }

    public void halfDamage(Warrior def) {
        def.getDamage(getAttack() / 2);
    }
}

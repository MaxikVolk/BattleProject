class WarriorFactory {
    public static Warrior createWarrior(WarriorType type) {
        Warrior warrior = null;

        switch (type) {
            case WARRIOR:
                warrior =  new Warrior();
                break;
            case KNIGHT:
                warrior = new Knight();
                break;
            case DEFENDER:
                warrior = new Defender();
                break;
        }

        return warrior;
    }
}

class WarriorFactory {
    public static Warrior createWarrior(WarriorType type) {

        return switch (type) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
            case ROOKIE -> new Rookie();
            case VAMPIRE -> new Vampire();
            case LANCER -> new Lancer();
            case HEALER -> new Healer();
            case WARLORD -> new Warlord();
        };
    }
}

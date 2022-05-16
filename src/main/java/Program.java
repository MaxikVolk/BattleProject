public class Program {
    public static void main(String[] args) {
        Warrior chuck = new Warrior();
        Defender bruce = new Defender();
        Knight carl = new Knight();
        Vampire dave = new Vampire();

        //System.out.println(Fight.fight(chuck, bruce));
        System.out.println(Fight.fight(dave, bruce));

        System.out.println();

//        Army army_1 = new Army();
//        Army army_2 = new Army();
//        army_1.add_units(WarriorType.WARRIOR,10);
//        army_2.add_units(WarriorType.KNIGHT,9);
//
//        System.out.println(Battle.fight(army_1,army_2));
    }
}

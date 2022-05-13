public class Program {
    public static void main(String[] args) {
        Warrior chuck = new Warrior();
        Warrior bruce = new Warrior();
        Knight carl = new Knight();
        Warrior dave = new Warrior();

        System.out.println(Fight.fight(chuck, bruce));
        System.out.println(Fight.fight(dave, carl));

        System.out.println();

        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR,10);
        army_2.add_units(WarriorType.KNIGHT,9);

        System.out.println(Battle.fight(army_1,army_2));
    }
}

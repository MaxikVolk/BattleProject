public class Program {
    public static void main(String[] args) {
        Army army1= new Army();
        Army army2= new Army();
        army1.addUnits(WarriorType.KNIGHT,1).addUnits(WarriorType.LANCER,1);
        army2.addUnits(WarriorType.VAMPIRE,1).addUnits(WarriorType.HEALER,1);
        army1.getWarrior(1).equipWeapon(new GreatAxe());
        army1.getWarrior(0).equipWeapon(new MagicWand());
        army2.getWarrior(1).equipWeapon(new GreatAxe());
        army2.getWarrior(0).equipWeapon(new MagicWand());
        System.out.println(Battle.fight(army1,army2));

    }
}

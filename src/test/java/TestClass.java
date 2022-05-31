import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass {
    private static Stream<Arguments> FightTest() {
        Warrior warrior;
        Knight knight;
        Defender defender;
        return Stream.of(
                Arguments.of(new Warrior(), new Knight(), false),
                Arguments.of(new Knight(), new Warrior(), true),
                Arguments.of(knight = new Knight(), warrior = new Warrior(), false, Fight.fight(new Warrior(), knight)),
                Arguments.of(defender = new Defender(), warrior = new Warrior(), true, Fight.fight(defender, new Rookie())),
                Arguments.of(new Defender(), new Warlord(), false),
                Arguments.of(new Warlord(), new Vampire(), true),
                Arguments.of(new Warlord(), new Knight(), true),
                Arguments.of(new Warrior().equipWeapon(new Weapon(-10, 5, 0, 40, 0)),
                        new Vampire().equipWeapon(new Sword()), true),
                Arguments.of(new Defender().equipWeapon(new Shield()),
                        new Lancer().equipWeapon(new GreatAxe()), false),
                Arguments.of(new Healer().equipWeapon(new MagicWand()),
                        new Knight().equipWeapon(new Katana()), false),
                Arguments.of(new Defender().equipWeapon(new Shield()).equipWeapon(new MagicWand()),
                        new Vampire().equipWeapon(new Shield()).equipWeapon(new Katana()), false)
        );
    }

    private static Stream<Arguments> aliveTest() {
        Warrior warrior;
        Knight knight;
        return Stream.of(
                Arguments.of(warrior = new Warrior(), true, Fight.fight(warrior, new Warrior())),
                Arguments.of(knight = new Knight(), true, Fight.fight(knight, new Warrior())),
                Arguments.of(warrior = new Warrior(), false, Fight.fight(new Warrior(), warrior)),
                Arguments.of(knight = new Knight(), true, Fight.fight(new Warrior(), knight))
        );
    }

    private static Stream<Arguments> battleTest() {
        Army firstArmy;
        Army secondArmy;
        return Stream.of(

                Arguments.of(new Army().addUnits(WarriorType.WARRIOR, 1),
                        new Army().addUnits(WarriorType.WARRIOR, 2), false),
                Arguments.of(new Army().addUnits(WarriorType.WARRIOR, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 3), false),
                Arguments.of(new Army().addUnits(WarriorType.WARRIOR, 5),
                        new Army().addUnits(WarriorType.WARRIOR, 7), false),
                Arguments.of(new Army().addUnits(WarriorType.WARRIOR, 20),
                        new Army().addUnits(WarriorType.WARRIOR, 21), true),
                Arguments.of(new Army().addUnits(WarriorType.WARRIOR, 10),
                        new Army().addUnits(WarriorType.WARRIOR, 11), true),
                Arguments.of(new Army().addUnits(WarriorType.WARRIOR, 11),
                        new Army().addUnits(WarriorType.WARRIOR, 7), true),
                Arguments.of(new Army().addUnits(WarriorType.WARRIOR, 5)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.DEFENDER, 5),
                        new Army().addUnits(WarriorType.WARRIOR, 4), true),
                Arguments.of(new Army().addUnits(WarriorType.DEFENDER, 5)
                                .addUnits(WarriorType.WARRIOR, 20)
                                .addUnits(WarriorType.DEFENDER, 4),
                        new Army().addUnits(WarriorType.WARRIOR, 21), true),
                Arguments.of(new Army().addUnits(WarriorType.WARRIOR, 10)
                                .addUnits(WarriorType.DEFENDER, 5)
                                .addUnits(WarriorType.DEFENDER, 10),
                        new Army().addUnits(WarriorType.WARRIOR, 5), true),
                Arguments.of(new Army().addUnits(WarriorType.DEFENDER, 2)
                                .addUnits(WarriorType.WARRIOR, 1)
                                .addUnits(WarriorType.DEFENDER, 1),
                        new Army().addUnits(WarriorType.WARRIOR, 5), false),
                Arguments.of(new Army().addUnits(WarriorType.DEFENDER, 5)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.WARRIOR, 7),
                        new Army().addUnits(WarriorType.WARRIOR, 6)
                                .addUnits(WarriorType.DEFENDER, 6).
                                addUnits(WarriorType.VAMPIRE, 6), false),
                Arguments.of(new Army().addUnits(WarriorType.DEFENDER, 2)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.WARRIOR, 4),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.VAMPIRE, 3), false),
                Arguments.of(new Army().addUnits(WarriorType.DEFENDER, 11)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.WARRIOR, 4),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4).
                                addUnits(WarriorType.VAMPIRE, 13), true),
                Arguments.of(new Army().addUnits(WarriorType.DEFENDER, 9)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.WARRIOR, 8),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.VAMPIRE, 13), true),
                Arguments.of(new Army().addUnits(WarriorType.LANCER, 5)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.LANCER, 5), false),
                Arguments.of(new Army().addUnits(WarriorType.LANCER, 7)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.LANCER, 4), true),
                Arguments.of(new Army().addUnits(WarriorType.LANCER, 7)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.DEFENDER, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.LANCER, 4), true),
                Arguments.of(new Army().addUnits(WarriorType.LANCER, 1)
                                .addUnits(WarriorType.WARRIOR, 3)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.KNIGHT, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.LANCER, 4), false),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), true,
                        firstArmy.addUnits(WarriorType.KNIGHT, 1).addUnits(WarriorType.LANCER, 1),
                        secondArmy.addUnits(WarriorType.VAMPIRE, 1).addUnits(WarriorType.HEALER, 1),
                        firstArmy.getWarrior(0).equipWeapon(new MagicWand()),
                        firstArmy.getWarrior(1).equipWeapon(new GreatAxe()),
                        secondArmy.getWarrior(0).equipWeapon(new MagicWand()),
                        secondArmy.getWarrior(1).equipWeapon(new GreatAxe())),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), true,
                        firstArmy.addUnits(WarriorType.DEFENDER, 1).addUnits(WarriorType.WARRIOR, 1),
                        secondArmy.addUnits(WarriorType.KNIGHT, 1).addUnits(WarriorType.HEALER, 1),
                        firstArmy.getWarrior(0).equipWeapon(new GreatAxe()),
                        firstArmy.getWarrior(1).equipWeapon(new GreatAxe()),
                        secondArmy.getWarrior(0).equipWeapon(new Sword()),
                        secondArmy.getWarrior(1).equipWeapon(new Sword())),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), false,
                        firstArmy.addUnits(WarriorType.DEFENDER, 2),
                        secondArmy.addUnits(WarriorType.KNIGHT, 1).addUnits(WarriorType.VAMPIRE, 1),
                        firstArmy.getWarrior(0).equipWeapon(new Katana()),
                        firstArmy.getWarrior(1).equipWeapon(new Katana()),
                        secondArmy.getWarrior(0).equipWeapon(new Katana()),
                        secondArmy.getWarrior(1).equipWeapon(new Katana())),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), true,
                        firstArmy.addUnits(WarriorType.KNIGHT, 3),
                        secondArmy.addUnits(WarriorType.WARRIOR, 1).addUnits(WarriorType.DEFENDER, 2),
                        firstArmy.getWarrior(0).equipWeapon(new Weapon(-20, 6, 1, 40, -2)),
                        firstArmy.getWarrior(1).equipWeapon(new Weapon(-20, 6, 1, 40, -2)),
                        firstArmy.getWarrior(2).equipWeapon(new Weapon(20, -2, 2, -55, 3)),
                        secondArmy.getWarrior(0).equipWeapon(new Weapon(-20, 6, 1, 40, -2)),
                        secondArmy.getWarrior(1).equipWeapon(new Weapon(20, -2, 2, -55, 3)),
                        secondArmy.getWarrior(2).equipWeapon(new Weapon(20, -2, 2, -55, 3))),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), true,
                        firstArmy.addUnits(WarriorType.WARLORD, 1).addUnits(WarriorType.WARRIOR, 2)
                                .addUnits(WarriorType.LANCER, 2).addUnits(WarriorType.HEALER, 2),
                        secondArmy.addUnits(WarriorType.WARLORD, 1).addUnits(WarriorType.VAMPIRE, 1)
                                .addUnits(WarriorType.HEALER, 2).addUnits(WarriorType.KNIGHT, 2)),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), false,
                        firstArmy.addUnits(WarriorType.WARRIOR, 2).addUnits(WarriorType.LANCER, 2)
                                .addUnits(WarriorType.DEFENDER, 1).addUnits(WarriorType.WARLORD, 3),
                        secondArmy.addUnits(WarriorType.WARLORD, 2).addUnits(WarriorType.VAMPIRE, 1)
                                .addUnits(WarriorType.HEALER, 5).addUnits(WarriorType.KNIGHT, 2)),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), true,
                        firstArmy.addUnits(WarriorType.WARRIOR, 2).addUnits(WarriorType.LANCER, 3)
                                .addUnits(WarriorType.DEFENDER, 1).addUnits(WarriorType.WARLORD, 4),
                        secondArmy.addUnits(WarriorType.WARLORD, 1).addUnits(WarriorType.VAMPIRE, 1)
                                .addUnits(WarriorType.ROOKIE, 1).addUnits(WarriorType.KNIGHT, 1),
                        firstArmy.getWarrior(0).equipWeapon(new Sword()),
                        secondArmy.getWarrior(0).equipWeapon(new Shield()))
        );
    }

    private static Stream<Arguments> hpTest() {
        Defender defender;
        return Stream.of(
                Arguments.of(defender = new Defender(), 60, Fight.fight(defender, new Rookie()))
        );
    }

    private static Stream<Arguments> straightBattleTest() {
        Army firstArmy;
        Army secondArmy;
        return Stream.of(
                Arguments.of(new Army().addUnits(WarriorType.LANCER, 5)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.LANCER, 5), false),
                Arguments.of(new Army().addUnits(WarriorType.LANCER, 7)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.LANCER, 4), true),
                Arguments.of(new Army().addUnits(WarriorType.LANCER, 7)
                                .addUnits(WarriorType.VAMPIRE, 3)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.DEFENDER, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.VAMPIRE, 6)
                                .addUnits(WarriorType.LANCER, 4), false),
                Arguments.of(new Army().addUnits(WarriorType.LANCER, 4)
                                .addUnits(WarriorType.WARRIOR, 3)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.KNIGHT, 2),
                        new Army().addUnits(WarriorType.WARRIOR, 4)
                                .addUnits(WarriorType.DEFENDER, 4)
                                .addUnits(WarriorType.HEALER, 1)
                                .addUnits(WarriorType.VAMPIRE, 2)
                                .addUnits(WarriorType.LANCER, 4), true),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), false,
                        firstArmy.addUnits(WarriorType.VAMPIRE, 3),
                        secondArmy.addUnits(WarriorType.WARRIOR, 1).addUnits(WarriorType.DEFENDER, 2),
                        firstArmy.getWarrior(0).equipWeapon(new Weapon(-20, 1, 1, 40, -2)),
                        firstArmy.getWarrior(1).equipWeapon(new Weapon(-20, 1, 1, 40, -2)),
                        firstArmy.getWarrior(2).equipWeapon(new Weapon(20, 2, 2, -55, 3)),
                        secondArmy.getWarrior(0).equipWeapon(new Weapon(-20, 1, 1, 40, -2)),
                        secondArmy.getWarrior(1).equipWeapon(new Weapon(20, 2, 2, -55, 3)),
                        secondArmy.getWarrior(2).equipWeapon(new Weapon(20, 2, 2, -55, 3))),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), true,
                        firstArmy.addUnits(WarriorType.VAMPIRE, 2).addUnits(WarriorType.ROOKIE, 2),
                        secondArmy.addUnits(WarriorType.WARRIOR, 1).addUnits(WarriorType.DEFENDER, 2),
                        firstArmy.getWarrior(0).equipWeapon(new Katana()),
                        firstArmy.getWarrior(1).equipWeapon(new Katana()),
                        firstArmy.getWarrior(2).equipWeapon(new Shield()),
                        secondArmy.getWarrior(0).equipWeapon(new Katana()),
                        secondArmy.getWarrior(1).equipWeapon(new Shield()),
                        secondArmy.getWarrior(2).equipWeapon(new Shield())),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), true,
                        firstArmy.addUnits(WarriorType.VAMPIRE, 3),
                        secondArmy.addUnits(WarriorType.WARRIOR, 1).addUnits(WarriorType.DEFENDER, 1),
                        firstArmy.getWarrior(0).equipWeapon(new GreatAxe()),
                        firstArmy.getWarrior(1).equipWeapon(new GreatAxe()),
                        firstArmy.getWarrior(2).equipWeapon(new GreatAxe()),
                        secondArmy.getWarrior(0).equipWeapon(new Sword()),
                        secondArmy.getWarrior(1).equipWeapon(new Sword())),
                Arguments.of(firstArmy = new Army(), secondArmy = new Army(), false,
                        firstArmy.addUnits(WarriorType.ROOKIE, 3),
                        secondArmy.addUnits(WarriorType.DEFENDER, 1).addUnits(WarriorType.HEALER, 1),
                        firstArmy.getWarrior(0).equipWeapon(new Katana()),
                        firstArmy.getWarrior(1).equipWeapon(new Katana()),
                        firstArmy.getWarrior(2).equipWeapon(new Katana()),
                        secondArmy.getWarrior(0).equipWeapon(new MagicWand()),
                        secondArmy.getWarrior(1).equipWeapon(new MagicWand()))
//                Arguments.of(firstArmy = new Army(),secondArmy=new Army(),false,
//                        firstArmy.addUnits(WarriorType.WARRIOR,2).addUnits(WarriorType.LANCER,3)
//                                .addUnits(WarriorType.DEFENDER,1).addUnits(WarriorType.WARLORD,1),
//                        secondArmy.addUnits(WarriorType.WARLORD,5).addUnits(WarriorType.VAMPIRE,1)
//                                .addUnits(WarriorType.ROOKIE,1).addUnits(WarriorType.KNIGHT,1),
//                        firstArmy.getWarrior(0).equipWeapon(new Sword()),
//                        secondArmy.getWarrior(0).equipWeapon(new Shield()))
        );
    }

    @ParameterizedTest
    @MethodSource
    void FightTest(Warrior st, Warrior nd, boolean expected) {
        assertEquals(expected, Fight.fight(st, nd));
    }

    @ParameterizedTest
    @MethodSource
    void aliveTest(Warrior warrior, boolean expected) {
        assertEquals(expected, warrior.isAlive());
    }

    @ParameterizedTest
    @MethodSource
    void battleTest(Army st, Army nd, boolean expected) {
        assertEquals(expected, Battle.fight(st, nd));
    }

    @ParameterizedTest
    @MethodSource
    void hpTest(Warrior warrior, int expected) {
        assertEquals(expected, warrior.getHealth());
    }

    @ParameterizedTest
    @MethodSource
    void straightBattleTest(Army st, Army nd, boolean expected) {
        assertEquals(expected, Battle.straightFight(st, nd));
    }
}

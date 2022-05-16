import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestClass {
    @ParameterizedTest
    @MethodSource
    void FightTest(Warrior st, Warrior nd, boolean expected) {
        assertEquals(expected, Fight.fight(st, nd));
    }

    private static Stream<Arguments> FightTest() {
        Warrior carl = new Warrior();
        Knight jim = new Knight();
        return Stream.of(
                Arguments.of(carl, jim, false),
                Arguments.of(jim, carl, true),
                Arguments.of(jim, carl, true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void aliveTest(Warrior st, Warrior nd, boolean check, boolean expected) {
        Fight.fight(st, nd);
        if (check) {
            check = st.getIsAlive();
        } else {
            check = nd.getIsAlive();
        }
        assertEquals(expected, check);
    }

    private static Stream<Arguments> aliveTest() {
        Warrior carl = new Warrior();
        Warrior jim = new Warrior();
        Knight knight = new Knight();
        return Stream.of(
                Arguments.of(carl, jim, true, true),
                Arguments.of(carl, knight, false, true)
        );
    }
    @ParameterizedTest
    @MethodSource
    void battleTest(Army st, Army nd, boolean expected) {
        assertEquals(expected, Battle.fight(st, nd));
    }

    private static Stream<Arguments> battleTest() {
        return Stream.of(

                Arguments.of(new Army().add_units(WarriorType.WARRIOR, 1), new Army().add_units(WarriorType.WARRIOR, 2), false),
                Arguments.of(new Army().add_units(WarriorType.WARRIOR, 2),new Army().add_units(WarriorType.WARRIOR, 3), false),
                Arguments.of(new Army().add_units(WarriorType.WARRIOR, 5), new Army().add_units(WarriorType.WARRIOR, 7), false),
                Arguments.of(new Army().add_units(WarriorType.WARRIOR, 20), new Army().add_units(WarriorType.WARRIOR, 21), true),
                Arguments.of(new Army().add_units(WarriorType.WARRIOR, 10), new Army().add_units(WarriorType.WARRIOR, 11), true),
                Arguments.of(new Army().add_units(WarriorType.WARRIOR, 11), new Army().add_units(WarriorType.WARRIOR, 7), true),
                Arguments.of(new Army().add_units(WarriorType.WARRIOR, 5).add_units(WarriorType.DEFENDER, 4)
                        .add_units(WarriorType.DEFENDER, 5),new Army().add_units(WarriorType.WARRIOR, 4), true),
                Arguments.of(new Army().add_units(WarriorType.DEFENDER, 5).add_units(WarriorType.WARRIOR, 20)
                        .add_units(WarriorType.DEFENDER, 4),new Army().add_units(WarriorType.WARRIOR, 21), true),
                Arguments.of(new Army() .add_units(WarriorType.WARRIOR, 10).add_units(WarriorType.DEFENDER, 5)
                        .add_units(WarriorType.DEFENDER, 10),new Army().add_units(WarriorType.WARRIOR, 5), true),
                Arguments.of(new Army() .add_units(WarriorType.DEFENDER, 2).add_units(WarriorType.WARRIOR, 1)
                        .add_units(WarriorType.DEFENDER, 1),new Army() .add_units(WarriorType.WARRIOR, 5), false),
                Arguments.of(new Army() .add_units(WarriorType.DEFENDER, 5).add_units(WarriorType.VAMPIRE, 6)
                        .add_units(WarriorType.WARRIOR, 7),new Army() .add_units(WarriorType.WARRIOR, 6)
                        .add_units(WarriorType.DEFENDER, 6).add_units(WarriorType.VAMPIRE,6), false),
                Arguments.of(new Army() .add_units(WarriorType.DEFENDER, 2).add_units(WarriorType.VAMPIRE, 3)
                        .add_units(WarriorType.WARRIOR, 4),new Army() .add_units(WarriorType.WARRIOR, 4)
                        .add_units(WarriorType.DEFENDER, 4).add_units(WarriorType.VAMPIRE,3), false),
                Arguments.of(new Army() .add_units(WarriorType.DEFENDER, 11).add_units(WarriorType.VAMPIRE, 3)
                        .add_units(WarriorType.WARRIOR, 4),new Army() .add_units(WarriorType.WARRIOR, 4)
                        .add_units(WarriorType.DEFENDER, 4).add_units(WarriorType.VAMPIRE,13), true),
                Arguments.of(new Army() .add_units(WarriorType.DEFENDER, 9).add_units(WarriorType.VAMPIRE, 3)
                        .add_units(WarriorType.WARRIOR, 8),new Army() .add_units(WarriorType.WARRIOR, 4)
                        .add_units(WarriorType.DEFENDER, 4).add_units(WarriorType.VAMPIRE,13), true)
        );
    }

    @Test
    void firstTest() {
        Warrior carl = new Warrior();
        Knight jim = new Knight();
        assertFalse(Fight.fight(carl, jim));
    }

    @Test
    void secondTest() {
        Knight jim = new Knight();
        Warrior carl = new Warrior();
        assertTrue(Fight.fight(jim, carl));
    }

    @Test
    void thirdTest() {
        Warrior carl = new Warrior();
        Warrior jim = new Warrior();
        Fight.fight(carl, jim);
        assertTrue(carl.getIsAlive());
    }

    @Test
    void fourthTest() {
        Knight zeus = new Knight();
        Warrior godKiller = new Warrior();
        assertTrue(Fight.fight(zeus, godKiller));
    }

    @Test
    void fifthTest() {
        Warrior husband = new Warrior();
        Warrior wife = new Warrior();
        Fight.fight(husband, wife);
        assertFalse(wife.getIsAlive());
    }

    @Test
    void sixthTest() {
        Warrior dragon = new Warrior();
        Knight knight = new Knight();
        Fight.fight(dragon, knight);
        assertTrue(knight.getIsAlive());
    }

    @Test
    void seventhTest() {
        Warrior unit_1 = new Warrior();
        Knight unit_2 = new Knight();
        Warrior unit_3 = new Warrior();
        Fight.fight(unit_1, unit_2);
        assertFalse(Fight.fight(unit_2, unit_3));
    }

    @Test
    void eighthTest() {
        Defender unit_1 = new Defender();
        Rookie unit_2 = new Rookie();
        Fight.fight(unit_1, unit_2);
        assertEquals(60, unit_1.getHealth());
    }

    @Test
    void ninthTest() {
        Defender unit_1 = new Defender();
        Rookie unit_2 = new Rookie();
        Warrior unit_3 = new Warrior();
        Fight.fight(unit_1, unit_2);
        assertTrue(Fight.fight(unit_1, unit_3));
    }

    @Test
    void firstBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 1);
        army_2.add_units(WarriorType.WARRIOR, 2);
        assertFalse(Battle.fight(army_1, army_2));
    }

    @Test
    void secondBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 2);
        army_2.add_units(WarriorType.WARRIOR, 3);
        assertFalse(Battle.fight(army_1, army_2));
    }

    @Test
    void thirdBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 5);
        army_2.add_units(WarriorType.WARRIOR, 7);
        assertFalse(Battle.fight(army_1, army_2));
    }

    @Test
    void fourthBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 20);
        army_2.add_units(WarriorType.WARRIOR, 21);
        assertTrue(Battle.fight(army_1, army_2));
    }

    @Test
    void fifthBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 10);
        army_2.add_units(WarriorType.WARRIOR, 11);
        assertTrue(Battle.fight(army_1, army_2));
    }

    @Test
    void sixthBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 11);
        army_2.add_units(WarriorType.WARRIOR, 7);
        assertTrue(Battle.fight(army_1, army_2));
    }

    @Test
    void seventhBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 5);
        army_1.add_units(WarriorType.DEFENDER, 4);
        army_1.add_units(WarriorType.DEFENDER, 5);
        army_2.add_units(WarriorType.WARRIOR, 4);
        assertTrue(Battle.fight(army_1, army_2));
    }

    @Test
    void eighthBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.DEFENDER, 5);
        army_1.add_units(WarriorType.WARRIOR, 20);
        army_2.add_units(WarriorType.WARRIOR, 21);
        army_1.add_units(WarriorType.DEFENDER, 4);
        assertTrue(Battle.fight(army_1, army_2));
    }

    @Test
    void ninthBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 10);
        army_1.add_units(WarriorType.DEFENDER, 5);
        army_2.add_units(WarriorType.WARRIOR, 5);
        army_1.add_units(WarriorType.DEFENDER, 10);
        assertTrue(Battle.fight(army_1, army_2));
    }

    @Test
    void tenthBattleTest() {
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.DEFENDER, 2);
        army_1.add_units(WarriorType.WARRIOR, 1);
        army_1.add_units(WarriorType.DEFENDER, 1);
        army_2.add_units(WarriorType.WARRIOR, 5);
        assertFalse(Battle.fight(army_1, army_2));
    }
}

import static org.junit.jupiter.api.Assertions.*;

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
            check = st.isAlive();
        } else {
            check = nd.isAlive();
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
                                .addUnits(WarriorType.LANCER, 4), false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void straightBattleTest(Army st, Army nd, boolean expected) {
        assertEquals(expected, Battle.straightFight(st, nd));
    }

    private static Stream<Arguments> straightBattleTest() {
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
                                .addUnits(WarriorType.LANCER, 4), true)
        );
    }
}

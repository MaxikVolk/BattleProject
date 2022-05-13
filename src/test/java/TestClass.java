import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {
    @Test
    void firstTest(){
        Warrior carl = new Warrior();
        Knight jim = new Knight();
        assertFalse(Fight.fight(carl,jim));
    }
    @Test
    void secondTest(){
        Knight jim = new Knight();
        Warrior carl = new Warrior();
        assertTrue(Fight.fight(jim,carl));
    }
    @Test
    void thirdTest(){
        Warrior carl = new Warrior();
        Warrior jim = new Warrior();
        Fight.fight(carl,jim);
        assertTrue(carl.is_alive);
    }
    @Test
    void fourthTest(){
        Knight zeus = new Knight();
        Warrior godKiller = new Warrior();
        assertTrue(Fight.fight(zeus, godKiller));
    }
    @Test
    void fifthTest(){
        Warrior husband = new Warrior();
        Warrior wife = new Warrior();
        Fight.fight(husband,wife);
        assertFalse(wife.is_alive);
    }
    @Test
    void sixthTest(){
        Warrior dragon = new Warrior();
        Knight knight = new Knight();
        Fight.fight(dragon,knight);
        assertTrue(knight.is_alive);
    }
    @Test
    void seventhTest(){
        Warrior unit_1 = new Warrior();
        Knight  unit_2 = new Knight();
        Warrior unit_3 = new Warrior();
        Fight.fight(unit_1, unit_2);
        assertFalse(Fight.fight(unit_2, unit_3));
    }
    @Test
    void eighthTest(){
        Defender unit_1 = new Defender();
        Rookie unit_2 = new Rookie();
        Fight.fight(unit_1, unit_2);
        assertEquals(60,unit_1.health);
    }
    @Test
    void ninthTest(){
        Defender unit_1 = new Defender();
        Rookie unit_2 = new Rookie();
        Warrior unit_3 = new Warrior();
        Fight.fight(unit_1, unit_2);
        assertTrue(Fight.fight(unit_1, unit_3));
    }

    @Test
    void firstBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 1);
        army_2.add_units(WarriorType.WARRIOR, 2);
        assertFalse(Battle.fight(army_1, army_2));
    }
    @Test
    void secondBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 2);
        army_2.add_units(WarriorType.WARRIOR, 3);
        assertFalse(Battle.fight(army_1, army_2));
    }
    @Test
    void thirdBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 5);
        army_2.add_units(WarriorType.WARRIOR, 7);
        assertFalse(Battle.fight(army_1, army_2));
    }
    @Test
    void fourthBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 20);
        army_2.add_units(WarriorType.WARRIOR, 21);
        assertTrue(Battle.fight(army_1, army_2));
    }
    @Test
    void fifthBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 10);
        army_2.add_units(WarriorType.WARRIOR, 11);
        assertTrue(Battle.fight(army_1, army_2));
    }
    @Test
    void sixthBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 11);
        army_2.add_units(WarriorType.WARRIOR, 7);
        assertTrue(Battle.fight(army_1, army_2));
    }
    @Test
    void seventhBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 5);
        army_1.add_units(WarriorType.DEFENDER, 4);
        army_1.add_units(WarriorType.DEFENDER, 5);
        army_2.add_units(WarriorType.WARRIOR, 4);
        assertTrue(Battle.fight(army_1, army_2));
    }
    @Test
    void eighthBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.DEFENDER, 5);
        army_1.add_units(WarriorType.WARRIOR, 20);
        army_2.add_units(WarriorType.WARRIOR, 21);
        army_1.add_units(WarriorType.DEFENDER, 4);
        assertTrue(Battle.fight(army_1, army_2));
    }
    @Test
    void ninthBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.WARRIOR, 10);
        army_1.add_units(WarriorType.DEFENDER, 5);
        army_2.add_units(WarriorType.WARRIOR, 5);
        army_1.add_units(WarriorType.DEFENDER, 10);
        assertTrue(Battle.fight(army_1, army_2));
    }
    @Test
    void tenthBattleTest(){
        Army army_1 = new Army();
        Army army_2 = new Army();
        army_1.add_units(WarriorType.DEFENDER, 2);
        army_1.add_units(WarriorType.WARRIOR, 1);
        army_1.add_units(WarriorType.DEFENDER, 1);
        army_2.add_units(WarriorType.WARRIOR, 5);
        assertFalse(Battle.fight(army_1, army_2));
    }
}

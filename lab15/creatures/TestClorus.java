package creatures;

import huglife.*;
import org.junit.Test;

import java.awt.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestClorus {
    @Test
    public void testBasics() {
        Clorus p = new Clorus(2);
        assertEquals(2, p.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), p.color());
        p.move();
        assertEquals(1.97, p.energy(), 0.01);
        p.move();
        assertEquals(1.94, p.energy(), 0.01);
        p.stay();
        assertEquals(1.93, p.energy(), 0.01);
        p.stay();
        assertEquals(1.92, p.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus p = new Clorus(2);
        assertEquals(2, p.energy(), 0.01);
        Clorus newClorus = p.replicate();
        assertNotEquals(newClorus, p);
        assertEquals(1, (int) newClorus.energy());
        assertEquals(1, (int) p.energy());
    }
    @Test
    public void chooseAction1() {
        System.out.println("check 3");

        Clorus p = new Clorus(2);
        Clorus p_baby = p.replicate();
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();


        surrounded.put(Direction.TOP, new Plip());
        surrounded.put(Direction.BOTTOM, new Plip());
        surrounded.put(Direction.LEFT, new Plip());
        surrounded.put(Direction.RIGHT, new Plip());
//        Direction randDir = HugLifeUtils.randomEntry(surrounded);
//            System.out.println("randDir");
        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);
        assertEquals(expected, actual);
    }

    @Test
    public void chooseActionw2() {
        System.out.println("check 4");

        Clorus p = new Clorus(2);
        //Clorus p_baby = p.replicate();
        HashMap<Direction, Occupant> surrounded = new HashMap<>();
        surrounded.put(Direction.TOP, new Plip());
        surrounded.put(Direction.BOTTOM, new Empty());
        surrounded.put(Direction.LEFT, new Empty());
        surrounded.put(Direction.RIGHT, new Empty());
        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.ATTACK, Direction.TOP);
        assertEquals(expected, actual);

    }
    @Test
    public void chooseActionw3() {
        Clorus p = new Clorus(2);
        //Clorus p_baby = p.replicate();
        HashMap<Direction, Occupant> surrounded = new HashMap<>();
        surrounded.put(Direction.TOP, new Empty());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Empty());

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.REPLICATE, Direction.TOP);
        assertEquals(expected, actual);

    }
    @Test
    public void chooseActionw4() {
        Clorus p = new Clorus(0.8);
        //Clorus p_baby = p.replicate();
        HashMap<Direction, Occupant> surrounded = new HashMap<>();
        surrounded.put(Direction.TOP, new Empty());
        surrounded.put(Direction.BOTTOM, new Empty());
        surrounded.put(Direction.LEFT, new Empty());
        surrounded.put(Direction.RIGHT, new Empty());

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.MOVE, Direction.TOP);
        assertEquals(expected, actual);}
    }

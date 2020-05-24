package creatures;

import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {
    private int r;
    private int g;
    private int b;

    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }


    public Clorus() {
        this(1);
    }

    public Color color() {
        r = 34;
        b = 231;
        g = 0;
        return color(r, g, b);
    }

    public void attack(Creature c) {
        energy += c.energy();
    }

    public void move() {
        energy -= 0.03;
    }

    public void stay() {
        energy -= 0.01;
    }

    public Clorus replicate() {
        double new_energy = this.energy = 0.5 * this.energy;
        return new Clorus(new_energy);
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> PlipNeighbors = new ArrayDeque<>();
        for (Direction key1 : neighbors.keySet()) {
            if (neighbors.get(key1).name().equals("empty")) {
                emptyNeighbors.add(key1);
            }
            if (neighbors.get(key1).name().equals("plip")) {
                PlipNeighbors.add(key1);
            }
        }
        if (emptyNeighbors.isEmpty()) {
            return new Action(Action.ActionType.STAY);}
        else if (!PlipNeighbors.isEmpty()) {
            return new Action(Action.ActionType.ATTACK, randomEntry(PlipNeighbors));
        }
        else if (energy >= 1) {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        }
        else {
        return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
        }
    }
}


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

public class Plip extends Creature {

    private int r;

    private int g;

    private int b;

    public Plip(double e) {
        super("plip");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    public Plip() {
        this(1);
    }

    public Color color() {
        r = 99;
        b = 76;
        g = (int) Math.round(96 * energy + 63);
        return color(r, g, b);
    }

    public void attack(Creature c) {
        // do nothing.
    }

    public void move() {
        energy -= 0.15;
    }



    public void stay() {
        energy += 0.2;
        if (energy > 2) {
            energy = 2;
        }
    }


    public Plip replicate() {
        double new_energy = this.energy = 0.5 * this.energy;
        return new Plip(new_energy);
    }


    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        // Rule 1
        Deque<Direction> emptyNeighbors = new ArrayDeque<>();
        Deque<Direction> clorusNeighbors = new ArrayDeque<>();
        for (Direction key1 : neighbors.keySet()) {
            if (neighbors.get(key1).name().equals("empty")) {
                emptyNeighbors.add(key1);
            }
            if (neighbors.get(key1).name().equals("clorus")) {
                clorusNeighbors.add(key1);
            }
        }
        if (emptyNeighbors.isEmpty()) {
            return new Action(Action.ActionType.STAY);
        } else if (energy >= 1) {
            return new Action(Action.ActionType.REPLICATE, randomEntry(emptyNeighbors));
        } else if (!clorusNeighbors.isEmpty() && Math.random() <= 0.5) {
            return new Action(Action.ActionType.MOVE, randomEntry(emptyNeighbors));
        } else {
            return new Action(Action.ActionType.STAY);
        }
    }
}



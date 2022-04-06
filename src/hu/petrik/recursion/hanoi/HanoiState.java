package hu.petrik.recursion.hanoi;

import static hu.petrik.recursion.Recusives.reapeatString;

public class HanoiState {
    private final Tower from, helper, to;
    private final int numberOfDisks;

    public HanoiState(int numberOfDisks) {
        this.numberOfDisks = numberOfDisks;
        this.from = new Tower(numberOfDisks, 1);
        this.helper = new Tower(2);
        this.to = new Tower(3);
    }

    public HanoiState(int numberOfDisks, Tower from, Tower helper, Tower to) {
        this.numberOfDisks = numberOfDisks;
        this.from = from;
        this.helper = helper;
        this.to = to;
    }

    public void moveDisk(TowerName origin, TowerName destination) {
        Tower originTower = getTowerFromName(origin);
        Tower destinationTower = getTowerFromName(destination);
        if (destinationTower.canPlaceDisk(originTower.lookTop())) {
            getTowerFromName(destination).placeDisk(originTower.takeTop());
        }
    }
    public void takeStep(Step step){
        moveDisk(step.getOrigin(),step.getDestination());
    }

    public void print() {
        System.out.println();
        int spacer = String.valueOf(numberOfDisks).length();
        String formatter = " %" + spacer + "d ";
        for (int i = numberOfDisks - 1; i > -1; i--) {
            for (int j = 1; j < 4; j++) {
                Integer actual = getTowerFromName(TowerName.fromId(j)).lookPosition(i);
                if (actual == 0) {
                    System.out.print(reapeatString(" ", spacer + 2));
                } else {
                    System.out.printf(formatter, actual);
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public Tower getTowerFromName(TowerName name) {
        switch (name) {
            case FROM:
                return this.from;
            case TO:
                return this.to;
            default:
                return this.helper;
        }
    }

    public Tower getFrom() {
        return from;
    }

    public Tower getHelper() {
        return helper;
    }

    public Tower getTo() {
        return to;
    }

    public int getNumberOfDisks() {
        return numberOfDisks;
    }

}

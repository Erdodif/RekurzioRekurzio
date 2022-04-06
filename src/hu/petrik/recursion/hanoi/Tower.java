package hu.petrik.recursion.hanoi;

import java.util.LinkedList;

public class Tower {
    private final int initialId;
    private final LinkedList<Integer> column;

    public Tower(int id) {
        this.column = new LinkedList<>();
        this.initialId = id;
    }

    public Tower(Integer n,int id) {
        this.column = new LinkedList<>();
        for (int i = n; i > 0; i--) {
            column.add(i);
        }
        this.initialId = id;
    }

    public boolean canPlaceDisk(Integer disk) {
        Integer target = lookTop();
        return target == 0 || disk < target;
    }

    public void placeDisk(Integer disk) {
        if (canPlaceDisk(disk)) {
            column.add(disk);
            return;
        }
        throw new IllegalStateException(
                String.format("Lehelyezési kísérlet nem megfelelő helyre! " +
                        "(kívánt elem: %d, célhelyen álló: %d)", disk, lookTop()));
    }

    public Integer lookPosition(int position) {
        try {
            return  column.get(position);
        }
        catch (IndexOutOfBoundsException e){
            return 0;
        }
    }

    public Integer lookTop() {
        if (column.isEmpty()) {
            return 0;
        }
        return column.getLast();
    }

    public Integer takeTop() {
        if (column.isEmpty()) {
            return 0;
        }
        return column.pollLast();
    }

    public int getInitialId() {
        return initialId;
    }
    public TowerName getInitialName() {
        return TowerName.fromId(initialId);
    }
}

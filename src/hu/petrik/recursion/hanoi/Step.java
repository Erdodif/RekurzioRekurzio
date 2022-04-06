package hu.petrik.recursion.hanoi;

public class Step {
    private final TowerName origin, destination;
    public Step(TowerName origin,TowerName destination){
        this.origin = origin;
        this.destination = destination;
    }

    public TowerName getOrigin() {
        return origin;
    }

    public TowerName getDestination() {
        return destination;
    }
}

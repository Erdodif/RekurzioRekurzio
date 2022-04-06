package hu.petrik.recursion.hanoi;

public enum TowerName {
    FROM("From", 1),
    HELPER("Helper", 2),
    TO("To", 3);
    private final String name;
    private final int id;

    TowerName(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static TowerName fromId(int id) {
        switch (id) {
            case 1:
                return FROM;
            case 2:
                return HELPER;
            case 3:
                return TO;
            default:
                throw new IllegalArgumentException("3 torony van csak (1-3), megadba: " + id);
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}

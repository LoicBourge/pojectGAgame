public enum EnvironmentTile {
    VIDE("\u00A0"),
    TILE("\u22A0"),
    CREATURE("\u26C4"),
    START("\u2690"),
    END("\u2691");


    private final String tile;

    EnvironmentTile(String tile){
        this.tile=tile;
    }

    public String getTile() {
        return tile;
    }

    @Override
    public String toString() {
        return  tile;
    }
}

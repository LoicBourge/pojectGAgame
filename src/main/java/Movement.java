public enum Movement {
    DOWN (0,1),
    DOWN_RIGHT (1,1),
    RIGHT (1,0),
    UP_RIGHT (1,-1),
    UP(0,-1),
    UP_LEFT(-1,-1),
    LEFT(-1,0),
    DOWN_LEFT(-1,1);

    private int x;
    private int y;

    Movement(int x,int y){
        this.x =x;
        this.y =y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Movement[] multiplechoiceMovement(String choice){
        char[] digits1 = choice.toCharArray();
        Movement[] movements = new Movement[digits1.length];
        int i=0;
        for (char digit:digits1) {
            movements[i]=Movement.values()[Character.digit(digit,10)];
            i++;
        }
        return movements;
    }

}

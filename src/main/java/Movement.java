public enum Movement {
    DOWN (0,-1),
    DOWN_RIGHT (1,-1),
    RIGHT (1,0),
    UP_RIGHT (1,1),
    UP(0,1),
    UP_LEFT(-1,1),
    LEFT(-1,0),
    DOWN_LEFT(-1,-1);

    private int x;
    private int y;

    Movement(int x,int y){
        this.x =x;
        this.y =y;
    }

    public Movement choiceMovement(int choice){
        switch (choice){
            case 0: return DOWN;
            case 1: return DOWN_RIGHT;
            case 2: return RIGHT;
            case 3: return UP_RIGHT;
            case 4: return UP;
            case 5: return UP_LEFT;
            case 6: return LEFT;
            case 7: return DOWN_LEFT;
        }
        return null;
    }

    public Movement[] multiplechoiceMovement(String choice){
        char[] digits1 = choice.toCharArray();
        Movement[] movements = new Movement[digits1.length];
        int i=0;
        for (char digit:digits1) {
            movements[i]=choiceMovement(digit);
        }
        return movements;
    }

}

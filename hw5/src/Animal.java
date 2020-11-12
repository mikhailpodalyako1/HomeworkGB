public abstract class Animal {
    private String type;
    private float maxRan;
    private float maxJamp;
    private float maxSwim;

    static final int swimYes = 1;
    static final int swimNo = 0;


    Animal(String type, float maxRan, float maxJamp, float maxSwim){
        this.type = type;
        this.maxRan = maxRan;
        this.maxJamp = maxJamp;
        this.maxSwim = maxSwim;
    }

    String getType() {
        return this.type;
    }

    float getMaxRan() {
        return this.maxRan;
    }

    float getMaxJamp() {
        return this.maxJamp;
    }

    float getMaxSwim() {
        return this.maxSwim;
    }

    protected boolean ran(float distance) {
        return (distance <= maxRan);
    }

    protected int swim (float distance) {
        return (distance <= maxSwim) ? swimYes : swimNo;
    }

    protected boolean jump (float hight ) {
        return (hight <= maxJamp);
    }

}

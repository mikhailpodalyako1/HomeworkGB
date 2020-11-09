public class Bird extends Animal {
    Bird (String type, float maxJump, float maxRun, float maxSwim){
        super ("Bird", maxJump, maxRun, maxSwim);
    }
    @Override
    protected int swim(float distance) {
        return Animal.swimNo;
    }
}

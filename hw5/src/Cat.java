public class Cat extends Animal {

    Cat(String type, float maxJump, float maxRun, float maxSwim) {
        super ("Cat", maxJump, maxRun, maxSwim);
    }

    @Override
    protected int swim(float distance) {
        return Animal.swimNo;
    }

}

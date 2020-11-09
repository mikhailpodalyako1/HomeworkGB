public class Actions {

    public static void main(String[] args) {

        Cat cat1 = new Cat ( "Vasiliy", 2, 200, 0);
        Dog dog1 = new Dog("Petya", 0.5f, 500, 10);
        Horse horse1 = new Horse("Stepan", 3f, 1500, 100);
        Bird bird1 = new Bird("Viktor",0.2f, 5, 0);

        Animal[] arrey = {cat1, dog1, horse1, bird1};
        float toJump = 0.9f;
        float toRun = 300;
        float toSwim = 10;

        for (int i = 0; i < arrey.length; i++) {
            String nameString = arrey[i].getType() + " " + arrey[i].getType() + " может ";

            String eventName = String.format("прыгнуть на %.2f м. Пытается прыгнуть на ", arrey[i].getMaxJamp());
            String eventResult = (arrey[i].jump(toJump)) ? " это получилось" : " это не получилось";
            System.out.println(nameString + eventName + toJump + " м и" + eventResult);

            eventName = String.format("пробежать на %.2f м. Пытается пробежать на ", arrey[i].getMaxRan());
            eventResult = arrey[i].ran(toRun) ? " это получилось" : " это не получилось";
            System.out.println(nameString + eventName + toRun + " м и" + eventResult);

            int swimResult = arrey[i].swim(toSwim);
            eventName = String.format("проплыть на %.2f м. Попытка проплыть на ", arrey[i].getMaxSwim());
            eventResult = (swimResult == Animal.swimNo) ? " это получилось" : " это не получилось";
            if (swimResult == Animal.swimNo)
                eventResult = " это не получилось, т.к. не умеет плавать";
            System.out.println(nameString + eventName + toSwim + " м и" + eventResult);
        }
    }

}

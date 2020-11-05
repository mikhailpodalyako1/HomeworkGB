public class Employee {
    private String surname;
    private String secondName;
    private String name;
    private String position;
    private String phonenumber;
    private float salary;
    private int age;

     Employee(String name,
             String secondName,
             String surname,
             String phonenumber,
             String position,
             float salary,
             int age) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.position = position;
        this.phonenumber = phonenumber;
        this.salary = salary;
        }

    String getName (){
         return name;
    }

    String getSurname (){
        return surname;
    }

    String getSecondName(){
        return secondName;
    }

    String getPhonenumber(){
         return phonenumber;
    }

    String getPosition() {
         return position;
    }

    float getSalary() {
         return salary;
    }

    int getAge(){
         return age;
    }


}

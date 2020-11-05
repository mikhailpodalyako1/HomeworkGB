public class main {
    public static void main(String[] args){
      Employee employee1 = new Employee("Petr", "Petrovich",
                "Petrov", "8912121212",
                "ingeneer", 100000, 25);

      System.out.println("Name " + employee1.getName() + " "+ employee1.getSecondName() + " " + employee1.getSurname()
              + ", Position "+ employee1.getPosition());


        Employee employee2 = new Employee("Ivan", "Ivanovich",
                "Ivanovc", "8912121212",
                "ingeneer", 20000, 45);
        Employee employee3 = new Employee("Oleg", "Olegovich",
                "Olegov", "8912121213",
                "ingeneer", 50000, 50);
        Employee employee4 = new Employee("Viktor", "Sergeyvich",
                "Popov", "8912121214",
                "ingeneer", 75000, 60);
        Employee employee5 = new Employee("Petro", "Sergeyvich",
                "Timoshenko", "8912121215",
                "ingeneer", 75000, 27);

        Employee[] employees = {employee1, employee2, employee3, employee4, employee5};
        System.out.println ("Emplyees elder then 40");
        for (int i = 0; i < employees.length; i++)
            if (employees[i].getAge()>40) {
                System.out.println ( employees[i].getName() + " " +
                                    employees[i].getSecondName() + " " +
                                    employees[i].getSurname() + " " +
                                    employees[i].getPhonenumber() + " " +
                                    employees[i].getSalary() + " "+
                                    employees[i].getPosition() + " "+
                                    employees[i].getAge());
            }

    }
}

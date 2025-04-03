package seminar3;

public class Employee {
    private static final int CURRENT_YEAR = 2025;
    String name;
    String midName;
    String surName;
    String position;
    String phone;
    int salary;
    int birthYear;

    public Employee(String name, String midName, String surName, String position, String phone, int salary, int birthYear) {
        this.name = name;
        this.midName = midName;
        this.surName = surName;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return CURRENT_YEAR - birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void raiseSalary(int sumRaise, int ageRaise) {
        if (this.getAge() > ageRaise) {
            this.setSalary(this.getSalary() + sumRaise);
        }
    }

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s %s, %s, телефон=%s, зарплата=%d, возраст=%d",
                surName, name, midName, position, phone, salary, getAge());


    }

    public static float averageSalary(Employee[] emp) {
        float result = 0;
        for (int i = 0; i < emp.length; i++)
            result += emp[i].getSalary();

        return result / emp.length;
    }


    public static float averageAge(Employee[] emp) {
        float result = 0;
        for (int i = 0; i < emp.length; i++)
            result += emp[i].getAge();

        return result / emp.length;
    }


}

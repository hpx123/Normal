public class Info {
}

class Person{
    String name;
    String address;
    String phoneNum;
    String emailAdd;

    public Person(String name, String address, String phoneNum, String emailAdd) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.emailAdd = emailAdd;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", emailAdd='" + emailAdd + '\'' +
                '}';
    }
}

class Students extends Person{
    int status = 1;

    public Students(String name, String address, String phoneNum, String emailAdd, int status) {
        super(name, address, phoneNum, emailAdd);
        this.status = status;
    }

    public Students(String name, String address, String phoneNum, String emailAdd) {
        super(name, address, phoneNum, emailAdd);
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", emailAdd='" + emailAdd + '\'' +
                ", status=" + status +
                '}';
    }
}

class Employee extends Person{
    String office;
    String salary;
    String dateHired;

    public Employee(String name, String address, String phoneNum, String emailAdd, String office, String salary, String dateHired) {
        super(name, address, phoneNum, emailAdd);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", emailAdd='" + emailAdd + '\'' +
                ", office='" + office + '\'' +
                ", salary='" + salary + '\'' +
                ", dateHired='" + dateHired + '\'' +
                '}';
    }
}
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    static List<Employee> employees = new ArrayList<>();

    static void addEmployee(int id, String name, double salary) {
        employees.add(new Employee(id, name, salary));
    }

    static void updateEmployee(int id, String newName, double newSalary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.name = newName;
                emp.salary = newSalary;
                return;
            }
        }
    }

    static void removeEmployee(int id) {
        employees.removeIf(emp -> emp.id == id);
    }

    static Employee searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                return emp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Employee\n2. Update Employee\n3. Remove Employee\n4. Search Employee\n5. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter ID, Name, Salary: ");
                int id = sc.nextInt();
                String name = sc.next();
                double salary = sc.nextDouble();
                addEmployee(id, name, salary);
            } else if (choice == 2) {
                System.out.print("Enter ID, New Name, New Salary: ");
                int id = sc.nextInt();
                String newName = sc.next();
                double newSalary = sc.nextDouble();
                updateEmployee(id, newName, newSalary);
            } else if (choice == 3) {
                System.out.print("Enter ID to remove: ");
                int id = sc.nextInt();
                removeEmployee(id);
            } else if (choice == 4) {
                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();
                Employee emp = searchEmployee(id);
                System.out.println(emp != null ? emp : "Employee not found");
            } else if (choice == 5) {
                break;
            }
        }
        sc.close();
    }
}

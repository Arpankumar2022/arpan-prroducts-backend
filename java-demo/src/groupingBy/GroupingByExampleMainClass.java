package groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupingByExampleMainClass {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("1", "Alice", "101"),
                new Employee("2", "Bob", "102"),
                new Employee("3", "Charlie", "101"),
                new Employee("4", "David", "103")
        );

        List<Department> departments = Arrays.asList(
                new Department("101", "HR"),
                new Department("102", "Engineering"),
                new Department("103", "Marketing")
        );

        List<Project> projects = Arrays.asList(
                new Project("P1", "Project X"),
                new Project("P2", "Project Y"),
                new Project("P3", "Project Z")
        );

        List<EmployeeProject> employeeProjects = Arrays.asList(
                new EmployeeProject("1", "P1"),
                new EmployeeProject("2", "P2"),
                new EmployeeProject("3", "P1"),
                new EmployeeProject("4", "P3")
        );

        // Group employees by department and then by project
        groupEmployeesByDepartmentAndProject(employees, departments, projects, employeeProjects);

    }

    private static void groupEmployeesByDepartmentAndProject(List<Employee> employees, List<Department> departments, List<Project> projects, List<EmployeeProject> employeeProjects) {

        employees.stream().collect(Collectors.groupingBy(emp-> emp.getDepartmentId()
                )).entrySet().forEach(obj-> System.out.println(obj.getValue()+"   ++++   "+obj.getKey()));



    }
}

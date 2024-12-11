package java17;

public class TextBlock {

    public static void main(String[] args) {
        String sql = """
    SELECT id, firstName, lastName\s\
    FROM Employee
    WHERE departmentId = "IT" \
    ORDER BY lastName, firstName""";

        System.out.println(sql);
    }
}

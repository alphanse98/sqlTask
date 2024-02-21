import java.sql.*;

public class connectionJdbc {
    public static void main(String[] args) throws SQLException {

        // Database URL, username, and password
        String url = "jdbc:mysql://localhost/taskOne";
        String user = "root";
        String pass = "123456";

        // Establishing a connection to the database
        Connection connection = DriverManager.getConnection(url, user, pass);

        // SQL query to create the 'employee' table if it doesn't exist
        String createTableQuery = "CREATE TABLE IF NOT EXISTS employee ("
                + "empcode INT PRIMARY KEY,"
                + "empname VARCHAR(255),"
                + "empage INT,"
                + "esalary DOUBLE"
                + ")";

//        PreparedStatement cretedTable =   connection.prepareStatement(createTableQuery);
//        cretedTable.execute();


        // SQL query to insert data into the 'employee' table
        String insetQuery = "insert into employee (empcode, empname, empage, esalary) values " +
                "(101, 'Jenny', 25, 10000)," +
                "(102, 'Jacky', 30, 20000), " +
                "(103, 'Joe', 20, 40000), " +
                "(104, 'John', 40, 80000), " +
                "(105, 'Shameer', 25, 90000);";

//        PreparedStatement insetedData =   connection.prepareStatement(insetQuery);
//        insetedData.execute();


        // SQL query to select all data from the 'employee' table
        String selectSQL  = "select * from employee;";

        PreparedStatement selectSQLData =   connection.prepareStatement(selectSQL);
        selectSQLData.execute();

        ResultSet resultSet = selectSQLData.executeQuery();

        while (resultSet.next()) {
            int empCode = resultSet.getInt("empcode");
            String empName = resultSet.getString("empname");
            int empAge = resultSet.getInt("empage");
            double empSalary = resultSet.getDouble("esalary");

            System.out.println(empCode + "\t" + empName + "\t" + empAge + "\t" + empSalary);
        }



    }
}

//OUT PUT

// 101	Jenny	25	10000.0
// 102	Jacky	30	20000.0
// 103	Joe	20	40000.0
// 104	John	40	80000.0
// 105	Shameer	25	90000.0




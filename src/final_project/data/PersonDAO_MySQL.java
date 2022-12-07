package final_project.data;

import final_project.MyException;
import java1review.Person;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO_MySQL implements MyDAO<Person>{

    List<Person> list;

    private Connection getConnection() throws SQLException {
        String connectionString = "jdbc:mariadb://127.0.0.1:3307/java2_22b";
        String username = "root";
        String password = "password";
        Connection connection = DriverManager.getConnection(connectionString, username, password);
        return connection;
    }

    @Override
    public void readInData() throws MyException {
        try(Connection connection = getConnection()) {
            if(connection.isValid(2)) {
                list = new ArrayList<>();
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
                CallableStatement statement = connection.prepareCall("{call sp_get_all_people()}");
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    int heightInInches = resultSet.getInt("heightInInches");
                    double weightInPounds = resultSet.getDouble("weightInPounds");
                    LocalDateTime dateOfBirth = resultSet.getTimestamp("dateOfBirth").toLocalDateTime();
                    Person person = new Person(id, firstName, lastName, heightInInches, weightInPounds, dateOfBirth);
                    list.add(person);
                }
                resultSet.close();
                statement.close();
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
        }

    }

    @Override
    public void add(Person obj) throws MyException {
        // update the ArrayList
        if(list == null) {
            readInData();
        }
        list.add(obj);
        // update the database
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{call sp_add_person(?,?,?,?,?)}");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setInt(3, obj.getHeightInInches());
            statement.setDouble(4, obj.getWeightInPounds());
            statement.setTimestamp(5, Timestamp.valueOf(obj.getDateOfBirth()));
            statement.execute();
        } catch(SQLException e) {

        }
    }

    @Override
    public Person get(int id) throws MyException {
        Person person = null;
        try(Connection connection = getConnection()) {
             CallableStatement statement = connection.prepareCall("{call sp_get_person_by_id(?)}");
             statement.setInt(1, id);
             ResultSet resultSet = statement.executeQuery();
             if(resultSet.next()) {
                 String firstName = resultSet.getString("firstName");
                 String lastName = resultSet.getString("lastName");
                 int heightInInches = resultSet.getInt("heightInInches");
                 double weightInPounds = resultSet.getDouble("weightInPounds");
                 LocalDateTime dateOfBirth = resultSet.getTimestamp("dateOfBirth").toLocalDateTime();
                 person = new Person(id, firstName, lastName, heightInInches, weightInPounds, dateOfBirth);
             }
             resultSet.close();
             statement.close();
        } catch(SQLException e) {

        }
        return person;
    }

    @Override
    public List<Person> get(String name) throws MyException {
        List<Person> people = new ArrayList<>();
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{call sp_get_person_by_name(?)}");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int heightInInches = resultSet.getInt("heightInInches");
                double weightInPounds = resultSet.getDouble("weightInPounds");
                LocalDateTime dateOfBirth = resultSet.getTimestamp("dateOfBirth").toLocalDateTime();
                Person person = new Person(id, firstName, lastName, heightInInches, weightInPounds, dateOfBirth);
                people.add(person);
            }
            resultSet.close();
            statement.close();
        } catch(SQLException e) {

        }
        return people;
    }

    @Override
    public List<Person> get(LocalDate date) throws MyException {
        List<Person> people = new ArrayList<>();
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{call sp_get_person_by_date(?)}");
            statement.setTimestamp(1, Timestamp.valueOf(date.atStartOfDay()));
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int heightInInches = resultSet.getInt("heightInInches");
                double weightInPounds = resultSet.getDouble("weightInPounds");
                LocalDateTime dateOfBirth = resultSet.getTimestamp("dateOfBirth").toLocalDateTime();
                Person person = new Person(id, firstName, lastName, heightInInches, weightInPounds, dateOfBirth);
                people.add(person);
            }
            resultSet.close();
            statement.close();
        } catch(SQLException e) {

        }
        return people;
    }

    @Override
    public List<Person> getAll() throws MyException {
        if(list == null) {
            readInData();
        }
        return list;
    }

    @Override
    public void set(int id, Person obj) throws MyException {
        // update list
        list.set(id, obj);
        // update database
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{call sp_update_person(?,?,?,?,?,?)}");
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getFirstName());
            statement.setString(3, obj.getLastName());
            statement.setInt(4, obj.getHeightInInches());
            statement.setDouble(5, obj.getWeightInPounds());
            statement.setTimestamp(6, Timestamp.valueOf(obj.getDateOfBirth()));
            statement.execute();
            statement.close();
        } catch(SQLException e) {

        }
    }

    @Override
    public boolean remove(Person obj) throws MyException {
        // update list
        list.remove(obj);
        // update database
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{call sp_delete_person(?)}");
            statement.setInt(1, obj.getId());
            statement.execute();
            statement.close();
            return true;
        } catch(SQLException e) {

        }
        return false;
    }


}

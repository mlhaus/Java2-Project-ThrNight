package final_project.input;

import final_project.MyException;
import final_project.data.MyDAO;
import final_project.ui.UserInput;
import java1review.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GetPerson implements MyDataHandler {
    @Override
    public void handleTask(MyDAO dao, Scanner scanner, ResourceBundle messages) throws MyException {
        String userIn = UserInput.getString("Search for person by their id, first name, last name, or date of birth (YYYY-MM-DD)", scanner);
        try {
            // Check if id was input
            int id = Integer.parseInt(userIn);
            Person person = (Person)dao.get(id);
            if(person == null) {
                System.out.println("\nNo person found with id '" + id + "'.");
            } else {
                System.out.println("\nRetrieved:");
                System.out.println(person);
            }
        } catch(NumberFormatException e1) {
            try {
                // Check if date was input
                DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateOfBirth = LocalDate.parse(userIn, formatterInput);
                List<Person> people = dao.get(dateOfBirth);
                if(people.size() == 0) {
                    System.out.println("\nNo person found with birth date '" + dateOfBirth + "'.");
                } else {
                    System.out.println("\nRetrieved:");
                    for(Person person: people) {
                        System.out.println(person);
                    }
                }
            } catch (DateTimeParseException e2) {
                // The input must be a string
                List<Person> people = dao.get(userIn);
                if(people.size() == 0) {
                    System.out.println("\nNo person found with first or last name containing '" + userIn + "'.");
                } else {
                    System.out.println("\nRetrieved:");
                    for(Person person: people) {
                        System.out.println(person);
                    }
                }
            }
        }
    }
}

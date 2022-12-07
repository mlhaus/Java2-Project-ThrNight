package final_project.input;

import final_project.MyException;
import final_project.data.MyDAO;
import final_project.ui.UIUtility;
import final_project.ui.UserInput;
import java1review.Person;

import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AddPerson implements MyDataHandler {
    @Override
    public void handleTask(MyDAO dao, Scanner scanner, ResourceBundle messages) throws MyException {
        Person person = new Person();
        UIUtility.showMenuTitle(messages.getString("add-person"));
        for(;;) {
            try {
                String userIn = UserInput.getString(messages.getString("enter-first-name"), scanner);
                person.setFirstName(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                String userIn = UserInput.getString(messages.getString("enter-last-name"), scanner);
                person.setLastName(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                int userIn = UserInput.getInt(messages.getString("enter-height"), scanner, messages);
                person.setHeightInInches(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                double userIn = UserInput.getDouble(messages.getString("enter-weight"), scanner, messages);
                person.setWeightInPounds(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        for(;;) {
            try {
                LocalDateTime userIn = UserInput.getDate(messages.getString("enter-date-of-birth"), scanner, messages);
                person.setDateOfBirth(userIn);
                break;
            } catch(IllegalArgumentException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
        }

        dao.add(person);
        System.out.println("\n" + messages.getString("person-added"));
    }
}

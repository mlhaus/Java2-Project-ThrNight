package final_project;

import final_project.data.MyDAO;
import final_project.data.MyDAOFactory;
import final_project.input.AddPerson;
import final_project.input.DeletePerson;
import final_project.input.GetPerson;
import final_project.input.UpdatePerson;
import final_project.ui.Language;
import final_project.ui.UIUtility;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Language language = new Language();
        ResourceBundle messages = language.getMessages();
        Scanner scanner = new Scanner(System.in);
        String dao_source = "mysql";
        MyDAO personDAO = MyDAOFactory.getMyDAO(dao_source).get(0);
        MyDAO bookDAO = MyDAOFactory.getMyDAO(dao_source).get(1);
        if(personDAO == null) {
            UIUtility.showErrorMessage("Person data source '"+ dao_source + "' invalid", scanner, messages);
            return;
        }
        if(bookDAO == null) {
            UIUtility.showErrorMessage("Book data source '"+ dao_source + "' invalid", scanner, messages);
            return;
        }
        try {
            personDAO.readInData();
            bookDAO.readInData();
        } catch(MyException e) {
            UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            return;
        }
        int choice = 0;
        while(true) {
            messages = language.getMessages();
            String menuTitle = messages.getString("main-menu");
            String prompt = messages.getString("prompt");
            String[] menuOptions = {
                    messages.getString("add-person"),
                    messages.getString("get-person"),
                    messages.getString("update-person"),
                    messages.getString("delete-person"),
                    messages.getString("change-language")
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if(choice == menuOptions.length + 1) {
                break;
            }
            if(choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            try {
                switch (choice) {
                    case 1:
                        new AddPerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 2:
                        new GetPerson().handleTask(personDAO,scanner, messages);
                        break;
                    case 3:
                        new UpdatePerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 4:
                        new DeletePerson().handleTask(personDAO, scanner, messages);
                        break;
                    case 5:
                        language.setMessages(scanner);
                        messages = language.getMessages();
                        break;
                }
            } catch (MyException e) {
                UIUtility.showErrorMessage(e.getMessage(), scanner, messages);
            }
            UIUtility.pressEnterToContinue(scanner, messages);
        }
        System.out.println("\n" + messages.getString("end"));
        scanner.close();
    }
}

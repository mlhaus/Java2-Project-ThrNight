package final_project.ui;

import final_project.ui.UIUtility;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Language {
    private ResourceBundle messages;

    public Language() {
        messages = ResourceBundle.getBundle("messages", Locale.getDefault());
    }

    public ResourceBundle getMessages() {
        return messages;
    }

    public void setMessages(Scanner scanner) {
        int choice = 0;
        while(true) {
            String menuTitle = messages.getString("languages-available");
            String prompt = messages.getString("select-language");
            String[] menuOptions = {
                    messages.getString("english"),
                    messages.getString("french")
            };
            choice = UIUtility.showMenuOptions(menuTitle, prompt, menuOptions, scanner, messages);
            if(choice == menuOptions.length + 1) {
                break;
            }
            if(choice <= 0 || choice > menuOptions.length + 1) {
                UIUtility.pressEnterToContinue(scanner, messages);
                continue;
            }
            switch(choice) {
                case 1:
                    messages = ResourceBundle.getBundle("messages", Locale.ENGLISH);
                    break;
                case 2:
                    messages = ResourceBundle.getBundle("messages", new Locale("fr", "FR"));
                    break;
            }
            System.out.println("\n" + messages.getString("language-changed"));
            break;
        }
    }
}

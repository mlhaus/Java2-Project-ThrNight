package final_project.input;

import final_project.MyException;
import final_project.data.MyDAO;

import java.util.ResourceBundle;
import java.util.Scanner;

public interface MyDataHandler {
    void handleTask(MyDAO dao, Scanner scanner, ResourceBundle messages) throws MyException;
}

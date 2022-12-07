package final_project.data;

import final_project.data.MyDAO;

import java.util.ArrayList;
import java.util.List;

public class MyDAOFactory {
    public static List<MyDAO> getMyDAO(String dao_source) {
        MyDAO personDAO = null;
        MyDAO bookDAO = null;
        switch(dao_source.toUpperCase()) {
            case "CSV":
                personDAO = new PersonDAO_CSV();
                bookDAO = new BookDAO_CSV();
                break;
            case "XML":
                personDAO = new PersonDAO_XML();
                
                break;
            case "MYSQL":
                personDAO = new PersonDAO_MySQL();
                bookDAO = new BookDAO_MySQL();
                break;
        }
        List<MyDAO> daos = new ArrayList<>();
        daos.add(personDAO);
        daos.add(bookDAO);
        return daos;
    }

}

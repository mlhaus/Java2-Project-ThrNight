package final_project.data;

import final_project.MyException;
import java1review.Person;

import java.time.LocalDate;
import java.util.List;

public class PersonDAO_XML implements MyDAO<Person>{
    @Override
    public void readInData() throws MyException {

    }

    @Override
    public void add(Person obj) throws MyException {

    }

    @Override
    public Person get(int id) throws MyException {
        return null;
    }

    @Override
    public List<Person> get(String name) throws MyException {
        return null;
    }

    @Override
    public List<Person> get(LocalDate date) throws MyException {
        return null;
    }

    @Override
    public List<Person> getAll() throws MyException {
        return null;
    }

    @Override
    public void set(int id, Person obj) throws MyException {

    }

    @Override
    public boolean remove(Person obj) throws MyException {
        return false;
    }


}

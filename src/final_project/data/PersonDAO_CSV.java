package final_project.data;

import final_project.MyException;
import java1review.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PersonDAO_CSV implements MyDAO<Person>{
    private static final String FILE_PATH = "src/main/resources/person.csv";
    private List<Person> list;
    private int next_id = 0;

    @Override
    public void readInData() throws MyException {
        try(Scanner scanner = new Scanner(new File(FILE_PATH))) {
            list = new ArrayList<Person>();
            int lineCount = 1;
            String line = scanner.nextLine();
            while(scanner.hasNextLine()) {
                lineCount++;
                line = scanner.nextLine();
                String[] fields = line.split(",");
                try {
                    int id = Integer.parseInt(fields[0]);
                    String firstName = fields[1];
                    String lastName = fields[2];
                    int height = Integer.parseInt(fields[3]);
                    double weight = Double.parseDouble(fields[4]);
                    DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate dateOfBirth = LocalDate.parse(fields[5], formatterInput);
                    if(id > next_id) {
                        next_id = id;
                    }
                    Person person = new Person(id, firstName, lastName, height, weight, dateOfBirth.atStartOfDay());
                    list.add(person);
                } catch(DateTimeParseException | IllegalArgumentException e) {
                    throw new MyException("Invalid data found on line " + lineCount + " of file: '" + FILE_PATH + "'.");
                } 
            }
        } catch(FileNotFoundException e) {
            throw new MyException("File cannot be found at '" + FILE_PATH + "'.");
        }
    }

    @Override
    public void add(Person obj) throws MyException {
        obj.setId(++next_id);
        list.add(obj);
        saveToFile();
    }

    public void saveToFile() throws MyException {
        try(PrintWriter writer = new PrintWriter(new File(FILE_PATH))) {
            String firstLine = "id,firstName,lastName,heightInInches,weightInPounds,dateOfBirth";
            writer.println(firstLine);
            list.forEach((person) -> {
                String line = person.getId() + ","
                        + person.getFirstName() + ","
                        + person.getLastName() + ","
                        + person.getHeightInInches() + ","
                        + person.getWeightInPounds() + ","
                        + person.getDateOfBirth().toLocalDate();
                writer.println(line);
            });
        } catch(FileNotFoundException e) {
            throw new MyException(e.getMessage());
        }
    }

    @Override
    public Person get(int id) throws MyException {
        try(Scanner scanner = new Scanner(new File(FILE_PATH))) {
            String line = scanner.nextLine();
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] fields = line.split(",");
                if(id == Integer.parseInt(fields[0])) {
                    Person person = new Person(id, fields[1], fields[2], Integer.parseInt(fields[3]), Double.parseDouble(fields[4]), LocalDate.parse(fields[5], DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay());
                    return person;
                }
            }
        } catch(FileNotFoundException e) {
            throw new MyException("File cannot be found at '" + FILE_PATH + "'.");
        }
        return null;
    }

    @Override
    public List<Person> get(String name) throws MyException {
        List<Person> list = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(FILE_PATH))) {
            String line = scanner.nextLine();
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] fields = line.split(",");
                String firstName = fields[1].toUpperCase();
                String lastName = fields[2].toUpperCase();
                if(firstName.contains(name.toUpperCase()) || lastName.contains(name.toUpperCase())
                || (firstName + " " + lastName).contains(name.toUpperCase())){
                    Person person = new Person(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Double.parseDouble(fields[4]), LocalDate.parse(fields[5], DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay());
                    list.add(person);
                }
            }
        } catch(FileNotFoundException e) {
            throw new MyException("File cannot be found at '" + FILE_PATH + "'.");
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public List<Person> get(LocalDate date) throws MyException {
        List<Person> list = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(FILE_PATH))) {
            String line = scanner.nextLine();
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] fields = line.split(",");
                if(date.equals(LocalDate.parse(fields[5]))){
                    Person person = new Person(Integer.parseInt(fields[0]), fields[1], fields[2], Integer.parseInt(fields[3]), Double.parseDouble(fields[4]), date.atStartOfDay());
                    list.add(person);
                }
            }
        } catch(FileNotFoundException e) {
            throw new MyException("File cannot be found at '" + FILE_PATH + "'.");
        }
        return list;
    }

    @Override
    public List<Person> getAll() throws MyException {
        return list;
    }

    @Override
    public void set(int id, Person obj) throws MyException {
        list.set(id, obj);
        saveToFile();
    }

    @Override
    public boolean remove(Person obj) throws MyException {
        boolean removed = list.remove(obj);
        saveToFile();
        return removed;
    }


}

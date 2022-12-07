package java1review;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Person implements Comparable<Person> {
    private int id;
    private String firstName;
    private String lastName;
    private int heightInInches;
    private double weightInPounds;
    private LocalDateTime dateOfBirth;

    public static final int DEFAULT_ID = 0;
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final int DEFAULT_HEIGHT_WEIGHT = 0;
    public static final LocalDateTime DEFAULT_DOB = LocalDateTime.now().minusDays(1);
    public static final LocalDateTime TOMORROW_MIDNIGHT_CST = LocalDateTime.of(LocalDate.now(ZoneId.of("America/Los_Angeles")), LocalTime.MIDNIGHT);

    public Person(int id, String firstName, String lastName, int heightInInches, double weightInPounds, LocalDateTime dateOfBirth) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setHeightInInches(heightInInches);
        setWeightInPounds(weightInPounds);
        setDateOfBirth(dateOfBirth);
    }

    public Person(String firstName, String lastName) {
        this(DEFAULT_ID, firstName, lastName, DEFAULT_HEIGHT_WEIGHT, DEFAULT_HEIGHT_WEIGHT, DEFAULT_DOB);
    }

    public Person(String firstName) {
        this(firstName, DEFAULT_LAST_NAME);
    }

    public Person() {
        this(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.equals("")) {
            throw new IllegalArgumentException("First name is required");
        } else if(firstName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("First name cannot contain a number");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.equals("")) {
            throw new IllegalArgumentException("Last name is required");
        } else if(lastName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Last name cannot contain a number");
        }
        this.lastName = lastName;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        if(heightInInches < 0) {
            throw new IllegalArgumentException("Height must be greater than or equal to 0");
        }
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        if(weightInPounds < 0) {
            throw new IllegalArgumentException("Weight must be greater than or equal to 0");
        }
        this.weightInPounds = weightInPounds;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        if(dateOfBirth.isAfter(TOMORROW_MIDNIGHT_CST)) {
            throw new IllegalArgumentException("Birth date cannot be in the future");
        }
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName ;
    }

    @Override
    public int compareTo(Person o) {
        int result = this.lastName.compareTo(o.lastName);
        if(result == 0) {
            result = this.firstName.compareTo(o.firstName);
        }
        return result;
    }
}

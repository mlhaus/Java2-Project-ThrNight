package java1review;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person person;
    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void sample() {
        
    }

    @Test
    void getFirstName() {
        assertEquals(Person.DEFAULT_FIRST_NAME, person.getFirstName());
    }

    @Test
    void setFirstName() {
        // Good data
        person.setFirstName("Marc");
        assertEquals("Marc", person.getFirstName());
        // Bad data
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> person.setFirstName(""));
        assertEquals("First name is required", e.getMessage());
        e = assertThrows(IllegalArgumentException.class, () -> person.setFirstName("1"));
        assertEquals("First name cannot contain a number", e.getMessage());
    }

    @Test
    void getLastName() {
        assertEquals(Person.DEFAULT_LAST_NAME, person.getLastName());
    }

    @Test
    void setLastName() {
        fail();
    }

    @Test
    void getHeightInInches() {
        assertEquals(Person.DEFAULT_HEIGHT_WEIGHT, person.getHeightInInches());
    }

    @Test
    void setHeightInInches() {
        // Good data
        person.setHeightInInches(70);
        assertEquals(70, person.getHeightInInches());
        // bad data
        assertThrows(IllegalArgumentException.class, () -> person.setHeightInInches(-1));
    }

    @Test
    void getWeightInPounds() {
        assertEquals(Person.DEFAULT_HEIGHT_WEIGHT, person.getWeightInPounds());
    }

    @Test
    void setWeightInPounds() {
        fail();
    }

    @Test
    void getDateOfBirth() {
        assertEquals(Person.DEFAULT_DOB, person.getDateOfBirth());
    }

    @Test
    void setDateOfBirth() {
        // Good
        person.setDateOfBirth(LocalDateTime.of(1981, 2, 6, 11, 50));
        assertEquals(LocalDateTime.of(1981, 2, 6, 11, 50), person.getDateOfBirth());
        // Bad
        assertThrows(IllegalArgumentException.class, () -> person.setDateOfBirth(LocalDateTime.now().plusDays(1)));
    }

    @Test
    void testToString() {
        assertEquals(String.format("Person{firstName='%s', lastName='%s'}", Person.DEFAULT_FIRST_NAME,
                Person.DEFAULT_LAST_NAME), person.toString());
    }

    @Test
    void testCompareTo() {
        Person person2 = new Person("Jane", "Doe");
        Person person3 = new Person("Marc", "Hauschildt");
        Person person4 = new Person("Amy", "Hauschildt");
        assertTrue(person.compareTo(person2) > 0);
        assertTrue(person2.compareTo(person3) < 0);
        assertTrue(person3.compareTo(person4) > 0);
        assertTrue(person4.compareTo(person) > 0);
        assertTrue(person2.compareTo(person4) < 0);
        assertTrue(person4.compareTo(person4) == 0);
    }
}
package java1review;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {
    @Test
    public void goodTests() {
        assertTrue("0.0.1".equals(new Version().toString()));
        assertTrue(new Version("1.2.3").toString().equals("1.2.3"));
        assertTrue(new Version("1.2.3.4").toString().equals("1.2.3"));
        assertTrue(new Version("1.2.3.d").toString().equals("1.2.3"));
        assertTrue(new Version("1").toString().equals("1.0.0"));
        assertTrue(new Version("1.1").toString().equals("1.1.0"));
        assertTrue(new Version(1, 2, 3).toString().equals("1.2.3"));
        assertTrue(new Version("").toString().equals("0.0.1"));
        assertEquals("0.0.1", new Version().toString());
        assertEquals("1.2.3", new Version("1.2.3").toString());
        assertEquals("1.2.3", new Version("1.2.3.4").toString());
        assertEquals("1.2.3", new Version("1.2.3.d").toString());
        assertEquals("1.0.0", new Version("1").toString());
        assertEquals("1.1.0", new Version("1.1").toString());
        assertEquals("1.2.3", new Version(1, 2, 3).toString());
        assertEquals("0.0.1", new Version("").toString());
    }

    @Test
    public void badTests() {
        assertThrows(IllegalArgumentException.class, () -> new Version("a.b.c"));
        assertThrows(IllegalArgumentException.class, () -> new Version(-1, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Version(-0, -1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Version(0, 0, -1));
        assertThrows(IllegalArgumentException.class, () -> new Version(0, 0, 0));
    }
}
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @Test
    public void findsuperheroTestWhenOneHeroes() {
        // Arrange
        Database database = new Database();

        // Act
        database.createSuperhero("The flash", "Speed", 2000, "Barry Allen", true);
        ArrayList<Superhero> results = database.getSuperheroArrayList();

        int actualSize = results.size();
        int expectedSize = 1;

        //Assert
        assertEquals(actualSize, expectedSize);

    }

    @Test
    public void createTestData() {
        // Arrange
        Database database = new Database();

        // Act
        database.createTestData();
        ArrayList<Superhero> results = database.getSuperheroArrayList();

        int actualSize = results.size();
        int expectedSize = 1;

        // Assert
        assertEquals(actualSize, expectedSize);


    }

    @Test
    public void searchFor() {
        // Arrange
        Database database = new Database();

        // Act
        database.createTestData();
        ArrayList<Superhero> results = database.searchForMoreHeroes("Batman");

        int actualSize = results.size();
        int expectedSize = 1;

        // Assert
        assertEquals(actualSize, expectedSize);

    }

    @Test
    public void searchForNothing() {
        // Arrange
        Database database = new Database();

        // Act
        database.createTestData();
        ArrayList<Superhero> results = database.searchForMoreHeroes("dadad");

        int actualSize = results.size();
        int expectedSize = 0;

        // Assert
        assertEquals(actualSize, expectedSize);

    }
}


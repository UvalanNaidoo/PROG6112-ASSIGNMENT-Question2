/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assi22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
    

public class Assi22Test {

    private ArrayList<LoadEntry> loadEntries;
    private InputStream originalSystemIn;
    private PrintStream originalSystemOut;

    @BeforeEach
    public void setUp() {
        loadEntries = new ArrayList<>();
        originalSystemIn = System.in;
        originalSystemOut = System.out;
    }

    @Test
    public void testCaptureNewLoad_InvalidQuantityInput() {
        // Redirect standard input to provide invalid quantity input
        String input = "123\nJohn\nProduct1\nInvalidQuantity\nfull\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect standard output to capture printed result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Assi22.captureNewLoad(new Scanner(System.in), loadEntries);

        // Check if no load is added due to invalid quantity
        assertEquals(0, loadEntries.size());

        // Check if the appropriate validation message is printed
        String expectedOutput = "Enter the quantity (ton): Invalid input. Quantity must be a number.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testSearchForLoad_LoadFound() {
        // Create a test load entry
        LoadEntry load = new LoadEntry("123", "John", "Product1", 5.0, "full");
        loadEntries.add(load);

        // Redirect standard input to provide the trip number to search
        String input = "123\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect standard output to capture printed result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Assi22.searchForLoad(new Scanner(System.in), loadEntries);

        // Check if the expected load details are printed
        String expectedOutput = "Load details found:\nTrip Number: 123\nDriver's Name: John\nProduct: Product1\nQuantity (ton): 5.0\nFuel Level: full\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testSearchForLoad_LoadNotFound() {
        // Create a test load entry
        LoadEntry load = new LoadEntry("123", "John", "Product1", 5.0, "full");
        loadEntries.add(load);

        // Redirect standard input to provide a trip number that doesn't exist
        String input = "456\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect standard output to capture printed result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Assi22.searchForLoad(new Scanner(System.in), loadEntries);

        // Check if a message for load not found is printed
        String expectedOutput = "Load with trip number 456 not found.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDeleteLoad_ConfirmDeletion() {
        // Create a test load entry
        LoadEntry load = new LoadEntry("123", "John", "Product1", 5.0, "full");
        loadEntries.add(load);

        // Redirect standard input to confirm load deletion
        String input = "123\nyes\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect standard output to capture printed result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Assi22.deleteLoad(new Scanner(System.in), loadEntries);

        // Check if the load was deleted
        assertEquals(0, loadEntries.size());

        // Check if a deletion success message is printed
        String expectedOutput = "Load deleted successfully.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testDeleteLoad_CancelDeletion() {
        // Create a test load entry
        LoadEntry load = new LoadEntry("123", "John", "Product1", 5.0, "full");
        loadEntries.add(load);

        // Redirect standard input to cancel load deletion
        String input = "123\nno\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirect standard output to capture printed result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Assi22.deleteLoad(new Scanner(System.in), loadEntries);

        // Check if the load is not deleted
        assertEquals(1, loadEntries.size());

        // Check if a cancellation message is printed
        String expectedOutput = "Load not deleted.\n";
        assertEquals(expectedOutput, outContent.toString());
    }

}




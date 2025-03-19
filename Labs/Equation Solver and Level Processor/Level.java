import java.io.*;
import java.util.*;

public class Level {
    private int xSize;
    private int ySize;
    private int[][] size;
    private List<Entry> entries = new ArrayList<>();

    // Constructor
    public Level(String filename) throws IOException { 
        readFile(filename);
    }

    // Read file
    private void readFile(String filename) throws IOException 
    {
        try (Scanner scan = new Scanner(new File(filename))) 
        {
            // Read x and y size
            ySize = scan.nextInt();
            xSize = scan.nextInt();

            // Initialize 2D array
            size = new int[ySize][xSize];

            // Create 2D array
            for (int i = 0; i < ySize; i++) 
            {
                for (int j = 0; j < xSize; j++) 
                {
                    size[i][j] = scan.nextInt();
                }
            }

            // Read number of entries
            int numEntries = scan.nextInt();
            entries = new ArrayList<>();
            
            // Creare a for loop that goes through entries and add into entry
            for (int i = 0; i < numEntries; i++) 
            {
                int x = scan.nextInt();
                int y = scan.nextInt();
                String name = scan.next();
                entries.add(new Entry(x, y, name));
            }
        }
    }

    // Add 1 to every value in the grid
    public void addOne() 
    {
        for (int i = 0; i < ySize; i++) 
        {
            for (int j = 0; j < xSize; j++) 
            {
                size[i][j] += 1;
            }
        }
    }

    // Write to file
    public void writeFile(String fileName) throws IOException 
    {
        try
        {
            // Create printwrite to write into file
            PrintWriter writer = new PrintWriter(new File(fileName));
            writer.println(ySize + " " + xSize);
            
            // Create a for loop to print out numbers
            for (int[] row : size) 
            {
                for (int num : row) 
                {
                    writer.print(num + " ");
                }
                writer.println();
            }

            writer.println(entries.size());
            for (Entry entry : entries) 
            {
                writer.println(entry);
            }
        }
        catch(FileNotFoundException e)
        {
         System.out.println("Cant find file to write in");
        }
    }

    // Create a toString() to print out
    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();

        sb.append(ySize).append(" ").append(xSize).append("\n");
        
        // Create a for loop to print out numbers
        for (int[] row : size) 
        {
            for (int num : row) 
            {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
         
        // Print out the entry size
        sb.append(entries.size()).append("\n");
        for (Entry entry : entries) 
        {
            sb.append(entry).append("\n");
        }
        return sb.toString();
    }
}
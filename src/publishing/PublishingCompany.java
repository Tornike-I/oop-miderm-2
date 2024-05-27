package publishing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PublishingCompany {
    private List<Publication> publications;

    public PublishingCompany() {
        this.publications = new ArrayList<>();
    }

    // Method for adding a publication
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    // Method for removing a publication
    public void removePublication(Publication publication) {
        publications.remove(publication);
    }

    // Saving the state
    public void saveState() {
        //writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Publication publication : publications) {
                writer.write(publication.toString()); //using toString method from publication class
                writer.newLine(); //new line for each publication
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Restoring a state
    public void restoreState() {
        publications.clear(); //we clear existing publications
        //reader
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) { //reading line by line and stopping at the end of the file
                String[] parts = line.split(","); //splitting on commas
                if (parts.length == 3) { //saving each part in a variable
                    String title = parts[0];
                    String author = parts[1];
                    int year = Integer.parseInt(parts[2]); //converting to an int
                    publications.add(new Publication(title, author, year)); //add the new publication
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // access the publications
    public List<Publication> getPublications() {
        return publications;
    }
}


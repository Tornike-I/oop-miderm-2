package publishing;

public class Tester {
    public static void main(String[] args) {
        // Creating a publishing company
        PublishingCompany company = new PublishingCompany();

        // Creating new publications
        Publication p1 = new Publication("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979);
        Publication p2 = new Publication("Python Programming", "Author A", 2021);
        Publication p3 = new Publication("C++ Programming", "Author B", 2019);
        // adding the publications to the company
        company.addPublication(p1);
        company.addPublication(p2);
        company.addPublication(p3);

        // Printing the publications
        System.out.println("Initial Publications:");
        printPublications(company);

        // Remove p2 publication
        company.removePublication(p2);
        System.out.println("\nAfter removing one publication:");
        printPublications(company);

        // save state
        company.saveState();
        System.out.println("\nState saved."); //optional outputs

        // Remove p3 publication
        company.removePublication(p3);
        System.out.println("\nAfter removing one more publication:");
        printPublications(company);

        // restore state
        company.restoreState();
        System.out.println("\nState restored."); //optional outputs

        //p3 will still be there even though we removed it because it was saved and restored
        System.out.println("\nPublications after restoring state:");
        printPublications(company);
    }

    // method for printing the publications to console
    private static void printPublications(PublishingCompany company) {
        for (Publication pub : company.getPublications()) {
            System.out.println(pub.getTitle() + " by " + pub.getAuthor() + " (" + pub.getYear() + ")");
        }
    }
}


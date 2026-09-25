import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class PetTest {
    Scanner sc = new Scanner(System.in);
    public ArrayList<Pets> pets = new ArrayList<>();
    public void loadPets() {
        pets.clear();
        try {
            File file = new File("PetsDetails.txt");
            if (!file.exists()) {
                System.out.println("PetsDetails.txt not found.");
                return;
            }//end of if
            Scanner reader = new Scanner(file);
            //reading the file
            int lineNumber = 0;
            while (reader.hasNextLine()) {
                //creating a thing to hold the string line to sort through
                String line = reader.nextLine();
                lineNumber++;
                if (line == null || line.strip().isEmpty()) continue;
                String[] p = line.split(",");
                //splitting the string line  into words to sort through
                for (int i = 0; i < p.length; i++) {
                    p[i] = p[i].trim();
                }//end of for

                String name = p[0];
                int age = Integer.parseInt(p[1]);
                String type = p[2];

                //applying special vars to the locations
                if (type.equalsIgnoreCase("Cat")) {
                    String breed = p[3];
                    pets.add(new Cat(name, age, breed));
                }//end of if
                else if (type.equalsIgnoreCase("Dog")) {
                    String breed = p[3]; //location 5,special var
                    pets.add(new Dog(name, age, breed));
                }//end of if
                else {
                    String breed = p[3]; //location 5,special var
                    pets.add(new Dog(name, age, breed));
                }
            }//end of while
            //closing the file reader.
            reader.close();
            //catching the exceptions
        }//end of try
        catch (Exception e) {
            System.out.println("No previous animal file found.");
            //catching the exception if animal is not found.
        }//end of catch
    }//end of load Pets

    public void AddPet(Pets a) {
        if (a == null) {
            System.out.print("Can not save Pwts, as it contains null values.");
        }//end of check for nulls
        else {
            System.out.println("Animal values correct, animal saved successfully.");
            pets.add(a);
        }//end of final check
        //adding the animal
    }//end of add animals

    public void savePets() {
        if (pets == null || pets.isEmpty()) {
            System.out.println("No pets to save. File not overwritten.");
            return;
        }//end of checking for nulls or empty
        try (PrintWriter pw = new PrintWriter("PetsDetails.txt")) {
            for (Pets a : pets) {
                pw.println(a);
            }
        } //end of try
        catch (Exception e) {
            System.out.println("Error saving animals.");
        }//end of catch
    }

    public void GetPetsDetail() {
        for (int i = 0; i < pets.size(); i++) {
            Pets a = pets.get(i);
            System.out.println(a.Speak());
        }//end of for
    }
    public void report() {
        ArrayList<String> types = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>();

        //sorting through animals to find the animal name
        for (int i = 0; i < pets.size(); i++) {
            String type = pets.get(i).getClass().getSimpleName();
            int index = -1;

            for (int j = 0; j < types.size(); j++) {
                if (types.get(j).equals(type)) {
                    index = j;
                    break;
                }//end of if
            }//end of for

            if (index == -1) {
                types.add(type);
                counts.add(1);
            }//end if statement
            else {
                counts.set(index, counts.get(index) + 1);
            }//end of else
        }//end of for

        //prints the count for each type of animal.
        for (int i = 0; i < types.size(); i++) {
            System.out.println(types.get(i) + " the count is " + counts.get(i));
        }//end of for
    }//end of report
    public Pets searchByName(String name) {
        for (int i = 0; i < pets.size(); i++) { //sorting by length of arraylist
            Pets a = pets.get(i);
            //attaching animal to a variable
            if (a.GetName().equalsIgnoreCase(name)) {
                return a;   //if its found
            } //end of if
        }//end of for
        System.out.println("Animal not found or null values inputted.");
        return null;
        //if not found
    }//end of search by name


}

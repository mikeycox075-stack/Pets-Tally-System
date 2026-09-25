import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.random.*;

public class Program {
    public static void main(String[] args){
        PetTest pet = new PetTest();
        Scanner sc = new Scanner(System.in);
        String ContinueChoice = sc.nextLine();

            while(true) {
                if (ContinueChoice.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Do you want to continue the program? ");
                System.out.println("Or you can type 'exit' to exit the program");
                ContinueChoice = sc.nextLine();

                for (int i = 0; i < 5; i++) {
                    System.out.println("Want to add a cat or a dog?");
                    String choice = sc.nextLine();
                    System.out.println("What do you want to name your animal?");
                    String name = sc.nextLine();
                    AddPet(pet, sc, name, choice);
                    pet.savePets();
                }
                pet.report();
                pet.GetPetsDetail();
                System.out.println("Do you want to search for an animal? ");
                String choiceTwo = sc.nextLine();
                if (choiceTwo.equalsIgnoreCase("Yes")) {
                    System.out.println("Please enter the pets name you are searching for? ");
                    String SearchName = sc.nextLine();
                    Pets Foundpet = pet.searchByName(SearchName);
                    System.out.println(Foundpet.Speak());
                } else {
                    System.out.println("Search not selected");
                }
            }
        System.out.println("Program exiting");
    }

    public static void AddPet(PetTest pet, Scanner sc, String name, String choice){
        if (choice.equalsIgnoreCase("Dog")){
            int randomNumOne = (int) (Math.random() * (15 - 0 + 1)) + 0;
            int age = randomNumOne;
            String[] breedsDog = {"Labrador","Jack Russel","DashHound","Retriver","Poodle"};
            int randomNumTwo = (int) (Math.random() * (4 - 0 + 1)) + 0;
            String breed =breedsDog[randomNumTwo];
            String type = "Dog";
            pet.AddPet(new Dog(name,age,breed));

        }else {
            int randomNumOne = (int) (Math.random() * (15 - 0 + 1)) + 0;
            int age = randomNumOne;
            String[] breedsCats = {"Ginger", "Tabby", "Rag-Doll", "Siemese", "Calico"};
            int randomNumTwo = (int) (Math.random() * (4 - 0 + 1)) + 0;
            String breed =breedsCats[randomNumTwo];
            String type = "Cat";
            pet.AddPet(new Cat(name,age,breed));

        }//end of else if
    }
}


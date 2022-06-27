package zoo;

import java.util.Scanner;

public class ManageAnimals {
    private Zoo<Animal> zoo; // zoo only contains Monkeys or Chimps
    private Zoo<Bird> birdPark;
    public ManageAnimals() {
        zoo = new Zoo<Animal>();
        birdPark = new Zoo<Bird>();
    }
    public void listAnimals () {
        System.out.println("Zoo: " + zoo);
        System.out.println("Bird Park: " + birdPark);
    }
    public void addAnimal(String specie, String name) { // INCOMPLETE
        switch (specie) {
            // Substitutability in action (2) -
            //	Animal expected, Monkey (or Chimp) provided
            case "Monkey":
                zoo.addAnimal(new Monkey(name));
                return;
            case "Chimp":
                zoo.addAnimal(new Chimp(name));
                return;
            default: birdPark.addAnimal(new Bird(specie, name));
        }
    }
    public static void main(String[] args) {
        ManageAnimals manager = new ManageAnimals();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter species name:");
        String a = "", b = "";
        do{
            a = sc.next();
            if(a.equals("q")) break;
            b = sc.next();
            manager.addAnimal(a,b);
            System.out.println("Species " + a + " with name " + b +" added.");

        }while(!a.equals("q"));
        manager.listAnimals();
    }
}

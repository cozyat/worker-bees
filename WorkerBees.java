import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.lang.InterruptedException;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Thread;

abstract class BeeResources { // Abstract class "BeeResources" by Soham
    protected Scanner sc = new Scanner(System.in);

    public Scanner getScannerObject() {
        return sc;
    }

    public void setScannerObject(Scanner sc) {
        this.sc = sc;
    }

    protected double waterPercentage;
    protected double sanityPercentage;
    protected int foodSecurity;
    protected int buildingMaterials;

    public void setResources(double waterPercentage, double sanityPercentage, int foodSecurity, int buildingMaterials) {
        this.waterPercentage = waterPercentage;
        this.sanityPercentage = sanityPercentage;
        this.foodSecurity = foodSecurity;
        this.buildingMaterials = buildingMaterials;
    }

    public void readResources(String filePath) throws FileNotFoundException {
        Scanner fileReader = new Scanner(new File(filePath));
        setResources(fileReader.nextDouble(), fileReader.nextDouble(), fileReader.nextInt(), fileReader.nextInt());
        fileReader.close();
    }

    public double getWaterPercentage() {
        return waterPercentage;
    }

    public double getSanityPercentage() {
        return sanityPercentage;
    }

    public int getFoodSecurity() {
        return foodSecurity;
    }

    public int getBuildingMaterials() {
        return buildingMaterials;
    }
}

public class WorkerBees extends BeeResources { // Public class "WorkerBees" by Soham && Jason && Aryan

    public static void main(String[] args) throws InputMismatchException, FileNotFoundException, InterruptedException { // Main method "main()" by Aryan
        WorkerBees ClassInstance = new WorkerBees();

        ClassInstance.getPassword();
        ClassInstance.getResources();
        ClassInstance.ScenarioOne();
        ClassInstance.ScenarioTwo();
        // ClassInstance.ScenarioThree();
        // ClassInstance.ScenarioFour();
        // ClassInstance.ScenarioFive();
    }

    public void getPassword() throws InputMismatchException { // Password method "getPassword()" by Jason
        int secretNumber = (int) (Math.random() * 10) + 1;
        int userGuess = 0;

        System.out.println();
        System.out.println();
        System.out.println("Welcome to the Worker Bee Empire!");
        System.out.println("We are the workers of the Empire who devote ourselves for survival.");
        System.out.println();

        while (userGuess != secretNumber) {
            System.out.println();
            System.out.print("Enter your randomized pin to enter (between 1 and 10): ");
            userGuess = sc.nextInt();
            sc.nextLine();

            if (userGuess == secretNumber) {
                System.out.println();
                System.out.println("Welcome Back!");
            } else {

                if (userGuess < secretNumber) {
                    System.out.println();
                    System.out.println("Try again, Your pin is higher.");
                } else {
                    System.out.println();
                    System.out.println("Try again, Your pin is lower.");
                }
            }
        }
    }

    public void getResources() throws FileNotFoundException, InterruptedException { // Resources method "getResources()" by Aryan
        readResources("/Users/sohampanda/Desktop/Programming/APCSA/BeeResources.dat");
        Thread.sleep(700);

        System.out.println();
        System.out.println();
        System.out.println("THESE ARE YOUR RESOURCES: ");
        System.out.println("Water: " + waterPercentage + "%");
        System.out.println("Sanity: " + sanityPercentage + "%");
        System.out.println("Food Security: Level " + foodSecurity);
        System.out.println("Building Materials: " + buildingMaterials + " items");

        Thread.sleep(3000);

        System.out.println();
        System.out.println();
        System.out.println("SYNOPSIS OF YOUR SITUATION:");
        System.out.print("As a Worker Bee in this complex world,");
        System.out.println(" you find yourself amidst the toiling masses, fueling the robotic regime's infrastructure.");
        System.out.print("The decision rests in your hands as the post-apocalyptic saga unfolds with the");
        System.out.print(" Robot Overlords’s dictatorship over anti-autonomy and AI generation.");

    }

    public void ScenarioOne() throws InputMismatchException, InterruptedException { // Secnario 1 method "ScenarioOne()" by Soham
        Thread.sleep(3000);

        String questionOneResult = "";

        System.out.println();
        System.out.println();
        System.out.println("DAY ONE:");
        System.out.print("As you get up on your first day of living in the WBC (Worker Bees Corporation),");
        System.out.println(" you realize that you are low on water.");
        System.out.println("How can you get some water EFFICIENTLY?");

        Thread.sleep(1700);

        System.out.println();
        System.out.println("A: Get to the nearby water reserve");
        System.out.println("B: Search for water in your home's kitchen");
        System.out.println("C: Drink water from the sink (tap water)");
        System.out.println("D: Don't drink any water and move on");

        Thread.sleep(500);

        System.out.println();
        System.out.print("Your choice: ");
        questionOneResult = sc.nextLine().toUpperCase();
    
        Thread.sleep(500);

        if (questionOneResult.equals("A")) {
            waterPercentage -= 15.00;
            sanityPercentage -= 20.00;
            System.out.println();
            System.out.println("You were attacked by The Rebellion at the reserve, 5 other WBC workers were KIA when this happened.");
            System.out.println("You lost 15% of your water and 20% of your sanity!");
        } else if (questionOneResult.equals("B")) {
            waterPercentage += 40.00;
            System.out.println();
            System.out.println("You found a stash of water bottles in your kitchen. Good job!");
            System.out.println("You gained 40% of water from drinking!");
        } else if (questionOneResult.equals("C")) {
            waterPercentage -= 5.00;
            waterPercentage += 25.00;
            System.out.println();
            System.out.println("You drank water from the sink. It replenished your water, but be cautious about the source!");
            System.out.println("You lost 5% of your water due to the dirtiness of the water.");
            System.out.println("You gained 25% of water from drinking!");
        } else if (questionOneResult.equals("D")) {
            waterPercentage -= 20.00;
            System.out.println();
            System.out.println("Since you chose the poor choice of NOT drinking water, you go thirsty for the whole morning!");
            System.out.println("You lost 20% due to your missing quench of thirst!");
        }

        Thread.sleep(800);

        System.out.println();
        System.out.println("Current water percentage: " + Math.round(waterPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current sanity percentage: " + Math.round(sanityPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current food security level: " + "Level: " + foodSecurity);
        System.out.println("Current amount of building materials: " + buildingMaterials + " items.");
        System.out.println();
        System.out.println();
    }

    /*
     * FOR SCENARIO TWO, FINISH THE REST AND REPLACE AND S1 THINGS [LINES 193-253]
     */

    public void ScenarioTwo() throws InputMismatchException, InterruptedException { // Secnario 2 method "ScenarioOne()" by Jason
        Thread.sleep(3000);

        String questionTwoResult = "";

        System.out.println("DAY TWO:");
        System.out.print("As you get up on your first day of living in the WBC (Worker Bees Corporation),");
        System.out.println(" you realize that you are low on water.");
        System.out.println("How can you get some water EFFICIENTLY?");

        Thread.sleep(1700);

        System.out.println();
        System.out.println("A: Get to the nearby water reserve");
        System.out.println("B: Search for water in your home's kitchen");
        System.out.println("C: Drink water from the sink (tap water)");
        System.out.println("D: Don't drink any water and move on");

        Thread.sleep(500);

        System.out.println();
        System.out.print("Your choice: ");
        questionTwoResult = sc.nextLine().toUpperCase();
    
        Thread.sleep(500);

        if (questionTwoResult.equals("A")) {
            waterPercentage -= 15.00;
            sanityPercentage -= 20.00;
            System.out.println();
            System.out.println("You were attacked by The Rebellion at the reserve, 5 other WBC workers were KIA when this happened.");
            System.out.println("You lost 15% of your water and 20% of your sanity!");
        } else if (questionTwoResult.equals("B")) {
            waterPercentage += 40.00;
            System.out.println();
            System.out.println("You found a stash of water bottles in your kitchen. Good job!");
            System.out.println("You gained 40% of water from drinking!");
        } else if (questionTwoResult.equals("C")) {
            waterPercentage -= 5.00;
            waterPercentage += 25.00;
            System.out.println();
            System.out.println("You drank water from the sink. It replenished your water, but be cautious about the source!");
            System.out.println("You lost 5% of your water due to the dirtiness of the water.");
            System.out.println("You gained 25% of water from drinking!");
        } else if (questionTwoResult.equals("D")) {
            waterPercentage -= 20.00;
            System.out.println();
            System.out.println("Since you chose the poor choice of NOT drinking water, you go thirsty for the whole morning!");
            System.out.println("You lost 20% due to your missing quench of thirst!");
        }

        Thread.sleep(800);

        System.out.println();
        System.out.println("Current water percentage: " + Math.round(waterPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current sanity percentage: " + Math.round(sanityPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current food security level: " + "Level: " + foodSecurity);
        System.out.println("Current amount of building materials: " + buildingMaterials + " items.");
        System.out.println();
        System.out.println();
    }

}
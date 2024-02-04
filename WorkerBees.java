/*
 * WORKER BEES HACKATHON
 * By Soham Panda, Aryan Anand, and Jason Carrasco
 * 3rd Period - A Day, AP Computer Science A
 * This class simulates the improvement process of a normal Worker Bee in the dystopian world of the Robot Overlords.
 * Users will be shown choices to choose from in order to keep their Worker Bee healthy, safe, and thriving.
 */
 
/*
 * NOTES:
 * Please be sure to replace the file path in the "getResources()" method with your own path aligned with BeeResources.dat!
 * "Thread.sleep()" and "System.exit(0) were used to pause and terminate the program at mandatory times."
 * All methods, classes, objects, variables, reference variables, and datatypes have been camel cased. [Ex: camelCase]
 * This java file is over 700 lines. 5 methods are boilerplated (repeated code with different "System.out.print" text) repeatedly.
 * All principles of object oriented programming were covered in this singular file: Abstraction, Ecnapsulation, Polymorphism, and Inheritance.
 */

/* 
 * IMPORTS:
 * These are the required libraries needed to import to the WorkerBees class.
 * java.io.File - This is used to read files.
 * java.io.FileNotFoundException - This is used to throw file reader errors from file reader object.
 * java.util.InputMismatchException - This is used to throw input errors from scanner object.
 * java.lang.InterruptedException - This is used to throw program pausing errors.
 * java.util.Scanner - This is used to get user input.
 * java.lang.Math - This is used for using math functions such as rounding and randomization.
 * java.lang.Thread - This is used for pausing the program.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.lang.InterruptedException;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Thread;

/*
 * ABSTRACT CLASS BeeResources:
 * This class is used to set and get variables, objects, references, etc. for the program.
 * Doing this will be easier for methods to access any data or item in this file instead of returning.
 * This class is abstracted in order to not reveal any implementation methods to the user.
 * All reference variables are encapsulated and are set as protected in order to prevent a resource leak which an exception can't handle.
 * The "this." is to refer back to the variables as the object under the setter method "setResources()".
 * All other variables are getter methods and readers which get objects for cross-method usability.
 * Finally, they are returned for use. [Please note that they are not supposed to be "final" because these will be changed depending on user input]
 */

abstract class BeeResources { // This was written by Soham.
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

/*
 * PUBLIC CLASS WorkerBees:
 * This class which defines this file is the main class that procceses inputs from the user and produces outputs to the user through logic and conditioning.
 * In order to use objects and variables, otherwise known as the resources for WorkerBees.java, we inherit abstract class BeeResources through an extension to public class WorkerBees.
 * Since our abstract class methods were not defined as static, it was exceptionally important to write instances for the WorkerBees Class in order to avoid an error of non-static presence.
 * The "getPassword()" method requires a simple, randomized PIN from the user. We use a while loop to loop through till the user has found the pin after a certain trial of tries of PIN codes.
 * The "getResources()" method uses the file reader object to the maximum. We gathered the data from the BeeResources.dat file in order to extract them into our 4 objects.
 * A scenario is given to the user for them to be informed and to know what the program is about.
 * The following methods: "ScenarioOne() {all the way through} SecnarioFive()" are five methods that used to ask questions to the user. Read the following for more elaboration.
 * Since these are boilerplate methods written from the "ScenarioOne()" method, it was simple to replace questions and answers with different things in order to increase variability.
 * For example, take any scenario method. This method will first give a situation that the user will face as a worker bee. They will need to answer the following question acoordingly.
 * Once answered, they will have percentages, integers, or points gaied or taken away depending on the answer choice they have chosen.
 * If any one of the objects reach 0% or go below that percentage level, the program will exit and tell the user that they have not saved their worker bee.
 * Boolean operations were used to determine when this percentage and when the end result (discussed in next line) is met including conditionals like "if/else/else if" and logical operators such as "||", "&&".
 * Finally, the last method "finalResult()" gives a result to the user if they have gone through all 5 scenario methods without getting a negative/zero percentage.
 * They will recieve either a bronze, silver, or a gold badge determining how high their percentages and levels are for their Worker Bee.
 */

public class WorkerBees extends BeeResources { // This was written by Soham, Aryan, and Jason.

    /**
     * These comments are error exceptions to be thrown when reading files, passing inputs, and program terminations.
     * @throws InputMismatchException
     * @throws FileNotFoundException
     * @throws InterruptedException
     * @param args
     */

    public static void main(String[] args) throws InputMismatchException, FileNotFoundException, InterruptedException { // This was written by Aryan.
        WorkerBees ClassInstance = new WorkerBees();

        ClassInstance.getPassword();
        ClassInstance.getResources();
        ClassInstance.ScenarioOne();
        ClassInstance.ScenarioTwo();
        ClassInstance.ScenarioThree();
        ClassInstance.ScenarioFour();
        ClassInstance.ScenarioFive();
        ClassInstance.finalResult();
    }

    public void getPassword() throws InputMismatchException { // This was written by Jason.
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

    public void getResources() throws FileNotFoundException, InterruptedException { // This was written by Aryan.
        // NOTE: You will need to replace this file path with your own path aligned with BeeResources.dat!
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
        System.out
                .println(" you find yourself amidst the toiling masses, fueling the robotic regime's infrastructure.");
        System.out.print("The decision rests in your hands as the post-apocalyptic saga unfolds with the");
        System.out.print(" Robot Overlords’s dictatorship over anti-autonomy and AI generation.");

    }

    public void ScenarioOne() throws InputMismatchException, InterruptedException { // This was written by Jason.
        Thread.sleep(3000);

        String questionOneResult = "";

        System.out.println();
        System.out.println();
        System.out.println("TASK ONE:");
        System.out.print("As you get up on your first day of living in the WBC (Worker Bees Corporation),");
        System.out.println(" you realize that you are low on water.");
        Thread.sleep(1000);
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
            System.out.println(
                    "You were attacked by The Rebellion at the reserve, 5 other WBC workers were KIA when this happened.");
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
            System.out.println(
                    "You drank water from the sink. It replenished your water, but be cautious about the source!");
            System.out.println("You lost 5% of your water due to the dirtiness of the water.");
            System.out.println("You gained 25% of water from drinking!");
        } else if (questionOneResult.equals("D")) {
            waterPercentage -= 20.00;
            System.out.println();
            System.out.println(
                    "Since you chose the poor choice of NOT drinking water, you go thirsty for the whole morning!");
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

        if (waterPercentage == 0.00 || waterPercentage < 0.00) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "You have no more water left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (sanityPercentage == 0.00 || sanityPercentage < 0.00) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "You have no more sanity left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (foodSecurity == 0 || foodSecurity < 0) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "The security of your consumables are too endangered! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (buildingMaterials == 0 || buildingMaterials < 0) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "You have no more materials to build for your shelter! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        }
    }

    public void ScenarioTwo() throws InputMismatchException, InterruptedException { // This was written by Soham.
        Thread.sleep(3000);

        String questionTwoResult = "";

        System.out.println("TASK TWO:");
        System.out.println("After your water problem, you now face the issue of a hearty breakfast!");
        Thread.sleep(1400);
        System.out.println("Pick a place to eat, but be careful as one or more of them could affect your food security!");
        Thread.sleep(1400);
        System.out.println("How can you get some food for breakfast SECURELY?");

        Thread.sleep(1700);

        System.out.println();
        System.out.println("A: Search for food in your home's kitchen and cook");
        System.out.println("B: Go to the nearby bagel shop");
        System.out.println("C: Drink a quick microwave coffee");
        System.out.println("D: Ask your very friendly neighbor for some bread and jam!");

        Thread.sleep(500);

        System.out.println();
        System.out.print("Your choice: ");
        questionTwoResult = sc.nextLine().toUpperCase();

        Thread.sleep(500);

        if (questionTwoResult.equals("A")) {
            foodSecurity -= 1;
            foodSecurity += 5;
            System.out.println();
            System.out.println("You tried to find bread and jam but couldn't find any, so I guess it was cereal and milk for today for you.");
            System.out.println("You gained 5 levels of food security!");
            System.out.println("You lost 1 level of food security!");
        } else if (questionTwoResult.equals("B")) {
            foodSecurity -= 2;
            foodSecurity += 6;
            sanityPercentage -= 9.00;
            System.out.println();
            System.out.println("You went and enjoyed a great bagel with cream cheese! However, the waiter was a prick to you and the bagel tasted quite funny.");
            System.out.println("You gained 6 levels of food security!");
            System.out.println("You lost 2 levels of food security!");
            System.out.println("You lost 9% of your sanity!");
        } else if (questionTwoResult.equals("C")) {
            foodSecurity -= 1;
            foodSecurity += 3;
            sanityPercentage += 30.00;
            System.out.println();
            System.out.println("You drank a cup of coffee full of energy, but not a wise choice since this is not an actual breakfast.");
            System.out.println("You gained 3 levels of food security!");
            System.out.println("You lost 1 level of food security!");
            System.out.println("You gained 30% of sanity!");
        } else if (questionTwoResult.equals("D")) {
            sanityPercentage -= 90.00;
            System.out.println();
            System.out.println("Oh no!! You got beaten up by your quote on quote \"friendly\" neighbor since you apparently annoyed him about bread and jam.");
            System.out.println("You lost 90% of your sanity!");
        }

        Thread.sleep(800);

        System.out.println();
        System.out.println("Current water percentage: " + Math.round(waterPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current sanity percentage: " + Math.round(sanityPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current food security level: " + "Level: " + foodSecurity);
        System.out.println("Current amount of building materials: " + buildingMaterials + " items.");
        System.out.println();
        System.out.println();

        if (waterPercentage == 0.00 || waterPercentage < 0.00) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more water left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (sanityPercentage == 0.00 || sanityPercentage < 0.00) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more sanity left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (foodSecurity == 0 || foodSecurity < 0) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("The security of your consumables are too endangered! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (buildingMaterials == 0 || buildingMaterials < 0) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more materials to build for your shelter! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        }
    }

    public void ScenarioThree() throws InputMismatchException, InterruptedException { // This was written by Soham.
        Thread.sleep(3000);

        String questionThreeResult = "";

        System.out.println("TASK THREE:");
        System.out.println("Time to go to work now! You job is to place cinder blocks for construction and log them into a system for your manager.");
        Thread.sleep(2000);
        System.out.println("All seems well but as you step into the construction site, your manager (the boss) stops you to talk personally...");
        Thread.sleep(2000);
        System.out.println("It seems that you have been taking an unnoticed leave for a couple of days in the past few months and the boss is very angry about this.");
        Thread.sleep(2000);
        System.out.println("You must explain yourself in order to avoid any punishment for this, lie if you need too as well but at your own discretion!");
        Thread.sleep(2000);
        System.out.println("How would you be able to convince or lie to the boss that you have a PROPER excuse for your unnoticed leaves?");

        Thread.sleep(1700);

        System.out.println();
        System.out.println("A: Lie about your sick dog and how you needed to take care of him");
        System.out.println("B: Give up and tell the truth: you went on a cross-country trip with your friends");
        System.out.println("C: Lie about going on a leave to go take care of your wife who is currently in labor");
        System.out.println("D: Lie about how you needed to leave to visit your relatives.");

        Thread.sleep(500);

        System.out.println();
        System.out.print("Your choice: ");
        questionThreeResult = sc.nextLine().toUpperCase();

        Thread.sleep(500);

        if (questionThreeResult.equals("A")) {
            sanityPercentage -= 5.00;
            System.out.println();
            System.out.println("You chose to lie! This had worked out and you got out of the situation safely.");
            System.out.println("You lost 5% of your sanity!");
        } else if (questionThreeResult.equals("B")) {
            sanityPercentage += 35.00;
            sanityPercentage -= 10.00;
            buildingMaterials -= 455;
            System.out.println();
            System.out.println("You decided to tell the truth. This had somewhat worked out and your boss appreciates your honesty but gave a mild punishment for your leave.");
            System.out.println("You gained 35% of sanity");
            System.out.println("You lost 10% of your sanity");
            System.out.println("You lost 455 building materials!");
        } else if (questionThreeResult.equals("C")) {
            sanityPercentage -= 25.00;
            buildingMaterials -= 1681;
            System.out.println();
            System.out.println("You chose to lie! This went horribly wrong and your boss gave a harsh punishment.");
            System.out.println("You lost 25% of your sanity");
            System.out.println("You lost 1681 building materials!");
        } else if (questionThreeResult.equals("D")) {
            sanityPercentage -= 7;
            System.out.println();
            System.out.println("You chose to lie! This had worked out and you got out of the situation safely. Since you included relatives in your lie, you lost a bit more sanity than lying about a fake dog's sickness.");
            System.out.println("You lost 7% of your sanity!");
        }

        Thread.sleep(800);

        System.out.println();
        System.out.println("Current water percentage: " + Math.round(waterPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current sanity percentage: " + Math.round(sanityPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current food security level: " + "Level: " + foodSecurity);
        System.out.println("Current amount of building materials: " + buildingMaterials + " items.");
        System.out.println();
        System.out.println();

        if (waterPercentage == 0.00 || waterPercentage < 0.00) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more water left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (sanityPercentage == 0.00 || sanityPercentage < 0.00) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more sanity left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (foodSecurity == 0 || foodSecurity < 0) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("The security of your consumables are too endangered! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (buildingMaterials == 0 || buildingMaterials < 0) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more materials to build for your shelter! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        }
    }

    public void ScenarioFour() throws InputMismatchException, InterruptedException { // This was written by Aryan.
        Thread.sleep(3000);

        String questionFourResult = "";

        System.out.println("TASK FOUR:");
        System.out.println("After the crazy interaction with your boss, you must go into work before causing any more troubles.");
        Thread.sleep(2000);
        System.out.println("After a couple of hours have passed, you head out for lunch but you notice your co-worker working overtime placing heavier cinder blocks.");
        Thread.sleep(2000);
        System.out.println("He calls you out to go and help him with the blocks since only one person can't do the job.");
        Thread.sleep(2000);
        System.out.println("What would be the most LOGICAL way to approach this?");

        Thread.sleep(1700);

        System.out.println();
        System.out.println("A: Ignore him and go eat lunch");
        System.out.println("B: Help him but for half of the time both of you have for lunch");
        System.out.println("C: Help him but for all of time both of you have for lunch");
        System.out.println("D: Cuss at him because he purposefully ate your strawberry yogurt from yesterday's lunchtime");

        Thread.sleep(500);

        System.out.println();
        System.out.print("Your choice: ");
        questionFourResult = sc.nextLine().toUpperCase();

        Thread.sleep(500);

        if (questionFourResult.equals("A")) {
            sanityPercentage -= 40.00;
            waterPercentage += 20.00;
            foodSecurity += 6;
            System.out.println();
            System.out.println("You ignored him and enjoyed a hearty lunch, but he reported you for avoidance of conduct and you are in trouble now.");
            System.out.println("You gained 6 levels of food security!");
            System.out.println("You gained 20% of water and lost 40% of your sanity!");
        } else if (questionFourResult.equals("B")) {
            foodSecurity += 6;
            waterPercentage += 20.00;
            sanityPercentage -= 7.00;
            sanityPercentage += 34.00;
            System.out.println();
            System.out.println("You helped him but both of you finished 75% of the work. However, both of you were able to eat a good lunch which made you more happier to do so.");
            System.out.println("You gained 6 levels of food security!");
            System.out.println("You gained 20% of water!");
            System.out.println("You lost 7% of your sanity and gained 34% back!");
        } else if (questionFourResult.equals("C")) {
            foodSecurity -= 7;
            waterPercentage -= 10.00;
            sanityPercentage += 30.00;
            sanityPercentage -= 40.00;
            System.out.println();
            System.out.println("You helped him but skipped lunch. Despite not eating, you felt extremely generous by helping your co-worker.");
            System.out.println("You lost 10% of water!");
            System.out.println("You lost 7 levels of food security!");
            System.out.println("You lost 20% of your sanity and gained 40% back!");
        } else if (questionFourResult.equals("D")) {
            sanityPercentage -= 100.00;
            System.out.println();
            System.out.println("You cussed at your co-worker and forgot about that fact that he goes under serious anger management. Then, he picked up a hammer and beat you to the death before other co-workers came to stop him.");
            System.out.println("You lost 100% of your sanity and DIED!");
            System.exit(0);
        }

        Thread.sleep(800);

        System.out.println();
        System.out.println("Current water percentage: " + Math.round(waterPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current sanity percentage: " + Math.round(sanityPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current food security level: " + "Level: " + foodSecurity);
        System.out.println("Current amount of building materials: " + buildingMaterials + " items.");
        System.out.println();
        System.out.println();

        if (waterPercentage == 0.00 || waterPercentage < 0.00) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more water left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (sanityPercentage == 0.00 || sanityPercentage < 0.00) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more sanity left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (foodSecurity == 0 || foodSecurity < 0) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("The security of your consumables are too endangered! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (buildingMaterials == 0 || buildingMaterials < 0) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more materials to build for your shelter! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        }
    }

    public void ScenarioFive() throws InputMismatchException, InterruptedException { // This was written by Jason.
        Thread.sleep(3000);

        String questionFourResult = "";

        System.out.println("TASK FIVE:");
        System.out.println("Time to go home! You head home by walk listening to your favorite song in your headphones. It is currently 11:32 PM.");
        Thread.sleep(3000);
        System.out.println("In the distance near a lampost, you see a group of suspicious individuals walking quite fast towards you.");
        Thread.sleep(3000);
        System.out.println("You slowly pull out your earbuds in confusion and start to slowly realize that you are about to be jumped!");
        Thread.sleep(3000);
        System.out.println("You throw your headphones in your pocket, pause your music, put your hoodie up, and start running.");
        Thread.sleep(3000);
        System.out.println("You then look back to see that the group is now chasing you at a fast pace and you try to run even faster.");
        Thread.sleep(3000);
        System.out.println("You then reach an dark alleyway where there is a dead end but a light at one of the walls.");
        Thread.sleep(3000);
        System.out.println("The group pulls up foward to you by giving you a hard punch to the face and you fall flat on the cold concrete underneath the light.");
        Thread.sleep(3000);
        System.out.println("You slowly get up asking them to not hurt you and then suddenly...");
        Thread.sleep(3000);
        System.out.println("The group of people take off their hoodies and show a symbol on their arm, a tattoo that is the sign of the infamous Rebellion!");
        Thread.sleep(3000);
        System.out.println("You realize you must fight or run, what would be the BEST thing to do in order to be safe?");

        Thread.sleep(2500);

        System.out.println();
        System.out.println("A: Land a hard punch to the first person and slowly take down everyone else");
        System.out.println("B: Yell out for help");
        System.out.println("C: Run away by squeezing through the people and distracting them");
        System.out.println("D: Accept your fate");

        Thread.sleep(500);

        System.out.println();
        System.out.print("Your choice: ");
        questionFourResult = sc.nextLine().toUpperCase();

        Thread.sleep(500);

        if (questionFourResult.equals("A")) {
            sanityPercentage -= 20.00;
            System.out.println();
            System.out.println("You beat up 3 out of 5 Rebels but got slightly injured by the other 2. You run away and escape after.");
            System.out.println("You lost 20% of your sanity!");
        } else if (questionFourResult.equals("B")) {
            sanityPercentage -= 100.00;
            System.out.println();
            System.out.println("Bad idea, no one was there to save you and therefore you died from the immense beating.");
            System.out.println("You lost 100% of your sanity and DIED!");
            System.exit(0);
        } else if (questionFourResult.equals("C")) {
            sanityPercentage -= 10.00;
            sanityPercentage += 45.00;
            System.out.println();
            System.out.println("You successfully ran away without getting injured or injuring others.");
            System.out.println("You gained 45% of your sanity sand lost 10% of your sanity!");
        } else if (questionFourResult.equals("D")) {
            sanityPercentage -= 100.00;
            System.out.println();
            System.out.println("Well, what would you expect by accepting your fate? The rest speaks for itself...");
            System.out.println("You lost 100% of your sanity and DIED!");
            System.exit(0);
        }

        Thread.sleep(800);

        System.out.println();
        System.out.println("Current water percentage: " + Math.round(waterPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current sanity percentage: " + Math.round(sanityPercentage * 100.0) / 100.0 + "%");
        System.out.println("Current food security level: " + "Level: " + foodSecurity);
        System.out.println("Current amount of building materials: " + buildingMaterials + " items.");
        System.out.println();
        System.out.println();

        if (waterPercentage == 0.00 || waterPercentage < 0.00) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more water left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (sanityPercentage == 0.00 || sanityPercentage < 0.00) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more sanity left! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (foodSecurity == 0 || foodSecurity < 0) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("The security of your consumables are too endangered! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        } else if (buildingMaterials == 0 || buildingMaterials < 0) {
            System.out.println();
            System.out.println();
            Thread.sleep(800);
            System.out.println("You have no more materials to build for your shelter! Consquently, you died and killed another poor Worker Bee...");
            System.exit(0);
        }
    }

    public final void finalResult() throws InterruptedException { // This was written by Soham.
        Thread.sleep(3000);

        System.out.println("If you had made it through all 5 scenarios, congratulations on keeping your Worker Bee safe and healthy!");
        System.out.println("Here were your results.");
        System.out.println();

        Thread.sleep(1500);

        String goldResult = "GOLD";
        String silverResult = "SILVER";
        String bronzeResult = "BRONZE";

        if (waterPercentage >= 50.00 || sanityPercentage >= 60.00) {
            if (foodSecurity >= 5 && buildingMaterials >= 950) {
                System.out.println("You won a " + goldResult + "." + " Great job!");
            } else {
                System.out.println("You won a " + silverResult + "." + " Great job!");
            }
        } else if (waterPercentage <= 50.00 || sanityPercentage <= 60.00) {
            System.out.println("You won a " + silverResult + "." + " Great job!");
        } else {
            System.out.println("You won a " + bronzeResult + "." + " Great job!");
        }
    }
}
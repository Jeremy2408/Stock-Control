
/**
Jeremy Odor
C21302913

This will be the Driver Class that will carry out the main functions of the assignment
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class SystemDriver
{
    // Declare the arrayList*/
    ArrayList<Appliance> appliances;

    public SystemDriver () {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        // Create a blank Appliance ArrayList
        appliances = new ArrayList<Appliance>();

        if (readFromFile())
        {
            System.out.println("System is populated with items");
        }
        else
        {
            System.out.println("There are no items in this system");
        }

        systemMenu();

        saveToFile();

    }

    public void saveToFile()
    {
        ObjectOutputStream fileOut;
        try{
            fileOut = new ObjectOutputStream(new FileOutputStream("items.dat"));
            for (Appliance anAppliance : appliances)
            {
                fileOut.writeObject(anAppliance);
            }
            fileOut.close();
            System.out.println("All items have been saved");
        }
        catch (IOException e)
        {
            System.out.println("IO Error : " + e.getMessage());
        }
    }//end saveToFile

    public boolean readFromFile()
    {
        int index=0;
        ObjectInputStream fileIn;
        Appliance a;

        try{
            fileIn = new ObjectInputStream(new FileInputStream("students.dat"));
            System.out.println("Opened file successfully");
            a = (Appliance) fileIn.readObject();
            index = 1;
            while (a != null)
            {
                appliances.add(a);
                a = (Appliance) fileIn.readObject();
                index++;
            }
            fileIn.close();
            return true;
        }
        catch (IOException e)
        {
            if (index > 0) 
            {
                return true; 
            }
            else 
            { System.out.println("Data file does not exist\n");
                return false;
            }
        }

        catch (ClassNotFoundException e)
        {
            System.out.println("Class Error : " + e.getMessage());
            return false;
        }
    }//end saveToFile

    public void createDryer()
    {
        Scanner scan = new Scanner(System.in);
        Appliance anAppliance;
        //Appliance Variables
        String name= " ";
        int stockLevel=0;
        double price=0;
        String energyRating= " ";
        int warranty=0;
        String fitType= " ";
        //Dryer Variables
        String dryerType= " ";
        int dryCapacity=0;

        System.out.println("Enter Dryer Name :\n");
        name = scan.nextLine();
        System.out.println("Enter Dryer Stock Level :\n");
        stockLevel = scan.nextInt();
        System.out.println("Enter Dryer Price :\n");
        price = scan.nextDouble();
        scan.nextLine();
        do
        {
            System.out.println("Enter Dryer Energy Rating :\n");
            energyRating = scan.nextLine();
            if(!energyRating.equals("A") && !energyRating.equals("B") && !energyRating.equals("C")
            && !energyRating.equals("D") && !energyRating.equals("E") && !energyRating.equals("F") && !energyRating.equals("G"))
            {
                System.out.println("Invalid Energy Rating");
            }
        }while(!energyRating.equals("A") && !energyRating.equals("B") && !energyRating.equals("C")
        && !energyRating.equals("D") && !energyRating.equals("E") && !energyRating.equals("F") && !energyRating.equals("G"));

        System.out.println("Enter Dryer Warranty :\n");
        warranty = scan.nextInt();
        scan.nextLine();
        do
        {
            System.out.println("Integrated or Freestanding :\n");
            fitType = scan.nextLine();
            if(!fitType.equalsIgnoreCase("Integrated") && !fitType.equalsIgnoreCase("Freestanding"))
            {
                System.out.println("Error-Dryer must be either integrated or freestanding");
            }
        }while(!fitType.equalsIgnoreCase("Integrated") && !fitType.equalsIgnoreCase("Freestanding"));

        do{
            System.out.println("Enter Dryer Type :\n");
            dryerType = scan.nextLine();
            if(!dryerType.equalsIgnoreCase("Gas") && !dryerType.equalsIgnoreCase("Vented") && !dryerType.equalsIgnoreCase("Condenser")
            && !dryerType.equalsIgnoreCase("Heat Pump"))
            {
                System.out.println("Error-Invalid Dryer Type"); 
            }
        }while(!dryerType.equalsIgnoreCase("Gas") && !dryerType.equalsIgnoreCase("Vented") && !dryerType.equalsIgnoreCase("Condenser")
        && !dryerType.equalsIgnoreCase("Heat Pump"));
        System.out.println("Enter Dryer Capacity :\n");
        dryCapacity = scan.nextInt();
        //Creates a Dryer object
        anAppliance = new Dryer(name,stockLevel,price,energyRating,
            warranty,fitType,dryerType,dryCapacity,0);
        //Adds the Dryer to the ArrayList
        appliances.add(anAppliance);
    }

    public void createCooker()
    {
        Scanner scan = new Scanner(System.in);
        Appliance anAppliance;
        //Appliance Variables
        String name= " ";
        int stockLevel=0;
        double price=0;
        String energyRating= " ";
        int warranty=0;
        String fitType= " ";
        //Cooker Variables
        String fuelType= " ";
        String ovenType= " ";

        System.out.println("Enter Cooker Name :\n");
        name = scan.nextLine();
        System.out.println("Enter Cooker Stock Level :\n");
        stockLevel = scan.nextInt();
        System.out.println("Enter Cooker Price :\n");
        price = scan.nextDouble();
        scan.nextLine();
        do{
            System.out.println("Enter Cooker Energy Rating :\n");
            energyRating = scan.nextLine();
            if(!energyRating.equals("A") && !energyRating.equals("B") && !energyRating.equals("C")
            && !energyRating.equals("D") && !energyRating.equals("E") && !energyRating.equals("F") && !energyRating.equals("G"))
            {
                System.out.println("Error-Invalid Energy Rating");
            }
        }while(!energyRating.equals("A") && !energyRating.equals("B") && !energyRating.equals("C")
        && !energyRating.equals("D") && !energyRating.equals("E") && !energyRating.equals("F") && !energyRating.equals("G"));
        System.out.println("Enter Cooker Warranty :\n");
        warranty = scan.nextInt();
        scan.nextLine();
        do
        {
            System.out.println("Integrated or Freestanding :\n");
            fitType = scan.nextLine();
            if(!fitType.equalsIgnoreCase("Integrated") && !fitType.equalsIgnoreCase("Freestanding"))
            {
                System.out.println("Error-Dryer must be either integrated or freestanding");
            }
        }while(!fitType.equalsIgnoreCase("Integrated") && !fitType.equalsIgnoreCase("Freestanding"));
        do
        {
            System.out.println("Enter Cooker Fuel Type:\n");
            fuelType = scan.nextLine();
            if(!fuelType.equalsIgnoreCase("Electric") && !fuelType.equalsIgnoreCase("Gas")
            && !fuelType.equalsIgnoreCase("Dual Fuel"))
            {
                System.out.println("Error-Invalid Fuel Type");
            }
        }while(!fuelType.equalsIgnoreCase("Electric") && !fuelType.equalsIgnoreCase("Gas")
        && !fuelType.equalsIgnoreCase("Dual Fuel"));
        do
        {
            System.out.println("Single or Double Oven :\n");
            ovenType = scan.nextLine();
            if(!ovenType.equalsIgnoreCase("Single") && !ovenType.equalsIgnoreCase("Double"))
            {
                System.out.println("Error-Cooker can only contain a single or double oven"); 
            }
        }while(!ovenType.equalsIgnoreCase("Single") && !ovenType.equalsIgnoreCase("Double"));
        //Creates a Cooker object
        anAppliance = new Cooker(name,stockLevel,price,energyRating,
            warranty,fitType,fuelType,ovenType,0);
        //Adds the Dryer to the ArrayList
        appliances.add(anAppliance);

    }

    public void systemMenu()
    {
        Scanner scan = new Scanner(System.in);
        int menuOption;
        do {
            scan.nextLine();
            System.out.print("\f");
            System.out.print("Kitchen Appliance Stock Control System\n\n");
            System.out.println("1. Customer Menu");
            System.out.println("2. Staff Menu");
            System.out.println("3. Exit System");

            System.out.print("Which option would you like to proceed with?: ");
            menuOption = scan.nextInt();
            scan.nextLine();

            if (menuOption ==1)
            {
                customerMenu();
            }
            else if (menuOption ==2)
            {
                staffMenu();
            }

        }while (menuOption !=3);
        scan.nextLine();

    }

    public void customerMenu()
    {
        Scanner scan = new Scanner(System.in);
        int menuOption;

        System.out.print("\f");
        System.out.print("Customer Menu\n\n");
        System.out.println("1. Display appliances for sale");
        System.out.println("2. Buy one or more appliances");
        System.out.println("3. Exit Customer Menu");

        System.out.print("Which option would you like to proceed with?: ");
        menuOption = scan.nextInt();
        scan.nextLine();

        if (menuOption ==1)
        {
            displayAppliances();
        }
        else if (menuOption ==2)
        {
            purchaseAppliances();
        }
        else if (menuOption ==3)
        {
            systemMenu();
        }

    }

    public void displayAppliances()
    {
        System.out.print("\f");
        if(appliances.isEmpty())
        {
            System.out.println("Error-There are no items in stock");
        }
        else
        {
            System.out.println("\n\nDisplaying appliances for sale....\n");
            for (Appliance a: appliances)  
            {
                System.out.println(a.toString());
            }
        }
    }

    public void purchaseAppliances()
    {
        Scanner scan = new Scanner(System.in);
        //local variables
        String applianceName,itemName;
        int number;
        int stockLevel;
        int unitsSold;
        boolean found = false;

        if(appliances.isEmpty())
        {
            System.out.println("Error-There are no items in stock");
        }
        else
        {

            do
            {
                System.out.println("\nWould you like to purchase a dryer or a  cooker ?");
                applianceName = scan.nextLine();
                if(!applianceName.equalsIgnoreCase("Dryer")  &&  !applianceName.equalsIgnoreCase("Cooker"))
                {
                    System.out.println("Error-Appliance not found");
                }

            }while(!applianceName.equalsIgnoreCase("Dryer") &&  !applianceName.equalsIgnoreCase("Cooker"));

            System.out.println("\nEnter the name of the item you wish to purchase :");
            itemName = scan.nextLine();
            for (Appliance a : appliances)
            {

                if (a.getName().equals(itemName))
                {
                    System.out.println("\nHow many items do you wish to buy ?");
                    number = scan.nextInt();
                    if(number <= a.getStockLevel())
                    {
                        found = true;
                        /*Assign the getter method(a.getStockLevel())to the local variable
                        (stockLevel).This turns the variable into whatever number
                        the getter is set to (e.g 10)*/
                        stockLevel = a.getStockLevel();
                        unitsSold = a.getUnitsSold();
                        //Update the local variable by subtracting it by whatever number is input
                        stockLevel = stockLevel - number;
                        unitsSold = unitsSold + number;
                        // Update the setter method(a.setStockLevel) by passing in the new stock level
                        a.setStockLevel(stockLevel);
                        System.out.println("Sale complete");
                        a.setUnitsSold(number);
                    }
                    else
                    {
                        System.out.println("Sorry,there are not enough items in stock");
                    }
                }

            }
            if (found==false)
            {
                System.out.println("Error-item not found");
            }

        }
        System.out.print("\nPress return to continue : ");
        scan.nextLine();
    }

    public void staffMenu()
    {
        Scanner scan = new Scanner(System.in);
        int menuOption;

        System.out.print("\f");
        System.out.print("Staff Menu\n\n");
        System.out.println("1. Add a new type of dryer/cooker to the stock list");
        System.out.println("2. Display details of the best-selling kitchen appliance");
        System.out.println("3. Update kitchen appliance stock level");
        System.out.println("4. Add discount to items");
        System.out.println("5. Exit Staff Menu");

        System.out.print("Which option would you like to proceed with?: ");
        menuOption = scan.nextInt();
        scan.nextLine();

        if (menuOption ==1)
        {
            addStock();
        }
        else if (menuOption ==2)
        {
            displayBestSeller();
        }
        else if (menuOption ==3)
        {
            updateStock();
        }

        else if(menuOption ==4)
        {
            addDiscount();
        }

        else if (menuOption ==5)
        {
            systemMenu();
        }
    }

    public void addStock()
    {
        Scanner scan = new Scanner(System.in);
        String itemChoice;

        System.out.print("\f");
        System.out.println("Would you like to add a new cooker or dryer to the stock list? :");
        itemChoice = scan.nextLine();
        if (itemChoice.equalsIgnoreCase("Cooker"))
        {
            createCooker();
        }
        else if (itemChoice.equalsIgnoreCase("Dryer"))
        {
            createDryer();
        }
        else
        {
            System.out.println("Error-Item not valid");
        }
    }

    public void updateStock()
    {  
        Scanner scan = new Scanner(System.in);
        //local variables
        String applianceName,itemName;
        int stockNumber;
        int stockLevel;
        System.out.print("\f");
        boolean found = false;
        do
        {
            System.out.println("\nWould you like to add stock to a dryer or a  cooker ?");
            applianceName = scan.nextLine();
            if(!applianceName.equalsIgnoreCase("Dryer")  &&  !applianceName.equalsIgnoreCase("Cooker"))
            {
                System.out.println("Error-Appliance not found");
            }

        }while(!applianceName.equalsIgnoreCase("Dryer") &&  !applianceName.equalsIgnoreCase("Cooker"));

        System.out.println("\nEnter the name of the item you wish to add stock to :");
        itemName = scan.nextLine();
        for (Appliance a : appliances)
        {
            if (a.getName().equals(itemName))
            {
                found = true;
                System.out.println("\nHow much stock would you like to add to the" + " " + itemName + " " + applianceName + "?");
                stockNumber = scan.nextInt();

                /*Assign the getter method(a.getStockLevel())to the local variable
                (stockLevel).This turns the variable into whatever number
                the getter is set to (e.g 10)*/
                stockLevel=a.getStockLevel();
                //Update the local variable by adding it by whatever number is input
                stockLevel= a.getStockLevel() + stockNumber;
                // Update the setter method(a.setStockLevel) by passing in the new stock level
                a.setStockLevel(stockLevel);
                System.out.println("Delivery Complete");
            }
            else
            {
                System.out.println("Error-item not found");
            }

        }
        if (found==false)
        {
            System.out.println("Error-item not found");
        }

    }

    public void displayBestSeller()
    {
        System.out.print("\f");

        if(appliances.isEmpty())
        {
            System.out.println("Error-There are no items in stock");
        }
        else
        {
            for (Appliance a : appliances)
            {

                System.out.println("Here are the units sold for each item\n\n");
                System.out.println(a.saleInfo());
                 
            }

        }

    }

    public void addDiscount()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");

        String applianceName,itemName;
        double priceDiscount;
        double price;
        boolean found = false;
        if(appliances.isEmpty())
        {
            System.out.println("Error-There are no items in stock");
        }
        else
        {
            do
            {
                System.out.println("\nWould you like to add a discount to a dryer or a  cooker ?");
                applianceName = scan.nextLine();
                if(!applianceName.equalsIgnoreCase("Dryer")  &&  !applianceName.equalsIgnoreCase("Cooker"))
                {
                    System.out.println("Error-Appliance not found");
                }

            }while(!applianceName.equalsIgnoreCase("Dryer") &&  !applianceName.equalsIgnoreCase("Cooker"));

            System.out.println("\nEnter the name of the item you wish to add a discount to :");
            itemName = scan.nextLine();
            for (Appliance a : appliances)
            {
                if (a.getName().equals(itemName))
                {
                    found = true;
                    System.out.println("\nHow much would you like to reduce the" + " " + itemName + " " + applianceName + " " + "by ?");
                    priceDiscount = scan.nextDouble();

                    price=a.getPrice();
                    price= a.getPrice() - priceDiscount;
                    a.setPrice(price);
                    System.out.println("Discount Added." + " " + "The" + itemName + " " + applianceName + " " + "has now been reduced by" + 
                        " " + priceDiscount + " " + "Euro") ;
                }
                else
                {
                    System.out.println("Error-item not found");
                }

            }
            if (found==false)
            {
                System.out.println("Error-item not found");
            }

        }
    }
}


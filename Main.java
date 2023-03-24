import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

class Inventory {
  String name;
  String serial;
  Integer value;
  
  Inventory (String name, String serial, Integer value) {
    this.name = name;
    this.serial = serial;
    this.value = value;
  }
  
  public String toString() {
    return name + "," + serial + "," + value;
  }
/*
  public boolean equals(Object obj) {
    if (obj == this.serial) {
      return true;
    }
    else return false;
  }
*/
}

class Main {
	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Inventory> inventoryList = new ArrayList<>();
    
    boolean runnerino = true;    
    while (runnerino) {
      System.out.println("Press 1 to add an item.");
      System.out.println("Press 2 to delete an item.");
      System.out.println("Press 3 to update an item.");
      System.out.println("Press 4 to show all the items.");
      System.out.println("Press 5 to quit the program.");
      
      int choice;
      try {
        choice = sc.nextInt();
        sc.nextLine();
        System.out.println("(debug) You have entered " + choice);
      } catch (Exception e) {
        e.printStackTrace();
        sc.next();
        continue;
      }
      
      switch(choice) {
        case 1: System.out.println("Enter the name:");
                String name = sc.nextLine();
                System.out.println("(debug) You have entered " + name);
                System.out.println("Enter the serial number:");
                String serial = sc.nextLine();
                System.out.println("(debug) You have entered " + serial);
                Integer value = null;
                while(runnerino) {
                  System.out.println("Enter the value in dollars (whole number):");
                  try {
                    value = sc.nextInt();
                    sc.nextLine();
                    System.out.println("(debug) You have entered " + value);
                    break;
                  } catch (Exception e) {
                    e.printStackTrace();
                    sc.next();
                    continue;
                  }
                }
                Inventory items = new Inventory(name, serial, value);
                inventoryList.add(items);
                System.out.println("(debug) " + inventoryList);
          break;          
        case 2: System.out.println("Enter the serial number of the item to delete:");
                String serialToDelete = sc.nextLine();
                System.out.println("(debug) You have entered " + serialToDelete);                
                try {
                  Iterator<Inventory> inventoryIterator = inventoryList.iterator();
                  while(inventoryIterator.hasNext()) {
                    Inventory iteratorNext = inventoryIterator.next();
                    if (serialToDelete.equals(iteratorNext.serial)) {
                      inventoryIterator.remove();
                      break;
                    }
                  }
                  System.out.println("(debug) " + inventoryList);    
                } catch (Exception e) {
                  e.printStackTrace();
                }
          break;          
        case 3: System.out.println("Enter the serial number of the item to change:");
                String serialToChange = sc.nextLine();
          
                System.out.println("Enter the new name:");
                String newName = sc.nextLine();
                System.out.println("(debug) You have entered " + newName);
                Integer newValue = null;
                while(runnerino) {
                  System.out.println("Enter the new value in dollars (whole number):");
                  try {
                    newValue = sc.nextInt();
                    sc.nextLine();
                    System.out.println("(debug) You have entered " + newValue);
                    break;
                  } catch (Exception e) {
                    e.printStackTrace();
                    sc.next();
                    continue;
                  }
                }
                Inventory newItems = new Inventory(newName, serialToChange, newValue);
                try {
                  ListIterator<Inventory> inventoryListIterator = inventoryList.listIterator();
                  while(inventoryListIterator.hasNext()) {
                    Inventory listIteratorNext = inventoryListIterator.next();
                    if (serialToChange.equals(listIteratorNext.serial)) {
                      inventoryListIterator.set(newItems);
                      break;
                    }
                  }
                  System.out.println("(debug) " + inventoryList);      
                } catch (Exception e) {
                  e.printStackTrace();
                }
          break;          
        case 4: for (int i = 0; i < inventoryList.size(); i++) {
                  System.out.println(inventoryList.get(i));
                }
          break;          
        case 5: runnerino = false;
          break;          
        default: System.out.println("Invalid input, try again...");
          continue;
      }
    }
	}
}
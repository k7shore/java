import java.util.*;
class Grocery {
    class Item {
        int id;
        String name;
        int price;
        String units;

        public Item(int id, String name, int price, String units) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.units = units;
        }
    }

    Item[] items = {
            new Item(0, "Rice", 70 , "(per kg)"),
            new Item(1, "Salt", 20 , "(per kg)"),
            new Item(2, "Turmeric", 15 , "(100g)"),
            new Item(3, "Atta", 52 , "(per kg)"),
            new Item(4, "Maida", 50 , "(per kg)"),
            new Item(5, "Rava", 45 , "(per kg)"),
            new Item(6, "Raggi Flour", 70 , "(per kg)"),
            new Item(7, "Corn Flour", 80 , "(per kg)"),
            new Item(8, "Moong Dal", 150 , "(per kg)"),
            new Item(9, "Channa", 110 , "(per kg)"),
            new Item(10, "Green Gram", 120 , "(per kg)"),
            new Item(11, "Milk", 50 , "(1ltr)"),
            new Item(12, "Sugar", 40 , "(per kg)"),
            new Item(13, "Eggs", 6 , "(1)"),
            new Item(14, "Yogurt", 15 , "(200ml)"),
            new Item(15, "Bread", 30 , "(12pcs)")

    };

    List<Integer> cartItems = new ArrayList<>();

    public void run() {
        try {
            System.out.println();
            Thread.sleep(100);
            System.out.println("Welcome to the Grocery Store!!");
            Thread.sleep(500);
            options();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void options() {
        try {
            Scanner sc = new Scanner(System.in);
            String input;

            while (true) {
                System.out.println();
                System.out.println("1 => Show available groceries");
                System.out.println("2 => View Cart");
                System.out.println("3 => Add items to Cart");
                System.out.println("4 => Remove items from Cart");
                System.out.println("5 => Buy items");
                System.out.println("q => Exit");
                System.out.print("Enter Your Choice : ");
                input = sc.nextLine();

                switch (input) {
                    case "1" -> listOfItems();
                    case "2" -> cart();
                    case "3" -> addItemsToCart();
                    case "4" -> removeItemsFromCart();
                    case "5" -> buyItems();
                    case "q" -> {
                        System.out.println("Thanks for shopping with us!");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Please enter a valid option.");
                        Thread.sleep(300);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItemsToCart() {
        try {
            Thread.sleep(100);
            listOfItems();
            // Thread.sleep(10);
            System.out.print("Choose items to be added using ID (separated by space) : ");
            Scanner itms = new Scanner(System.in);
            String[] selectedItems = itms.nextLine().split("\\s");

            for (String selectedItem : selectedItems) {
                int itemNumber = Integer.parseInt(selectedItem);
                if (itemNumber >= 0 && itemNumber < items.length) {
                    cartItems.add(itemNumber);
                    System.out.println(items[itemNumber].name + " added to your cart.");
                    Thread.sleep(900);
                }
                else {
                    System.out.println(itemNumber + "Item not found. Please choose a valid items");
                    Thread.sleep(200);
                    addItemsToCart();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input only numbers allowed. Please enter a valid item ID");
            addItemsToCart();
        } catch (Exception e) {
            e.printStackTrace();
            addItemsToCart();
        }
    }

    public void removeItemsFromCart() {
        try {
            // Thread.sleep(100);
            // listOfItems();
            // Thread.sleep(100);
            // System.out.print("Your Cart");
            Thread.sleep(100);
            cart();
            Thread.sleep(10);
            System.out.print("Choose items to remove using ID (separated by space): ");
            Scanner itms = new Scanner(System.in);
            String[] selectedItems = itms.nextLine().split("\\s");

            for (String selectedItem : selectedItems) {
                int itemNumber = Integer.parseInt(selectedItem);
                if (cartItems.contains(itemNumber)) {
                    cartItems.remove(Integer.valueOf(itemNumber));
                    System.out.println(items[itemNumber].name + " removed from your cart.");
                    Thread.sleep(900);
                } 
                else{
                    System.out.println();
                    System.out.println("Item " + itemNumber + " not found in the cart.");
                    Thread.sleep(300);
                    System.out.println("Please enter a valid ID");
                    Thread.sleep(300);
                    removeItemsFromCart();
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid input. Please enter valid a item ID.");
            removeItemsFromCart();
        }
        catch (Exception e) {
            e.printStackTrace();
            removeItemsFromCart();
        }
    }
    public void addItemsIfCartIsEmpty(){
        System.out.print("Do you want to add items to your cart [y/n] : ");
        Scanner scanner = new Scanner(System.in);
        String yesOrNo = scanner.nextLine();
        switch(yesOrNo){
            case "y" -> addItemsToCart();
            case "Y" -> addItemsToCart();
            case "n" -> options();
            case "N" -> options();
            default -> {
                System.out.println("Invalid input only y or n is allowed");
                addItemsIfCartIsEmpty();
            }
        } 
    }
    public void processingLoad(){
        System.out.print("Processing your purchase.");
        try {
            Thread.sleep(200); 
            System.out.print(".");
            Thread.sleep(300); 
            System.out.print(".");
            Thread.sleep(400); 
            System.out.print(".");
            Thread.sleep(450); 
            System.out.print(".");
            Thread.sleep(500); 
            System.out.print(".");
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void buyItems() {
        try {
            if (cartItems.isEmpty()) {
                Thread.sleep(100);
                System.out.println("Your cart is empty. Add items before buying.");
                Thread.sleep(100);
                addItemsIfCartIsEmpty();
            } 
            else {
                System.out.println();
                // System.out.println("Processing your purchase...");
                processingLoad();
                System.out.println();
                System.out.println("Successfully processed...");
                Thread.sleep(100);
                displayReceipt();
                Thread.sleep(100);
                System.out.println("Thanks for purchasing :)...");
                Thread.sleep(1000);
                emptyCart();
                Thread.sleep(100);
            }
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayReceipt() {
        try {
            Thread.sleep(500);
            System.out.println();
            System.out.println("----------------Receipt---------------------");
            System.out.printf("| %-5s| %-5s | %-15s | %-8s|\n", "S.no", "Id", "Items", "Price");
            System.out.println("--------------------------------------------");
            int cartId = 1;
            int billAmount = 0;
            for (int itemNumber : cartItems) {
                Item itemsSelected = items[itemNumber];
                System.out.printf("| %-5s| %-5s | %-15s | ₹%-7s|\n", cartId,itemsSelected.id, itemsSelected.name, itemsSelected.price);
                cartId++;
                billAmount += itemsSelected.price;
            }
            System.out.println("--------------------------------------------");
            System.out.printf("\t\t\t   Total : ₹%-4.2f ", (float) billAmount);
            System.out.println();
            System.out.println("--------------------------------------------");
            Thread.sleep(1000);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void emptyCart() {
        cartItems.clear();
    }

    public void cart() {
        try {
            if (cartItems.isEmpty()) {
                System.out.println("Your cart is empty.");
                Thread.sleep(100);
                addItemsIfCartIsEmpty();
            } 
            else {
                System.out.println();
                System.out.println("---------------Cart Items-------------------");
                System.out.printf("| %-3s | %-5s | %-15s | %-7s |\n", "S.no", "ID", "Items", "Price");
                System.out.println("--------------------------------------------");
                int cartId = 1;
                int billAmount = 0;
                for (int itemNumber : cartItems) {
                    Item itemsSelected = items[itemNumber];
                    System.out.printf("| %-5s| %-5s | %-15s | ₹%-7s|\n", cartId, itemsSelected.id, itemsSelected.name, itemsSelected.price);
                    cartId++;
                    billAmount += itemsSelected.price;
                }
                System.out.println("--------------------------------------------");
                System.out.printf("\t\t\t   Total : ₹%-2.2f ", (float) billAmount);
                System.out.println();
                System.out.println("--------------------------------------------");
                Thread.sleep(1000);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listOfItems() {
        try {
            Thread.sleep(100);
            System.out.println("-------------List of items-----------------");
            System.out.printf("| %-4s | %-15s | %-9s\t  |\n", "ID", "Items", "Price");
            System.out.println("-------------------------------------------");

            for (Item item : items) {
                System.out.printf("| %-4s | %-15s | ₹%-4s %-8s |\n", item.id, item.name, item.price,item.units);
            }
            System.out.println("-------------------------------------------");
            Thread.sleep(800);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            Grocery grocery = new Grocery();
            grocery.run();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package eshop;


import java.util.Scanner;


public class eshop {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);

        shop.registerEmployee(1, "Alice", "password");
        shop.registerCustomer(2, "Bob", "password", "123 Main St");
        
        
        
        shop.addItem(1, "Laptop", 10, 999.99);
        shop.addItem(2, "Smartphone", 15, 699.99);
        shop.addItem(3, "Tablet", 20, 399.99);
        shop.addItem(4, "Headphones", 30, 199.99);
        shop.addItem(5, "Smartwatch", 25, 299.99);
        
        while (true) {
            System.out.println("Welcome to eShop! Are you a:");
            System.out.println("1. Customer");
            System.out.println("2. Employee");
            System.out.println("3. Exit");
            int userType = scanner.nextInt();
            scanner.nextLine();  

            if (userType == 3) {
                System.out.println("Thank you for visiting eShop!");
                break;
            }

            switch (userType) {
                case 1:
                    handleCustomerActions(shop, scanner);
                    break;
                case 2:
                    handleEmployeeActions(shop, scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void handleCustomerActions(Shop shop, Scanner scanner) {
        System.out.println("1. Register as a new customer");
        System.out.println("2. Log in as an existing customer");
        int customerChoice = scanner.nextInt();
        scanner.nextLine();  

        Customer customer = null;
        if (customerChoice == 1) {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter a password:");
            String password = scanner.nextLine();
            System.out.println("Enter your address:");
            String address = scanner.nextLine();
            int userID = shop.generateUserID();
            shop.registerCustomer(userID, name, password, address);
            customer = (Customer) shop.login(userID, password);
            System.out.println("Registered and logged in as new customer: " + name);
        } else if (customerChoice == 2) {
            System.out.println("Enter your user ID:");
            int userID = scanner.nextInt();
            scanner.nextLine();  
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            customer = (Customer) shop.login(userID, password);
            if (customer == null) {
                System.out.println("Invalid ID or password.");
                return;
            } else {
                System.out.println("Logged in as: " + customer.getName());
            }
        }

        while (customer != null) {
            System.out.println("1. Shop items");
            System.out.println("2. View shopping cart");
            System.out.println("3. Update item quantity in cart");
            System.out.println("4. Remove item from cart");
            System.out.println("5. Checkout");
            System.out.println("6. Log out");
            int action = scanner.nextInt();
            scanner.nextLine();  

            switch (action) {
                case 1:
                    shop.displayItems();
                    System.out.println("Enter item number to add to cart:");
                    int itemNumber = scanner.nextInt();
                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  
                    Item item = shop.findItemByNumber(itemNumber);
                    if (item != null) {
                        customer.addToCart(item, quantity);
                        System.out.println("Item added to cart.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 2:
                    System.out.println("Shopping cart: " + customer.getShoppingCart());
                    break;
                case 3:
                    System.out.println("Enter item number to update:");
                    itemNumber = scanner.nextInt();
                    System.out.println("Enter new quantity:");
                    quantity = scanner.nextInt();
                    scanner.nextLine(); 
                    item = shop.findItemByNumber(itemNumber);
                    if (item != null) {
                        customer.updateCart(item, quantity);
                        System.out.println("Cart updated.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter item number to remove from cart:");
                    itemNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    item = shop.findItemByNumber(itemNumber);
                    if (item != null) {
                        customer.removeFromCart(item);
                        System.out.println("Item removed from cart.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 5:
                    double invoice = customer.checkout();
                    System.out.println(invoice);
                    System.out.println("Checkout complete. Thank you for your purchase!");
                    break;
                case 6:
                    customer = null;
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



    private static void handleEmployeeActions(Shop shop, Scanner scanner) {
        System.out.println("Enter your user ID:");
        int userID = scanner.nextInt();
        scanner.nextLine();  
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        User user = shop.login(userID, password);
        if (user instanceof Employee) {
            Employee employee = (Employee) user;
            System.out.println("Logged in as: " + employee.getName());

            while (employee != null) {
                System.out.println("1. Add new item");
                System.out.println("2. Update inventory");
                System.out.println("3. Register new employee");
                System.out.println("4. Log out");
                int action = scanner.nextInt();
                scanner.nextLine();  

                switch (action) {
	                case 1:
	                    int itemNumber = shop.getNextItemNumber();
	                    System.out.println("Enter item description:");
	                    String description = scanner.nextLine();
	                    System.out.println("Enter item inventory:");
	                    int inventory = scanner.nextInt();
	                    System.out.println("Enter item price:");
	                    double price = scanner.nextDouble();
	                    scanner.nextLine();  
	                    employee.addItem(shop.getItems(), itemNumber, description, inventory, price);
	                    System.out.println("Item added to inventory with item number: " + itemNumber);
	                    break;
                    case 2:
                        System.out.println("Enter item number to update:");
                        itemNumber = scanner.nextInt();
                        System.out.println("Enter new inventory:");
                        inventory = scanner.nextInt();
                        scanner.nextLine();  
                        Item item = shop.findItemByNumber(itemNumber);
                        if (item != null) {
                            employee.updateInventory(item, inventory);
                            System.out.println("Inventory updated.");
                        } else {
                            System.out.println("Item not found.");
                        }
                        break;
                    case 3:
                        System.out.println("Enter new employee name:");
                        String empName = scanner.nextLine();
                        System.out.println("Enter new employee password:");
                        String empPassword = scanner.nextLine();
                        int empUserID = shop.generateUserID();
                        shop.registerEmployee(empUserID, empName, empPassword);
                        System.out.println("New employee registered with ID: " + empUserID);
                        break;
                    case 4:
                        employee = null;
                        System.out.println("Logged out.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid ID or password.");
        }
    }

}

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Store store = Store.getInstance();
        store.loadProducts();
        store.loadQuantities();
        User user = createUser();
        ShoppingCart cart = new ShoppingCart(user);

        while (true) {
            //showing the main menu
            System.out.println("MENU\nSelect option:\n1. Display products\n2. Add products to cart \n" +
                    "3. Go to Cart\n4. Finalize order\n5. Check stock\n0. Exit\n>>");

            //getting option selection from the user
            String input = scanner.nextLine();
            int selection = Integer.parseInt(input);

            //depending on the menu option selected by the user, the following functions are available
            switch (selection) {
                case 1:
                    // show catalogue
                    store.displayProducts();
                case 2:
                    //add products to cart
                    while (true) {
                        selection = (getIntegerInput(
                                "Enter product code to add it to the cart:\n " +
                                        "(to return to the previous menu press 9)\n>>"));
                        if (selection == 9) {
                            break;
                        } else {
                            Product product = store.getProduct(selection);
                            cart.addItem(product, getIntegerInput("Enter quantity\n>>"));
                        }
                    }
                    break;
                case 3:
                    //display the cart contents
                    cart.displayItemsInCart();
                    System.out.println("Total number of items in the cart: " + cart.cartTotalQuantity() + "\n");
//                    System.out.println("Total amount to pay: " + cart.cartTotalAmount());

                    break;
                case 4:
                    //finalize the order
                    Order order = cart.createOrder();
                    break;

                case 5:
                    store.checkStock();
                    break;
                case 0:
                    //exit
                    return;
                default:
                    System.out.println("Invalid option selected");
            }

        }

    }

    public static User createUser() {
        String name;
        String address;
        String phoneNumber;

        // please enter your name, address and phone number
        System.out.println("Please enter your username:");
        name = scanner.nextLine();
        System.out.println("Please enter your address:");
        address = scanner.nextLine();
        System.out.println("Please enter your phone number");
        phoneNumber = scanner.nextLine();

        return new User(name, address, phoneNumber);
    }

    public static int getIntegerInput(String msg) {
        System.out.println(msg);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}

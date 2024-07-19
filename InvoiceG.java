package task2nova;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Invoice {
    private ArrayList<Item> items;
    private String customerName;
    // private String invoiceDate;
    // private String formattedDateTime;

    public Invoice(String customerName){           // String invoiceDate) {
        this.customerName = customerName;
        // this.invoiceDate = invoiceDate;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void generateInvoice(String formattedDateTime) {
        double total = 0;
        System.out.println("                                                        ");

        System.out.println("-----------------------------------------------");
        System.out.println("                                                        ");
        System.out.println("                                                        ");
        System.out.println("              Business enterprise name                 ");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Date: " + formattedDateTime);
        System.out.println("------------------------------------------------");
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Item", "Quantity", "Price", "Total");
        System.out.println("------------------------------------------------");
        for (Item item : items) {
            double itemTotal = item.getQuantity() * item.getPrice();
            System.out.printf("%-20s %-10d %-10.2f %-10.2f\n", item.getName(), item.getQuantity(), item.getPrice(), itemTotal);
            total += itemTotal;
        }
        System.out.println("------------------------------------------------ ");
        System.out.printf("%-20s %-10s %-10s %-10.2f\n", "Total", "", "", total);

         System.out.println("                      Thank you                       ");
         System.out.println("                        ***                           ");
         System.out.println("                                                      ");


    }
}


class Item {
    private String name;
    private int quantity;
    private double price;
    // private String quantity;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() { 
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}


public class InvoiceG {
    public static void main(String[] args) {
        Scanner inputobj = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = inputobj.nextLine();


         // Get the current date and time in IST
        ZonedDateTime currentDateTimeInIndia = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        // Format the date and time in a readable format
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = currentDateTimeInIndia.format(formatter);

        // String date =formattedDateTime;
        // Print the current date and time in IST
        System.out.println("date and time : " + formattedDateTime);

        //  System.out.print("Enter invoice date (YYYY-MM-DD): ");
        // String invoiceDate = inputobj.nextLine();f

        Invoice invoice = new Invoice(customerName);//invoiceDate);

        while (true) {
            System.out.print("Enter item name (or type 'done' to get the invoice): ");
            String itemName = inputobj.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = inputobj.nextInt();

            System.out.print("Enter price: ");
            double price = inputobj.nextDouble();
            inputobj.nextLine();  // Consume the newline

            Item item = new Item(itemName, quantity, price);
            invoice.addItem(item);

        }

        invoice.generateInvoice(formattedDateTime);
    }
}

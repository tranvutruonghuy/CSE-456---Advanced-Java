package vn.edu.eiu.cse456;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.edu.eiu.cse456.config.AppConfig;
import vn.edu.eiu.cse456.entity.Customer;
import vn.edu.eiu.cse456.entity.Invoice;
import vn.edu.eiu.cse456.entity.Product;
import vn.edu.eiu.cse456.service.CustomerService;
import vn.edu.eiu.cse456.service.InvoiceService;
import vn.edu.eiu.cse456.service.ProductSerivce;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize Spring Application Context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get services via dependency injection
        CustomerService customerService = context.getBean(CustomerService.class);
        ProductSerivce productService = context.getBean(ProductSerivce.class);
        InvoiceService invoiceService = context.getBean(InvoiceService.class);

        System.out.println("=== Invoice Management System ===");

        // 1. Create and save a new customer
        System.out.println("\n1. Creating customer...");
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john.doe@email.com");
        customerService.createCustomer(customer);
        System.out.println("Customer created: " + customer.getName());

        // 2. Create hardcoded products
        System.out.println("\n2. Creating product catalog...");
        List<Product> catalogProducts = createProductCatalog();

        // Display available products
        System.out.println("Available products in catalog:");
        for (Product product : catalogProducts) {
            System.out.println("- " +
                    product.getName() + ": " + product.getPrice() + " (Qty: " + product.getQuantity() + ")");
        }

        // 3. Generate invoice for customer with selected products + print pdf file
        System.out.println("\n3. Generating invoice...");
        // Select first and third product from catalog
        List<Product> selectedProducts = Arrays.asList(catalogProducts.get(0), catalogProducts.get(2));
        Invoice invoice = invoiceService.createInvoice(customer, selectedProducts);

        System.out.println("\n=== Application completed successfully ===");
    }

    private static List<Product> createProductCatalog() {
        // Create hardcoded products as catalog (not persisted to DB yet)
        Product laptop = new Product();
        laptop.setName("Laptop Dell XPS 13");
        laptop.setPrice(1299.99);
        laptop.setQuantity(1);
        laptop.setDescription("High-performance laptop");

        Product mouse = new Product();
        mouse.setName("Wireless Mouse");
        mouse.setPrice(29.99);
        mouse.setQuantity(2);
        mouse.setDescription("Ergonomic wireless mouse");

        Product keyboard = new Product();
        keyboard.setName("Mechanical Keyboard");
        keyboard.setPrice(149.99);
        keyboard.setQuantity(1);
        keyboard.setDescription("RGB mechanical gaming keyboard");

        Product monitor = new Product();
        monitor.setName("4K Monitor");
        monitor.setPrice(399.99);
        monitor.setQuantity(1);
        monitor.setDescription("27-inch 4K display");

        return Arrays.asList(laptop, mouse, keyboard, monitor);
    }
}
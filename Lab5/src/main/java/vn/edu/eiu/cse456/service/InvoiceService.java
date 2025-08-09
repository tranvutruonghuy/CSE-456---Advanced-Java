package vn.edu.eiu.cse456.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.cse456.entity.Customer;
import vn.edu.eiu.cse456.entity.Invoice;
import vn.edu.eiu.cse456.entity.Product;
import vn.edu.eiu.cse456.repo.IGenericRepo;
import vn.edu.eiu.cse456.repo.InvoiceRepo;
import vn.edu.eiu.cse456.utils.PdfGeneratorUtil;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceService {
    private IGenericRepo repo;
    private PdfGeneratorUtil pdfGeneratorUtil;

    @Autowired
    public InvoiceService(InvoiceRepo repo, PdfGeneratorUtil pdfGeneratorUtil) {
        this.repo = repo;
        this.pdfGeneratorUtil = pdfGeneratorUtil;
    }

    public Invoice createInvoice(Customer customer, List<Product> selectedProducts) {


        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setInvoiceDate(LocalDateTime.now());
        //Generate infor to show pdfFile
        String filename = "";
        String content = "";

        // Create new product instances for this invoice to avoid detached entity issues
        for (Product selectedProduct : selectedProducts) {
            Product invoiceProduct = new Product();
            invoiceProduct.setName(selectedProduct.getName());
            invoiceProduct.setPrice(selectedProduct.getPrice());
            invoiceProduct.setQuantity(selectedProduct.getQuantity());
            invoiceProduct.setDescription(selectedProduct.getDescription());
            invoiceProduct.setInvoice(invoice); // Set the invoice reference
            invoice.addProduct(invoiceProduct);
            content += "- Name:" + invoiceProduct.getName() + ", Price: $" + invoiceProduct.getPrice() + ", Quantity: " + invoiceProduct.getQuantity() + "\n";
        }


        // Calculate total amount
        invoice.calculateTotalAmount();
        content += "- Total: $" + invoice.getTotalAmount();

        // Add invoice to customer
        customer.addInvoice(invoice);

        // Save invoice (will cascade to products)
        repo.createEntity(invoice);
        filename = "invoice_" + invoice.getId() + ".pdf";
        //Create Pdf file
        pdfGeneratorUtil.generatePdfFile(filename, content);
        return invoice;
    }


    public Invoice findInvoiceById(int id) {
        return (Invoice) repo.findEntity(id);
    }

    public List<Invoice> findAllInvoices() {
        return repo.findAllEntities();
    }
}
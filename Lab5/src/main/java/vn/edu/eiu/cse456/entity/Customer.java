package vn.edu.eiu.cse456.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tbl_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Invoice> invoices = new ArrayList<>();

    public void addInvoice(Invoice invoice){
        this.invoices.add(invoice);
        invoice.setCustomer(this);
    }
    public void removeInvoice(Invoice invoice){
        this.invoices.remove(invoice);
        invoice.setCustomer(null);
    }
}

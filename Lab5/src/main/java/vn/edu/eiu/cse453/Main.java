package vn.edu.eiu.cse453;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.cse453.entity.Customer;
import vn.edu.eiu.cse453.infra.JpaUtil;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
    }
}
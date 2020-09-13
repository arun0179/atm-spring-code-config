package th.ac.ku.atm;

import java.util.Map;

public class Bank {
    private String name;

    //composition
    private Map<Integer,Customer> customers;
//    private DataSourceDB dataSourceDB;
    private DataSource dataSourceFile;

    //receive the dataSource like this it is like you can change object
    public Bank(String name, DataSource dataSource) {
        this.name = name;
        this.customers = dataSource.readCustomers();
    }
    public void registerCustomer(Customer customer){
        this.customers.put(customer.getId(),customer);
    }
    public Customer findCustomer(int id){
        return customers.get(id);
    }

    public String getName() {
        return name;
    }
}

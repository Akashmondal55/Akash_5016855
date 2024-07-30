public class CustomerService {
    private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getCustomerName(String id) {
        return repository.findCustomerById(id);
    }

    public void addCustomer(String id, String name) {
        repository.addCustomer(id, name);
    }

    public void updateCustomer(String id, String name) {
        repository.updateCustomer(id, name);
    }

    public void deleteCustomer(String id) {
        repository.deleteCustomer(id);
    }
}
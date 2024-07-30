public interface CustomerRepository {
    String findCustomerById(String id);
    void addCustomer(String id, String name);
    void updateCustomer(String id, String name);
    void deleteCustomer(String id);
}
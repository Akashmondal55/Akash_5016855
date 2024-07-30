import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, String> customers;

    public CustomerRepositoryImpl() {
        customers = new HashMap<>();
    }

    @Override
    public String findCustomerById(String id) {
        return customers.get(id);
    }

    @Override
    public void addCustomer(String id, String name) {
        customers.put(id, name);
    }

    @Override
    public void updateCustomer(String id, String name) {
        if (customers.containsKey(id)) {
            customers.put(id, name);
        }
    }

    @Override
    public void deleteCustomer(String id) {
        customers.remove(id);
    }
}
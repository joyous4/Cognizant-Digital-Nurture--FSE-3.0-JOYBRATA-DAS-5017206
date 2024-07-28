public class CustomerService {
    private final CustomerRepository customerRepository;

    // Step 5: Implement Dependency Injection using constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomer(int id) {
        return customerRepository.findCustomerById(id);
    }
}
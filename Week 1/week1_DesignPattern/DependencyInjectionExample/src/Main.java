public class Main {
    public static void main(String[] args) {
        // Create a concrete repository implementation
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Create a customer service with the repository
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the customer service to find a customer
        Customer customer = customerService.findCustomer(1);
        System.out.println("Found customer: " + customer.getName() + " with email " + customer.getEmail());
    }
}
package br.ada.ecommerce.usecases.impl.order;

import br.ada.ecommerce.model.Customer;
import br.ada.ecommerce.usecases.INotifierUseCase;
import br.ada.ecommerce.usecases.impl.customer.CustomerUseCaseImpl;
import br.ada.ecommerce.usecases.repository.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class CustomerUserCaseImplTest {

    private ICustomerRepository customerRepository;
    private INotifierUseCase<Customer> notifier;

    private CustomerUseCaseImpl customerUseCase;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        Customer customer = new Customer();
        customerRepository = Mockito.mock(ICustomerRepository.class);

        notifier = Mockito.mock(INotifierUseCase.class);

        Mockito.when(customerRepository.findByDocument("dummy-value")).thenReturn(customer);

        customerUseCase = new CustomerUseCaseImpl(customerRepository, notifier);
    }
}

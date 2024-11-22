package br.ada.ecommerce.usecases.impl.order;

import br.ada.ecommerce.model.Customer;
import br.ada.ecommerce.usecases.INotifierUseCase;
import br.ada.ecommerce.usecases.impl.customer.CustomerUseCaseImpl;
import br.ada.ecommerce.usecases.repository.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerUserCaseImplTest {

    @Mock
    private ICustomerRepository customerRepository;

    @Mock
    private INotifierUseCase<Customer> notifier;

    @InjectMocks
    private CustomerUseCaseImpl customerUseCase;

    @BeforeEach
    public void setUp() {
        Customer customer = new Customer();
        customerRepository = Mockito.mock(ICustomerRepository.class);

        notifier = Mockito.mock(INotifierUseCase.class);

        Mockito.when(customerRepository.findByDocument("dummy-value")).thenReturn(customer);

        customerUseCase = new CustomerUseCaseImpl(customerRepository, notifier);
    }
}

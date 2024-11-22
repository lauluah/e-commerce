package br.ada.ecommerce.usecases.impl.order;

import br.ada.ecommerce.model.Customer;
import br.ada.ecommerce.usecases.INotifierUseCase;
import br.ada.ecommerce.usecases.impl.customer.CustomerUseCaseImpl;
import br.ada.ecommerce.usecases.repository.ICustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerUserCaseImplTest {

    @Mock
    private ICustomerRepository customerRepository;

    @Mock
    private INotifierUseCase<Customer> notifier;

    @InjectMocks
    private CustomerUseCaseImpl useCase;

    @Test
    public void deletarClienteExistente_retornaCliente() {
        Customer customer = new Customer();
        customer.setId(1L);

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Customer deletedCustomer = useCase.delete(1L);


        Assertions.assertNotNull(deletedCustomer);
        Mockito.verify(customerRepository, Mockito.times(1)).delete(customer);
        Mockito.verify(notifier, Mockito.times(1)).deleted(customer);
        Assertions.assertEquals(1L, deletedCustomer.getId());
    }

    @Test
    public void retornarNull_SeNaoEcontrarClientePorId() {
        Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Customer result = useCase.delete(1L);
        Assertions.assertNull(result);
    }
}

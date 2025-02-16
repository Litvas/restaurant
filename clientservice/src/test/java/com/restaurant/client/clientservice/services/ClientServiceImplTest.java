package com.restaurant.client.clientservice.services;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.dtos.ClientDTO;
import com.restaurant.client.clientservice.exceptions.ClientNotFoundException;
import com.restaurant.client.clientservice.mappers.ClientMapper;
import com.restaurant.client.clientservice.repositories.ClientRepository;
import com.restaurant.client.clientservice.services.impl.ClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    private final String INNER_ID = "INNER_ID";
    private final String INCORRECT_INNER_ID = "INCORRECT_INNER_ID";

    @InjectMocks
    private ClientServiceImpl testedEntry;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    private Client client = new Client();
    private ClientDTO clientDTO = new ClientDTO();

    @Before
    public void setRules() {
        doReturn(client).when(clientRepository).getClientByInnerId(anyString());
        doReturn(client).when(clientRepository).save(client);
        doReturn(clientDTO).when(clientMapper).toClientDTO(client);
        doReturn(null).when(clientRepository).getClientByInnerId(INCORRECT_INNER_ID);
    }

    @Test
    public void shouldToReturnClientDuringGet() {
        assertThat(testedEntry.getClientByInnerId(INNER_ID)).isInstanceOf(ClientDTO.class);
    }

    @Test
    public void shouldToReturnClientDuringSave() {
        assertThat(testedEntry.createClient(client)).isInstanceOf(ClientDTO.class);
    }

    @Test
    public void shouldToThrowException() {
        ClientNotFoundException exception = assertThrows(ClientNotFoundException.class, () -> {
            testedEntry.getClientByInnerId(INCORRECT_INNER_ID);
        });
        assertThat(exception).isInstanceOf(ClientNotFoundException.class);
        assertThat(exception.getMessage()).isEqualTo("Client with innerId " + INCORRECT_INNER_ID + " not found in system");
    }
}

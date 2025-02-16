package com.restaurant.client.clientservice.services;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.repositories.ClientRepository;
import com.restaurant.client.clientservice.services.impl.ClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

    private final String INNER_ID = "INNER_ID";

    @InjectMocks
    private ClientServiceImpl testedEntry;

    @Mock
    private ClientRepository clientRepository;

    private Client client = new Client();

    @Before
    public void setRules() {
        doReturn(client).when(clientRepository).getClientByInnerId(anyString());
        doReturn(client).when(clientRepository).save(client);
    }

    @Test
    public void shouldToReturnClientDuringGet() {
        assertThat(testedEntry.getClientByInnerId(INNER_ID)).isInstanceOf(Client.class);
    }

    @Test
    public void shouldToReturnClientDuringSave() {
        assertThat(testedEntry.createClient(client)).isInstanceOf(Client.class);
    }
}

package com.restaurant.client.clientservice.controllers;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.services.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ClientControllerTest.class)
public class ClientControllerTest {

    private final Long ID = 100L;
    private final String INNER_ID = "inner_id";
    private final String PHONE = "PHONE";
    private final String USERNAME = "USERNAME";
    private final Long BONUSES = 100L;
    private LocalDateTime CREATED_DATE = LocalDateTime.of(2025, 01, 12, 17, 22);

    @MockitoBean
    private ClientService clientService;

    @Autowired
    private MockMvc mvc;

    private Client client = new Client();

    @Before
    public void initTestData() {
        client.setId(ID);
        client.setInnerId(INNER_ID);
        client.setPhone(PHONE);
        client.setUsername(USERNAME);
        client.setBonuses(BONUSES);
        client.setCreatedDate(CREATED_DATE);
    }

    @Before
    public void setRule() {
        doReturn(client).when(clientService).getClientByInnerId(INNER_ID);
    }

    @Test
    public void shouldReturnClientError() throws Exception {
        mvc.perform(get("/api/clients"))
                .andExpect(status().is4xxClientError());
    }

}

package com.restaurant.client.clientservice.controllers;

import com.restaurant.client.clientservice.domain.Client;
import com.restaurant.client.clientservice.dtos.ClientDTO;
import com.restaurant.client.clientservice.services.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ClientController.class)
public class ClientControllerTest {

    private final Long ID = 100L;
    private final String INNER_ID = "inner_id";
    private final String PHONE = "PHONE";
    private final String USERNAME = "USERNAME";
    private final Long BONUSES = 100L;
    private LocalDateTime CREATED_DATE = LocalDateTime.parse("2025-02-16T17:24:44");

    @MockitoBean
    private ClientService clientService;

    @Autowired
    private MockMvc mvc;

    private ClientDTO client = new ClientDTO();
    private Client client_without_username = new Client();

    @Before
    public void initTestData() {
        client.setInnerId(INNER_ID);
        client.setPhone(PHONE);
        client.setUsername(USERNAME);
        client.setBonuses(BONUSES);
        client.setCreatedDate(CREATED_DATE);
    }

    @Test
    public void shouldReturnClientError() throws Exception {
        doReturn(client).when(clientService).getClientByInnerId(INNER_ID);
        mvc.perform(get("/api/clients"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturnCorrectObject() throws Exception {
        doReturn(client).when(clientService).getClientByInnerId(INNER_ID);
        mvc.perform(get("/api/clients").param("innerId", INNER_ID))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.innerId").value(INNER_ID))
                .andExpect(jsonPath("$.phone").value(PHONE))
                .andExpect(jsonPath("$.username").value(USERNAME))
                .andExpect(jsonPath("$.bonuses").value(BONUSES));
    }

    @Test
    public void shouldReturn4xxStatus() throws Exception {
        mvc.perform(post("/api/clients")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$[0].fieldName").value("username"))
                .andExpect(jsonPath("$[0].errorMessage").value("Field 'username' cannot be null or empty"));
    }

}

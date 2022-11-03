package com.amigoscode.guest.integration;

import com.amigoscode.guest.Guest;
import com.amigoscode.guest.GuestController;
import com.amigoscode.guest.GuestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GuestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GuestRepository guestRepository;
    @Test
    void canAddNewGuest() throws Exception {
        //given
        Guest guest = new Guest(
                "Imran",
                "Khan",
                "ooj@gmail.com"
        );
        //when
        ResultActions resultActions = mockMvc
                .perform(post("/api/v1/guests")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    objectMapper.writeValueAsString(guest)
                ));
        //then

        resultActions.andExpect(status().isOk());
       List<Guest> guests = guestRepository.findAll();
       assertThat(guests).usingElementComparatorIgnoringFields("id")

               .contains(guest);
    }
}

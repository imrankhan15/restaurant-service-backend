package com.amigoscode.amigosservices.guest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

class GuestServiceTest {

    @Mock private GuestRepository guestRepository;
    private RestTemplate restTemplate;
    private GuestService underTest;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new GuestService(guestRepository, restTemplate);

    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
    @Test
    void canGetAllGuests() {
        //when
        underTest.getAllGuests();
        //then
        verify(guestRepository).findAll();
    }

    @Test

    void canAddGuest() {
        // given
        Guest guest = new Guest("yxcydz","dsdf","sdfsdf");
        // when
        underTest.addGuest(guest);

        //then
        ArgumentCaptor<Guest> guestArgumentCaptor = ArgumentCaptor.forClass(Guest.class);
        verify(guestRepository).save(guestArgumentCaptor.capture());

        Guest guest2 = guestArgumentCaptor.getValue();

        assertThat(guest2).isEqualTo(guest);


    }

    @Test
    @Disabled
    void registerGuest() {
    }
}
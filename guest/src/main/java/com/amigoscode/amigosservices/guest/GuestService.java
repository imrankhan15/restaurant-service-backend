package com.amigoscode.amigosservices.guest;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;
    private final RestTemplate restTemplate;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public void addGuest(Guest guest) {
        // check if email is taken
        guestRepository.save(guest);
    }

    public void registerGuest(Guest guest) {

        guestRepository.saveAndFlush(guest);
/*
       TableCheckResponse tableCheckResponse = restTemplate.getForObject(
                "http://localhost:8082/api2/v1/table-check/{guestId}",
                TableCheckResponse.class,
                guest.getId()
        );

        if (tableCheckResponse.isRegistered()) {
            System.out.println("You are given a table");
        }
        else {
            // need to comment this line to run the integration test

          //  throw new IllegalStateException("You are registered but no table assigned. Please create a new Table");
        }

*/


    }
}

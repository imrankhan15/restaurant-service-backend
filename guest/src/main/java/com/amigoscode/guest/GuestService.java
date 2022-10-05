package com.amigoscode.guest;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;
    private final RestTemplate restTemplate;

    public void registerGuest(GuestRegistrationRequest request) {
        Guest guest = Guest.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        guestRepository.saveAndFlush(guest);
        // todo: check if fraudster
       TableCheckResponse tableCheckResponse = restTemplate.getForObject(
                "http://localhost:8082/api/v1/table-check/{guestId}",
                TableCheckResponse.class,
                guest.getId()
        );

        if (tableCheckResponse.isRegistered()) {
            System.out.println("You are given a table");
        }
        else {
            System.out.println("No table available");
        }



    }
}

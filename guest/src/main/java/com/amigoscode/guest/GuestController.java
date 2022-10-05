package com.amigoscode.guest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/guests")
@AllArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @PostMapping
    public void registerGuest(@RequestBody GuestRegistrationRequest guestRegistrationRequest) {
        log.info("new guest registration {}", guestRegistrationRequest);
        guestService.registerGuest(guestRegistrationRequest);
    }
}

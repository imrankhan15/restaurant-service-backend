package com.restaurantbackend.restaurantservices.guest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/guests")
@AllArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }


    @PostMapping
    public void registerGuest(@RequestBody Guest guest) {


        // guestService.addGuest(guest);
        guestService.registerGuest(guest);
    }
}

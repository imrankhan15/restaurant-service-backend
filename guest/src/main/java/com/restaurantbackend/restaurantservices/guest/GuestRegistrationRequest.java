package com.restaurantbackend.restaurantservices.guest;

public record GuestRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}

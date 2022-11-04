package com.amigoscode.amigosservices.guest;

public record GuestRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}

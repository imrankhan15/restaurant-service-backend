package com.amigoscode.guest;

public record GuestRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}

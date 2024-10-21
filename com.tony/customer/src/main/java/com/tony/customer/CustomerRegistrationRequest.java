package com.tony.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
)
        {
}

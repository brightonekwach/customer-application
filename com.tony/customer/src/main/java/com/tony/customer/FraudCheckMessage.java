package com.tony.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class FraudCheckMessage {
    private Integer customerId;
}

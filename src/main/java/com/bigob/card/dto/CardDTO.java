package com.bigob.card.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
	 private Long cardId;

    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits")
    private String mobileNumber;

    @NotEmpty(message = "Card number cannot be empty")
    private String cardNumber;

    @NotEmpty(message = "Card type cannot be empty")
    private String cardType;

    @NotEmpty(message = "PAN cannot be empty")
    @Pattern(
        regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$",
        message = "Invalid PAN format"
    )
    private String pan;

    @NotEmpty(message = "Aadhar cannot be empty")
    @Pattern(
        regexp = "^[0-9]{12}$",
        message = "Aadhar number should be 12 digits"
    )
    private String aadhar;

    @NotNull(message = "Total limits cannot be empty")
    private long totalLimit;
    
    @NotNull(message = "Amount used cannot be empty")
    private long amountUsed;
    
    @NotNull(message = "Available amount cannot be empty")
    private long availableAmount;
}

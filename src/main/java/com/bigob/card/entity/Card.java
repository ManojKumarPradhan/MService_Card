package com.bigob.card.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Card {
	@Column(name="card_id")
    @Id
    private Long cardId;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;
    
    @Column(name = "pan")
    private String pan;

    @Column(name = "aadhar")
    private String aadhar;

    @Column(name = "total_limit")
    private Long totalLimit;
    
    @Column(name = "amount_used")
    private long amountUsed;
    
    @Column(name = "available_amount")
    private long availableAmount;
    
}

package com.bigob.card.mapper;

import com.bigob.card.dto.CardDTO;
import com.bigob.card.entity.Card;

public class CardMapper {

    public static CardDTO mapToCardDTO(Card card, CardDTO cardDTO) {
        cardDTO.setCardId(card.getCardId());
        cardDTO.setMobileNumber(card.getMobileNumber());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setCardType(card.getCardType());
        cardDTO.setPan(card.getPan());
        cardDTO.setAadhar(card.getAadhar());
        cardDTO.setTotalLimit(card.getTotalLimit());
        cardDTO.setAmountUsed(card.getAmountUsed());
        cardDTO.setAvailableAmount(card.getAvailableAmount());

        return cardDTO;
    }

    public static Card mapToCard(CardDTO cardDTO, Card card) {
        card.setCardId(cardDTO.getCardId());
        card.setMobileNumber(cardDTO.getMobileNumber());
        card.setCardNumber(cardDTO.getCardNumber());
        card.setCardType(cardDTO.getCardType());
        card.setPan(cardDTO.getPan());
        card.setAadhar(cardDTO.getAadhar());
        card.setTotalLimit(cardDTO.getTotalLimit());
        card.setAmountUsed(cardDTO.getAmountUsed());
        card.setAvailableAmount(cardDTO.getAvailableAmount());

        return card;
    }
}
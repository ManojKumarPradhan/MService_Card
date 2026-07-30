package com.bigob.card.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.bigob.card.exception.CardAlreadyExistException;
import com.bigob.card.dto.CardDTO;
import com.bigob.card.entity.Card;
import com.bigob.card.mapper.CardMapper;
import com.bigob.card.repository.CardRepository;
import com.bigob.card.service.ICardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements ICardService { 
	
	private final CardRepository cardRepository;
	
	@Override
    public Long createCard(CardDTO cardDTO) {
        Card card = CardMapper.mapToCard(cardDTO, new Card());
        Optional<Card> existingCard = cardRepository.findByMobileNumber(card.getMobileNumber());
        if (existingCard.isPresent()) {
            throw new CardAlreadyExistException(
                "Card with mobile number " + card.getMobileNumber() + " already exists."
            );
        }
        Card savedCard = cardRepository.save(card);
        return savedCard.getCardId();
    }
}

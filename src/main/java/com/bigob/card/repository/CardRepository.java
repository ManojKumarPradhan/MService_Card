package com.bigob.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigob.card.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
	Optional<Card> findByMobileNumber(String mobileNumber);
}

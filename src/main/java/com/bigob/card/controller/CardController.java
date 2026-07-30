package com.bigob.card.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bigob.card.constants.CardConstants;
import com.bigob.card.dto.CardDTO;
import com.bigob.card.dto.ResponseDTO;
import com.bigob.card.dto.ResponseError;
import com.bigob.card.service.ICardService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/cards", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@Validated
public class CardController {
	
	private final ICardService cardService;
	
	@Operation(
			summary = "Create Account REST API",
			description = "REST API to create new Customer &  Account inside EazyBank"
	)

	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status CREATED"
	)
	@ApiResponse(
			responseCode = "500",
			description = "HTTP Status Internal Server Error",
			content = @Content(
					schema = @Schema(implementation = ResponseError.class)
			)
	)
	
	@PostMapping("/create")
	@RateLimiter(name = "postPutLimiter")
	public ResponseEntity<ResponseDTO<Long>> createAccount(@Valid @RequestBody CardDTO cardDTO) {
		Long cardId = cardService.createCard(cardDTO);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponseDTO.<Long>builder().statusCode(CardConstants.STATUS_201)
						.statusMessage(CardConstants.MESSAGE_201).body(cardId).build());
	}

}

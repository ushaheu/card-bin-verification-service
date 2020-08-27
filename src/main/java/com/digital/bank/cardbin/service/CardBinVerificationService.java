package com.digital.bank.cardbin.service;

import com.digital.bank.cardbin.entity.CardBinEntity;
import com.digital.bank.cardbin.helper.ListBinResponse;
import com.digital.bank.cardbin.helper.Payload;
import com.digital.bank.cardbin.repository.CardBinRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author ushaheu
 * @date 8/27/20 6:10 PM
 * @project card-bin-verification-service
 */
@Service
public class CardBinVerificationService {

    private CardBinRepository cardBinRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public CardBinVerificationService(CardBinRepository cardBinRepository, ObjectMapper objectMapper) {
        this.cardBinRepository = cardBinRepository;
        this.objectMapper = objectMapper;
    }

    @ServiceActivator(inputChannel = "input")
    public void createCardBin(Message<String> message) throws JsonProcessingException {
        Payload payload = objectMapper.readValue(message.getPayload(), Payload.class);
        Long cardBIN = payload.getCardBin();
        Optional<CardBinEntity> optionalCardBinEntity = cardBinRepository.findById(cardBIN);
        CardBinEntity cardBinEntity;
        if(optionalCardBinEntity.isPresent()) {
            cardBinEntity = optionalCardBinEntity.get();
            int hits = cardBinEntity.getHitCount() + 1;
            cardBinEntity.setHitCount(hits);
        } else {
            cardBinEntity = new CardBinEntity().setCardBin(payload.getCardBin())
                    .setBank(payload.getBank())
                    .setHitCount(1)
                    .setScheme(payload.getScheme())
                    .setType(payload.getType());
        }
        cardBinRepository.save(cardBinEntity);
    }

    public ListBinResponse listBin(int start, int limit) {
        ListBinResponse listBinResponse = null;
        Pageable paging = PageRequest.of(start, limit);
        Page<CardBinEntity> cardBinEntityList = cardBinRepository.findAll(paging);
        if(cardBinEntityList.hasContent()) {
            Map<String, Integer> payload = new HashMap<>();
            cardBinEntityList.get().forEach(cardBinEntity -> payload.put(String.valueOf(cardBinEntity.getCardBin()), cardBinEntity.getHitCount()));
            listBinResponse = new ListBinResponse().setSuccess(true)
                    .setStart(start)
                    .setLimit(limit)
                    .setSize(cardBinEntityList.getTotalPages())
                    .setPayload(payload);
        }
        return listBinResponse;
    }
}

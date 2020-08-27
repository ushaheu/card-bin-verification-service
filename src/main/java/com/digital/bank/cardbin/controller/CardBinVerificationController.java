package com.digital.bank.cardbin.controller;

import com.digital.bank.cardbin.helper.ListBinResponse;
import com.digital.bank.cardbin.service.CardBinVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ushaheu
 * @date 8/27/20 7:02 PM
 * @project card-bin-verification-service
 */
@RestController
public class CardBinVerificationController {

    private CardBinVerificationService cardBinVerificationService;

    @Autowired
    public CardBinVerificationController(CardBinVerificationService cardBinVerificationService) {
        this.cardBinVerificationService = cardBinVerificationService;
    }

    @GetMapping("/card-scheme/stats")
    public ListBinResponse listBinResponse(@RequestParam("start") int start, @RequestParam("limit") int limit) {
        return cardBinVerificationService.listBin(start, limit);
    }


}

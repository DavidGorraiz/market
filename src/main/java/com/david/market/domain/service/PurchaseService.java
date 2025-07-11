package com.david.market.domain.service;

import com.david.market.domain.Purchase;
import com.david.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> findAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clienyId) {
        return purchaseRepository.getByCLient(clienyId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}

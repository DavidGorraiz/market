package com.david.market.domain.repository;

import com.david.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByCLient(String clientId);
    Purchase save(Purchase purchase);
}

package com.david.market.persistence;

import com.david.market.domain.Purchase;
import com.david.market.domain.repository.PurchaseRepository;
import com.david.market.persistence.crud.CompraCrudRepository;
import com.david.market.persistence.entity.Compra;
import com.david.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByCLient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        if (compra.getIdCompra() != null || compra.getIdCompra() == 0) {
            compra.setIdCompra(null);
        }
        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}

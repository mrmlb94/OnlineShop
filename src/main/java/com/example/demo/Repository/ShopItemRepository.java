package com.example.demo.Repository;

import com.example.demo.Model.ShopItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepository extends MongoRepository<ShopItem, String> {
    // Spring provides all CRUD automatically.
}

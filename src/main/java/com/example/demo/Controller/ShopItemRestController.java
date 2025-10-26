package com.example.demo.Controller;

import com.example.demo.Model.ShopItem;
import com.example.demo.Repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ShopItemRestController {

    @Autowired
    private ShopItemRepository shopItemRepository;

    @GetMapping
    public List<ShopItem> getAllItems() {
        return shopItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopItem> getItem(@PathVariable String id) {
        return shopItemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShopItem> createItem(@RequestBody ShopItem item) {
        ShopItem saved = shopItemRepository.save(item);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopItem> updateItem(@PathVariable String id, @RequestBody ShopItem item) {
        if (!shopItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        item.setId(id);
        ShopItem updated = shopItemRepository.save(item);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        if (!shopItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        shopItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.demo.Controller;

import com.example.demo.Model.ShopItem;
import com.example.demo.Repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ShopItemController {

    @Autowired
    private ShopItemRepository shopItemRepository;

    @GetMapping
    public String listItems(Model model) {
        List<ShopItem> items = shopItemRepository.findAll();
        model.addAttribute("items", items);
        return "list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("shopItem", new ShopItem());
        return "create";
    }

    @PostMapping
    public String createItem(@ModelAttribute ShopItem item) {
        shopItemRepository.save(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        ShopItem item = shopItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item ID: " + id));
        model.addAttribute("shopItem", item);
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateItem(@PathVariable String id, @ModelAttribute ShopItem item) {
        item.setId(id);
        shopItemRepository.save(item);
        return "redirect:/items";
    }

    @PostMapping("/{id}/delete")
    public String deleteItem(@PathVariable String id) {
        shopItemRepository.deleteById(id);
        return "redirect:/items";
    }

    @GetMapping("/{id}")
    public String viewItem(@PathVariable String id, Model model) {
        ShopItem item = shopItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item ID: " + id));
        model.addAttribute("shopItem", item);
        return "view";
    }
}

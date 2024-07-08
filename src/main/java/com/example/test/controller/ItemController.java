package com.example.test.controller;

import com.example.test.dto.ItemRequestDto;
import com.example.test.dto.DeleteResponseDto;
import com.example.test.entity.Item;
import com.example.test.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    private final ItemService itemService;

    @PostMapping("/post")
    public Item saveItem(
            @RequestBody ItemRequestDto itemRequestDto
    ) {
        return itemService.saveItem(itemRequestDto);
    }

    @GetMapping("/post/{id}")
    public Item getItemById(
            @PathVariable Long id
    ) {
        return itemService.getItemById(id);
    }

    @GetMapping("/post")
    public List<Item> getItemList() {
        return itemService.getItemList();
    }

    @PutMapping("/post/{id}")
    public Item updateItem(
            @PathVariable Long id,
            @RequestBody ItemRequestDto itemRequestDto
    ) {
        return itemService.updateItem(id, itemRequestDto);
    }

    @DeleteMapping("/post/{id}")
    public DeleteResponseDto deleteItem(
            @PathVariable Long id
    ) {
        itemService.deleteItem(id);
        return new DeleteResponseDto("삭제완료");
    }
}

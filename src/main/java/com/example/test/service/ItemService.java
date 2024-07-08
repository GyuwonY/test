package com.example.test.service;

import com.example.test.dto.ItemRequestDto;
import com.example.test.entity.Item;
import com.example.test.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public Item saveItem(ItemRequestDto itemRequestDto) {
        return itemRepository.save(new Item(
                null,
                itemRequestDto.getTitle(),
                itemRequestDto.getContent(),
                itemRequestDto.getPrice(),
                itemRequestDto.getUsername()
        ));
    }


    public Item getItemById (Long id) {
        return itemRepository.findById(id).orElseThrow();
    }

    public List<Item> getItemList() {
        return itemRepository.findAll();
    }

    @Transactional
    public Item updateItem (
            Long id,
            ItemRequestDto itemRequestDto
    ) {
        Item item = itemRepository.findById(id).orElseThrow();

        item.setContent(itemRequestDto.getContent());
        item.setTitle(itemRequestDto.getTitle());
        item.setPrice(itemRequestDto.getPrice());
        item.setUsername(itemRequestDto.getUsername());

        return item;
    }

    public void deleteItem (Long id) {
        itemRepository.deleteById(id);
    }
}

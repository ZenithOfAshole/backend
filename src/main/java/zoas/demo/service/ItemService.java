package zoas.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoas.demo.domian.Category;
import zoas.demo.domian.Item;
import zoas.demo.repository.ItemRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    public final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> findItemsByCategoryId(Long categoryId){ //category별 item list 불러오기

        return itemRepository.findByCategory(categoryId);
    }

    public Item findOne(Long itemId){ //item 정보 불러오기
        return itemRepository.findOne(itemId);
    }





}

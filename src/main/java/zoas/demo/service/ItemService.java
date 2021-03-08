package zoas.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoas.demo.domian.Item;
import zoas.demo.repository.ItemRepository;
import zoas.demo.repository.UserRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {

    public final ItemRepository itemRepository;

    //좋아요 레파지토리
 //   private final Like
    private final UserRepository userRepository;



    ItemService(final ItemRepository itemRepository,final UserRepository userRepository){
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }


    public List<Item> findItemsByCategoryId(Long categoryId){ //category별 item list 불러오기

        return itemRepository.findByCategory(categoryId);
    }

//    public DefaultRes findCategoryItemsByLike(final int categoryId, final int curId){
//
//        return DefaultRes.res()
//    }

    public Item findOne(Long itemId){ //item 정보 불러오기
        return itemRepository.findOne(itemId);
    }





}

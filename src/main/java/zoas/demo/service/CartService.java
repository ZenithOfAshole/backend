package zoas.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoas.demo.domian.*;
import zoas.demo.repository.CartRepository;
import zoas.demo.repository.ItemRepository;
import zoas.demo.repository.TokenRepository;
import zoas.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class CartService {

    Logger logger  = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final ItemRepository itemRepository;
    //cart 목록 불러오기

    private final CartItem cartItem;


    @Transactional
    public Cart findCart(String token){

        Token tokenVO = tokenRepository.findByTokenValue(token);
        Long userId = tokenVO.getUser().getId();

        return cartRepository.findByUserId(userId);

    }
    // 첫 아이템 넣으면서 카트 생성
    public Cart insertItemToCart(String token, Long ItemId, int count){//count = 주문 량
        Token tokenVO =  tokenRepository.findByTokenValue(token);
        Long userId = tokenVO.getUser().getId();

        logger.info(ItemId.toString());

        Item item = itemRepository.findItemById(ItemId);

        User user = userRepository.findUserById(userId);

        CartItem cartItem = CartItem.createCartItem(item, item.getPrice(),count);

        Cart cart =  Cart.createCart(user,cartItem);

        cartRepository.save(cart);

        return cart;
    }

    @Transactional
    public void cancelCart(Long userId){ // cart 취소
       cartRepository.deleteByUserId(userId);
    }



}

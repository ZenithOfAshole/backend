package zoas.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoas.demo.domian.Cart;
import zoas.demo.domian.CartItem;
import zoas.demo.repository.CartRepository;
import zoas.demo.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    //cart 목록 불러오기
    @Transactional
    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }

   // public List<CartItem> findCartItem(){

  //  }

    @Transactional
    public void cancelCart(Long cartId){
        Cart cart = cartRepository.findCart(cartId);

    }



}

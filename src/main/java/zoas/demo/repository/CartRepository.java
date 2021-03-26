package zoas.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.Cart;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    @Autowired
    private final EntityManager em;

    public void save(Cart cart){
        em.persist(cart);
    }

    public Cart findCart(Long id){
        //회원에 맞는 장바구니 가져오기
        return em.find(Cart.class,id);
    }

    private void deleteCart(Cart cart){
        em.remove(cart);
    }


}

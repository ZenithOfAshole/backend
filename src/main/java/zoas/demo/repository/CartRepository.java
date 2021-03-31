package zoas.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.Cart;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

    void deleteByUserId(Long userId); // 장바구니 전체 취소

    Cart findByUserId(Long userId);

    void deleteByUserIdAndItemId(Long userId, Long ItemId); // 장바구니에서 하나 지우는 거






}

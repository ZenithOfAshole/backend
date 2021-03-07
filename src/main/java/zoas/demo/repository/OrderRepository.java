package zoas.demo.repository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    @Autowired
    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

//    public Order findByUserId(){
//
//    }
}

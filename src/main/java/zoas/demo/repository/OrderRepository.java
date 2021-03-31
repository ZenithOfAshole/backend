package zoas.demo.repository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.Order;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {



  Optional<Order> findById(Long orderId);


}

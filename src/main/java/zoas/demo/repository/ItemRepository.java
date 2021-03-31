package zoas.demo.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.Item;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    Page<Item> finAll(Pageable pageable);

    Item findItemById(Long id);

    List<Item> findItemByCategory(Long CategoryId);

}

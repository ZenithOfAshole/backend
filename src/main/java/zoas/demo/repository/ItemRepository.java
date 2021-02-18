package zoas.demo.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.Item;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    @Autowired
    private  EntityManager em;

    public void save(Item item){
        if(item.getId() == null){
            //item 이 처음 jpa에 저장될 때까지 id를 가지고 저장하지 않는다.
            em.persist(item);
        }else{
            em.merge(item);
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class,id);
    }

    public List<Item> findByCategory(Long categoryId){  //카테고리별 아이템 불러오기
        return em.createQuery("select i from Item  i where i.categories = :categoryId ",Item.class)
                .setParameter("categoryId",categoryId)
                .getResultList();
    }

    public List<Item> findByName(String name){ // 이름으로 찾기
        return em.createQuery("select i from Item i where i.name like :name",Item.class)
                .setParameter("name",name)
                .getResultList();
    }
}

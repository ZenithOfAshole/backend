package zoas.demo.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import zoas.demo.domian.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private EntityManager em;

    public UserRepository(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id){
        return em.find(User.class,id);
    }

    public User findByEmail(String email ){
        return em.createQuery("select u from User u where u.email =:email",User.class)
                .setParameter("email",email)
                .getSingleResult();
    }


}

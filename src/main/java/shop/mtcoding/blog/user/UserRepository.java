package shop.mtcoding.blog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public User save(User user) {
        em.persist(user);

        return user;
    }

    public User findById(Integer id) {
        User user = em.find(User.class, id);

        return user;
    }

    public List<User> findAll() {
        Query query = em.createQuery("SELECT u FROM User u ORDER BY u.id DESC");

        return query.getResultList();
    }

    public User updateById(Integer id, UserRequest.UpdateDTO requestDTO) {
        User user = findById(id);
        user.update(requestDTO);

        return user;
    }
    public void deleteById(Integer id) {
        User user = findById(id);

        em.remove(user);
    }
}

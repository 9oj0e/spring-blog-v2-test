package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    @Transactional
    public void save(BoardRequest.saveDTO reqDTO) {
        Query query = em.createNativeQuery("insert into board_tb (title, content, created_at) values (?, ?, now())");
        query.setParameter(1, reqDTO.getTitle());
        query.setParameter(2, reqDTO.getContent());
        query.executeUpdate();
    }
}

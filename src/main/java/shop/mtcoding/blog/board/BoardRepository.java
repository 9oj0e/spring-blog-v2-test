package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<Board> findAll() {
        Query query = em.createNativeQuery("select * from board_tb order by id desc", Board.class);
        return query.getResultList();
    }

    public Board findById(Integer id) {
        Query query = em.createNativeQuery("select * from board_tb where id = ?", Board.class);
        query.setParameter(1, id);
        return (Board) query.getSingleResult();
    }
}

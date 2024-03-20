package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;

    @Transactional
    public Board save(Board board) {
        em.persist(board);

        return board;
    }

    public Board findById(Integer id) {
        Board board = em.find(Board.class, id);

        return board;
    }

    public List<Board> findAll() {
        Query query = em.createQuery("SELECT b FROM Board b ORDER BY b.id DESC");

        return query.getResultList();
    }

    @Transactional
    public Board updateById(Integer id, BoardRequest.UpdateDTO requestDTO) {
        Board board = findById(id);
        board.update(requestDTO);

        return board;
    }

    @Transactional
    public void deleteById(Integer id) {
        Board board = findById(id);

        em.remove(board);
    }
}

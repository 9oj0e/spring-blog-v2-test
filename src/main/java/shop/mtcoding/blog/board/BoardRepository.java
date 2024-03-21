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
    public void upload(BoardRequest.UploadDTO reqDTO){
        String q = """
                insert into board_tb(title, username, content, created_at) values(?, ?, ?, now()); 
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, reqDTO.getTitle());
        query.setParameter(2, reqDTO.getUsername());
        query.setParameter(3, reqDTO.getContent());
        query.executeUpdate();
    }

    public List<Board> findAll(){
        String q = """
                select * from board_tb order by id desc
                """;
        Query query = em.createNativeQuery(q, Board.class);


        return query.getResultList();
    }
}

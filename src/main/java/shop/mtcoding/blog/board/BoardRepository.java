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
    public void update(int id, BoardRequest.UpdateDTO reqDTO){
        String q = """
                update board_tb set title = ?, content = ?, username = ? where id = ?;
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, reqDTO.getTitle());
        query.setParameter(2, reqDTO.getContent());
        query.setParameter(3, reqDTO.getUsername());
        query.setParameter(4, id);
        query.executeUpdate();
    }

    public Board findById(int id) {
        String q = """
                select * from board_tb where id = ?;
                """;
        Query query = em.createNativeQuery(q, Board.class);
        query.setParameter(1, id);

        return (Board)query.getSingleResult();
    }

    @Transactional
    public void deleteById(int id){
        String q = """
                delete from board_tb where id = ?;
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, id);
        query.executeUpdate();

    }

    public BoardResponse.DetailDTO detail(int id){
        String q = """
                select title, content, username from board_tb where id = ?; 
                """;

        Query query = em.createNativeQuery(q);
        query.setParameter(1, id);

        Object[] row = (Object[]) query.getSingleResult();
        BoardResponse.DetailDTO dto = new BoardResponse.DetailDTO();
        dto.setTitle((String)row[0]);
        dto.setContent((String)row[1]);
        dto.setUsername((String)row[2]);

        return dto;
    }

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

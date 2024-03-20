package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "board_tb")
@Data
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private Timestamp createdAt;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

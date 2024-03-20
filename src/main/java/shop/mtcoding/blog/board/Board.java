package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "board_tb")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
}

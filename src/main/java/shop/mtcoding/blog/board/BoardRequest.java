package shop.mtcoding.blog.board;

import lombok.Data;
import shop.mtcoding.blog.user.User;

public class BoardRequest {
    @Data
    public static class SaveDTO {
        private String username;
        private String title;
        private String content;

        public Board toEntity(User user) {
            return Board.builder()
                    .username(user.getUsername())
                    .title(this.title)
                    .content(this.title)
                    .build();
        }
    }
    @Data
    public static class UpdateDTO {
        private String title;
        private String content;
    }
}

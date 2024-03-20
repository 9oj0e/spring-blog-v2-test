package shop.mtcoding.blog.board;

import lombok.Data;

public class BoardRequest {

    @Data
    public static class saveDTO {
        private String title;
        private String content;

        public saveDTO(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public Board toEntity() {
            return new Board(title, content);
        }
    }

    @Data
    public static class UpdateDTO {
        private String title;
        private String content;

        public UpdateDTO(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }
}

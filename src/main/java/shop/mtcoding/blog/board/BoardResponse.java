package shop.mtcoding.blog.board;

import lombok.Data;

public class BoardResponse {

    @Data
    public static class DetailDTO{
        private String title;
        private String username;
        private String content;
    }

    @Data
    public static class UpdateDTO{
        private String title;
        private String username;
        private String content;
    }
}

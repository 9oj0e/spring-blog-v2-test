package shop.mtcoding.blog.user;

import lombok.Data;

public class UserRequest {
    @Data
    public class SaveDTO {
        private String username;
        private String password;
        private String email;
        public User toEntity() {
            return User.builder()
                    .username(this.username)
                    .password(this.password)
                    .email(this.email)
                    .build();
        }
    }
    @Data
    public class UpdateDTO {
        private String username;
        private String password;
        private String email;
    }
}

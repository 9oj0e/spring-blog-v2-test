package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final HttpSession session;
    private final UserRepository userRepository;

    @GetMapping("/join-form")
    public String joinForm() {

        return "user/join-form";
    }

    @PostMapping("/join")
    public String join(UserRequest.SaveDTO requestDTO) {
        userRepository.save(requestDTO.toEntity());

        return "redirect:/";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {
        User sessionUser = userRepository.findByUsernameAndPassword(requestDTO);
        session.setAttribute("sessionUser", sessionUser);

        return "redirect:/";
    }

    @GetMapping("/user/{id}/update-form")
    public String updateForm(@PathVariable Integer id, HttpServletRequest request) {
        User user = userRepository.findById(id);
        request.setAttribute("user", user);

        return "redirect:/";
    }

    @PostMapping("/user/{id}/update")
    public String update(@PathVariable Integer id, UserRequest.UpdateDTO requestDTO) {
        userRepository.updateById(id, requestDTO);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();

        return "redirect:/";
    }
}

package shop.mtcoding.blog.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {


    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @PostMapping("/board/save")
    public String save() {
        return "board/save-form";
    }

    @GetMapping("/" )
    public String index() {
        return "index";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer id) {
        return "board/detail";
    }

    @GetMapping("/board/{id}/update-form")
    public String updateForm() {
        return "board/save-form";
    }

    @PostMapping("/board/{id}/save")
    public String update() {
        return "board/";
    }

    @PostMapping("/board/{id}/delete")
    public String delete() {
        return "redirect:/";
    }

}

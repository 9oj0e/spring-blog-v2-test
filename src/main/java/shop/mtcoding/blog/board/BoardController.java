package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("/" )
    public String index(HttpServletRequest request) {
        List<Board> boardList = boardRepository.findAll();
        request.setAttribute("boardList", boardList);
        return "index";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @PostMapping("/board/save")
    public String save(BoardRequest.saveDTO reqDTO) {
        boardRepository.save(reqDTO);
        return "redirect:/";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer id) {
        return "board/detail";
    }
}

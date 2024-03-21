package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardRepository boardRepository;

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable int id, BoardRequest.UpdateDTO reqDTO){
        boardRepository.update(id, reqDTO);
        return "redirect:/board/" + id;
    }

    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable int id, HttpServletRequest request){
        Board board = boardRepository.findById(id);

        request.setAttribute("board", board);
        return "/board/update-form";
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable int id){
        boardRepository.deleteById(id);

        return "redirect:/";
    }

    @PostMapping("/board/save")
    public String upload(BoardRequest.UploadDTO reqDTO){
        boardRepository.upload(reqDTO);

        return "redirect:/";
    }

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

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) {
        BoardResponse.DetailDTO dto = boardRepository.detail(id);
        request.setAttribute("boardDetail", dto);

        return "board/detail";
    }
}

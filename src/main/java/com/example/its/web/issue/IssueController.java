package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import com.example.its.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // このクラスがWebコントローラーとして機能することをSpringに示すアノテーション
@RequestMapping("/issues") // このコントローラーが処理するリクエストの共通パスを指定するアノテーション
@RequiredArgsConstructor // finalフィールドに対して必須のコンストラクタを自動生成するアノテーション
public class IssueController {

    private final IssueService issueService; // IssueServiceへの参照

    // 全てのIssueをリストで表示するメソッド
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("issueList", issueService.findAll());
        return "/issues/list"; // テンプレートエンジンにより解釈されるビュー名
    }

    // Issue作成フォームを表示するメソッド
    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form){
        return "issues/creationForm"; // Issue作成フォームのビュー名
    }

    // Issueを作成するメソッド
    @PostMapping
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return showCreationForm(form); // エラーがある場合、フォームを再表示
        }
        issueService.create(form.getSummary(), form.getDescription()); // Issueをデータベースに保存
        return "redirect:/issues"; // Issueリストページへのリダイレクト
    }

    // 特定のIssueの詳細を表示するメソッド
    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model){
        model.addAttribute("issue", issueService.findById(issueId)); // 特定のIssueを取得してモデルに追加
        return "issues/detail"; // Issue詳細ページのビュー名
    }
}

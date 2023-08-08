package com.example.its.web.issue;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data // Lombokライブラリが自動でgetter, setterなどの一般的なメソッドを生成するためのアノテーション
public class IssueForm {

    @NotBlank // このフィールドが空白でないことを検証するアノテーション
    @Size(max=256) // このフィールドのサイズが最大256文字であることを検証するアノテーション
    private String summary; // Issueの概要を表すフィールド

    @NotBlank // このフィールドが空白でないことを検証するアノテーション
    @Size(max=256) // このフィールドのサイズが最大256文字であることを検証するアノテーション
    private String description; // Issueの詳細説明を表すフィールド
}

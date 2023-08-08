package com.example.its.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;

// IssueEntityクラスは、Rubyにおけるモデルのような概念です。
// @AllArgsConstructor: このLombok注釈は、全フィールドを引数に持つコンストラクタを自動生成します。
// @Data: このLombok注釈は、フィールドのgetter、setter、equals、hashCode、toStringメソッドを自動生成します。

@AllArgsConstructor
@Data
public class IssueEntity {
    // 問題のユニークな識別子
    private long id;

    // 問題の簡単な情報またはタイトル
    private String summary;

    // 問題の詳細な説明
    private String description;
}

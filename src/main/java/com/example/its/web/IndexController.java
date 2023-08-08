package com.example.its.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // このクラスがコントローラークラスであると伝えているアノテーション
public class IndexController {
    // GET /
    // HTTP GETリクエストを特定のメソッドにマッピングするためのアノテーション
    // この場合、ルートURL ("/") へのリクエストを処理
    @GetMapping("/")
    // ハンドラーメソッドを定義（特定のURLにリクエストされた際に呼ばれる）
    // @ResponseBodyをつけることで、戻り値はHTTPレスポンスボディとしてクライアントに直接送信される（今回はテンプレートエンジンを利用するため不要）
    public String index() {
        return "index"; // "index"ビューを返す（通常はテンプレートエンジンで対応するHTMLファイルがレンダリングされる）
    }
}

package com.example.its;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Spring Bootアプリケーションであることを示し、設定を自動的に有効にするアノテーション
public class ItsApplication {

	public static void main(String[] args) {
		// SpringApplication.runメソッドは、Spring Bootアプリケーションを起動します。
		// 引数には、主要な設定クラスとコマンドライン引数を渡します。
		SpringApplication.run(ItsApplication.class, args);
	}

}

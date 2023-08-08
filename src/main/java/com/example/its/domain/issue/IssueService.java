package com.example.its.domain.issue;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // このクラスをSpringのサービスクラスとして登録します。サービスクラスはビジネスロジックを実装するためのものです。
@RequiredArgsConstructor // finalがついたフィールドから必須のコンストラクタを自動生成します。この場合、IssueRepositoryを引数に持つコンストラクタが生成されます。
public class IssueService {

    private final IssueRepository issueRepository; // IssueRepositoryへの参照。データベースへの操作を行うために使用します。

    public List<IssueEntity> findAll(){
        // IssueRepositoryを使ってissuesテーブルから全てのレコードを取得し、それらを返します。
        return issueRepository.findAll();
    }

    @Transactional // このメソッドがトランザクション内で実行されることを指定します。データベースへの変更が一連の操作として一緒に行われます。
    public void create(String summary, String description) {
        // IssueRepositoryのinsertメソッドを使用して、新しいレコードをissuesテーブルに挿入します。
        issueRepository.insert(summary, description);
    }

    public IssueEntity findById(long issueId) {
        // IssueRepositoryのfindByIdメソッドを使用して、指定されたIDを持つレコードをissuesテーブルから取得し、それを返します。
        return issueRepository.findById(issueId);
    }
}

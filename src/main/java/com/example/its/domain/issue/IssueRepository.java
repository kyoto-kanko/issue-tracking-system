package com.example.its.domain.issue;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // MyBatisのマッパーとしてこのインターフェイスを登録します。マッパーはデータベースへのクエリを実行するためのものです。
public interface IssueRepository {
    @Select("select * from issues") // issuesテーブルから全てのレコードを選択するSQLクエリを指定します。
    List<IssueEntity> findAll(); // 上記のクエリを実行し、issuesテーブルから全てのレコードを取得し、IssueEntityのリストとして返すメソッド

    @Insert("insert into issues (summary, description) values (#{summary}, #{description})") // issuesテーブルに新しいレコードを挿入するSQLクエリを指定します。パラメータのsummaryとdescriptionを使用します。
    void insert(String summary, String description); // 上記のクエリを実行し、新しいレコードをissuesテーブルに挿入するメソッド。引数は挿入する値。

    @Select("select * from issues where id = #{issuesId}") // issuesテーブルから特定のIDを持つレコードを選択するSQLクエリを指定します。
    IssueEntity findById(long issueId); // 上記のクエリを実行し、指定されたIDを持つレコードをissuesテーブルから取得し、IssueEntityとして返すメソッド
}

package org.example.chapter03.repository.session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.chapter03.domain.Comment;

import java.io.IOException;
import java.io.InputStream;

public class CommentSessionRepository {

    private SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public Comment selectCommentById(Long id) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()){
            String statement = "org.example.chapter03.repository.mapper.CommentMapper.selectCommentById";
            return sqlSession.selectOne(statement, id);
        }
    }

    public Integer insertComment(Comment comment) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = "org.example.chapter03.repository.mapper.CommentMapper.insertComment";
            int result = sqlSession.insert(statement, comment);

            if (result > 0) sqlSession.commit();
            return result;
        }
    }

    public Integer updateComment(Comment comment) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = "org.example.chapter03.repository.mapper.CommentMapper.updateComment";
            int result = sqlSession.update(statement, comment);

            if (result > 0) sqlSession.commit();
            return result;
        }
    }

    public Integer deleteCommentById(Long id) {
        try (SqlSession sqlSession = getSqlSessionFactory().openSession()) {
            String statement = "org.example.chapter03.repository.mapper.CommentMapper.deleteCommentById";
            int result = sqlSession.delete(statement, id);

            if (result > 0) sqlSession.commit();
            return result;
        }
    }

}
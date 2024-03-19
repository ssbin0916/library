package com.project.library.book;

import com.project.library.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BookDaoImpl implements BookDao {

    public SqlSessionFactory sqlSessionFactory;

    public BookDaoImpl() throws Exception {
        this.sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));

    }

    // 책 셍성
    @Override
    public int insert(Book book) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int rowCount = bookMapper.insert(book);
        sqlSession.close();
        return rowCount;
    }

    // 책 수정
    @Override
    public int update(Book book) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int rowCount = bookMapper.update(book);
        sqlSession.close();
        return rowCount;
    }

    // 책 삭제
    @Override
    public int delete(Long bIn) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int rowCount = bookMapper.delete(bIn);
        sqlSession.close();
        return rowCount;
    }

}

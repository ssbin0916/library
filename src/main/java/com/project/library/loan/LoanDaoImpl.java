package com.project.library.loan;

import com.project.library.mapper.LoanMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.Date;

public class LoanDaoImpl implements LoanDao {

    private SqlSessionFactory sqlSessionFactory;

    public LoanDaoImpl() throws Exception {
        this.sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"));
    }

    // 책 대여
    @Override
    public void rentBook(Long id, Long bId, Date rentDate) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        LoanMapper loanMapper = sqlSession.getMapper(LoanMapper.class);



        loanMapper.rentBook(id, bId, rentDate);
        sqlSession.close();
    }

    // 책 반납
    @Override
    public void returnBook(Long lId, Date returnDate) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        LoanMapper loanMapper = sqlSession.getMapper(LoanMapper.class);
        loanMapper.returnBook(lId, returnDate);
        sqlSession.close();
    }

    // 대여 기록
    @Override
    public boolean exists(Long lId) throws Exception {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            LoanMapper loanMapper = sqlSession.getMapper(LoanMapper.class);
            return loanMapper.exists(lId) > 0;
        }
    }

}

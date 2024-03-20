package com.project.library.mapper.loan;

import com.project.library.domain.loan.Loan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoanMapper {

    @Insert("INSERT INTO loan (id, book_id, member_id, rent_date) " +
            "VALUES (loan_id_SEQ.NEXTVAL, #{bookId}, #{memberId}, #{rentDate})")
    void rentBook(Loan loan);

    @Update("UPDATE loan SET return_date = #{returnDate} WHERE id = #{id}")
    void returnBook(Long id);

    @Select("SELECT COUNT(*) FROM loan WHERE id = #{id}")
    int exist(Long id);
}

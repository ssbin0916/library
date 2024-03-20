package com.project.library.domain.loan;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoanMapper {

    @Insert("INSERT INTO loan (id, book_id, member_id, rent_date" +
            "VALUES (loan_id_SEQ.NEXTVAL, #{bookId}, #{memberId}, #{rentDate})")
    void rentBook(Loan loan) throws Exception;

    @Update("UPDATE loan SET return_date = #{returnDate} WHERE id = #{id}")
    void returnBook(Long id) throws Exception;

    @Select("SELECT COUNT(*) FROM loan WHERE id = #{id}")
    int exists(Long id) throws Exception;
}

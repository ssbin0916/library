package com.project.library.domain.loan;

import com.project.library.domain.book.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoanMapper {

    @Insert("INSERT INTO loan (id, book_id, member_id, rent_date) VALUES (loan_id_seq.NEXTVAL, #{bookId}, #{memberId}, SYSDATE)")
    void rentBook(@Param("bookId") Long bookId, @Param("memberId") Long memberId);

    @Update("UPDATE loan SET return_date = SYSDATE WHERE book_id = #{bookId} AND member_id = #{memberId}")
    void returnBook(@Param("bookId") Long bookId, @Param("memberId") Long memberId);

    @Select("SELECT * FROM loan WHERE member_id = #{memberId}")
    List<Loan> findLoanedBooksByMemberId(Long memberId);

    @Select("SELECT COUNT(*) FROM loan WHERE book_id = #{bookId}")
    int countActiveLoansForBook(Long bookId);

    @Update("UPDATE book SET is_rented = 'Y' WHERE id = #{bookId}")
    void isRented(Long bookId);

    @Update("UPDATE book SET is_rented = 'N' WHERE id = #{bookId}")
    void isReturned(Long bookId);

}

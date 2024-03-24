package com.project.library.domain.loan;

import com.project.library.web.loan.LoanBookDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoanMapper {

    @Insert("INSERT INTO loan (id, book_id, member_id, rent_date) VALUES (loan_id_seq.NEXTVAL, #{bookId}, #{memberId}, SYSDATE)")
    void rentBook(@Param("bookId") Long bookId, @Param("memberId") Long memberId);

    @Update("UPDATE loan SET return_date = SYSDATE WHERE book_id = #{bookId} AND member_id = #{memberId}")
    void returnBook(@Param("bookId") Long bookId, @Param("memberId") Long memberId);

    @Update("UPDATE book SET is_rented = 'Y' WHERE id = #{bookId}")
    void isRented(Long bookId);

    @Update("UPDATE book SET is_rented = 'N' WHERE id = #{bookId}")
    void isReturned(Long bookId);

    @Select("SELECT b.id AS bookId, b.title, b.author, b.category, l.member_id AS memberId, " +
            "TO_CHAR(l.rent_date, 'YYYY-MM-DD HH24:MI:SS') AS rentDate, " +
            "TO_CHAR(l.return_date, 'YYYY-MM-DD HH24:MI:SS') AS returnDate " +
            "FROM loan l JOIN book b ON l.book_id = b.id " +
            "WHERE l.member_id = #{memberId} " +
            "ORDER BY l.rent_date DESC")
    List<LoanBookDTO> histories(Long memberId);

    @Delete("DELETE FROM loan WHERE id = #{id}")
    void delete(Long id);
}

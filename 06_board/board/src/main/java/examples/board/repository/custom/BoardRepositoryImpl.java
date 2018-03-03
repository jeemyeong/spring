package examples.board.repository.custom;


import com.querydsl.jpa.JPQLQuery;
import examples.board.entity.Board;
import examples.board.entity.QBoard;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

// BoardRepositoryCustom 를 구현한다.
// 설정파일에서 클래스 이름 규칙을 정한다.
public class BoardRepositoryImpl
        extends QueryDslRepositorySupport
        implements BoardRepositoryCustom {

    public BoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public List<Board> findBoardByTitle(String title) {
        QBoard qboard = QBoard.board;
        JPQLQuery query = from(qboard);
        query.where(qboard.title.like("%" + title + "%"));
        return query.fetch();
    }

    @Override
    public long updateReadCount(Long id, int readCount) {
        QBoard qboard = QBoard.board;
        return update(qboard).where(qboard.id.eq(id))
                .set(qboard.readCount, readCount + 1)
                .execute();
    }

    @Override
    public List<Board> findBoardByContent(String content) {
        QBoard qboard = QBoard.board;
        return from(qboard)
                .where(qboard.content
                .like("%" + content + "%"))
                .fetch();
    }
}

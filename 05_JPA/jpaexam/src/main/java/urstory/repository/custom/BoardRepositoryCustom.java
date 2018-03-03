package urstory.repository.custom;

import org.springframework.data.repository.NoRepositoryBean;
import urstory.entity.Board;

import java.util.List;

// QueryDSL을 이용하여 결과를 구하고자 할 때 메소드를 선언한다.
@NoRepositoryBean
public interface BoardRepositoryCustom {
    public List<Board> findBoardByTitle(String title);
    public long updateReadCount(Long id, int readCount);
    public List<Board> findBoardByContent(String content);
}

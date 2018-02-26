package urstory.repository.custom;

import org.springframework.data.repository.NoRepositoryBean;
import urstory.entity.Board;

import java.util.List;

@NoRepositoryBean
public interface BoardRepositoryCustom {
    public List<Board> findBoardByTitle(String title);
    public long updateReadCount(Long id, int readCount);
}

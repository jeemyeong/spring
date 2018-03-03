package urstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import urstory.entity.Board;
import urstory.repository.custom.BoardRepositoryCustom;

import java.util.List;

// Method Query를 사용하는 interface
@Repository
public interface BoardRepository
        extends JpaRepository<Board, Long>,
        JpaSpecificationExecutor<Board>,
        BoardRepositoryCustom {
    // select * from board where title like '%' + title + '%'
    public List<Board> findBoardByTitleContains(String title);
}

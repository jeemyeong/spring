package urstory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import urstory.entity.Board;
import urstory.repository.custom.BoardRepositoryCustom;

import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, JpaSpecificationExecutor<Board>, BoardRepositoryCustom {
    public List<Board> findBoardByTitleContains(String title);
}

package examples.board;

import examples.board.config.RootApplicationContextConfig;
import examples.board.entity.Board;
import examples.board.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = RootApplicationContextConfig.class)
})
//@Transactional
public class JpaTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void configTest(){
        assertTrue(true);
    }

    @Test
    public void insert(){

        Board board = new Board();
        board.setName("홍길동");
        board.setTitle("나는 어디로 가는가?");
        board.setContent("고길동은 내 친구입니다.");
        board.setRegdate(new Date());
        board.setReadCount(0);

        Board returnBoard = boardRepository.save(board);
        System.out.println(returnBoard.getId());
    }

    @Test
    public void getTitleContains(){
        List<Board> list = boardRepository.findBoardByTitleContains("어디로");
        for(Board board:list){
            System.out.println(board);
        }
    }
}


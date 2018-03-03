package urstory;

import static org.junit.Assert.*;

import jdk.nashorn.internal.runtime.ECMAException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import urstory.entity.Board;
import urstory.repository.BoardRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration("classpath:spring/applicationContext.xml")
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

        for(int i = 0; i < 3; i++) {
            Board returnBoard = boardRepository.save(board);
            System.out.println(returnBoard.getId());
        }
    }

    @Test
    public void getTitleContains(){
        List<Board> list = boardRepository.findBoardByTitleContains("어디로");
        for(Board board:list){
            System.out.println(board);
        }
    }
}


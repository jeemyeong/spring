package examples.guestbook.dao;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import examples.guestbook.config.ApplicationConfig;
import examples.guestbook.dto.Guestbook;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);
		
		//1. dao의 다른 메소드 부분은 주석문 처리하고 실행한다.
		Guestbook guestbook = new Guestbook();
		guestbook.setName("강경미");
		guestbook.setContent("반갑습니다. 여러분.");
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);
		System.out.println("id : " + id);
		
		//2. dao의 다른 메소드 부분은 주석문 처리하고 실행한다.
//		List<Guestbook> list = guestbookDao.selectAll(0, 5);
//		for(Guestbook g: list) {
//			System.out.println(g);
//		}
			
		//3. dao의 다른 메소드 부분은 주석문 처리하고 실행한다.
//		LogDao logDao = ac.getBean(LogDao.class);
//		Log log = new Log();
//		log.setIp("127.0.0.1");
//		log.setMethod("insert");
//		log.setRegdate(new Date());
//		logDao.insert(log);
	}
}

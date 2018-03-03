package examples.guestbook.service;

import java.util.Date;
import java.util.List;

import examples.guestbook.config.ApplicationConfig;
import examples.guestbook.dto.Guestbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GuestbookServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);
		
		//1. service의 다른 메소드 부분은 주석문 처리하고 실행한다.
		//2. Exception이 발생하도록 한 후 실행을 한다. 출력된 id에 해당하는 Guestbook이 없는 것을 알 수 있다.
		Guestbook guestbook = new Guestbook();
		guestbook.setName("강경미");
		guestbook.setContent("반갑습니다. 여러분.");
		guestbook.setRegdate(new Date());
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
		

		List<Guestbook> list = guestbookService.getGuestbooks(0);
		for(Guestbook g: list) {
			System.out.println(g);
		}
			

	}
}

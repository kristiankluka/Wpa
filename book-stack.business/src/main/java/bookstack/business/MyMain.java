package bookstack.business;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import bookstack.persistence.dao.BookDAO;

//@Startup
@Singleton
public class MyMain {
	
	@Inject
	private BookDAO bookDao;
	
	@Inject
	private BookService boi;
	
	@PostConstruct
	private void init() {
		System.out.println("MyMain initialization");
		//System.out.println("list size: "+bookDao.getBooksByTitle("example").size());
	}
	
	@Schedule(hour="9", minute="40")
	private void query() {
		// boi.createNew();
		System.out.println("list size: "+bookDao.getBooksByTitle("example").size());
	}

}

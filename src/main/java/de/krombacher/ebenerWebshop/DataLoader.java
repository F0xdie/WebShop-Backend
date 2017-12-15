//package de.krombacher.ebenerWebshop;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import de.krombacher.ebenerWebshop.domain.Article;
//import de.krombacher.ebenerWebshop.domain.Employee;
//import de.krombacher.ebenerWebshop.repository.ArticleRepository;
//import de.krombacher.ebenerWebshop.repository.EmployeeRepository;
//
//@Component
//public class DataLoader implements ApplicationRunner {
//
//	private EmployeeRepository userRepository;
//	private ArticleRepository articleRepository;
//
//	@Autowired
//	public DataLoader(EmployeeRepository userRepository, ArticleRepository articleRepository) {
//		this.userRepository = userRepository;
//		this.articleRepository = articleRepository;
//
//	}
//
//	public void run(ApplicationArguments args) {
//
//		Employee user = userRepository.findByPersNr("4711");
//		if (user == null) {
//
//			user.setFirstname("Markus");
//			user.setName("Kroll");
//			user.setPersNr("4711");
//			user.setMail("testmail@test.com");
//			user.setPhoneNr("0123123123");
//			user.setCostLocation("KIT");
//			userRepository.save(user);
//		}
//		Employee user1 = userRepository.findByPersNr("1000");
//		if (user1 == null) {
//			user1.setFirstname("Tim");
//			user1.setName("Taler");
//			user1.setPersNr("1000");
//			user1.setMail("testmail@test.com");
//			user1.setPhoneNr("0123123123");
//			user1.setCostLocation("KIT");
//			userRepository.save(user1);
//		}
//
//		Employee user2 = userRepository.findByPersNr("1001");
//		if (user2 == null) {
//			user2.setFirstname("Jens");
//			user2.setName("Vogt");
//			user2.setPersNr("1001");
//			user2.setMail("testmail@test.com");
//			user2.setPhoneNr("0123123123");
//			user2.setCostLocation("KIT");
//			userRepository.save(user2);
//		}
//
//		Employee user3 = userRepository.findByPersNr("1002");
//		if (user3 == null) {
//			user3.setFirstname("Markus");
//			user3.setName("Kroll");
//			user3.setPersNr("1002");
//			user3.setMail("testmail@test.com");
//			user3.setPhoneNr("0123123123");
//			user3.setCostLocation("KIT");
//			userRepository.save(user3);
//		}
//
//		Article article = articleRepository.findByArticleID(new Long(1));
//		if (article == null) {
//			article.setArticlenr(new Long(1));
//			article.setDescription("Ordner");
//			article.setEancode("ABD1sadsad23");
//			article.setSerialNr("1212222412");
//			article.setStock(553);
//			article.setStorageLocation("Lager1");
//			article.setVisible(true);
//			articleRepository.save(article);
//		}
//			Article article1 = articleRepository.findByArticleID(new Long(2));
//			if (article1 == null) {
//			article1.setArticlenr(new Long(2));
//			article1.setDescription("Buch");
//			article1.setEancode("ABDZAFSD123");
//			article1.setSerialNr("121212");
//			article1.setStock(50);
//			article1.setStorageLocation("Lager4");
//			article1.setVisible(true);
//			articleRepository.save(article1);
//			}
//			
//			Article article2 = articleRepository.findByArticleID(new Long(3));
//			if (article2 == null) {
//			article2.setArticlenr(new Long(3));
//			article2.setDescription("Papier");
//			article2.setEancode("ABGGGG123");
//			article2.setSerialNr("121212");
//			article2.setStock(1001);
//			article2.setStorageLocation("Lager6");
//			article2.setVisible(true);
//			articleRepository.save(article2);
//
//		}
//
//	}
//}

package org.java.lessons;

import java.time.LocalDate;

import org.java.lessons.db.pojo.Pizza;
import org.java.lessons.db.pojo.SpecialOffer;
import org.java.lessons.db.serv.PizzaService;
import org.java.lessons.db.serv.SpecialOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaMiaPizzeria1Application implements CommandLineRunner{
	
	@Autowired
	private PizzaService pServ;
	
	@Autowired
	private SpecialOfferService sor;
	
	public static void main(String[] args) {
		SpringApplication.run(LaMiaPizzeria1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		
		Pizza pizza1 = new Pizza("margherita", 6.50d,"https://it.ooni.com/cdn/shop/articles/Margherita-9920.jpg?crop=center&height=800&v=1644590028&width=800", "pomodoro, mozzarella");
		Pizza pizza2 = new Pizza("capricciosa", 8.00d,"https://www.pizzanapoletanadoc.it/wp-content/uploads/2019/04/capricciosa-pizza-napoletana-doc.jpg" , "pomodoro, mozzarella, prosciutto, carciofi, funghi");
		Pizza pizza3 = new Pizza("diavola", 7.50d, "https://www.negroni.com/sites/negroni.com/files/styles/scale__1440_x_1440_/public/pizza_rustica.jpg?itok=Lbp_jtZW", "pomodoro, mozzarella, salamino piccante");
		
		pServ.save(pizza1);
		pServ.save(pizza2);
		pServ.save(pizza3);
		
		SpecialOffer offerta1 = new SpecialOffer("sconto20", LocalDate.parse("2023-01-16") , LocalDate.parse("2023-12-16"), pizza3);
		SpecialOffer offerta2 = new SpecialOffer("sconto30", LocalDate.parse("2023-02-25") , LocalDate.parse("2023-12-16"), pizza2);
		SpecialOffer offerta3 = new SpecialOffer("autunno caldo", LocalDate.parse("2023-01-16") , LocalDate.parse("2023-12-16"), pizza2);
		SpecialOffer offerta4 = new SpecialOffer("meta' prezzo", LocalDate.parse("2023-01-16") , LocalDate.parse("2023-12-16"), pizza1);
		SpecialOffer offerta5 = new SpecialOffer("voglia d'estate", LocalDate.parse("2023-01-16") , LocalDate.parse("2023-12-16"), pizza1);
		
		sor.save(offerta1);
		sor.save(offerta2);
		sor.save(offerta3);
		sor.save(offerta4);
		sor.save(offerta5);
	}

}

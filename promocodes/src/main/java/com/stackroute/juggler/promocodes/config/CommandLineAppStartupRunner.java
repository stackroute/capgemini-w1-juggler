package com.stackroute.juggler.promocodes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.stackroute.juggler.promocodes.domain.Promocodes;
import com.stackroute.juggler.promocodes.repository.PromocodeRepository;

@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {

		PromocodeRepository promoRepository;
		
		@Autowired
		 public CommandLineAppStartupRunner(PromocodeRepository promoRepository) {
			
			this.promoRepository = promoRepository;
		}

		
		@Override
		public void run(String... args) throws Exception {
			
			
//			logger.info("Application started with command-line arguments: {} . "
//			 		+ "\n To kill this application, press Ctrl + C.", Arrays.toString(args));
			
			Promocodes promo1=new Promocodes(1, "FLAT100", "http://4.bp.blogspot.com/-A3aLFetzU34/VhVklMdjOcI/AAAAAAAAASs/xPSWi_SyPuk/s1600/Untitled1865-358x256.png", "It is applicable from 500Rs on Ticket", 100);
			Promocodes promo2=new Promocodes(2, "FLAT200","http://4.bp.blogspot.com/-A3aLFetzU34/VhVklMdjOcI/AAAAAAAAASs/xPSWi_SyPuk/s1600/Untitled1865-358x256.png" , "It is applicable from 1000Rs on ticket", 200);
			Promocodes promo3=new Promocodes(3, "FLAT50","http://4.bp.blogspot.com/-A3aLFetzU34/VhVklMdjOcI/AAAAAAAAASs/xPSWi_SyPuk/s1600/Untitled1865-358x256.png", "It is applicable from 300Rs on ticket", 50);
			Promocodes promo4=new Promocodes(4, "FLAT20", "http://4.bp.blogspot.com/-A3aLFetzU34/VhVklMdjOcI/AAAAAAAAASs/xPSWi_SyPuk/s1600/Untitled1865-358x256.png","It is applicable from 200Rs on ticket", 20);
//			Promocodes promo5=new Promocodes(5, "FLAT10", "http://4.bp.blogspot.com/-A3aLFetzU34/VhVklMdjOcI/AAAAAAAAASs/xPSWi_SyPuk/s1600/Untitled1865-358x256.png", "It is applicable from 100Rs on ticket", 10);
			promoRepository.save(promo1);
			promoRepository.save(promo2);
			promoRepository.save(promo3);
			promoRepository.save(promo4);
//			promoRepository.save(promo5);
		}
}

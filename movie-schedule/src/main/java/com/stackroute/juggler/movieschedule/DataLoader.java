package com.stackroute.juggler.movieschedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.stackroute.juggler.kafka.domain.MovieSchedule;
import com.stackroute.juggler.kafka.domain.Seats;
import com.stackroute.juggler.movieschedule.service.MovieScheduleService;

@Component
public class DataLoader implements ApplicationRunner{
	
	private MovieScheduleService movieScheduleService;

	// Constructor
	@Autowired
	public DataLoader(MovieScheduleService movieScheduleService) {
		this.movieScheduleService = movieScheduleService;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Integer> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		for(int i=0;i<10;i++){
//			list1[i]=new ArrayList<Integer>();
			list1.add(i);
			list2.add(i);
		}
		String[] typesOfSeats = {"Platnium", "Gold","Silver"};
		int[] noOfSeats = new int[]{10, 20, 30};
		int[] weekendsprice = new int[]{100, 20, 30};
		int[] weekdayprice = new int[]{10, 20, 30};
		Seats local = new Seats(10, 10, list1,list2);
		MovieSchedule local1 = new MovieSchedule("t1","Cinesquare Multiplex","theatre6@gmail.com","99, Shantinagar, Near IBP Petrol Pump,Uppal,East,Hyderabad-500060","Hyderabad","Cinesquare123","100",local,typesOfSeats,noOfSeats,"m1","Bad Boys","https://timesofindia.indiatimes.com/thumb/65715755.cms?width=219&height=317&imgsize=77504","Sanu Khan","Muzzamal Hussain","Saiful Islam","Drama","Bad Boys is an Assamese movie starring Sanu Khan, Muzammel Hussain and Parbin Rashid in prominent roles. It is a drama directed by Saiful Islam, forming part of the crew.","2D","Assamese","03:16:00","27/09/2018",2,"10:00,13:30",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local1);
		MovieSchedule local2 = new MovieSchedule("t2","GPR Multiplex","theatre7@gmail.com","3rd Floor,More Mega Mart Complex Kukatpally,Hyderabd-500092","Hyderabad","GPR123","100",local,typesOfSeats,noOfSeats,"m2","Mission Impossible- Fallout","https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/Mission-Impossible-FAllout-poster-45936823-600x889.jpg","Tom Cruise","Rebacca Ferguson","Cristopher McQuarie","Action","In the 6th installment of Mission: Impossible series As the IMF's best man Ethan Hunt's mission goes wrong, the credibility of the agency is questioned by the CIA and the world is faced with a catastrophic threat. Hunt takes it upon himself to save the world.","3D","English","02:28:00","27/09/2018",3,"10:00,13:00,17:00",weekendsprice, weekdayprice); 
		movieScheduleService.addMovieSchedule(local2);
		MovieSchedule local3 = new MovieSchedule("t3","Radhika Multiplex","theatre8@gmail.com","1-6-1,Sriram Nagar ColonyMain Road, ECIL,Kapra-500045","Hyderabad","Radhika123","100",local,typesOfSeats,noOfSeats,"m3","Gold","http://www.aajiraodisha.org/wp-content/uploads/2018/08/GoldMovie2018HDPosterImages.jpg","Akshay Kumar","Mouny Roy","Reema Kagti","Drama","A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.","2D","Hindi","02:33:00","26/09/2018",2,"09:00,17:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local3);
		MovieSchedule local4 = new MovieSchedule("t4","Cine Town","theatre9@gmail.com","Kishna Narsimha,Opposite Athidhi Restaurant, Miyapur, Hyderabad-500234","Hyderabad","Cine Town123","100",local,typesOfSeats,noOfSeats,"m4","96","https://moviegalleri.net/wp-content/uploads/2018/07/Trisha-Krishnan-Vijay-Sethupathi-96-Movie-New-Poster.jpg","Vijay Sethupatti","Trisha Krishnan","Prem Kumar","Drama","A heartwarming tale of romance that endures the test of time, 96 follows the story of Ram and Janu, and their shared destiny.","2D","Tamil","02:30:00","28/09/2018",4,"09:00,12:00,15:00,18:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local4);
		MovieSchedule local5 = new MovieSchedule("t5","Galaxy 70MM","theatre10@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Hyderabad-500345","Hyderabad","Galaxy123","100",local,typesOfSeats,noOfSeats,"m5","Nannu Dochukunduvate","https://timesofindia.indiatimes.com/thumb/64629084.cms?width=219&height=317&imgsize=87885","Suresh Babu","Nabha Natesha","R S Naidu","Romance","Ambitious, diligent and uncompromising, Karthik's dream is to land a job in the United States and climb up the corporate ladder. However, his life and priorities are about to turn upside down for the better with the arrival of a spirited and quirky girl named Siri.","2D","Telugu","02:29:00","27/09/2018",3,"11:00,14:00,17:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local5);
		MovieSchedule local6 = new MovieSchedule("t6","Milkyway Multiplex","theatre6@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345","Bangalore","Galaxy123","100",local,typesOfSeats,noOfSeats,"m1","Bad Boys","https://timesofindia.indiatimes.com/thumb/65715755.cms?width=219&height=317&imgsize=77504","Sanu Khan","Muzzamal Hussain","Saiful Islam","Drama","Bad Boys is an Assamese movie starring Sanu Khan, Muzammel Hussain and Parbin Rashid in prominent roles. It is a drama directed by Saiful Islam, forming part of the crew.","2D","Assamese","03:16:00","27/09/2018",2,"10:00,13:30",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local6);
		MovieSchedule local7 = new MovieSchedule("t7","Mars 70MM","theatre7@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345","Bangalore","Galaxy123","100",local,typesOfSeats,noOfSeats,"m2","Mission Impossible- Fallout","https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/Mission-Impossible-FAllout-poster-45936823-600x889.jpg","Tom Cruise","Rebacca Ferguson","Cristopher McQuarie","Action","In the 6th installment of Mission: Impossible series As the IMF's best man Ethan Hunt's mission goes wrong, the credibility of the agency is questioned by the CIA and the world is faced with a catastrophic threat. Hunt takes it upon himself to save the world.","3D","English","02:28:00","27/09/2018",3,"10:00,13:00,17:00",weekendsprice, weekdayprice); 
		movieScheduleService.addMovieSchedule(local7);
		MovieSchedule local8 = new MovieSchedule("t8","StackRoute 70MM","theatre8@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345","Bangalore","Galaxy123","100",local,typesOfSeats,noOfSeats,"m3","Gold","http://www.aajiraodisha.org/wp-content/uploads/2018/08/GoldMovie2018HDPosterImages.jpg","Akshay Kumar","Mouny Roy","Reema Kagti","Drama","A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.","2D","Hindi","02:33:00","26/09/2018",2,"09:00,17:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local8);
		MovieSchedule local9 = new MovieSchedule("t9","Lakshmi 4K","theatre9@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345","Bangalore","Galaxy123","100",local,typesOfSeats,noOfSeats,"m4","96","https://moviegalleri.net/wp-content/uploads/2018/07/Trisha-Krishnan-Vijay-Sethupathi-96-Movie-New-Poster.jpg","Vijay Sethupatti","Trisha Krishnan","Prem Kumar","Drama","A heartwarming tale of romance that endures the test of time, 96 follows the story of Ram and Janu, and their shared destiny.","2D","Tamil","02:30:00","28/09/2018",4,"09:00,12:00,15:00,18:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local9);
		MovieSchedule local10 = new MovieSchedule("t10","Sandhya 70MM","theatre10@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Bangalore-500345","Bangalore","Galaxy123","100",local,typesOfSeats,noOfSeats,"m5","Nannu Dochukunduvate","https://timesofindia.indiatimes.com/thumb/64629084.cms?width=219&height=317&imgsize=87885","Suresh Babu","Nabha Natesha","R S Naidu","Romance","Ambitious, diligent and uncompromising, Karthik's dream is to land a job in the United States and climb up the corporate ladder. However, his life and priorities are about to turn upside down for the better with the arrival of a spirited and quirky girl named Siri.","2D","Telugu","02:29:00","27/09/2018",3,"11:00,14:00,17:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local10);
		MovieSchedule local11 = new MovieSchedule("t11","Milkyway Multiplex","theatre6@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Chennai-500345","Chennai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m1","Bad Boys","https://timesofindia.indiatimes.com/thumb/65715755.cms?width=219&height=317&imgsize=77504","Sanu Khan","Muzzamal Hussain","Saiful Islam","Drama","Bad Boys is an Assamese movie starring Sanu Khan, Muzammel Hussain and Parbin Rashid in prominent roles. It is a drama directed by Saiful Islam, forming part of the crew.","2D","Assamese","03:16:00","27/09/2018",2,"10:00,13:30",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local11);
		MovieSchedule local12 = new MovieSchedule("t12","Mars 70MM","theatre7@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Chennai-500345","Chennai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m2","Mission Impossible- Fallout","https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/Mission-Impossible-FAllout-poster-45936823-600x889.jpg","Tom Cruise","Rebacca Ferguson","Cristopher McQuarie","Action","In the 6th installment of Mission: Impossible series As the IMF's best man Ethan Hunt's mission goes wrong, the credibility of the agency is questioned by the CIA and the world is faced with a catastrophic threat. Hunt takes it upon himself to save the world.","3D","English","02:28:00","27/09/2018",3,"10:00,13:00,17:00",weekendsprice, weekdayprice); 
		movieScheduleService.addMovieSchedule(local12);
		MovieSchedule local13 = new MovieSchedule("t13","StackRoute 70MM","theatre8@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Chennai-500345","Chennai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m3","Gold","http://www.aajiraodisha.org/wp-content/uploads/2018/08/GoldMovie2018HDPosterImages.jpg","Akshay Kumar","Mouny Roy","Reema Kagti","Drama","A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.","2D","Hindi","02:33:00","26/09/2018",2,"09:00,17:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local13);
		MovieSchedule local14 = new MovieSchedule("t14","Lakshmi 4K","theatre9@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Chennai-500345","Chennai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m4","96","https://moviegalleri.net/wp-content/uploads/2018/07/Trisha-Krishnan-Vijay-Sethupathi-96-Movie-New-Poster.jpg","Vijay Sethupatti","Trisha Krishnan","Prem Kumar","Drama","A heartwarming tale of romance that endures the test of time, 96 follows the story of Ram and Janu, and their shared destiny.","2D","Tamil","02:30:00","28/09/2018",4,"09:00,12:00,15:00,18:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local14);
		MovieSchedule local15 = new MovieSchedule("t15","Sandhya 70MM","theatre10@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Chennai-500345","Chennai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m5","Nannu Dochukunduvate","https://timesofindia.indiatimes.com/thumb/64629084.cms?width=219&height=317&imgsize=87885","Suresh Babu","Nabha Natesha","R S Naidu","Romance","Ambitious, diligent and uncompromising, Karthik's dream is to land a job in the United States and climb up the corporate ladder. However, his life and priorities are about to turn upside down for the better with the arrival of a spirited and quirky girl named Siri.","2D","Telugu","02:29:00","27/09/2018",3,"11:00,14:00,17:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local15);
		MovieSchedule local16 = new MovieSchedule("t16","Milkyway Multiplex","theatre6@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Mumbai-500345","Mumbai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m1","Bad Boys","https://timesofindia.indiatimes.com/thumb/65715755.cms?width=219&height=317&imgsize=77504","Sanu Khan","Muzzamal Hussain","Saiful Islam","Drama","Bad Boys is an Assamese movie starring Sanu Khan, Muzammel Hussain and Parbin Rashid in prominent roles. It is a drama directed by Saiful Islam, forming part of the crew.","2D","Assamese","03:16:00","27/09/2018",2,"10:00,13:30",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local16);
		MovieSchedule local17 = new MovieSchedule("t17","Mars 70MM","theatre7@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Mumbai-500345","Mumbai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m2","Mission Impossible- Fallout","https://cdn.flickeringmyth.com/wp-content/uploads/2018/07/Mission-Impossible-FAllout-poster-45936823-600x889.jpg","Tom Cruise","Rebacca Ferguson","Cristopher McQuarie","Action","In the 6th installment of Mission: Impossible series As the IMF's best man Ethan Hunt's mission goes wrong, the credibility of the agency is questioned by the CIA and the world is faced with a catastrophic threat. Hunt takes it upon himself to save the world.","3D","English","02:28:00","27/09/2018",3,"10:00,13:00,17:00",weekendsprice, weekdayprice); 
		movieScheduleService.addMovieSchedule(local17);
		MovieSchedule local18 = new MovieSchedule("t18","StackRoute 70MM","theatre8@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Mumbai-500345","Mumbai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m3","Gold","http://www.aajiraodisha.org/wp-content/uploads/2018/08/GoldMovie2018HDPosterImages.jpg","Akshay Kumar","Mouny Roy","Reema Kagti","Drama","A fictional retelling of an iconic moment in Indian history, the film revolves around the country's first Olympic gold win as an independent nation in 1948.","2D","Hindi","02:33:00","26/09/2018",2,"09:00,17:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local18);
		MovieSchedule local19 = new MovieSchedule("t19","Lakshmi 4K","theatre9@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Mumbai-500345","Mumbai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m4","96","https://moviegalleri.net/wp-content/uploads/2018/07/Trisha-Krishnan-Vijay-Sethupathi-96-Movie-New-Poster.jpg","Vijay Sethupatti","Trisha Krishnan","Prem Kumar","Drama","A heartwarming tale of romance that endures the test of time, 96 follows the story of Ram and Janu, and their shared destiny.","2D","Tamil","02:30:00","28/09/2018",4,"09:00,12:00,15:00,18:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local19);
		MovieSchedule local20 = new MovieSchedule("t20","Sandhya 70MM","theatre10@gmail.com","8-1-364/A, Brindhavan Colony,Tolichowki, West, Mumbai-500345","Mumbai","Galaxy123","100",local,typesOfSeats,noOfSeats,"m5","Nannu Dochukunduvate","https://timesofindia.indiatimes.com/thumb/64629084.cms?width=219&height=317&imgsize=87885","Suresh Babu","Nabha Natesha","R S Naidu","Romance","Ambitious, diligent and uncompromising, Karthik's dream is to land a job in the United States and climb up the corporate ladder. However, his life and priorities are about to turn upside down for the better with the arrival of a spirited and quirky girl named Siri.","2D","Telugu","02:29:00","27/09/2018",3,"11:00,14:00,17:00",weekendsprice,weekdayprice); 
		movieScheduleService.addMovieSchedule(local20);
	}

}

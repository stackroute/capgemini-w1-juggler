 package com.stackroute.juggler.payment.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.juggler.kafka.domain.TicketDetails;

@Repository
public interface PaymentRepository extends MongoRepository<TicketDetails, Integer> {

}

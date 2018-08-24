package com.stackroute.juggler.userprofile.domain;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserLikes {
	
	@Id
	private int userid;
	private String movie;

}

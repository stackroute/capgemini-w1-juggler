package com.stackroute.juggler.domain;
//pojo for show

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document(collection = "show")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
private String[] showTimings;

//@Override
//public String toString() {
//	return "Show [showTimings=" + Arrays.toString(showTimings) + "]";
//}



}

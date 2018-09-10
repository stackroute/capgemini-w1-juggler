package com.stackroute.juggler.showsheduler.domain;

public class TriggerMessage {

	private String TheatreName;
	private String DateToStop;
	private String SlotToStop;

	public TriggerMessage() {
	}

	public TriggerMessage(String theatreName, String dateToStop, String slotToStop) {
		TheatreName = theatreName;
		DateToStop = dateToStop;
		SlotToStop = slotToStop;
	}

	public String getTheatreName() {
		return TheatreName;
	}

	public void setTheatreName(String theatreName) {
		TheatreName = theatreName;
	}

	public String getDateToStop() {
		return DateToStop;
	}

	public void setDateToStop(String dateToStop) {
		DateToStop = dateToStop;
	}

	public String getSlotToStop() {
		return SlotToStop;
	}

	public void setSlotToStop(String slotToStop) {
		SlotToStop = slotToStop;
	}

}

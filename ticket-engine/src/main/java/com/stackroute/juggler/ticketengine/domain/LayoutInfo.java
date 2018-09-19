package com.stackroute.juggler.ticketengine.domain;

import java.util.List;

public class LayoutInfo {

	private int totalRows;
	private int totalCols;
	private List<Integer> rowValues;
	private List<Integer> colValues;

	public LayoutInfo() {
	}

	public LayoutInfo(int totalRows, int totalCols, List<Integer> rowValues, List<Integer> colValues) {
		super();
		this.totalRows = totalRows;
		this.totalCols = totalCols;
		this.rowValues = rowValues;
		this.colValues = colValues;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalCols() {
		return totalCols;
	}

	public void setTotalCols(int totalCols) {
		this.totalCols = totalCols;
	}

	public List<Integer> getRowValues() {
		return rowValues;
	}

	public void setRowValues(List<Integer> rowValues) {
		this.rowValues = rowValues;
	}

	public List<Integer> getColValues() {
		return colValues;
	}

	public void setColValues(List<Integer> colValues) {
		this.colValues = colValues;
	}

}

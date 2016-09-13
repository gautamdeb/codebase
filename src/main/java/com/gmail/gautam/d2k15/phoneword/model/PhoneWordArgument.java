package com.gmail.gautam.d2k15.phoneword.model;

public class PhoneWordArgument {
	private String dictonaryFile;
	private String inputDataFile;
	private String outputDataFile;

	public PhoneWordArgument(String dictonaryFile, String inputDataFile, String outputDataFile) {
		this.dictonaryFile = dictonaryFile;
		this.inputDataFile = inputDataFile;
		this.outputDataFile = outputDataFile;
	}

	public String getDictonaryFile() {
		return dictonaryFile;
	}

	public void setDictonaryFile(String dictonaryFile) {
		this.dictonaryFile = dictonaryFile;
	}

	public String getInputDataFile() {
		return inputDataFile;
	}

	public void setInputDataFile(String inputDataFile) {
		this.inputDataFile = inputDataFile;
	}

	public String getOutputDataFile() {
		return outputDataFile;
	}

	public void setOutputDataFile(String outputDataFile) {
		this.outputDataFile = outputDataFile;
	}

}

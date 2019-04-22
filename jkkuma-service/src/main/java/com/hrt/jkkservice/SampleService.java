package com.hrt.jkkservice;

public class SampleService {

	SampleServiceProcessor sampleServiceProcessor = new SampleServiceProcessor();

	public SampleOutput api01(SampleInput input) throws Exception {

		SampleOutput output = sampleServiceProcessor.api01().execute(input);

		return output;
	}
}

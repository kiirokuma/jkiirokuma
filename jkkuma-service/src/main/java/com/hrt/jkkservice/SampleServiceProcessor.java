package com.hrt.jkkservice;

import com.hrt.jkkservice.service.ServiceProcessor;

/**
 * @author kiirokuma
 *
 */
public class SampleServiceProcessor {

	SampleLogic sampleLogic = new SampleLogic();

	public ServiceProcessor<SampleInput, SampleOutput, SampleInput, SampleOutput> api01()
			throws Exception {

		ServiceProcessor<SampleInput, SampleOutput, SampleInput, SampleOutput> serviceProcessor = new ServiceProcessor<>();
		serviceProcessor
				.addInitial("Initial", (in, in2) -> {
					return sampleLogic.start(in);
				})
				.addValidation("Check1", (in) -> {
					sampleLogic.validation(in);
				})
				.addValidation("Check2", (in) -> {
					sampleLogic.validation(in);
				})
				.addExecution("Execuite", (in, out) -> {
					return sampleLogic.execution(in);
				})
				.addEnd("End", (in, out, in2, out2) -> {
					return sampleLogic.end(in, out);
				});

		return serviceProcessor;
	}

}

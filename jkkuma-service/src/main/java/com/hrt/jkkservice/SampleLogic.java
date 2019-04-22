package com.hrt.jkkservice;

import com.hrt.jkkservice.annotation.JkkmLogic;
import com.hrt.jkkservice.exceptiion.ServiceException;

/**
 * @author kiirokuma
 *
 */
@JkkmLogic
public class SampleLogic {

	public SampleInput start(final SampleInput in1) {
		System.out.println("start");
		return in1;
	}

	public void validation(final SampleInput input) throws ServiceException {
		System.out.println("validation");
	}

	public SampleOutput execution(final SampleInput input) throws ServiceException {
		System.out.println("execution");
		return new SampleOutput();
	}

	public SampleOutput end(final SampleInput input, final SampleOutput output) {
		System.out.println("end");
		SampleOutput result = new SampleOutput();
		result.meessage += "@end";
		return result;
	}


}

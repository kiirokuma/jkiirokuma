package com.hrt.jkkservice.service;

import java.util.ArrayList;
import java.util.List;

import com.hrt.jkkservice.exceptiion.ServiceException;
import com.hrt.jkkservice.task.ServiceEndTask;
import com.hrt.jkkservice.task.ServiceExecutionTask;
import com.hrt.jkkservice.task.ServiceInitialTask;
import com.hrt.jkkservice.task.ServiceValidationTask;

import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/**
 * @author kiirokuma
 *
 * @param <SVCINPUT>
 * @param <SVCOUTPUT>
 */
public class ServiceProcessor<APIINPUT, APIOUTPUT, SVCINPUT, SVCOUTPUT> {
	private List<Tuple2<String, ServiceInitialTask<APIINPUT, SVCINPUT>>> initialTasks = new ArrayList<>();
	private List<Tuple2<String, ServiceValidationTask<SVCINPUT>>> validationTasks = new ArrayList<>();
	private List<Tuple2<String, ServiceExecutionTask<SVCINPUT, SVCOUTPUT>>> executionTasks = new ArrayList<>();
	private List<Tuple2<String, ServiceEndTask<APIINPUT, APIOUTPUT, SVCINPUT, SVCOUTPUT>>> endTasks = new ArrayList<>();

	public ServiceProcessor<APIINPUT, APIOUTPUT, SVCINPUT, SVCOUTPUT> addInitial(String text,
			ServiceInitialTask<APIINPUT, SVCINPUT> task) {
		initialTasks.add(Tuples.of(text, task));
		return this;
	}

	public ServiceProcessor<APIINPUT, APIOUTPUT, SVCINPUT, SVCOUTPUT> addValidation(String text,
			ServiceValidationTask<SVCINPUT> task) {
		validationTasks.add(Tuples.of(text, task));
		return this;
	}

	public ServiceProcessor<APIINPUT, APIOUTPUT, SVCINPUT, SVCOUTPUT> addExecution(String text,
			ServiceExecutionTask<SVCINPUT, SVCOUTPUT> task) {
		executionTasks.add(Tuples.of(text, task));
		return this;
	}

	public ServiceProcessor<APIINPUT, APIOUTPUT, SVCINPUT, SVCOUTPUT> addEnd(String text,
			ServiceEndTask<APIINPUT, APIOUTPUT, SVCINPUT, SVCOUTPUT> task) {
		endTasks.add(Tuples.of(text, task));
		return this;
	}

	public APIOUTPUT execute(final APIINPUT apiinput) throws ServiceException {

		SVCINPUT svcinput = null;
		for (Tuple2<String, ServiceInitialTask<APIINPUT, SVCINPUT>> tuple : initialTasks) {
			svcinput = tuple.getT2().execute(apiinput, svcinput);
		}

		for (Tuple2<String, ServiceValidationTask<SVCINPUT>> tuple : validationTasks) {
			tuple.getT2().execute(svcinput);
		}

		SVCOUTPUT svcoutput = null;
		for (Tuple2<String, ServiceExecutionTask<SVCINPUT, SVCOUTPUT>> tuple : executionTasks) {
			svcoutput = tuple.getT2().execute(svcinput, svcoutput);
		}

		APIOUTPUT apioutput = null;
		for (Tuple2<String, ServiceEndTask<APIINPUT, APIOUTPUT, SVCINPUT, SVCOUTPUT>> tuple : endTasks) {
			apioutput = tuple.getT2().execute(apiinput, apioutput, svcinput, svcoutput);
		}

		return apioutput;
	}
}

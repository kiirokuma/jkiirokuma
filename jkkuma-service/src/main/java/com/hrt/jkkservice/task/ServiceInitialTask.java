package com.hrt.jkkservice.task;

/**
 * @author kiirokuma
 *
 * @param <APIINPUT>
 * @param <SVCINPUT>
 */
public interface ServiceInitialTask<APIINPUT,SVCINPUT> {

	SVCINPUT execute(final APIINPUT apiinput, final SVCINPUT svcinput);
}

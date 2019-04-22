package com.hrt.jkkservice.task;

/**
 * @author kiirokuma
 *
 * @param <APIINPUT>
 * @param <APIOUTPUT>
 * @param <SVCINPUT>
 * @param <SVCOUTPUT>
 */
public interface ServiceEndTask<APIINPUT,APIOUTPUT,SVCINPUT,SVCOUTPUT> {
	APIOUTPUT execute(final APIINPUT apiinput, final APIOUTPUT apioutput, final SVCINPUT svcinput, final SVCOUTPUT svcoutput);

}

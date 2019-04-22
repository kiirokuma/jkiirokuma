package com.hrt.jkkservice.task;

import com.hrt.jkkservice.exceptiion.ServiceException;

/**
 * @author kiirokuma
 *
 * @param <SVCINPUT>
 * @param <SVCOUTPUT>
 */
public interface ServiceExecutionTask<SVCINPUT, SVCOUTPUT> {
	SVCOUTPUT execute(final SVCINPUT svcinput, final SVCOUTPUT svcoutput) throws ServiceException;
}

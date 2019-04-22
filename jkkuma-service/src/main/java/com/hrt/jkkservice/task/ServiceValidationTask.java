package com.hrt.jkkservice.task;

import com.hrt.jkkservice.exceptiion.ServiceException;

/**
 * @author kiirokuma
 *
 * @param <SVCINPUT>
 */
public interface ServiceValidationTask<SVCINPUT> {

	void execute(final SVCINPUT input) throws ServiceException;
}

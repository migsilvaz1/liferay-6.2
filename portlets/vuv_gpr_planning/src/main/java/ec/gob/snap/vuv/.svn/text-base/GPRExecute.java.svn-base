/* 
* This file is part of the VUV Electronic Office of Government of Ecuador.
* Copyright 2015.
*/

/** 
 * <b>File:</b><p>ec.gob.snap.vuv.GPRExecute.java.</p>
 * <b>Description:</b><p> .</p>
 * <b>Project:</b><p>Platform of xxxxxxxxxx.</p>
 * <b>Date:</b><p>28/8/2015.</p>
 * @version 1.0, 28/8/2015.
 */
package ec.gob.snap.vuv;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskThreadLocal;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.model.BackgroundTask;


/** 
 * <p>Class .</p>
 * <b>Project:</b><p>xxxxxxxxxx</p>
 * @version 1.0, 28/8/2015.
 */
public class GPRExecute extends BaseBackgroundTaskExecutor{

	/**
	 * {@inheritDoc}
	 * @see com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor#execute(com.liferay.portal.model.BackgroundTask)
	 */
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTaskParam)
		throws Exception {

		SincroLogic.sincronize();
		Message message = new Message();

		// Background task id needs to be passed

		message.put("backgroundTaskId", BackgroundTaskThreadLocal.getBackgroundTaskId());

		// Pass all the necessary attributes here

		// Send it over the built-in Message Bus to the background task status
		// destination

		MessageBusUtil.sendMessage(DestinationNames.BACKGROUND_TASK_STATUS, message);
		BackgroundTaskResult result = new BackgroundTaskResult(0, "gpr-finish");
		return result;
	}

}

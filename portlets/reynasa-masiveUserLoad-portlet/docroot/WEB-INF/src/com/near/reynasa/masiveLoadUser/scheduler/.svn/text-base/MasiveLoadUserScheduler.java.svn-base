package com.near.reynasa.masiveLoadUser.scheduler;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.util.Locale;
import java.util.Map;



public class MasiveLoadUserScheduler implements MessageListener {
	
	public final void receive(final Message arg0) throws MessageListenerException{
		MasiveLoadUserSchedulerLogic.executePendingCSV();
	
	}
	
}

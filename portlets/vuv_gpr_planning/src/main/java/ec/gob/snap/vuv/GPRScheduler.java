
package ec.gob.snap.vuv;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * <p>Class that makes the sincronization scheduled.</p>
 * <b>Project:</b><p>vuv</p>
 * 
 * @version 1.0, 28/5/2015.
 */
public class GPRScheduler implements MessageListener {

	@Override
	public void receive(Message message)
		throws MessageListenerException {

		SincroLogic.sincronize();
	}
}

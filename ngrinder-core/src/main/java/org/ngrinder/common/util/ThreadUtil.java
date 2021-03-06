/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.ngrinder.common.util;

import static org.ngrinder.common.util.NoOp.noOp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread related utility.
 * 
 * @author JunHo Yoon
 * @since 3.0
 */
public abstract class ThreadUtil {

	private static final int RETRY_MILLISECOND = 5000;
	private static final int THREAD_WAITING_TIME = 5000;
	private static final Logger LOGGER = LoggerFactory.getLogger(ThreadUtil.class);

	/**
	 * Sleep in give millis without throwing exception.
	 * 
	 * @param millis
	 *            milisecond.
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			LOGGER.warn(e.getMessage(), e);
		}
	}

	/**
	 * Stop thread quietly.
	 * 
	 * @param thread
	 *            thread to be stop
	 * @param stopMaessage
	 *            message to be shown when stop thread forcely
	 */
	@SuppressWarnings("deprecation")
	public static void stopQuetly(Thread thread, String stopMaessage) {
		if (thread == null) {
			return;
		}
		// Wait 5000 second for natural death.
		try {
			thread.join(THREAD_WAITING_TIME);
		} catch (Exception e) {
			// Fall through
			noOp();
		}
		try {
			thread.interrupt();
		} catch (Exception e) {
			noOp();
		}
		try {
			// Again Wait 5000 second.
			thread.join(RETRY_MILLISECOND);
		} catch (Exception e) {
			// Fall through
			noOp();
		}
		try {
			// Force to Stop
			if (thread.isAlive()) {
				LOGGER.error(stopMaessage);
				thread.stop();
			}
		} catch (Exception e) {
			// Fall through
			noOp();
		}
	}

}

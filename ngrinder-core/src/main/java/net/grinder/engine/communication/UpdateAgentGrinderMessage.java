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
package net.grinder.engine.communication;

import net.grinder.communication.Message;

/**
 * Message for agent update.
 * 
 * @author JunHo Yoon
 * @since 3.0
 */
public class UpdateAgentGrinderMessage implements Message {

	private static final long serialVersionUID = 3218379141994562444L;
	private final String version;
	private final String downloadUrl;
	private final String fileName;

	/**
	 * Constructor.
	 * 
	 * @param fileName
	 *            fileName
	 * @param version
	 *            version
	 * @param downloadUrl
	 *            downloadUrl
	 */
	public UpdateAgentGrinderMessage(String fileName, String version, String downloadUrl) {
		this.version = version;
		this.downloadUrl = downloadUrl;
		this.fileName = fileName;
	}

	public String getVersion() {
		return version;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public String getFileName() {
		return fileName;
	}

}

/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.client.chat;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import mage.interfaces.ChatClient;
import mage.util.Logging;


/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public class ChatClientImpl implements ChatClient, Serializable {

	private final static Logger logger = Logging.getLogger(ChatClientImpl.class.getName());

	private JTextArea textArea;
	private String userName;
	private UUID clientId;

	public ChatClientImpl(String userName, JTextArea textArea) {
		this.clientId = UUID.randomUUID();
		this.textArea = textArea;
		try {
			this.userName = userName;
			UnicastRemoteObject.exportObject(this, 0);
		} catch (RemoteException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void receiveMessage(String message) throws RemoteException {
		this.textArea.append(message + "\n");
		textArea.setCaretPosition(textArea.getText().length() - 1);
	}

	@Override
	public String getName() throws RemoteException {
		return userName;
	}

	@Override
	public UUID getId() throws RemoteException {
		return clientId;
	}

	public UUID getIdLocal() {
		return clientId;
	}

}
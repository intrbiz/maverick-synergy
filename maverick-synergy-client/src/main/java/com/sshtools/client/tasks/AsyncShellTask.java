/**
 * (c) 2002-2019 JADAPTIVE Limited. All Rights Reserved.
 *
 * This file is part of the Maverick Synergy Java SSH API.
 *
 * Maverick Synergy is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Maverick Synergy is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.sshtools.client.tasks;

import com.sshtools.client.AsyncSessionChannel;
import com.sshtools.client.SshClientContext;
import com.sshtools.common.ssh.Connection;

public abstract class AsyncShellTask extends AbstractShellTask<AsyncSessionChannel> {

	public AsyncShellTask(Connection<SshClientContext> con) {
		super(con);
	}

	@Override
	protected void onOpenSession(AsyncSessionChannel session) {
	}

	@Override
	protected void onCloseSession(AsyncSessionChannel session) {
	}

	protected AsyncSessionChannel createSession(Connection<SshClientContext> con) {
		return new AsyncSessionChannel(
				con,
				con.getContext().getSessionMaxPacketSize(), 
				con.getContext().getSessionMaxWindowSize(),
				con.getContext().getSessionMaxWindowSize(),
				con.getContext().getSessionMinWindowSize(),
				future);
	}
}
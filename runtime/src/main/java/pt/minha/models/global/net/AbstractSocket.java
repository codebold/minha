/*
 * Minha.pt: middleware testing platform.
 * Copyright (c) 2011-2014, Universidade do Minho.
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package pt.minha.models.global.net;

import java.net.InetSocketAddress;
import java.net.SocketException;

public abstract class AbstractSocket {
	private InetSocketAddress local;
	protected NetworkStack stack;

	protected AbstractSocket(NetworkStack stack) {
		this.stack = stack;
	}
	
	protected AbstractSocket(NetworkStack stack, InetSocketAddress local) {
		this.stack = stack;
		this.local = local;
	}

	public void bind(InetSocketAddress addr) throws SocketException {
		if (local!=null)
			throw new SocketException("already bound");
		
		local = addr;
	}
	
	public InetSocketAddress getLocalAddress() {
		return local;
	}
	
	public NetworkStack getNetwork() {
		return stack;
	}
}

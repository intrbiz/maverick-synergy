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
package com.sshtools.common.events;

/**
 * Interface to be implemented by classes interested in receiving
 * events.
 * <p>
 * Listeners should be registered by using
 * EventService#addListener(EventListener).
 */
//NOT J2ME COMPLIANT AND SEEMINGLY NOT USEFUL public interface J2SSHEventListener extends EventListener {
public interface EventListener {

    /**
     * Invoked when an event occurs. 
     * 
     * @param evt event
     */
    public void processEvent(Event evt);

}
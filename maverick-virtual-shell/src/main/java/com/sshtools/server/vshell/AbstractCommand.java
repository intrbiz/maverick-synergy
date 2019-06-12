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
package com.sshtools.server.vshell;

import java.util.List;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public abstract class AbstractCommand implements Command {
	private String name;
	private Options options = new Options();
	private String subsystem;
	private String signature;
	private String description;
	private boolean builtIn = false;
	
	protected VirtualProcess process;
	
	protected int exitCode = 0;
	
	public AbstractCommand(String name, String subsystem) {
		this(name, subsystem, null);
	}

	public AbstractCommand(String name, String subsystem, String signature) {
		this(name, subsystem, signature, (Option[]) null);
	}
	
	public void init(VirtualProcess process) {
		this.process = process;
	}
	
	public boolean isHidden() {
		return false;
	}
	
	public VirtualProcess getProcess() {
		return process;
	}

	public int complete(String buffer, int cursor, List<String> candidates) {
		return 0;
	}

	public AbstractCommand(String name, String subsystem, String signature, Option... options) {
		this.name = name;
		this.subsystem = subsystem;
		this.signature = signature;
		if (options != null) {
			for (Option option : options) {
				this.options.addOption(option);
			}
		}
	}

	public String getName() {
		return name;
	}

	public boolean hasFixedOptions() {
		return true;
	}
	
	public Options getOptions() {
		return options;
	}

	public String getDescription() {
		return description;
	}

	public String getSubsystem() {
		return subsystem;
	}

	public String getCommandName() {
		return name;
	}

	public String getSignature() {
		return signature;
	}

	public List<String> getCollection(int i) throws Exception {
		return null;
	}

	public boolean isBuiltIn() {
		return builtIn;
	}

	protected void setBuiltIn(boolean builtIn) {
		this.builtIn = builtIn;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	protected void setSignature(String signature) {
		this.signature = signature;
	}

	protected void setDescription(String description) {
		this.description = description;
	}
	
	public int getExitCode() {
		return exitCode;
	}
}
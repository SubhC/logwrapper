/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eshark.logw.element;

/**
 * <TABLE BORDER="1" WIDTH="100%">
 * <TR>
 * <TH>Particulars</TH><TH>::</TH><TH>Details</TH>
 * </TR>
 * <TR>
 * <TD>Project Name</TD><TD>::</TD><TD>LogWrapper</TD>
 * </TR>
 * <TR>
 * <TD>File Name</TD><TD>::</TD><TD>LogElement.java</TD>
 * </TR>
 * <TR>
 * <TD>Created on</TD><TD>::</TD><TD>Nov 27, 2008 8:26:59 AM</TD>
 * </TR>
 * <TR>
 * <TD>@author</TD><TD>::</TD><TD><a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a></TD>
 * </TR>
 * <TR>
 * <TD>Purpose</TD><TD>::</TD><TD>A simple value object to hold the object message and the stacktrace to log</TD>
 * </TR>
 * <TR>
 * <TD COLSPAN=3></TD>
 * </TR>
 * </TABLE>
 *
 * <TABLE BORDER="1" WIDTH="100%">
 * <CAPTION>File Change History</CAPTION>
 * <TR>
 * <TH>Date</TH><TH>Description</TH>                    |
 * </TR>
 * <TR>
 * <TD>Nov 27, 2008</TD><TD>Created</TD>
 * </TR>
 * </TABLE>
 */
public class LogElement
{
	private String		mLogMessage	= null;
	private Throwable	mThrowable	= null;

	/**
	 * This creates LogElement
	 * @param aLogMessage
	 * @param aThrowable
	 */
	public LogElement(String aLogMessage, Throwable aThrowable)
	{
		mLogMessage = aLogMessage;
		mThrowable = aThrowable;
	}

	/**
	 * This creates LogElement
	 * @param aThrowable
	 */
	public LogElement(Throwable aThrowable)
	{
		mThrowable = aThrowable;
		mLogMessage = mThrowable.getMessage();
	}

	/**
	 * This creates LogElement
	 * @param aLogMessage
	 */
	public LogElement(String aLogMessage)
	{
		mLogMessage = aLogMessage;
	}

	/**
	 * This returns the value of logMesse of type String
	 * @return the logMesse
	 */
	public String getLogMessage()
	{
		return mLogMessage;
	}

	/**
	 * This sets the value of logMesse by aLogMesse
	 * @param aLogMesse the logMesse to set
	 */
	public void setLogMessage(String aLogMessage)
	{
		mLogMessage = aLogMessage;
	}

	/**
	 * This returns the value of throwable of type Throwable
	 * @return the throwable
	 */
	public Throwable getThrowable()
	{
		return mThrowable;
	}

	/**
	 * This sets the value of throwable by aThrowable
	 * @param aThrowable the throwable to set
	 */
	public void setThrowable(Throwable aThrowable)
	{
		mThrowable = aThrowable;
		if (mLogMessage != null)
			mLogMessage = mThrowable.getMessage();
	}
}
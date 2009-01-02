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

package org.eshark.logw.core;

import java.util.List;

import org.apache.log4j.spi.LoggerFactory;
import org.eshark.logw.element.LogElement;
import org.eshark.logw.element.LogListElement;

/**
 * <TABLE BORDER="1" WIDTH="100%">
 * <TR>
 * <TH>Particulars</TH><TH>::</TH><TH>Details</TH>
 * </TR>
 * <TR>
 * <TD>Project Name</TD><TD>::</TD><TD>LogWrapper</TD>
 * </TR>
 * <TR>
 * <TD>File Name</TD><TD>::</TD><TD>LogWFactory.java</TD>
 * </TR>
 * <TR>
 * <TD>Created on</TD><TD>::</TD><TD>Nov 18, 2008 5:26:36 PM</TD>
 * </TR>
 * <TR>
 * <TD>@author</TD><TD>::</TD><TD><a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a></TD>
 * </TR>
 * <TR>
 * <TD>Purpose</TD><TD>::</TD><TD>This Logger Factoy cater service to
 * all Logger classes and gives mechanism to create LogWLoggers. This 
 * also proves mechanism for factory logging.</TD>
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
 * <TD>Nov 18, 2008</TD><TD>Created</TD>
 * </TR>
 * </TABLE>
 */
public class LogWFactory implements LoggerFactory
{
	/* (non-Javadoc)
	 * @see org.apache.log4j.spi.LoggerFactory#makeNewLoggerInstance(java.lang.String)
	 * <br>Purpose to override <i>To give implementation for <code>makeNewLoggerInstance</code></i>
	 *
	 */
	public LogWLogger makeNewLoggerInstance(String aLoggerName)
	{
		if (aLoggerName == null || aLoggerName.trim().length() == 0)
			return null;
		return new LogWLogger(aLoggerName);
	}

	/**
	 * <BR>Introduced <strong>Nov 18, 2008 5:44:11 PM</strong>
	 * <BR>Purpose <i>To give implementation for <code>makeNewLoggerInstance with <code>Class</code> argument</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aClazz on whose name the logger is to be created
	 * @return LogWLogger an instance of the <code>LogWLogger</code> class
	 */
	@SuppressWarnings("unchecked")
	public LogWLogger makeNewLoggerInstance(Class aClazz)
	{
		if (aClazz == null)
			return null;
		return new LogWLogger(aClazz.getName());
	}

	/*
	 * --------------------------ERROR STARTS--------------------------- 
	 */

	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:13:08 AM</strong>
	 * <BR>Purpose <i>To log sequence of log informations togather using level as error.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public static void logError(LogListElement aListElement)
	{
		if (aListElement == null)
			return;
		LogWLogger lLogger = LogWLogger.getLogWLogger(aListElement.getCategoryName());

		List<LogElement> lList = aListElement.getLogMessages();
		for (LogElement tempLogElement : lList)
			lLogger.error(tempLogElement.getLogMessage(), tempLogElement.getThrowable());
	}

	/*
	 * --------------------------ERROR ENDS--------------------------- 
	 */
	/*
	 * --------------------------DEBUG STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:13:08 AM</strong>
	 * <BR>Purpose <i>To log sequence of log informations togather using level as debug.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public static void logDdebug(LogListElement aListElement)
	{
		if (aListElement == null)
			return;
		LogWLogger lLogger = LogWLogger.getLogWLogger(aListElement.getCategoryName());

		List<LogElement> lList = aListElement.getLogMessages();
		for (LogElement tempLogElement : lList)
			lLogger.debug(tempLogElement.getLogMessage(), tempLogElement.getThrowable());
	}

	/*
	 * --------------------------DEBUG ENDS--------------------------- 
	 */
	/*
	 * --------------------------FATAL STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:13:08 AM</strong>
	 * <BR>Purpose <i>To log sequence of log informations togather using level as fatal.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public static void logFatal(LogListElement aListElement)
	{
		if (aListElement == null)
			return;
		LogWLogger lLogger = LogWLogger.getLogWLogger(aListElement.getCategoryName());
		List<LogElement> lList = aListElement.getLogMessages();
		for (LogElement tempLogElement : lList)
			lLogger.fatal(tempLogElement.getLogMessage(), tempLogElement.getThrowable());
	}

	/*
	 * --------------------------FATAL ENDS--------------------------- 
	 */

	/*
	 * --------------------------INFO STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:13:08 AM</strong>
	 * <BR>Purpose <i>To log sequence of log informations togather using level as info.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public static void logInfo(LogListElement aListElement)
	{
		if (aListElement == null)
			return;
		LogWLogger lLogger = LogWLogger.getLogWLogger(aListElement.getCategoryName());
		List<LogElement> lList = aListElement.getLogMessages();
		for (LogElement tempLogElement : lList)
			lLogger.info(tempLogElement.getLogMessage(), tempLogElement.getThrowable());
	}

	/*
	 * --------------------------INFO ENDS--------------------------- 
	 */
	/*
	 * --------------------------TRACE STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:13:08 AM</strong>
	 * <BR>Purpose <i>To log sequence of log informations togather using level as trace.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public static void logTrace(LogListElement aListElement)
	{
		if (aListElement == null)
			return;
		LogWLogger lLogger = LogWLogger.getLogWLogger(aListElement.getCategoryName());
		List<LogElement> lList = aListElement.getLogMessages();
		for (LogElement tempLogElement : lList)
			lLogger.trace(tempLogElement.getLogMessage(), tempLogElement.getThrowable());
	}

	/*
	 * --------------------------TRACE ENDS--------------------------- 
	 */
	/*
	 * --------------------------NARRATIVE STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:13:08 AM</strong>
	 * <BR>Purpose <i>To log sequence of log informations togather using level as narrative.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public static void logNarrative(LogListElement aListElement)
	{
		if (aListElement == null)
			return;
		LogWLogger lLogger = LogWLogger.getLogWLogger(aListElement.getCategoryName());
		List<LogElement> lList = aListElement.getLogMessages();
		for (LogElement tempLogElement : lList)
			lLogger.narrative(tempLogElement.getLogMessage(), tempLogElement.getThrowable());
	}

	/*
	 * --------------------------NARRATIVE ENDS--------------------------- 
	 */
	/*
	 * --------------------------WARN STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:13:08 AM</strong>
	 * <BR>Purpose <i>To log sequence of log information togather using level as warn.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public static void logWarn(LogListElement aListElement)
	{
		if (aListElement == null)
			return;
		LogWLogger lLogger = LogWLogger.getLogWLogger(aListElement.getCategoryName());
		List<LogElement> lList = aListElement.getLogMessages();
		for (LogElement tempLogElement : lList)
			lLogger.warn(tempLogElement.getLogMessage(), tempLogElement.getThrowable());
	}
	/*
	 * --------------------------WARN ENDS--------------------------- 
	 */
}

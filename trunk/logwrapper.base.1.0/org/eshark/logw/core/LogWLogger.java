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

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.or.ObjectRenderer;
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
 * <TD>File Name</TD><TD>::</TD><TD>LogWLogger.java</TD>
 * </TR>
 * <TR>
 * <TD>Created on</TD><TD>::</TD><TD>Nov 18, 2008 6:17:18 PM</TD>
 * </TR>
 * <TR>
 * <TD>@author</TD><TD>::</TD><TD><a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a></TD>
 * </TR>
 * <TR>
 * <TD>Purpose</TD><TD>::</TD><TD>To give definition to the new sequencial logging.</TD>
 * </TR>
 * <TR>
 * <TD COLSPAN=3></TD>
 * </TR>
 * </TABLE>
 *
 * <TABLE BORDER="1" WIDTH="100%">
 * <CAPTION>File Change History</CAPTION>
 * <TR>
 * <TH>Date</TH><TH>Description</TH>
 * </TR>
 * <TR>
 * <TD>Nov 18, 2008</TD><TD>Created</TD>
 * </TR>
 * </TABLE>
 */
public class LogWLogger extends Logger
{
	/**
	 * Factory class used to return instance of a LogWLogger
	 */
	protected static LogWFactory	FACTORY	= new LogWFactory();

	/**
	 * The fully qualified name of the Level class. See also the
	 * getFQCN method.
	 */
	private static final String		FQCN	= LogWLevel.class.getName();

	/**
	 * This creates LogWLogger. <B>Called by the factory.</B>
	 * To get an instance of a logger use <code>LogWLogger.getLogWLogger( Class )
	 * </code> or <code>LogWLogger.getLogWLogger( String )</code>.<BR>
	 * <PRE>
	 * example:
	 *     <code>LogWLogger m_logger = LogWLogger.getLogWLogger( this.getClass() );
	 *     </code>
	 * </PRE>
	 * @param aName the name of the class calling the logger ( category )
	 */
	protected LogWLogger(String aName)
	{
		super(aName);
	}

	/**
	 * <BR>Introduced <strong>Nov 18, 2008 6:20:12 PM</strong>
	 * <BR>Purpose <i>Retrieve a logger by a Class object.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aClazz the class calling the logger ( category )
	 * @return LogWLogger instance of the <code>LogWLogger</code> class
	 */
	@SuppressWarnings("unchecked")
	static public LogWLogger getLogWLogger(Class aClazz)
	{
		return getLogWLogger(aClazz.getName());
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 7:24:09 AM</strong>
	 * <BR>Purpose <i>Retrieve a logger by name.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aName the name of the class calling the logger (category)
	 * @return LogWLogger The logger instance
	 */
	static public LogWLogger getLogWLogger(String aName)
	{
		return (LogWLogger) LogManager.getLogger(aName, FACTORY);
	}

	/*
	 * --------------------------TRACE STARTS--------------------------- 
	 */

	/* (non-Javadoc)
	 * @see org.apache.log4j.Logger#trace(java.lang.Object)
	 * <br>Purpose to override <i> Log a message object with the {@link LogWLevel#TRACE TRACE} Level.
	 *
	 * <p>This method first checks if this category is <code>TRACE</code>
	 * enabled by comparing the level of this category with {@link
	 * LogWLevel#TRACE TRACE} Level. If the category is <code>TRACE</code>
	 * enabled, then it converts the message object passed as parameter
	 * to a string by invoking the appropriate {@link ObjectRenderer}. It
	 * proceeds to call all the registered appenders in this category and
	 * also higher in the hierarchy depending on the value of the
	 * additivity flag.
	 *
	 * <p><b>WARNING</b> Note that passing a {@link Throwable} to this
	 * method will print the name of the Throwable but no stack trace. To
	 * print a stack trace use the {@link #trace(Object, Throwable)} form
	 * instead.</i>
	 *
	 */
	public void trace(Object aMessage)
	{
		if (isTraceEnabled())
			forcedLog(FQCN, LogWLevel.TRACE, aMessage, null);
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.Logger#trace(java.lang.Object, java.lang.Throwable)
	 * <br>Purpose to override <i>Log a message object with the <code>TRACE</code> level including
	 * the stack trace of the {@link Throwable} <code>aThrowable</code> passed as
	 * parameter.</i>
	 *
	 */
	public void trace(Object aMessage, Throwable aThrowable)
	{
		if (isTraceEnabled())
			forcedLog(FQCN, LogWLevel.TRACE, aMessage, aThrowable);
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 7:26:37 AM</strong>
	 * <BR>Purpose <i>Log a message object with the <code>TRACE</code> level including
	 * the stack trace.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement the object holding message object & exception to log, including its stack trace.
	 */
	private void trace(LogElement aElement)
	{
		if (aElement != null)
			forcedLog(FQCN, LogWLevel.TRACE, aElement.getLogMessage(), aElement.getThrowable());
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 7:31:34 AM</strong>
	 * <BR>Purpose <i>Log a list of messages object with the <code>TRACE</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public void trace(LogListElement aListElement)
	{
		if (isTraceEnabled() && aListElement != null)
		{
			List<LogElement> lList = aListElement.getLogMessages();
			for (LogElement tempLogElement : lList)
				trace(tempLogElement);
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.log4j.Logger#isTraceEnabled()
	 * <br>Purpose to override <i>Check whether this category is enabled for the <code>TRACE</code>
	 * Level.</i>
	 *
	 */
	public boolean isTraceEnabled()
	{
		return (repository.isDisabled(LogWLevel.TRACE_INT)) ? false : LogWLevel.TRACE.isGreaterOrEqual(this
				.getEffectiveLevel());
	}

	/*
	 * --------------------------TRACE ENDS--------------------------- 
	 */

	/*
	 * --------------------------NARRATIVE STARTS--------------------------- 
	 */

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:09:16 AM</strong>
	 * <BR>Purpose <i>Log a message object with the {@link LogWLevel#NARRATIVE NARRATIVE} Level.
	 *
	 * <p>This method first checks if this category is <code>NARRATIVE</code>
	 * enabled by comparing the level of this category with {@link
	 * LogWLevel#NARRATIVE NARRATIVE} Level. If the category is <code>NARRATIVE</code>
	 * enabled, then it converts the message object passed as parameter
	 * to a string by invoking the appropriate {@link ObjectRenderer}. It
	 * proceeds to call all the registered appenders in this category and
	 * also higher in the hierarchy depending on the value of the
	 * additivity flag.
	 *
	 * <p><b>WARNING</b> Note that passing a {@link Throwable} to this
	 * method will print the name of the Throwable but no stack trace. To
	 * print a stack trace use the {@link #narrative(Object, Throwable)} form
	 * instead.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aMessage the message object to log
	 */
	public void narrative(Object aMessage)
	{
		if (isNarrativeEnabled())
			forcedLog(FQCN, LogWLevel.NARRATIVE, aMessage, null);
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:10:20 AM</strong>
	 * <BR>Purpose <i>Log a message object with the <code>NARRATIVE</code> level including
	 * the stack trace of the {@link Throwable} <code>aThrowable</code> passed as
	 * parameter.
	 *
	 * <p>See {@link #narrative(Object)} for more detailed information.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aMessage the message object to log.
	 * @param aThrowable the exception to log, including its stack trace.
	 */
	public void narrative(Object aMessage, Throwable aThrowable)
	{
		if (isNarrativeEnabled())
			forcedLog(FQCN, LogWLevel.NARRATIVE, aMessage, aThrowable);
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:11:41 AM</strong>
	 * <BR>Purpose <i>Log a message object with the <code>NARRATIVE</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	private void narrative(LogElement aElement)
	{
		if (aElement != null)
			forcedLog(FQCN, LogWLevel.NARRATIVE, aElement.getLogMessage(), aElement.getThrowable());
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:12:56 AM</strong>
	 * <BR>Purpose <i>Log a list of messages object with the <code>TRACE</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public void narrative(LogListElement aListElement)
	{
		if (isNarrativeEnabled() && aListElement != null)
		{
			List<LogElement> lList = aListElement.getLogMessages();
			for (LogElement tempLogElement : lList)
				narrative(tempLogElement);
		}
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:15:19 AM</strong>
	 * <BR>Purpose <i>Check whether this category is enabled for the <code>NARRATIVE</code>
	 *  Level.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @return
	 */
	public boolean isNarrativeEnabled()
	{
		return (repository.isDisabled(LogWLevel.NARRATIVE_INT)) ? false : LogWLevel.NARRATIVE.isGreaterOrEqual(this
				.getEffectiveLevel());
	}

	/*
	 * --------------------------NARRATIVE ENDS--------------------------- 
	 */

	/*
	 * --------------------------DEBUG STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a message object with the <code>DEBUG</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	private void debug(LogElement aElement)
	{
		if (aElement != null)
			forcedLog(FQCN, LogWLevel.DEBUG, aElement.getLogMessage(), aElement.getThrowable());
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:12:56 AM</strong>
	 * <BR>Purpose <i>Log a list of messages object with the <code>DEBUG</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aListElement
	 */
	public void debug(LogListElement aListElement)
	{
		if (isDebugEnabled() && aListElement != null)
		{
			List<LogElement> lList = aListElement.getLogMessages();
			for (LogElement tempLogElement : lList)
				debug(tempLogElement);
		}
	}

	/*
	 * --------------------------DEBUG ENDS--------------------------- 
	 */

	/*
	 * --------------------------INFO STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a message object with the <code>INFO</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	public void info(LogElement aElement)
	{
		if (aElement != null)
			forcedLog(FQCN, LogWLevel.INFO, aElement.getLogMessage(), aElement.getThrowable());
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a list of messages object with the <code>INFO</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	public void info(LogListElement aListElement)
	{
		if (isInfoEnabled() && aListElement != null)
		{
			List<LogElement> lList = aListElement.getLogMessages();
			for (LogElement tempLogElement : lList)
				info(tempLogElement);
		}
	}

	/*
	 * --------------------------INFO ENDS--------------------------- 
	 */

	/*
	 * --------------------------WARN STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a message object with the <code>WARN</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	private void warn(LogElement aElement)
	{
		if (aElement != null)
			forcedLog(FQCN, LogWLevel.WARN, aElement.getLogMessage(), aElement.getThrowable());
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a list of messages object with the <code>WARN</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	public void warn(LogListElement aListElement)
	{
		if (repository.isDisabled(Level.WARN_INT) || aListElement == null)
			return;
		if (Level.WARN.isGreaterOrEqual(this.getEffectiveLevel()))
		{
			List<LogElement> lList = aListElement.getLogMessages();
			for (LogElement tempLogElement : lList)
				warn(tempLogElement);
		}
	}

	/*
	 * --------------------------WARN ENDS--------------------------- 
	 */

	/*
	 * --------------------------ERROR STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a message object with the <code>ERROR</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	private void error(LogElement aElement)
	{
		if (aElement!= null)
			forcedLog(FQCN, LogWLevel.ERROR, aElement.getLogMessage(), aElement.getThrowable());
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a list of messages object with the <code>ERROR</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	public void error(LogListElement aListElement)
	{
		if (repository.isDisabled(Level.ERROR_INT) || aListElement == null)
			return;
		if (Level.ERROR.isGreaterOrEqual(this.getEffectiveLevel()))
		{
			List<LogElement> lList = aListElement.getLogMessages();
			for (LogElement tempLogElement : lList)
				error(tempLogElement);
		}
	}
	/*
	 * --------------------------ERROR ENDS--------------------------- 
	 */
	/*
	 * --------------------------FATAL STARTS--------------------------- 
	 */
	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a message object with the <code>FATAL</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	private void fatal(LogElement aElement)
	{
		if (aElement != null)
			forcedLog(FQCN, LogWLevel.FATAL, aElement.getLogMessage(), aElement.getThrowable());
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:16:19 AM</strong>
	 * <BR>Purpose <i>Log a list of messages object with the <code>FATAL</code> level including
	 * the stack traces.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	public void fatal(LogListElement aListElement)
	{
		if (repository.isDisabled(Level.FATAL_INT) || aListElement == null)
			return;
		if (Level.FATAL.isGreaterOrEqual(this.getEffectiveLevel()))
		{
			List<LogElement> lList = aListElement.getLogMessages();
			for (LogElement tempLogElement : lList)
				fatal(tempLogElement);
		}
	}
	/*
	 * --------------------------ERROR ENDS--------------------------- 
	 */
}

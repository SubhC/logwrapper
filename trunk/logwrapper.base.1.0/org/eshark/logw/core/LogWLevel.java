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

import org.apache.log4j.Level;

/**
 * <TABLE BORDER="1" WIDTH="100%">
 * <TR>
 * <TH>Particulars</TH><TH>::</TH><TH>Details</TH>
 * </TR>
 * <TR>
 * <TD>Project Name</TD><TD>::</TD><TD>LogWrapper</TD>
 * </TR>
 * <TR>
 * <TD>File Name</TD><TD>::</TD><TD>LogWLevel.java</TD>
 * </TR>
 * <TR>
 * <TD>Created on</TD><TD>::</TD><TD>Nov 18, 2008 5:49:39 PM</TD>
 * </TR>
 * <TR>
 * <TD>@author</TD><TD>::</TD><TD><a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a></TD>
 * </TR>
 * <TR>
 * <TD>Purpose</TD><TD>::</TD><TD>Introduces two new custom levels, trace and narrative, which
 * are more detailed than INFO but less detailed than DEBUG. These
 * levels are only used by {@link LogWLogger}. Combined with the built-in log4j
 * levels, these are listed in descending order of priority:
 * <ol>
 *    <li>FATAL</li>
 *    <li>ERROR</li>
 *    <li>WARN</li>
 *    <li>INFO</li>
 *    <li>TRACE</li>
 *    <li>NARRATIVE</li>
 *    <li>DEBUG</li>
 * </ol></TD>
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
public class LogWLevel extends org.apache.log4j.Level
{

	private static final long		serialVersionUID	= -1711092135503244396L;

	/**
	 * Numeric value of a NARRATIVE statement. Notice how this is less that
	 * <a href="http://jakarta.apache.org/log4j/docs/api/index.html#INFO_INT">
	 * Priority.INFO_INT</a> and greater the {@link #TRACE_INT}. This
	 * establishes the hierarchy for the logging statements.
	 */
	public final static int			NARRATIVE_INT		= 15000;

	/**
	 * Numeric value of a TRACE statement. Notice how TRACE is less than
	 * {@link #NARRATIVE_INT} and greater that
	 * <a href="http://jakarta.apache.org/log4j/docs/api/index.html#DEBUG_INT">
	 * Priority.DEBUG_INT</a>. This establishes the hierarchy for the logging
	 * statements.
	 */
	public final static int			TRACE_INT			= 16500;

	/**
	 * String value of the NARRATIVE Level.
	 */
	public final static String		NARRATIVE_STR		= "NARR";

	/**
	 * String value of the TRACE Level.
	 */
	public final static String		TRACE_STR			= "TRACE";

	/**
	 * The <code>NARRATIVE</code> level designates informational messages
	 * that state the application's flow. This is a coarse-grained
	 * level of TRACE information.
	 */
	final static public LogWLevel	NARRATIVE			= new LogWLevel(NARRATIVE_INT, NARRATIVE_STR, 6);

	/**
	 * The <code>TRACE</code> level designates informational messages
	 * that state the application's flow. This is a coarse-grained
	 * level of TRACE information.
	 */
	final static public LogWLevel	TRACE				= new LogWLevel(TRACE_INT, TRACE_STR, 6);

	/**
	 * Instantiates a LogWLevel object. Creates a mapping between String and
	 * numeric representations of the level. 
	 * @param aLevel int value of the LogWLevel
	 * @param aLevelString levelStr string value of the level
	 * @param aSyslogEquivalent syslogEquivalent syslog equivalent of the level
	 */
	protected LogWLevel(int aLevel, String aLevelString, int aSyslogEquivalent)
	{
		super(aLevel, aLevelString, aSyslogEquivalent);
	}

	/**
	 * <BR>Introduced <strong>Nov 18, 2008 5:59:27 PM</strong>
	 * <BR>Purpose <i>Overridden from Level to add TRACE and NARRATIVE.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aValue the level to set to
	 * @param aDefaultLevel the level to go to if val not found
	 * @return LogWLevel instance of the requested LogWLevel
	 */
	public static LogWLevel toLevel(int aValue, Level aDefaultLevel)
	{
		switch (aValue)
		{
			case NARRATIVE_INT:
				return LogWLevel.NARRATIVE;
			case TRACE_INT:
				return LogWLevel.TRACE;
			default:
				return LogWLevel.toLevel(aValue, aDefaultLevel);
		}
		/*switch(val)
		{
		    case ALL_INT: return ALL;
		    case DEBUG_INT: return LogWLevel.DEBUG;
		    case TRACE_INT: return LogWLevel.TRACE;
		    case NARRATIVE_INT: return LogWLevel.NARRATIVE;
		    case INFO_INT: return LogWLevel.INFO;
		    case WARN_INT: return LogWLevel.WARN;
		    case ERROR_INT: return LogWLevel.ERROR;
		    case FATAL_INT: return LogWLevel.FATAL;
		    case OFF_INT: return OFF;
		    default: return defaultLevel;
		}*/
	}

	/**
	 * <BR>Introduced <strong>Nov 18, 2008 6:05:14 PM</strong>
	 * <BR>Purpose <i>Overridden from Level to add TRACE and NARRATIVE.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aStringLevel string representation of a Level to look for
	 * @param aDefaultLevel the level to go to if sArg not found
	 * @return LogWLevel instance of the requested Level     
	 */
	public static LogWLevel toLevel(String aStringLevel, LogWLevel aDefaultLevel)
	{
		if (aStringLevel == null)
			return aDefaultLevel;

		String lStringValue = aStringLevel.toUpperCase();

		if (lStringValue.equals(NARRATIVE_STR))
			return LogWLevel.NARRATIVE;
		if (lStringValue.equals(TRACE_STR))
			return LogWLevel.TRACE;
		return LogWLevel.toLevel(aStringLevel, aDefaultLevel);
	}

	/**
	 * <BR>Introduced <strong>Nov 18, 2008 6:08:52 PM</strong>
	 * <BR>Purpose <i>Convert the string passed as argument to a level. If the
	 * conversion fails, then this method returns {@link #DEBUG}.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aStringValue the string rep to look for
	 * @return LogWLevel found instance of the Level
	 */
	public static LogWLevel toLevel(String aStringValue)
	{
		return (LogWLevel) toLevel(aStringValue, LogWLevel.DEBUG);
	}

	/**
	 * <BR>Introduced <strong>Nov 18, 2008 6:12:10 PM</strong>
	 * <BR>Purpose <i>Convert an integer passed as argument to a level. If the
	 * conversion fails, then this method returns {@link #DEBUG}.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aValue the int rep to look for
	 * @return LogWLevel found instance of the Level
	 */
	public static LogWLevel toLevel(int aValue)
	{
		return (LogWLevel) toLevel(aValue, LogWLevel.DEBUG);
	}
}
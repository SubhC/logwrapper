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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <TABLE BORDER="1" WIDTH="100%">
 * <TR>
 * <TH>Particulars</TH><TH>::</TH><TH>Details</TH>
 * </TR>
 * <TR>
 * <TD>Project Name</TD><TD>::</TD><TD>LogWrapper</TD>
 * </TR>
 * <TR>
 * <TD>File Name</TD><TD>::</TD><TD>LogListElement.java</TD>
 * </TR>
 * <TR>
 * <TD>Created on</TD><TD>::</TD><TD>Nov 27, 2008 8:28:36 AM</TD>
 * </TR>
 * <TR>
 * <TD>@author</TD><TD>::</TD><TD><a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a></TD>
 * </TR>
 * <TR>
 * <TD>Purpose</TD><TD>::</TD><TD>To hold a list of logElements.</TD>
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
public class LogListElement
{
	private List<LogElement> mList	=	new ArrayList<LogElement>();
	@SuppressWarnings(value="all")
	private String	mCategoryName = null;
		
	
	/**
	 * This creates LogListElement
	 * @param aCategoryName
	 */
	public LogListElement(String aCategoryName)
	{
		mCategoryName = aCategoryName;
	}

	//GETTER
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:10:08 AM</strong>
	 * <BR>Purpose <i>Returns the entire list of the LogElements.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @return List<LogElement>
	 */
	public List<LogElement> getLogMessages()
	{
		return mList;
	}
	
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:10:02 AM</strong>
	 * <BR>Purpose <i>Returns a LogElement of a given index.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aPosition
	 * @return LogElement
	 */
	public LogElement getLogMessageFrom(int aPosition)
	{
		return mList.get(aPosition);
	}
	
	//SETTER
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:09:54 AM</strong>
	 * <BR>Purpose <i>Sets the entire list of LogElements.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aList
	 */
	public void setLogMessages(List<LogElement> aList)
	{
		mList = aList;
	}
	
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:09:42 AM</strong>
	 * <BR>Purpose <i>Sets one LogElement at the end of the list.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 */
	public void setLogMessage(LogElement aElement)
	{
		mList.add(aElement);
	}
	
	/**
	 * <BR>Introduced <strong>Nov 26, 2008 9:09:32 AM</strong>
	 * <BR>Purpose <i>Sets one LogElement at a perticular index.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aElement
	 * @param aPosition
	 */
	public void setLogMessageAt(LogElement aElement, int aPosition)
	{
		mList.add(aPosition,aElement);
	}
	
	//ITERATOR
	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:34:29 AM</strong>
	 * <BR>Purpose <i>returns the iterator of the list elements.</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @return
	 */
	public Iterator<LogElement> iterator()
	{
		return mList.iterator();
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:33:59 AM</strong>
	 * <BR>Purpose <i>This returns the value of categoryName of type String</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @return the categoryName
	 */
	public String getCategoryName()
	{
		return mCategoryName;
	}

	/**
	 * <BR>Introduced <strong>Nov 27, 2008 8:33:28 AM</strong>
	 * <BR>Purpose <i>This sets the value of categoryName by aCategoryName</i>
	 * @author <a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a>
	 * @param aCategoryName the categoryName to set
	 */
	public void setCategoryName(String aCategoryName)
	{
		mCategoryName = aCategoryName;
	}
}

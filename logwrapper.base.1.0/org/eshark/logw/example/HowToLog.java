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

package org.eshark.logw.example;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.eshark.logw.core.LogWFactory;
import org.eshark.logw.core.LogWLogger;
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
 * <TD>File Name</TD><TD>::</TD><TD>HowToLog.java</TD>
 * </TR>
 * <TR>
 * <TD>Created on</TD><TD>::</TD><TD>Nov 26, 2008 6:19:05 AM</TD>
 * </TR>
 * <TR>
 * <TD>@author</TD><TD>::</TD><TD><a href="mailto:subhasish@gmail.com">Subhasish Chattopadhyay</a></TD>
 * </TR>
 * <TR>
 * <TD>Purpose</TD><TD>::</TD><TD>Simple example</TD>
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
 * <TD>Nov 26, 2008</TD><TD>Created</TD>
 * </TR>
 * </TABLE>
 */
public class HowToLog 
{
	
	
	
	private static LogWLogger logger = LogWLogger.getLogWLogger(HowToLog.class);
	public static void main(String[] args)
	{
		new HowToLog().logtest();
	}

	private void logtest()
	{
		// Use a PropertyConfigurator to initialize from a property file.
        String resource = "/org/eshark/logw/example/log4j.properties";
        URL configFileResource = HowToLog.class.getResource(resource);
        PropertyConfigurator.configure(configFileResource);
        
        logger.debug("Starting the log");
        //Group of messages to be loged togather
        LogListElement aList = new LogListElement(HowToLog.class.getName());
        
        logger.debug("List Got Created");
        
        aList.setLogMessage(new LogElement("I have been created now."));
        
        logger.debug("Wrote the first mmessage in the list.");
        
        aList.setLogMessage(new LogElement("Writing 1"));
        
        logger.debug("Writing next ten messages starts.");
        
        for(int indx=2; indx < 12; indx++)
        	aList.setLogMessage(new LogElement("Writing " + indx));
        
        logger.debug("Writing next ten messages ends.");
        
        aList.setLogMessage(new LogElement("I am done"));
        
        //logging using factory method
        LogWFactory.logDdebug(aList);
        
        //logging using the logger method
        logger.debug(aList);
        logger.debug("Ending the log.");
        logger.debug("Testing finally debug---------------");
        //TESTING Logger levels
        
        logger.narrative("Testing finally narrative---------------");
        logger.trace("Testing finally trace---------------");
        logger.info("Testing finally info---------------");
        logger.warn("Testing finally warn---------------");
        logger.error("Testing finally error---------------");
        logger.fatal("Testing finally fatal---------------");
	}
}

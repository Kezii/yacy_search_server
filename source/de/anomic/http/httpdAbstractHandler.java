// httpdAbstractHandler.java 
// -----------------------
// (C) by Michael Peter Christen; mc@anomic.de
// first published on http://www.anomic.de
// Frankfurt, Germany, 2004
// last major change: 25.10.2004
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
// Using this software in any meaning (reading, learning, copying, compiling,
// running) means that you agree that the Author(s) is (are) not responsible
// for cost, loss of data or any harm that may be caused directly or indirectly
// by usage of this softare or this documentation. The usage of this software
// is on your own risk. The installation and usage (starting/running) of this
// software may allow other people or application to access your computer and
// any attached devices and is highly dependent on the configuration of the
// software which must be done by the user of the software; the author(s) is
// (are) also not responsible for proper configuration and usage of the
// software, even if provoked by documentation provided together with
// the software.
//
// Any changes to this file according to the GPL as documented in the file
// gpl.txt aside this file in the shipment you received can be done to the
// lines that follows this copyright notice here, but changes must not be
// done inside the copyright notive above. A re-distribution must contain
// the intact and unchanged copyright notice.
// Contributions and changes to the program code must be marked as such.

/*
   Documentation:
   the servlet interface
   an actual servlet for the AnomicHTTPD must provide a class that implements
   this interface. The resulting class is then placed in a folder that contains
   all servlets and is configured in the httpd.conf configuration file.
   servlet classes in that directory are then automatically selected as CGI
   extensions to the server.
   The core functionality of file serving is also implemented as servlet.
*/

package de.anomic.http;

import java.text.SimpleDateFormat;
import java.util.Properties;

import de.anomic.server.logging.serverLog;

public abstract class httpdAbstractHandler {
    
    // static tools
    
    private static int fileCounter = 0; // for unique file names
    
    private static SimpleDateFormat DateFileNameFormatter =
        new SimpleDateFormat("yyyyMMddHHmmss");
    
    protected static String uniqueDateString() {
        String c = Integer.toString(fileCounter);
        fileCounter++; if (fileCounter>9999) fileCounter = 0;
        while (c.length() < 4) { c = "0" + c; }
        return "FILE" + DateFileNameFormatter.format(httpc.nowDate()) + c;
    } 
    
    protected Properties connectionProperties = null;
    
    protected serverLog theLogger;
    
}

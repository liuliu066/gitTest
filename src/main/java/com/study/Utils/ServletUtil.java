package com.study.Utils;

/**
 * @author lwh
 * @date 2022/7/22 14:08
 */

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletUtil {
    private static final String UNKNOWN = "unknown";
    private static final String LOCALHOST_127 = "127.0.0.1";
    private static final int IPADDRESS_LENGTH = 15;
    private static Logger log = LoggerFactory.getLogger(ServletUtil.class);

    public ServletUtil() {
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;

        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }

            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }

            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if ("127.0.0.1".equals(ipAddress)) {
                    InetAddress inet = null;

                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException var4) {
                        log.error(var4.getMessage(), var4);
                    }

                    if (inet != null) {
                        ipAddress = inet.getHostAddress();
                    }
                }
            }

            if (ipAddress != null && ipAddress.length() > 15 && ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        } catch (Exception var5) {
            ipAddress = "";
        }

        return ipAddress;
    }
}

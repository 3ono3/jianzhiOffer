package com.jing.base;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.nio.charset.Charset;

public class SsrHost {
    public static void main(String[] args) throws Exception {
        StringBuilder address = new StringBuilder("104.");
        for (int i = 16; i <= 31; i++) {
            address.append(i);
            address.append(".");
            for (int j = 0; j <= 255; j++) {
                address.append(j);
                address.append(".");
                for (int x = 1; x <= 254; x++) {
                    address.append(x);
                    String ip = address.toString();
                    boolean result = isConnect(ip);
                    System.out.println(ip + "--" + result);
                    if (result) {
                        System.out.println("终于有一个了：" + ip);
                    }
                    int last = address.lastIndexOf(".");
                    address.delete(last+1,address.length());
                }
                address.deleteCharAt(address.length()-1);
                int last = address.lastIndexOf(".");
                address.delete(last+1,address.length());
            }
            address.deleteCharAt(address.length()-1);
            int last = address.lastIndexOf(".");
            address.delete(last+1,address.length());
        }

    }
    private static Runtime runtime = Runtime.getRuntime();
    /**
     * 根据ip判断当前ip是否能够ping通
     * 
     * @param ip
     * @return
     */
    public static boolean isConnect(String ip) {
        boolean bool = false;
        try {
            Process process = runtime.exec("ping " + ip);
            InputStream is = process.getInputStream();

            InputStreamReader isr = new InputStreamReader(is,Charset.forName("GBK"));
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sb.append(line);
// 优化速度
                if (line.indexOf("请求超时") >= 0) {
// System.out.println(ip + "网络断开，时间 " + new Date());
                    br.close();
                    isr.close();
                    is.close();
                    return false;
                }
            }
            br.close();
            isr.close();
            is.close();


            if (null != sb && !sb.toString().equals("")) {
                if (sb.toString().indexOf("TTL") > 0) {
// 网络畅通
// System.out.println(ip + "网络正常 ，时间" + new Date());
                    bool = true;
                } else {
// 网络不畅通
// System.out.println(ip + "网络断开，时间 " + new Date());
                    bool = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    public static boolean ping(String ipAddress) throws Exception {
        int  timeOut =  1000 ;  //超时应该在3钞以上
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);     // 当返回值是true时，说明host是可用的，false则不可。
        return status;
    }
}

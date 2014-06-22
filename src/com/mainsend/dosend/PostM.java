package com.mainsend.dosend;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import com.mainsend.Buesiness;

import com.mainsend.SendMPOJO;

public class PostM {
	
	public String PostSend(SendMPOJO sendMPOJO)throws Exception{
		String url1="http://www.cdxintu.com/objmsg/XT_dt00006.aspx?";
		System.out.println(getXMLContent(sendMPOJO));	    
	    URL url=new URL(url1);
	    URLConnection conn1=url.openConnection();
	    HttpURLConnection conn = (HttpURLConnection) conn1;
	    conn.setDoOutput(true);
	    conn.setRequestProperty("Cache-Control", "no-cache");
        conn.setRequestProperty("Content-Type", "text/xml");	
        conn.setRequestMethod("POST");
        conn.setConnectTimeout(30000);  
        conn.setReadTimeout(30000);
	    OutputStreamWriter opw=new OutputStreamWriter(conn.getOutputStream(),"utf-8");
	    String _v=getXMLContent(sendMPOJO);
	    System.out.println(_v);
	    opw.write(new String( _v.getBytes(),"utf-8"));
	    opw.flush();
	    opw.close();
	    
	    InputStreamReader read=new InputStreamReader(conn.getInputStream(),"utf-8");
	    BufferedReader reader=new BufferedReader(read);
	    String result = reader.readLine();//得到的执行后返回的结果
	    System.out.println(result);
	    return "oko";
	}
private String getXMLContent(SendMPOJO sendMPOJO){
	 
	if("9081031501".equals(sendMPOJO.getSpcode())){
		Object[] o=Buesiness.get106289975();
		sendMPOJO.setSpSerId((String)o[4]);
		sendMPOJO.setPrice((String)o[2]);
		
	}else if("9081112400".equals(sendMPOJO.getSpcode())){
		Object[] o=Buesiness.get106289977();
		sendMPOJO.setSpSerId((String)o[4]);
		sendMPOJO.setPrice((String)o[2]);
	}else {
		sendMPOJO.setSpSerId("N/A");
		sendMPOJO.setPrice("0");	
	}
		
		StringBuffer sb=new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
		sb.append("<SMS_MESSAGE>");
		sb.append("<SEQ_ID>").append(sendMPOJO.getLinkId()+"x"+sendMPOJO.getMobile()+"x"+sendMPOJO.getReserve()).append("</SEQ_ID>");
		sb.append("<PNONE_NO>").append(sendMPOJO.getMobile()).append("</PNONE_NO>");
		sb.append("<MESSAGE>").append(sendMPOJO.getMsg()).append("/<MESSAGE>");
		sb.append("<SERVICE_NO>").append(sendMPOJO.getSpSerId()).append("</SERVICE_NO>");
		sb.append("<RECEIVE_TIME>").append(sendMPOJO.getStime()).append("</RECEIVE_TIME>") ;
		sb.append("<PRICE>").append(sendMPOJO.getPrice()).append("</PRICE>");
		sb.append("<FEE_STATUS>").append(sendMPOJO.getStat()).append("</FEE_STATUS>");
		sb.append("</SMS_MESSAGE>");
		
		return sb.toString();
	}



}

package com.mainsend.service;

import com.mainsend.SendMPOJO;
import com.mainsend.ThreadClass;
import com.mainsend.dao.AllDao;

public class ServiceMod {
	/**
	 * �����Ƿ�����Ҫ����ļ�¼
	 * @return
	 */
	public int getNowRecord(){
	AllDao ad=new AllDao();	
	return ad.checkStatNum();
	}
	
	/**
	 * ��ʼ�߳�
	 */
	public void startDo(int i){
		Thread t=new ThreadClass(1);
		t.start();
		if(i>=10){
			
				//Thread.sleep(900);
				Thread t1=new ThreadClass(2);
				t1.start();
			
			
		}
	}
	
	/**
	 * ��ȡ��¼
	 * @return
	 */
	public SendMPOJO getPojo(int i){
		AllDao ad=new AllDao();
		return ad.getOnePOJO(i);
	}
	
	/**
	 * ��������״̬
	 * @param sendMPOJO
	 */
	public int errorUpdate(SendMPOJO sendMPOJO){
		AllDao ad=new AllDao();
		return ad.updateErrStat(sendMPOJO);
	}
	
	/**
	 * �ɹ������״̬
	 */
	public int successUpdate(SendMPOJO sendMPOJO){
		AllDao ad=new AllDao();
		return ad.updateStat(sendMPOJO);
	}
	
}

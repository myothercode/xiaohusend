package com.mainsend;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;



public class Buesiness {
	
    public static Object[] get106289977(){
    	Object[] Bu=new Object[5];
    	Bu[0]="9081112400"; //ҵ�����
    	Bu[1]=(byte)2;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="100";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)0;      //1B ����MT��Ϣ��ԭ��0-MO�㲥����ĵ�һ��MT��Ϣ��1-MO�㲥����ķǵ�һ��MT��Ϣ��2-��MO�㲥�����MT��Ϣ��3-ϵͳ���������MT��Ϣ
    	Bu[4]="106289977";
    	return Bu;
    }	

	public static Object[] get106289975(){
    	Object Bu[]=new Object[5];
    	Bu[0]="9081031501"; //ҵ�����
    	Bu[1]=(byte)1;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="0";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)0;
    	Bu[4]="106289975";
    	return Bu;
	}
	
	public static Object[] get106558411(){
	   	Object Bu[]=new Object[5];
    	Bu[0]="9081226101"; //ҵ�����
    	Bu[1]=(byte)2;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="0";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)0;
    	Bu[4]="106558411";
    	return Bu;
	}
	
	public static Object[] get10628997(){
	   	Object Bu[]=new Object[5];
    	Bu[0]="9081012601"; //ҵ�����
    	Bu[1]=(byte)3;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="500";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)2;
    	Bu[4]="10628997";
    	return Bu;
	}
	
	public static Object[] get106289978(){
	   	Object Bu[]=new Object[5];;
    	Bu[0]="9081234001"; //ҵ�����
    	Bu[1]=(byte)3;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="200";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)2;
    	Bu[4]="106289978";
    	return Bu;
	}
	
	public static Object[] get106289976(){
	   	Object Bu[]=new Object[5];;
    	Bu[0]="9081012501"; //ҵ�����
    	Bu[1]=(byte)3;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="500";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)2;
    	Bu[4]="106289976";
    	return Bu;
	}
	
	public static Object[] get106558412(){
	   	Object Bu[]=new Object[5];
    	Bu[0]="9081226102"; //ҵ�����
    	Bu[1]=(byte)3;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="1500";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)2;
    	Bu[4]="106558412";
    	return Bu;
	}

	public static Object[] get106289972() {
		Object Bu[]=new Object[5];
    	Bu[0]="9081186900"; //ҵ�����
    	Bu[1]=(byte)3;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="200";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)2;
    	Bu[4]="106289972";
    	return Bu;
	}
	
	public static Object[] get106289973() {
		Object Bu[]=new Object[5];
    	Bu[0]="9081186901"; //ҵ�����
    	Bu[1]=(byte)2;      //1B �Ʒ����� 1���,2,�����Ʒ�,3���¼Ʒ�
    	Bu[2]="0";        //�Ʒ�ֵ����λ�Ƿ�
    	Bu[3]=(byte)0;
    	Bu[4]="106289973";
    	return Bu;
	}
	public static String date2Str(Date date, String format) {
		  if (null != date && !"".equals(date)) {
		    SimpleDateFormat sdf = new SimpleDateFormat(format);
		    return sdf.format(date);
		  }
		  return null;
		}

		public static String timestamp2Str(Timestamp time) {
		  if(null != time && !"".equals(time)){
		    Date date = new Date(time.getTime());
		    return date2Str(date, "yyyy-MM-dd HH:mm:ss.SSS");
		  }
		  return null;
		}

}
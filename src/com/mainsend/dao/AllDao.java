package com.mainsend.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import com.mainsend.Buesiness;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.mainsend.SendMPOJO;
import com.mainsend.c3p0jdbctemple.JdbctempleManager;

public class AllDao {
	
	
	/**
	 * �õ����������ĵ�һ����¼
	 * @return
	 */
	public SendMPOJO getOnePOJO(int i){
		SendMPOJO sendMPOJO=new SendMPOJO();;
		JdbctempleManager s=JdbctempleManager.getInstance();
		JdbcTemplate jtp=(JdbcTemplate)s.getJdbctem();
		String sql="select top 1 [time],mobile_no,message,spcode,stime,stat,reserve from sms_log_new where flag='3' and stat is not null and reserve is not null and (spcode in('9081112400','9081234001')) and left(msg,3)='tpx' order by stime asc";
		if(i==2){
			sql="select top 1 [time],mobile_no,message,spcode,stime,stat,reserve from sms_log_new where flag='3' and stat is not null and reserve is not null and (spcode in('9081112400','9081234001')) and left(msg,3)='tpx' order by stime desc";
		}
		List rs= jtp.queryForList(sql);
		sendMPOJO.setLinkId((String)((Map)rs.get(0)).get("time") );
		sendMPOJO.setMobile((String)((Map)rs.get(0)).get("mobile_no"));
		sendMPOJO.setMsg((String)((Map)rs.get(0)).get("message"));
		sendMPOJO.setSpcode((String)((Map)rs.get(0)).get("spcode"));
		sendMPOJO.setStat((String)((Map)rs.get(0)).get("stat"));
		sendMPOJO.setReserve((String)((Map)rs.get(0)).get("reserve"));
		sendMPOJO.setStime(Buesiness.timestamp2Str((Timestamp)((Map)rs.get(0)).get("stime")));
		
		List reserve=jtp.queryForList("select msg from deliver where reserve='"+(String)((Map)rs.get(0)).get("reserve")+"' and mobile_no='"+sendMPOJO.getMobile()+"'" );
		sendMPOJO.setMsg((String)((Map)reserve.get(0)).get("msg"));
		System.out.println("�ҵ���Ҫ���͵���Ŀ:"+sendMPOJO.getMobile()+"::"+sendMPOJO.getMsg()+"::"+sendMPOJO.getStat()+"thread is "+i);
		return sendMPOJO;
	}
	
	/**
	 * ����״̬Ϊ4��Ϊ�Ѿ����ͳɹ�
	 * @param sendMPOJO
	 */
	public int updateStat(SendMPOJO sendMPOJO){
		JdbctempleManager s=JdbctempleManager.getInstance();
		JdbcTemplate jtp=(JdbcTemplate)s.getJdbctem();
		int c=jtp.update("update sms_log_new set flag='4' where flag='3' and [time]='"+sendMPOJO.getLinkId()+"' and mobile_no='"+sendMPOJO.getMobile()+"'");
		System.out.println("������"+c+"��!");
		return c;
	}
	
	/**
	 * ��������Ϊ5����ʾû�з��ͳɹ�
	 * @param sendMPOJO
	 */
	public int updateErrStat(SendMPOJO sendMPOJO){
		JdbctempleManager s=JdbctempleManager.getInstance();
		JdbcTemplate jtp=(JdbcTemplate)s.getJdbctem();
		
		int c=jtp.update("update sms_log_new set flag='5' where flag='3' and [time]='"+sendMPOJO.getLinkId()+"' and mobile_no='"+sendMPOJO.getMobile()+"'");
		System.out.println("������"+c+"��!");
		return c;
	}
	
	/**
	 * ��鵱ǰ�Ƿ�����Ҫ���͵ļ�¼
	 * @return
	 */
	public int checkStatNum(){
		
		JdbctempleManager s=JdbctempleManager.getInstance();
		JdbcTemplate jtp=(JdbcTemplate)s.getJdbctem();
		int c=jtp.queryForInt("select count(1) num from sms_log_new where flag='3' and stat is not null and reserve is not null and (spcode in('9081112400','9081234001')) and left(msg,3)='tpx'");
		return c;
	}
	

}

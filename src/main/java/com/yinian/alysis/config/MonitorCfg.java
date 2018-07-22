package com.yinian.alysis.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yinian.alysis.util.PropertiesUtil;

public class MonitorCfg {
	/**
	 * quartz执行时间设置
	 */
	public static final String QUARZ_CRON_EXPRESSION = PropertiesUtil.getDataParam("quarz_cron_expression");
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sf.parse("0000-00-00 00:00:00");
		
		System.out.println(sf.format(d));
	}
}

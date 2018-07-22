package com.yinian.alysis.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yinian.alysis.exception.ExceptionHandle;
import com.yinian.alysis.mail.SendMail;
import com.yinian.alysis.tool.RemoteShellTool;
import com.yinian.alysis.transData.YinianUpdate2HiveUtil;
import com.yinian.alysis.transData.jdbc.HiveJdbc;
import com.yinian.alysis.transData.jdbc.MysqlJdbcYinian;
import com.yinian.alysis.util.PropertiesUtil;

public class UpdateJob implements Runnable{
	private static final Logger LOGGER =  LoggerFactory.getLogger(UpdateJob.class);
	@Override
	public void run() {
		LOGGER.info("更新数据同步任务开始");
			YinianUpdate2HiveUtil util = new YinianUpdate2HiveUtil();
	    	try {
	    		LOGGER.info("开始执行");
	    		util.addSynUpdateDataMysql2Hive(PropertiesUtil.getDataParam("bi.mysql.schema.yinian"));
	    		LOGGER.info("执行结束");
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("业务数据同步出现故障",e);
				SendMail.sendMail("数据同步出错", ExceptionHandle.getErrorInfoFromException(e), null);
			}finally {
//				MysqlJdbcYinian.getInstance().releaseConn();
//				HiveJdbc.getInstance().releaseConn();
//				RemoteShellTool.getInstance().releaseConn();
			}
	}

}

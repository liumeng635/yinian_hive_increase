package com.yinian.alysis;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yinian.alysis.tool.RemoteShellTool;
import com.yinian.alysis.transData.Yinian2HiveUtil;
import com.yinian.alysis.transData.jdbc.HiveJdbc;
import com.yinian.alysis.transData.jdbc.MysqlJdbcYinian;
import com.yinian.alysis.transData.jdbc.SyncInfoJdbc;

@SpringBootApplication
public class StartApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
		/*try {
			Yinian2HiveUtil util = new Yinian2HiveUtil();
			util.createListAllMysqlTable2Hive("yinian");
			util.syncMysqlData2Hive("yinian", true, null);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MysqlJdbcYinian.getInstance().releaseConn();
			HiveJdbc.getInstance().releaseConn();
			RemoteShellTool.getInstance().releaseConn();
		}*/
		
		/*Yinian2HiveUtil util = new Yinian2HiveUtil();
		SyncInfoJdbc jdbc = SyncInfoJdbc.getInstance();
		try {
			clear();
			jdbc.truncateTables();
			util.createListAllMysqlTable2Hive("yinian");
		} catch (Exception e) {
			e.printStackTrace();
		}
		MysqlJdbcYinian.getInstance().releaseConn();*/
	}
	
	
	public static void clear() throws SQLException{
		RemoteShellTool tool = RemoteShellTool.getInstance();
		HiveJdbc hive = HiveJdbc.getInstance();
		hive.excuteSql(" drop database yinian cascade");
		tool.exec(" hadoop fs -rmr .Trash/Current/user/hive/warehouse/yinian.db");
		hive.excuteSql(" create database yinian");
	}
}
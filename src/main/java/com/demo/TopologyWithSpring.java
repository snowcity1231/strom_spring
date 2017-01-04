package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.bolt.InsertBolt;
import com.demo.spout.FileSpout;
import com.demo.spring.util.SpringContextUtil;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

/** 
* @ClassName: Topology 
* @Description: Strom拓扑+spring boot
* @author xuechen
* @date 2017年1月3日 下午4:26:01 
*  
*/
@SpringBootApplication
@ComponentScan
@Configuration
@MapperScan("com.demo.spring.dao")
public class TopologyWithSpring {
	
	private static final String FILE_SPOUT_ID	= "file-spout"; 
	private static final String INSERT_BOLT_ID = "insert-bolt";

	public static void main(String[] args) {
		
		//启动spring
		ApplicationContext applicationContext = SpringApplication.run(TopologyWithSpring.class, args);
		SpringContextUtil.setApplicationContext(applicationContext);
		
		//拓扑流程
		TopologyBuilder builder = new TopologyBuilder();
		 
		// 设置数据读取节点以及并发数
		builder.setSpout(FILE_SPOUT_ID, new FileSpout(), 1);
		builder.setBolt(INSERT_BOLT_ID, new InsertBolt(), 1).shuffleGrouping(FILE_SPOUT_ID);
		
		Config config = new Config();
		config.setDebug(false);
		config.setMaxTaskParallelism(1);
		
		
		//本地模拟一个完整的storm集群
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("TopologyWithSpring", config, builder.createTopology());
		
	}
}

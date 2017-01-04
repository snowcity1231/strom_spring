package com.demo.bolt;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.demo.spring.bean.Student;
import com.demo.spring.service.StudentService;
import com.demo.spring.util.SpringContextUtil;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

/** 
* @ClassName: InsertBolt 
* @Description: 插入表单处理器
* @author xuechen
* @date 2017年1月3日 下午4:33:20 
*  
*/
@Component
public class InsertBolt extends BaseRichBolt{
	
	private StudentService studentService;
	private OutputCollector collector;

	/* (non-Javadoc)
	 * @see backtype.storm.task.IBolt#prepare(java.util.Map, backtype.storm.task.TopologyContext, backtype.storm.task.OutputCollector)
	 */
	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		studentService = (StudentService) SpringContextUtil.getBean("StudentService");
	}

	/* (non-Javadoc)
	 * @see backtype.storm.task.IBolt#execute(backtype.storm.tuple.Tuple)
	 */
	@Override
	public void execute(Tuple input) {
		String str = input.getString(0);
		System.out.println("----------------------" + str + "--------------------------");
		String[] strs = str.split(",");
		Student student = new Student();
		student.setId(Long.valueOf(strs[0]));
		student.setName(strs[1]);
		student.setAge(Integer.valueOf(strs[2]));
		student.setSex(strs[3]);
		studentService.insert(student);
	}

	/* (non-Javadoc)
	 * @see backtype.storm.topology.IComponent#declareOutputFields(backtype.storm.topology.OutputFieldsDeclarer)
	 */
	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

}

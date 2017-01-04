package com.demo.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.bean.Student;
import com.demo.spring.dao.StudentMapper;
import com.demo.spring.service.StudentService;

/** 
* @ClassName: StudentServiceImpl 
* @Description: TODO
* @author xuechen
* @date 2017年1月3日 下午5:25:39 
*  
*/
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentMapper studentMapper;

	/* (non-Javadoc)
	 * @see com.demo.spring.service.StudentService#insert(com.demo.spring.bean.Student)
	 */
	@Override
	public void insert(Student student) {
		System.out.println("insert-----------" + student.toString());
		studentMapper.insert(student);
	}

}

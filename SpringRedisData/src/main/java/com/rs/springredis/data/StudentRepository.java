package com.rs.springredis.data;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import com.rs.springredis.util.DataTable;

@SuppressWarnings("unchecked")
public class StudentRepository {
	public static ClassPathXmlApplicationContext context;
	private static Map<String, Student>studDB = new HashMap<String, Student>();
	private static RedisTemplate<String, Student> rt;
	
	static {
		// Acquire Context
		context = new ClassPathXmlApplicationContext("SpringContext.xml");
		rt = (RedisTemplate<String, Student>) context.getBean("redisTemplate");
	}
	
	public static void main(String [] args) throws Exception{
		loadStudent();
	}
	
	public static Map<String, Student> loadStudent()
	{
		int i = 0;
		for(String key : DataTable.rdKeys)
		{
			Student stud = readStudent(key);
			studDB.put(key, stud);
			System.out.print("ID: "+DataTable.id[i]+"\t");
			System.out.println(stud);
			i++;
		}
		//System.out.println(studDB);
		
		return studDB;
	}
	
	public static Student readStudent(String key){
		Student student = rt.opsForValue().get(key);
		
		return student;
	}
	
	public static void writeStudent(String key, Student student) {
		rt.opsForValue().set(key, student);
	}

}

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.*;

public class StoreStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session=new Configuration().configure().buildSessionFactory().openSession();
	/************************************************************
	        @@@@@@code for insert data into database@@@@@@@ 
	 	
		Student std=new Student();
		std.setFname("Nikhil");
		std.setSname("chandoba");
		std.setMarks(93);
		
		session.save(std);
		
		Student std1=new Student();
		std1.setFname("Nishant");
		std1.setSname("Patil");
		std1.setMarks(80);
		
		session.save(std1);
		
		Student std2=new Student();
		std2.setFname("Gotam");
		std2.setSname("Abhale");
		std2.setMarks(85);
		
		session.save(std2);
		
		Student std3=new Student();
		std3.setFname("Vinit");
		std3.setSname("Sing");
		std3.setMarks(82);
		
		session.save(std3);
		
		session.beginTransaction().commit();
		*************************************************************/
		
		Criteria cr=session.createCriteria(Student.class);//apply criteria to student class
		
	//    cr.createAlias("Student", "s");//to create alias
		cr.add(Restrictions.eq("marks", 80));//equality
		
		
	/*************Projection method in Criteria***************
	 	cr.add(Restrictions.gt("marks", 82));//grater than
	    cr.add(Restrictions.lt("marks", 92));//less than
	    cr.add(Restrictions.like("Fname", "n%"));//Start from
		cr.add(Restrictions.ilike("Sname","c%"));//
		cr.add(Restrictions.between("marks", 82, 92));
		cr.addOrder(Order.asc("marks"));
		cr.setFirstResult(2);
		cr.setMaxResults(4);
		
		*********************************************************/
		
		/******Projection method in Criteria******************
		 
		cr.setProjection(Projections.max("id"));  //to find maximum number in id column
	    cr.setProjection(Projections.avg("marks")); //to find average off marks column 
		cr.setProjection(Projections.sum("marks")); //Output will be sum off all values
		cr.setProjection(Projections.rowCount()); // return number row present 
		cr.setProjection(Projections.countDistinct("marks"));
		
	  ***********************************************************/
		
		//***************************for fetch output on console*****************
		
	//	System.out.println("projection result="+cr.uniqueResult());//for unique output.
		
		List<Student> result=cr.list();//for list form output.
		for(Student s:result){
			System.out.println("ID  "+s.getId());
		    System.out.println("Fname  "+s.getFname());
		    System.out.println("Sname  "+s.getSname());
		    System.out.println("Marks"+s.getMarks());
		}
		System.out.println("okk java");
		session.close();
	}

}

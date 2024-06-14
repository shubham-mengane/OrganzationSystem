package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;
	
	public String addCountry(Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {		
		 session= factory.openSession();
		tx=session.beginTransaction();		
		session.persist(c);
		tx.commit();
		msg="Country is addedd...";
		}catch (Exception e) {
						
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();			
		}finally {
			
			if(session!=null) {
				session.close();
			}			
		}
		
		return msg;		
	}

	public String updateCountry(int id, Country c) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {			
			session= factory.openSession();
			tx=session.beginTransaction();
			
			Country country= 
					session.get(Country.class, id);
			
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			
			msg="Country is updatated...";	
			
		}catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
		
	}

	public String addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			
			session = factory.openSession();
			tx=session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg="Employee Is Added";
			
		} catch (Exception e) {
			// TODO: handle exception
		
			if (tx!=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
		
		
	}

	public String updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			Employee employee = session.get(Employee.class, emp.getId());
			
			employee.setName(emp.getName());
			employee.setCountry(emp.getCountry());
			employee.setCreatedby(emp.getCreatedby());
			employee.setCreateddtm(emp.getCreateddtm());
			employee.setUpdatedby(emp.getUpdatedby());
			employee.setUpdateddtm(emp.getUpdateddtm());
			employee.setDepartment(emp.getDepartment());
			employee.setStatus(emp.getStatus());
			employee.setPhoneno(emp.getPhoneno());
			employee.setEmailid(emp.getEmailid());
			employee.setSalary(emp.getSalary());
			
			session.merge(employee);
			tx.commit();
			msg="Employee Updated Successfully";
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
		
	}

	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction tx = null;
		String msg = null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Employee emp = session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg = "Employee Is Deleted";
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
		
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuey = "from Employee";
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hqlQuey,Employee.class);
			list=query.list();
			tx.commit();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public Employee getParticularById(int id) {
		// TODO Auto-generated method stub
		
		Session session=null;
		Transaction tx=null;
		Employee emp = null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			emp = session.get(Employee.class, id);
			tx.commit();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return emp;
	}

	public Employee loginCheck(Employee emp) {
		// TODO Auto-generated method stub
		
		Session session=null;
		Transaction tx=null;
		Employee employee=null;
		
		
		String hqlQuey = "from Employee where emailid=:myemailid and phoneno=:myphoneno";
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hqlQuey,Employee.class);
			
			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("myphoneno", emp.getPhoneno());
			
			employee = query.uniqueResult();
			tx.commit();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return employee;
		
	}

	public List<Employee> getSalary(double salary) {
		// TODO Auto-generated method stub
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuey = "from Employee where salary>:mysalary";
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hqlQuey,Employee.class);
			query.setParameter("mysalary", salary);
			list = query.list();
			tx.commit();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	public List<Employee> rangeSalary(double salary) {
		// TODO Auto-generated method stub
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuey = "from Employee where salary BETWEEN 100000 AND 200000 ";
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hqlQuey,Employee.class);
			
			list = query.list();
			tx.commit();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;

		
	}

	public List<Employee> empCountry(String country) {
		// TODO Auto-generated method stub
		
		Session session=null;
		Transaction tx=null;
		List<Employee> list=null;
		String hqlQuey = "from Employee where country=:mycountry";
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
			Query<Employee> query = session.createQuery(hqlQuey,Employee.class);
			query.setParameter("mycountry", country);
			list = query.list();
			tx.commit();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
	}

	
}

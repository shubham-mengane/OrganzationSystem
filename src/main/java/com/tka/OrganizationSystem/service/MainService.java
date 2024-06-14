package com.tka.OrganizationSystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	public String addCountry(Country c) {
		
		String msg= dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			msg="Country is not addedd...";
		}
		
		return msg;
	}
	
		public String updateCountry(int id, Country c) {
		
		String msg= dao.updateCountry(id,c);
		if(Objects.isNull(msg)) {
			msg="Country is not Updatated..";
		}
		
		return msg;
		
	}

		public String addEmployee(Employee emp) {
			// TODO Auto-generated method stub
			
			String msg = dao.addEmployee(emp);
			
			if (Objects.isNull(msg)) {
				
				msg="Employee Record Is Not Added";
				
			}
			return msg;
			
		}

		public String updateEmployee(Employee emp) {
			// TODO Auto-generated method stub
			
			String msg = dao.updateEmployee(emp);
			if(Objects.isNull(msg)) {
				msg="Record Is Not Updated";
			}
			return msg;
		}

		public String deleteEmployee(int id) {
			// TODO Auto-generated method stub
			
			String msg = dao.deleteEmployee(id);
			
			if(Objects.isNull(msg)) {
				msg = "Record Is Not Deleted";
			}
			
			return msg;
		}

		public List<Employee> getAllEmployee() {
			// TODO Auto-generated method stub
			
			List<Employee> list = dao.getAllEmployee();
			
			if(Objects.isNull(list)) {
				list=null;
			}
			
			return list;
		}

		public Employee getParticularById(int id) {
			// TODO Auto-generated method stub
			
			Employee emp = dao.getParticularById(id);
			
			if(Objects.isNull(emp)) {
				emp = null;
			}
			
			return emp;
		}

		public HashMap loginCheck(Employee emp) {
			// TODO Auto-generated method stub
			
			Employee e = dao.loginCheck(emp);
			
			HashMap map = new HashMap();
			
			if(Objects.isNull(e)) {
				
				map.put("msg", "Invalid User");
				map.put("user", e);
				
			}
			else {
				
				map.put("msg", "valid User");
				map.put("user", e);
				
			}
			
			return map;
			
		}

		public List<Employee> getSalary(double salary) {
			// TODO Auto-generated method stub
			
			List<Employee> list = dao.getSalary(salary);
			
			if(Objects.isNull(list)) {
				list=null;
			}
			return list;
		}

		public List<Employee> rangeSalary(double salary) {
			// TODO Auto-generated method stub
			
			List<Employee> list = dao.rangeSalary(salary);
			
			if(Objects.isNull(list)) {
				list=null;
			}
			return list;
		}

		public List<Employee> empCountry(String country) {
			// TODO Auto-generated method stub
			
			List<Employee> list = dao.empCountry(country);
			
			if(Objects.isNull(list)) {
				list=null;
			}
			
			return list;
		}

		
	
	
}

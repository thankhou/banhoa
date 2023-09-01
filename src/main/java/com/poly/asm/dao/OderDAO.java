package com.poly.asm.dao;


import com.poly.asm.entity.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OderDAO extends JpaRepository<Order,Long> {
	@Query("SELECT o FROM Order o WHERE o.account.username=?1")
	List<Order> findByUsername(String username);
	
	@Query(value = "select year(create_date)" + 
					" from orders" +
					" group by year(create_date)",
		nativeQuery = true)	
    List<Integer> findByYear();
	
	@Query(value = "select MONTH(o.create_date) as month, SUM(o.tongtien) as totalRevenue" + 
			" from orders o" +
			" where YEAR(o.create_date) = ?1" +
			" group by MONTH(o.create_date)",
			nativeQuery = true)
	List<Object[]> findByDoanhThuNam(int year);
	
	@Query("SELECT o FROM Order o ORDER BY o.createDate DESC")
    List<Order> findAllOrderByCreateDateDesc();
}

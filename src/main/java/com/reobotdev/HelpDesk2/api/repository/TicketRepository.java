package com.reobotdev.HelpDesk2.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.reobotdev.HelpDesk2.api.entity.TicketService;

public interface TicketRepository extends JpaRepository<TicketService, Integer>{
	
Page<TicketService> findByUserIdOrderByDateDesc(Pageable pages,String userId);
	
	Page<TicketService> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(
			String title,String status,String priority,Pageable pages);
	
	Page<TicketService> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndUserIdOrderByDateDesc(
			String title,String status,String priority,String userId,Pageable pages);
	
	Page<TicketService> findByNumber(Integer number,Pageable pages);
	
	Page<TicketService> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndAssignedUserIdOrderByDateDesc(
			String title,String status,String priority,String assignedUserId,Pageable pages);

}

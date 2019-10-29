package com.reobotdev.HelpDesk2.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.reobotdev.HelpDesk2.api.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages,String userId);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingOrderByDateDesc(
			String title,String status,String priority,Pageable pages);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndUserIdOrderByDateDesc(
			String title,String status,String priority,String userId,Pageable pages);
	
	Page<Ticket> findByNumber(Integer number,Pageable pages);
	
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusIgnoreCaseContainingAndPriorityIgnoreCaseContainingAndAssignedUserIdOrderByDateDesc(
			String title,String status,String priority,String assignedUserId,Pageable pages);

}

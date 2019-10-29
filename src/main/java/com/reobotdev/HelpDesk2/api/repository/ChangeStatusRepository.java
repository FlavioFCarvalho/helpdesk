package com.reobotdev.HelpDesk2.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reobotdev.HelpDesk2.api.entity.ChangeStatus;

public interface ChangeStatusRepository extends JpaRepository<ChangeStatus, Integer> {
	Iterable<ChangeStatus> findByTicketIdOrderByDateChangeStatusDesc(String ticketId);

}

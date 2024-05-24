package com.Ascendia.server.repository.ProjectManager;

import com.Ascendia.server.entity.ProjectManager.Task;
import com.Ascendia.server.entity.ProjectManager.UserProjectAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProjectAssignmentRepository  extends JpaRepository<UserProjectAssignment, Long> {
    List<UserProjectAssignment> findByProjectProjectId(Long projectId);

    @Query("SELECT assignment FROM UserProjectAssignment assignment WHERE " +
            "assignment.project.projectId = :projectId AND " +
            "(assignment.assignedUser.firstName LIKE %:query% OR " +
            "assignment.assignedUser.lastName LIKE %:query% OR " +
            "assignment.assignedUser.department LIKE %:query%)")
    List<UserProjectAssignment> searchAssignment(Long projectId, String query);



}

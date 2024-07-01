package com.Ascendia.server.entity.ProjectManager;

import com.Ascendia.server.entity.Project.Project;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "task")
@JsonIgnoreProperties({"project"}) // Prevent infinite recursion
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @Column(nullable = false, length = 100)
    private String taskName;
    @Column(nullable = false, length = 1000)
    private String description;
    @Column
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;

    @Column(nullable = false)
    private LocalDate createdDate;

    @Column(name = "current_status")
    private String status;

    @Column(name = "previous_status")
    private String prevStatus;

    @Column(nullable = false)
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false, referencedColumnName = "projectId")
    @JsonBackReference // Prevent infinite recursion
    private Project project;


}

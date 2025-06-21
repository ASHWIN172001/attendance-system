package com.attendance.attendance_system.repo;

import com.attendance.attendance_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<User, Integer> {

}

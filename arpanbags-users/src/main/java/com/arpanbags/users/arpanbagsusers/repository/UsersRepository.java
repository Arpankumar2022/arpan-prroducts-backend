package com.arpanbags.users.arpanbagsusers.repository;

import com.arpanbags.users.arpanbagsusers.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
}

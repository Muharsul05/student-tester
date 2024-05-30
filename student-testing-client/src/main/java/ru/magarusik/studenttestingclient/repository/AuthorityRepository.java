package ru.magarusik.studenttestingclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.magarusik.studenttestingclient.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByAuthority(String authority);
}

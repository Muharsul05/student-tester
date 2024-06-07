package ru.magarusik.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.magarusik.client.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByAuthority(String authority);
}

package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.LibrarianDto;

public interface LibrarianRepository extends JpaRepository<LibrarianDto, Long> {

}

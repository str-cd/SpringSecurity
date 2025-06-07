package com.springSecurity.Repository;

import com.springSecurity.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findByOwnerUsername(String ownerUsername);

}

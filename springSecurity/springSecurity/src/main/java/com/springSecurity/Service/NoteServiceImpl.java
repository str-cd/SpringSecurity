package com.springSecurity.Service;

import com.springSecurity.Model.Note;
import com.springSecurity.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository  noteRepository;

    @Override
    public Note createNoteForUser(String userName, String content) {
        Note note = new Note();

        note.setContent(content);
        note.setOwnerUsername(userName);

        return noteRepository.save(note);
    }

    @Override
    public Note UpdateNoteForUser(Long noteId, String userName, String content) {
        Note note = noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Notes not Found"));
        note.setContent(content);
        return noteRepository.save(note);
    }

    @Override
    public void deleteNoteForUser(Long noteId, String userName) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesForUser(String userName) {
        return noteRepository.findByOwnerUsername(userName);
    }
}

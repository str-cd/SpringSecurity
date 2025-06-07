package com.springSecurity.Service;

import com.springSecurity.Model.Note;

import java.util.List;

public interface NoteService {

    Note createNoteForUser(String userName,String content);

    Note UpdateNoteForUser(Long noteId, String userName,String content);

    void deleteNoteForUser(Long noteId, String userName);

    List<Note> getNotesForUser(String userName);

}

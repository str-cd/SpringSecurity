package com.springSecurity.Controller;

import com.springSecurity.Model.Note;
import com.springSecurity.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping()
    public Note createNote(@RequestBody String content,
                           @AuthenticationPrincipal UserDetails userDetails){ // AuthenticationPrincipal -It comes from springSecurity which help to get the details of the currently logged-in user
        String userName = userDetails.getUsername();
        return noteService.createNoteForUser(userName,content);
    }

    @GetMapping
    public List<Note> getUserNotes(@AuthenticationPrincipal UserDetails userDetails){
        String userName = userDetails.getUsername();
        return noteService.getNotesForUser(userName);
    }

    @PutMapping("/ ")
    public Note updateNotes(@AuthenticationPrincipal UserDetails userDetails,
                            @PathVariable Long noteId,
                            @RequestBody String content){
        String userName = userDetails.getUsername();

       return noteService.UpdateNoteForUser(noteId,userName,content);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId,@AuthenticationPrincipal UserDetails userDetails ){
        String userName = userDetails.getUsername();
        noteService.deleteNoteForUser(noteId,userName);
    }






}

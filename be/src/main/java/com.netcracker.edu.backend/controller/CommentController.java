package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Comment;
import com.netcracker.edu.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)//сопоставление запросов
    public ResponseEntity<Comment> getCommentById(@PathVariable(name = "id") Long id){
        Optional<Comment> comment = commentService.getCommentById(id);
        if(comment.isPresent()){
            return ResponseEntity.ok(comment.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }//ответ

    @RequestMapping(value = "", method = RequestMethod.GET)//сопоставление запросов
    public Iterable<Comment> getAllComment(){
        return commentService.getAllComment();
    }//ответ

    @RequestMapping(method = RequestMethod.POST)//сопоставление запросов
    public Comment saveComment(@RequestBody Comment comment){
        return this.commentService.saveComment(comment);
    }//ответ

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)//сопоставление запросов
    public ResponseEntity deleteCommentById(@PathVariable(name = "id") Long id){
        this.commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }//ответ
}

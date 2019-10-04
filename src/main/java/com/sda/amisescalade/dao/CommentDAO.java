package com.sda.amisescalade.dao;

import com.sda.amisescalade.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment, Long> {
}

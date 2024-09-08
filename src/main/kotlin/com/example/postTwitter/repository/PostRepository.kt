package com.example.postTwitter.repository

import com.example.postTwitter.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    //fun
}
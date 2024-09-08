package com.example.postTwitter.dto.response

import com.example.postTwitter.domain.Post
import java.time.LocalDateTime

class ReadResponseDto (
    var author:String,
    var title:String,
    var dateTime:LocalDateTime,
    var content:String,
    var expose:Long,
    var like:Long,
    var repost:Long
){
    constructor(post: Post):this(
            author = post.author,
            title = post.title,
            dateTime = post.datetime,
            content = post.content,
            expose = post.expose,
            like = post.like,
            repost = post.repost
    )
}
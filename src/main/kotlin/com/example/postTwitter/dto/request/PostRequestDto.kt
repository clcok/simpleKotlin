package com.example.postTwitter.dto.request

import com.example.postTwitter.domain.Post
import java.time.LocalDateTime

class PostRequestDto (
        var author : String,
        var title : String,
        var content : String ?= null
){
    fun toEntity(): Post = Post(
            author = author,
            title = title,
            content = content ?: "",  // null일 경우 빈 문자열로 처리
            datetime = LocalDateTime.now(),  // 현재 날짜를 자동으로 설정
    )
}
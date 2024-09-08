package com.example.postTwitter.controller

import com.example.postTwitter.dto.request.PostRequestDto
import com.example.postTwitter.dto.request.UpdateRequestDto
import com.example.postTwitter.dto.response.ReadResponseDto
import com.example.postTwitter.service.PostService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PostController (
        private val postService: PostService
)   {

    @PostMapping("/post") //게시글 쓰기
    fun post(@RequestBody postRequestDto: PostRequestDto) = postService.save(postRequestDto)

    @ExceptionHandler
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.message)
    }

    @PostMapping("/delete/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity<String> {
        postService.delete(id)
        return ResponseEntity.ok("게시글이 삭제되었습니다.")
    }

    @PutMapping("/update/{id}") //게시물 업데이트
    fun update(@PathVariable id: Long,@RequestBody updateRequestDto: UpdateRequestDto): ResponseEntity<String>{
        postService.update(id, updateRequestDto)
        return ResponseEntity.ok("게시물이 업데이트되었습니다.")
    }

    //전체 게시물
    @GetMapping("/read/all")
    fun readAll(): List<ReadResponseDto>{
        return postService.readALl()
    }

    //개별 게시물
    @GetMapping("/read/{id}")
    fun readOne(@PathVariable id:Long): ReadResponseDto{
        return postService.readOne(id)
    }

}
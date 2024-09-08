package com.example.postTwitter.service

import com.example.postTwitter.domain.Post
import com.example.postTwitter.dto.request.PostRequestDto
import com.example.postTwitter.dto.request.UpdateRequestDto
import com.example.postTwitter.dto.response.ReadResponseDto
import com.example.postTwitter.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService (private val postRepository: PostRepository){

    fun save(postRequestDto: PostRequestDto) : Post {
        val post = postRequestDto.toEntity()
        return postRepository.save(post)
    }

    fun delete(id:Long) {
        val post = postRepository.findById(id).orElseThrow {
            IllegalArgumentException("id = $id, (삭제)해당하는 게시글이 없습니다.")
        }
        postRepository.delete(post)
    }

    fun update(id:Long, updateRequestDto: UpdateRequestDto){
        val targetPost:Post = postRepository.findById(id).orElseThrow{
            IllegalArgumentException("id = $id, (업데이트)해당하는 게시글이 없습니다.")
        }
        targetPost.title = updateRequestDto.title
        targetPost.content = updateRequestDto.content

        postRepository.save(targetPost)
    }

    fun readOne(id: Long): ReadResponseDto{
        val readTarget : Post = postRepository.findById(id).orElseThrow{
            IllegalArgumentException("id = $id, (읽기)해당하는 게시글이 없습니다.")
        }

        readTarget.expose += 1 // 노출됐으니 1상승
        postRepository.save(readTarget)

        val readOne = ReadResponseDto(readTarget)

        return readOne
    }

    fun readALl(): List<ReadResponseDto>{
        val listOfPost: List<Post> = postRepository.findAll()
        val listOfResponseDto: List<ReadResponseDto> = listOfPost.map {Post->ReadResponseDto(Post)}
        return listOfResponseDto
    }
}
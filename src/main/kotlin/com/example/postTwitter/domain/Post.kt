package com.example.postTwitter.domain


import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,

    @Column
    (length = 10, nullable = false)
    val author: String,// 게시자

    @Column
    (length = 100, nullable = false)
    var title: String, // 제목

    @Column
    (nullable = false)
    var datetime: LocalDateTime, // 게시시 게시 시간이 자동 입력이 되도록 적용하기 위해 사용.

    @Column
    (nullable = false)
    var content: String, // 내용

    @Column
    (nullable = false)
    var expose: Long = 0L, // 조회될 때마다 +1 증가하며 같이 보여줄 값.

    @Column
    var like: Long = 0L, // like버튼 누를 시 증가할 값.

    @Column
    var repost: Long = 0L // 재게시할 시 증가할 값.

    /***constructor(author: String, title: String, content: String, expose: Long, like: Long, repost: Long) {
        this.author = author
        this.title = title
        this.datetime = LocalDate.now()
        this.content = content
        this.expose = expose
        this.like = like
        this.repost = repost
    }***/
)
package org.example.board.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "boarddb")
@Getter
@Setter
@NoArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 증가
    private int num;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String pwd;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 200)
    private String subject;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, length = 50)
    private String ipAddr;

    @Column(updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String created;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private int hitCount;

    // DTO → Entity 변환
    public static BoardEntity fromDTO(org.example.board.DTO.BoardDTO dto) {
        BoardEntity entity = new BoardEntity();
        entity.setName(dto.getName());
        entity.setPwd(dto.getPwd());
        entity.setEmail(dto.getEmail());
        entity.setSubject(dto.getSubject());
        entity.setContent(dto.getContent());
        entity.setIpAddr(dto.getIpAddr());
        entity.setHitCount(dto.getHitCount());
        return entity;
    }

    // Entity → DTO 변환
    public org.example.board.DTO.BoardDTO toDTO() {
        org.example.board.DTO.BoardDTO dto = new org.example.board.DTO.BoardDTO();
        dto.setNum(this.num);
        dto.setName(this.name);
        dto.setPwd(this.pwd);
        dto.setEmail(this.email);
        dto.setSubject(this.subject);
        dto.setContent(this.content);
        dto.setIpAddr(this.ipAddr);
        dto.setCreated(this.created);
        dto.setHitCount(this.hitCount);
        return dto;
    }
}


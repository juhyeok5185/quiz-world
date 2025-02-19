package com.danny.quizworld.common.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {

    @Column(name = "use_yn")
    private Boolean useYn;

    @Column(name = "save_dtm")
    private LocalDateTime saveDtm; // 등록일시

    @Column(name = "mod_dtm")
    private LocalDateTime modDtm; // 최종 수정일시

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.useYn = true;
        this.saveDtm = now;
        this.modDtm = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modDtm = LocalDateTime.now();
    }

    public void updateUseYn(){
        this.useYn = !this.useYn;
    }
}

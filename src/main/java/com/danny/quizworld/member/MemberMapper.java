package com.danny.quizworld.member;

import com.danny.quizworld.common.util.AES256Utils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "name", source = "name", qualifiedByName = "encrypt")
    @Mapping(target = "authId", source = "authId", qualifiedByName = "encrypt")
    @Mapping(target = "nickname", source = "nickname", qualifiedByName = "encrypt")
    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "deviceToken", constant = "null")
    @Mapping(target = "likeCount", constant = "0")
    @Mapping(target = "score", constant = "0")
    @Mapping(target = "loginToken" , ignore = true)
    @Mapping(target = "loginTokenExpiry" , ignore = true)
    @Mapping(target = "subscribeYn", constant = "false")
    @Mapping(target = "businessYn", constant = "false")
    Member toEntity(String name, String authId , String nickname);

    @Mapping(target = "name", source = "name", qualifiedByName = "decrypt")
    @Mapping(target = "authId", source = "authId", qualifiedByName = "decrypt")
    @Mapping(target = "nickname", source = "nickname", qualifiedByName = "decrypt")
    MemberResponse toResponse(Member member);

    @Named("encrypt")
    static String encrypt(String value) {
        return AES256Utils.encrypt(value);
    }

    @Named("decrypt")
    static String decrypt(String value) {
        return AES256Utils.decrypt(value);
    }
}

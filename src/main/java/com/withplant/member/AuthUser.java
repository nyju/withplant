package com.withplant.member;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) // 런타입까지 유지되어야 함
@Target(ElementType.PARAMETER) // 파라미터를 붙일 수 있도록
@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? null : member") // 현재 객체가 anonymousUser라면 null 아니면 account 값을 꺼내서 설정
public @interface AuthUser {
}

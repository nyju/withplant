# 스프링 JPA 프로젝트

[tistory_blog 정리내용 보기](https://anjuna.tistory.com/category/Study/web)

* 파일 다중 업로드
  * [jquery upload file 라이브러리](https://plugins.jquery.com/uploadfile/)
  * 파일을 여러개 선택하여 등록
  * 업로드한 이미지 미리보기 기능
  * ByteArray를 이용하여 파일 출력
* Thymeleaf 와 SpringSecurity
  * thymeleaf-extras-springsecurity
  * 사용자 정보 및 권한등을 쉽게 가져올 수 있음
  * https://github.com/thymeleaf/thymeleaf-extras-springsecurity 참조
* Thymeleaf Fragment Layout
* Rest 방식의 댓글 CURD 기능

  |기능|URL|
  |:---|:---:|
  |CREATE|/write/{itemId}|
  |READ|/list/{itemId}|
  |UPDATE|/update/{itemId}/{commentId}|
  |DELETE|/delete/{itemId}/{commentId}|

* OAuth구글 소셜 로그인
  * Spring Security Oauth2 Client 라이브러리
  * CustomOAuth2UserService
  * OAuth2User, spring security UserDetails 구현
  * spring security - loadUserByUsername 설정필요



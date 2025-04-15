Project
1.RESTAPI (ApiResponse 객체로 return 통일)
2.DDD 도메인 중심 설계 
    1) Service 는 도메인의 Entity 조회의 업무만 수행 (Facade 패턴 사용)
    2) store , reader 패턴 사용
    3) validator 사용
    4) factory 패턴(추가 예정)
3.MapStruct Mapper 객체로 toEntity , toResponse 관리

Security
1. Spring Security CSRF 적용
2. Oauth2.0 (네이버 로그인) 적용

Server
1.lets encrypt ssl 적용
2.certbot 으로 자동 ssl 갱신 구현
3.80포트 nginx 실행으로 ssl 적용 -> docker 내부 8080포트 프로젝트 실행

자동배포
1.Github Actions (github secret 사용으로 계정정보 숨김처리)
    1) docker image build
    2) docker hub repository push
    4) jenkins 호출
2.jenkins
    1) docker hub repository pull
    2) docker stop , rm
    3) container 실행
    4) 전에 사용했던 docker image 삭제

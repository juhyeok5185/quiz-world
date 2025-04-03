Project
1.RESTAPI (ApiResponse 객체로 return 통일)
2.DDD 도메인 중심 설계 (Service 는 도메인의 Entity 조회의 업무만 수행 , Facade 패턴 사용)
3.MapStruct Mapper 객체로 toEntity , toResponse 관리

Server
1.lets encrypt ssl 적용
2.certbot 으로 자동 ssl 갱신 구현
3.80포트 nginx 실행으로 ssl 적용 -> docker 내부 8080포트 프로젝트 실행

자동배포
1.Github Actions 
    1) docker image build
    2) docker hub repository push
    3) jenkins 호출
2.Jenkins
    1) image pull
    2) container 실행
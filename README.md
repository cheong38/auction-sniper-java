# Auction Sniper - Java

## 개요
[테스트 주도 개발로 배우는 객체지향 설계와 실천](http://www.insightbook.co.kr/book/programming-insight/%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%A3%BC%EB%8F%84-%EA%B0%9C%EB%B0%9C%EB%A1%9C-%EB%B0%B0%EC%9A%B0%EB%8A%94-%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EC%84%A4%EA%B3%84%EC%99%80-%EC%8B%A4%EC%B2%9C) 내의 예제를 실제로 구현

## 할 일
- [x] 단일 품목: 참여, 입찰하지 않은 상태로 낙찰 실패
- [ ] 단일 품목: 참여, 입찰 및 낙찰 실패
- [ ] 단일 품목: 참여, 입찰 및 낙찰
- [ ] 단일 품목: 가격 상세 표시
- [ ] 여러 품목
- [ ] GUI 를 통해 품목 추가
- [ ] 매매 지시 지정 가격에서 입찰을 중단


## 유의점
- Swing 의 테스트 프레임워크로 윈도리커 대신 [AssertJ Swing](http://joel-costigliola.github.io/assertj/assertj-swing.html) 을 사용

## 개발 환경
- Java 8
- gradle
- IntelliJ IDEA
- docker

## 테스트 실행

테스트 용 [openfire 서버를 도커](https://hub.docker.com/r/sameersbn/openfire/)로 실행한다. (XMPP 브로커)
```
$ chmod +x run-test-openfire.sh
# run-test-openfire.sh
```

openfire 에 어드민으로 접속해 테스트용 계정을 만든다.

- 브라우저에서 localhost:9090 에 접속하여 어드민 계정 설정
- 어드민 설정 시 서버 도메인을 localhost 로 설정
- ID: auction-item-54321, PW: auction / ID: sniper PW: sniper 를 각각 생성

`AuctionSniperEndToEndTest` 에서 테스트 케이스 실행
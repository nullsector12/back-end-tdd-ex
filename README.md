#back-end-tdd

``` yaml

server:
  port: 20000

spring:
  datasource:
    hikari:
      jdbc-url: jdbc:mysql://localhost:43306/piece_sale?useSSL=false&useUnicode=yes&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=Asia/Seoul&zeroDateTimeBehavior=convertToNull&allowPublicKeyRetrieval=TRUE
      username: root
      password: 3306

      pool-name: piece-sale-command-local
      minimum-idle: 10 # performance first
      maximum-pool-size: 10 # 10 default

mysql 9.2 버전 커맨드

`docker inspect ${docker-network name}`

"5eeaac3913acea40ea3540e77ba68073f82e805bea0d3e0777b034a24e0465b0": {
    "Name": "read-mysql",
    "EndpointID": "08478ac6eb79e6e00760b422c6a465b4c0a1625e54ab561fcb0b4615a911d5a5",
    "MacAddress": "02:42:ac:17:00:03",
    "IPv4Address": "172.23.0.3/16",
    "IPv6Address": ""
},
"a16e2c9d610ea135f07bed934999a90f7f80fa7e2d2a2fbecfdad2ff987285aa": {
    "Name": "write-mysql",
    "EndpointID": "7c849623585a2766847fcf9730c978cb9a6b50d6ee1f49f0526877dc5909a5b1",
    "MacAddress": "02:42:ac:17:00:02",
    "IPv4Address": "172.23.0.2/16",
    "IPv6Address": ""
}

-> main의 IPv4Address 메모해두기

`docker exec -it $container mysql -u $user -p`을 통해 write-mysql 컨테이너에 접속

`SHOW REPLICA STATUS\G` 명령어를 통해 현재 상태 확인

+------------------+----------+--------------+------------------+-------------------+
| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
+------------------+----------+--------------+------------------+-------------------+
| mysql-bin.000003 |      158 | cassette     |                  |                   |
+------------------+----------+--------------+------------------+-------------------+

file과 position을 기억해두기

`docker exec -it $container mysql -u $user -p`을 통해 read-mysql 컨테이너에 접속

`CHANGE REPLICATION SOURCE TO
SOURCE_HOST='source-ip',
SOURCE_USER='user',
SOURCE_PASSWORD='password',
SOURCE_LOG_FILE='file',
SOURCE_LOG_POS=position,
GET_SOURCE_PUBLIC_KEY=1;
`

`START REPLICA;`

`SHOW REPLICA STATUS\G` 명령어를 통해 현재 상태 확인

Replica_IO_Running: Yes
Replica_SQL_Running: Yes
이라면 성공적으로 복제가 완료


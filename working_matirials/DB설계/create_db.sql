mysql -u root -p
(mypassword)

CREATE DATABASE AGENCY_PLATFORM;

create user 'AGENT1' identified by '1234';

grant all privileges on AGENCY_PLATFORM.* to 'AGENT1';
  -- 일부권한 : grant insert,update,index,alter on APIPORTAL.* to 'apiportal';

flush privileges;


------------------------------------------------------------

[참고]
사용자조회
----------
mysql>use mysql;
mysql>SELECT host, user FROM user;

사용자 권한 조회
----------------
mysql>SHOW GRANTS FOR 'testuser'@'localhost'

database 삭제
---------------
mysql>DROP DATABASE testdb;

사용자 삭제
-----------
mysql>DROP USER 'testuser'@'localhost';

모든 권한 제거
--------------
REVOKE ALL ON testdb.* FROM 'testuser'@'localhost';
  -- testdb에 대한 testuser의 모든 권한을 제거한다.

특정 명령어에 대한 권한을 제거
------------------------------
REVOKE DROP ON testdb.* FROM 'testuser'@'localhost';
  -- testdb에 대한 testuser의 DROP 권한을 제거한다.
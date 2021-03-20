call mvn package -Dmaven.test.skip=true

call scp target\demo-0.0.1-SNAPSHOT.jar root@123.57.160.67:~/ibm


ps -ef|grep info-1.0-SNAPSHOT.jar|awk '{print $2}'|xargs kill -9

mvn clean package -Dmaven.test.skip=true

cp target/info-1.0-SNAPSHOT.jar ./info-1.0-SNAPSHOT.jar

nohup java -jar ./info-1.0-SNAPSHOT.jar > ./nohup.out &



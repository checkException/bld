# 打开页面的跳转地址
http://localhost:8060/bld/home/index
http://localhost:8060/bld/login

阿里云服务器页面地址
http://120.27.245.71:8080/bld/home/index
接口地址
http://120.27.245.71:8090/api/login/submit




-- 利用mybatis-generator 生产 xml dao bean等配置文件的方法
打开 bld-service 下 resource/mybatis 修改mybatisGeneratorinit.properties 文件下的 表名和要生产的文件名
修改后执行  mvn mybatis-generator:generate 或者 打开maven-project 执行  mybatis-generator:generate
注意：如果手动修改过生成的文件，再次生成是会覆盖，请修改目录 或者备份
--            ---------------------------------------------------------------------------

-- 项目永久启动方式
nohup java -jar bld-web-1.0-SNAPSHOT.jar > system.log 2>&1 &
nohup java -jar system-api.jar --spring.profiles.active=test > api.log 2>&1 &


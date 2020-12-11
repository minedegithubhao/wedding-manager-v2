# 父镜像
FROM 172.16.19.14:9877/base_java/openoffice_417:v1.0.3
MAINTAINER  VENUS <achilles@venus.com>
VOLUME /tmp
# 添加jar包到容器并重命名
ARG JAR_FILE
ADD ${JAR_FILE}-linux.tar.gz /achilles-pts-b
RUN bash -c 'touch /achilles-pts-b'
# 使用端口
EXPOSE 6001
# 运行jar包   achilles-pts-b/achilles-pts-b
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/achilles-pts-b/achilles-pts-b/lib/achilles-pts-b.jar"]
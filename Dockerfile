FROM centos:centos7

MAINTAINER Brian Jolly <brian@brianjolly.com>

RUN yum -y -q upgrade
RUN yum -y install tomcat

ADD tomcat_config/tomcat /usr/sbin/tomcat

EXPOSE 8080

ENTRYPOINT [ "/usr/sbin/tomcat", "foreground"]
CMD []


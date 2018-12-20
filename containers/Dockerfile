FROM debian:latest
Maintainer Abhishek Anand Amralkar<abhishekamralkar@pm.me>



#assign the $ZOOKEEPER_VERSION arg to the ZOOKEEPER_VERSION ENV so that it can be accessed
#by the subsequent RUN call within the container
ENV ZOOKEEPER_VERSION $ZOOKEEPER_VERSION


RUN apt-get upgrade && apt-get upgrade

# Install Java.

RUN \
  apt-get update && \
  apt-get install -y openjdk-8-jdk wget && \
  rm -rf /var/lib/apt/lists/*

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

# Install Zookeeper
RUN wget -q -O - http://mirror.csclub.uwaterloo.ca/apache/zookeeper/zookeeper-3.4.13/zookeeper-3.4.13.tar.gz | tar -xzf - -C /opt \
    && mv /opt/zookeeper-3.4.13 /opt/zookeeper \
    && cp /opt/zookeeper/conf/zoo_sample.cfg /opt/zookeeper/conf/zoo.cfg

EXPOSE 2181 2888 3888

WORKDIR /opt/zookeeper

VOLUME ["/opt/zookeeper/conf", "tmp/zookeeper"]

ENTRYPOINT ["/opt/zookeeper/bin/zkServer.sh"]

CMD ["start-foreground"]

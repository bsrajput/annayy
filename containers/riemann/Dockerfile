FROM clojure:openjdk-11-tools-deps

MAINTAINER Abhishek Amralkar

ENV RIEMANN_VERSION 0.3.1

ADD https://github.com/riemann/riemann/releases/download/${RIEMANN_VERSION}/riemann_${RIEMANN_VERSION}_all.deb /tmp/
RUN dpkg -i /tmp/riemann_${RIEMANN_VERSION}_all.deb
RUN rm /tmp/riemann* 
RUN mkdir -p /etc/riemann/conf.d

COPY riemann.config /etc/riemann/
COPY include /etc/riemann/include
EXPOSE 5555 5556

CMD ["start"]
ENTRYPOINT ["/usr/bin/riemann"]

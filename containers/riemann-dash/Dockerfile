FROM ruby:2.5-slim

MAINTAINER Abhishek Amralkar <abhishekamralkar@pm.me>

RUN apt-get update && \
    apt-get -y dist-upgrade && \
    apt-get -y install --no-install-recommends build-essential && \
    gem install --no-ri --no-rdoc \
        riemann-dash \
        thin && \
    apt-get -y remove build-essential && \
    apt-get -y autoremove && \
    apt-get clean


RUN mkdir /riemann-dash

WORKDIR /riemann-dash
#COPY config.rb /riemann-dash/

EXPOSE 4567

CMD ["riemann-dash"]


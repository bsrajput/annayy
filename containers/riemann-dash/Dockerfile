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

EXPOSE 4567

#RUN mkdir /etc/riemann /custom
#ADD ./config.rb /etc/riemann/riemann-dash-config.rb
CMD ["riemann-dash", "/etc/riemann/config.rb"]

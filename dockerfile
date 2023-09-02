FROM ubuntu

#version of chrome
ENV CHROME_VERSION 113.0.5672.63
ENV EDGE_VERSION 114.0.1823.11

# Workspace
WORKDIR /usr/share/Ecommerce

#installing dependency and updating pre-existing libs
RUN echo "Updating Packages.";apt-get update -y  >>  update.log
RUN echo "Installing Jdk..";apt-get install openjdk-11-jdk -y >> java.log
RUN echo "Installing wget...";apt-get install wget -y >> wget.log
RUN echo "Installing unzip....";apt-get install unzip -y >> unzip.log

#installing Chrome
RUN wget -q http://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_${CHROME_VERSION}-1_amd64.deb --no-verbose
RUN apt-get install ./google-chrome-stable_${CHROME_VERSION}-1_amd64.deb -y >> chrome.log

#installing edge
#RUN wget -q https://packages.microsoft.com/repos/edge/pool/main/m/microsoft-edge-stable/microsoft-edge-stable_${EDGE_VERSION}-1_amd64.deb --no-verbose
#RUN apt-get install ./microsoft-edge-stable_${EDGE_VERSION}-1_amd64.deb -y

#installing Chromedriver and moving it to /usr/bin
#RUN wget https://chromedriver.storage.googleapis.com/${CHROME_VERSION}/chromedriver_linux64.zip --no-verbose
#RUN unzip chromedriver_linux64.zip
#RUN mv  -v chromedriver /usr/bin

#checking and removing the setup files
RUN ls
RUN rm google-chrome-stable_${CHROME_VERSION}-1_amd64.deb;#rm chromedriver_linux64.zip;
RUN rm *.log
RUN echo "removal check";ls
RUN apt-get clean -y

#verifying Versions
HEALTHCHECK CMD java -version;google-chrome --version || exit 1

#ADD .jar under target from host(local) into this image
#ADD target/SeleniumFramework-0.0.1-SNAPSHOT.jar                          SeleniumFramework-0.0.1-SNAPSHOT.jar
ADD target/E-CommApp-0.0.1-SNAPSHOT-tests.jar                            E-CommApp-0.0.1-SNAPSHOT-tests.jar
ADD src/test/resources                                                   src/test/resources

# ADD testng suite files
ADD testng.xml                                                   testng.xml
ADD purchase.xml                                                 purchase.xml
# ADD health check script
#ADD healthcheck.sh                                      healthcheck.sh
#RUN dos2unix healthcheck.sh

#TAGS
ENTRYPOINT java -jar E-CommApp-0.0.1-SNAPSHOT-tests.jar $MODULE
# Perfecto-Serenity-Sample

[Serenity](http://www.thucydides.info/docs/serenity/) Integration with Perfecto.

This sample project is designed to get you up and running within few simple steps.

Begin with installing the dependencies below, and continue with the Getting Started procedure below.

### Dependencies
There are several prerequisite dependencies you should install on your machine prior to starting to work with this project:

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

* An IDE to write your tests on - [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr) or [IntelliJ](https://www.jetbrains.com/idea/download/#)

* [Maven](https://maven.apache.org/)

Eclipse users should also install:

1. [Maven Plugin](http://marketplace.eclipse.org/content/m2e-connector-maven-dependency-plugin)

2. [TestNG Plugin](http://testng.org/doc/download.html)


IntelliJ IDEA users should also install:

1. [Maven Plugin for IDEA](https://plugins.jetbrains.com/plugin/1166)

TestNG Plugin is built-in in the IntelliJ IDEA, from version 7 onwards.

## Downloading the Sample Project

* [Clone](https://github.com/PerfectoMobileSA/Perfecto-Serenity-Sample.git) the repository.

* After downloading and unzipping the project to your computer, open it from your IDE by choosing the folder containing the pom.xml 


## Running the sample as is
- Provide cloudName and securityToken in `serenity.properties` file.
- Update perfecto.capabilities.* capabilitites in `serenity.properties` file.
- To run a single test, run `mvn verify -P single`
- To run parallel tests, run `mvn verify -P parallel`

* CI dashboard integration can be performed by supplying the below properties to top-level Maven Targets:

		verify 
		-P parallel 
		-Dperfecto.capabilities.cloudName=${cloudName}
		-Dperfecto.capabilities.securityToken=${securityToken}
		-Dreportium-job-name=${JOB_NAME} 
		-Dreportium-job-number=${BUILD_NUMBER} 
		-Dreportium-job-tags=${myTag}

##Note:
It is recommended to use different Jobs for different platforms in order to avoid flacky parallel executions.


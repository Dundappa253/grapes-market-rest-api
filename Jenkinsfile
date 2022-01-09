
library identifier: "pipeline-library@master", retriever: modernSCM(
  [$class: "GitSCMSource",
   remote: "https://github.com/Dundappa253/grapes-market-rest-api.git"])

appName = "my-java-spring-boot"

pipeline {
    agent { label "maven" }
    stages {
        stage("Checkout") {
            steps {
                checkout scm
            }
        }
        stage("Docker Build") {
            steps {
                // This uploads your application's source code and performs a binary build in OpenShift
                // This is a step defined in the shared library (see the top for the URL)
                // (Or you could invoke this step using 'oc' commands!)
                binaryBuild(buildConfigName: appName, buildFromPath: ".")
            }
        }

    }
}

pipeline {
    agent any
    

    stages {
        stage('Build') {
            steps
             {
              git branch: 'master', url: 'https://github.com/Dundappa253/grapes-market-rest-api.git'
              
              sh "mvn install -DskipTests=true"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}

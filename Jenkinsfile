pipeline {
    agent any
    

    stages {
        stage('Build') {
             docker.image('maven').inside {
                withMaven {
                    sh 'mvn -version'
                }
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

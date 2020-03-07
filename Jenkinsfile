pipeline {
    agent any
    stages {
        stage('Checkout') {
            checkout scm
        }

        stage('Publish') {
            steps {
                sh './gradlew publish'
            }
        }
    }
    post {
        success {
            cleanWs()
        }
    }
}
pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
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
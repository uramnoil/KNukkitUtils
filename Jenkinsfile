pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                sh 'chmod +x gradlew'
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
pipeline {
    agent any
    stages {
        stage('Add Permission') {
            steps {
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
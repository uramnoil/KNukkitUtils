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
                sh './gradlew clean'
                sh './gradlew build'
                sh './gradlew bintrayUpload'
            }
        }
    }

    post {
        success {
            cleanWs()
        }
    }
}
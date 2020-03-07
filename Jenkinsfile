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
                sh './gradlew --scan publish'
            }
        }
    }

    post {
        success {
            cleanWs()
        }
    }
}
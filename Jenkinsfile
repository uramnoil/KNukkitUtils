pipeline {
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
}
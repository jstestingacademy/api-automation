pipeline {
    agent any
    
    environment {
        TEST_CONTAINER_NAME = 'rest-assured-tests'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/jstestingacademy/api-automation.git'
            }
        }

        stage('Test Docker Access') {
            steps {
                sh 'docker --version' // Check Docker access
                sh 'docker ps'        // List running containers
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t rest-assured-tests .'
            }
        }

        stage('Run Tests in Docker') {
            steps {
                sh 'docker-compose up --abort-on-container-exit'
            }
        }

        stage('Publish Test Report') {
            steps {
                publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target',
                    reportFiles: 'cucumber-reports.html',
                    reportName: 'API Test Report'
                ])
            }
        }
    }

    post {
        always {
            echo 'Cleaning up Docker environment...'
            sh 'docker-compose down || true'
            sh 'docker rmi -f rest-assured-tests || true'
        }
    }
}

}

pipeline {
    agent {
        docker {
            image 'maven:3.9.5-eclipse-temurin-17'
        }
    }

    environment {
        TEST_CONTAINER_NAME = 'rest-assured-tests'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/jstestingacademy/api-automation.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t rest-assured-tests .'
            }
        }

        stage('Run Tests in Docker') {
            steps {
                sh 'docker compose up --abort-on-container-exit'
            }
        }

        stage('Publish Test Report') {
            steps {
                publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber-reports.html',
                    reportName: 'API Test Report'
                ])
            }
        }
    }

    post {
        always {
            sh 'docker compose down -v'
            sh 'docker rmi -f rest-assured-tests || true'
            sh 'docker system prune -f'
        }
    }
}


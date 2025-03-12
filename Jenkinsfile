pipeline {
    agent {
        label 'linux-agent' // or simply 'docker' if it’s a Docker-based Linux agent
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
                script {
                    echo 'Building Docker Image...'
                    sh '''
                        set -e
                        docker build -t rest-assured-tests .
                    '''
                }
            }
        }

        stage('Run Tests in Docker') {
            steps {
                script {
                    echo 'Running tests in Docker...'
                    sh 'docker-compose -f ./docker-compose.yml up --abort-on-container-exit'
                }
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
            script {
                echo 'Cleaning up Docker environment...'
                sh '''
                    docker-compose -f ./docker-compose.yml down -v || true
                    docker rmi -f rest-assured-tests || true
                '''
            }
        }
    }
}

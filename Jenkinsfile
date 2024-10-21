pipeline {
    agent any

    triggers {
        githubPush()
    }

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t sbwebservice .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                sh 'docker tag sbwebservice $DOCKERHUB_CREDENTIALS_USR/sbwebservice:latest'
                sh 'docker push $DOCKERHUB_CREDENTIALS_USR/sbwebservice:latest'
            }
            post {
                always {
                    sh 'docker logout'
                }
            }
        }
    }
}
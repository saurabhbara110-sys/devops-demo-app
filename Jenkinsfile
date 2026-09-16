pipeline {
    agent any

    environment {
        DOCKERHUB_REPO = 'saurabhbara110/devops-demo-app'
        IMAGE_TAG = "${BUILD_NUMBER}"
       }

    stages {
        stage('Workspace Cleanup') {
           steps {
              deleteDir()
           }
       }
        stage('Checkout') {
           steps {
              checkout scm
           }
       }
        stage('SonarQube Scan') {
           steps {
              withSonarQubeEnv('sonarqube') {
                  sh '''
                     sonar-scanner \
                     -Dsonar.projectKey=devops-demo-app \
                     -Dsonar.sources=src
               '''
              }
           }
       }
        stage('Compile') {
           steps {
              sh 'javac src/Hello.java'
           }
       }
        stage('Run') {
           steps {
              sh 'java -cp src Hello'
           }
       }
        stage('Build Docker Image') {
           steps {
              sh 'docker build -t ${DOCKERHUB_REPO}:${IMAGE_TAG} .'
           }
       }

        stage('Run Docker Container') {
           steps {
              sh 'docker run --rm ${DOCKERHUB_REPO}:${IMAGE_TAG}'
           }
       }
        stage('Push Docker Image') {
           steps {
              withCredentials([usernamePassword(
                  credentialsId : 'dockerhub-credentials',
                  usernameVariable : 'DOCKERHUB_USER',
                  passwordVariable : 'DOCKERHUB_TOKEN'
              )]) {
                  sh '''
                      echo "$DOCKERHUB_TOKEN" | docker login -u "$DOCKERHUB_USER" --password-stdin
                      docker push ${DOCKERHUB_REPO}:${IMAGE_TAG}
                      docker logout
                  '''
             }
          }
       }
    }
}

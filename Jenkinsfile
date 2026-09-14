pipeline {
    agent any

    environment {
        IMAGE_NAME = 'devops-demo-app'
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
              sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
           }
       }

        stage('Run Docker Container') {
           steps {
              sh 'docker run --rm ${IMAGE_NAME}:${IMAGE_TAG}'
           }
       }
    }
}

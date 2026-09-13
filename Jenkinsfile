pipeline {
    agent any

    stages {
        stage('Workspace Cleanup') {
           steps {
              deleteDir()
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
              sh 'docker build -t devops-demo-app:1.0 .'
           }
       }

        stage('Run Docker Container') {
           steps {
              sh 'docker run --rm devops-demo-app:1.0'
           }
       }
    }
}
